package com.webteam.marathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webteam.marathon.dto.Marathon;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.service.IMarathonService;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;
	
	/**
	 * @author 정다현
	 * @param model
	 * @return
	 */
	@GetMapping("/receipt/insert")
	public String insertReceipt(int marathonId ,Model model) {
		model.addAttribute("marathon", marathonService.getMarathonInfo(marathonId));
		System.out.println(marathonService.getMarathonInfo(marathonId));
		
		System.out.println("1번");
		return "receipt/insert";
	}

	@PostMapping(value="/receipt/insert")
	public String insertReceipt(Receipt receipt, RedirectAttributes redirectAttrs) {
			System.out.println(receipt.toString());
			try {
				marathonService.insertReceipt(receipt);
				int message = receipt.getReceiptNum();
				redirectAttrs.addFlashAttribute("message", receipt.getUserName() + "님 접수번호 "+message+"번으로 참가 신청이 완료되었습니다.");
				System.out.println("2번");
			}catch(RuntimeException e) {
				redirectAttrs.addFlashAttribute("message", e.getMessage());
				e.printStackTrace();
				System.out.println("3번");
			}
			return "redirect:/receipt/insert?marathonId="+receipt.getMarathonId();
	}
	
	/**
	 * @author 윤상기
	 * @param model
	 * @return
	 */
	 @GetMapping("/result/info5")
	 public String getReceiptInfo(Model model) {
	     return "result/info5"; // 영수증 정보를 표시하는 JSP 페이지 
	 }
	 @PostMapping("/result/info5")
	 public String getReceiptInfo(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "phoneNum", required = false) String phoneNum, Model model) {
	    try{
	        List<Receipt> receipts = marathonService.getReceiptInfo(userName, phoneNum);
	        model.addAttribute("marathonList", marathonService.getMarathonList());
	        model.addAttribute("receipts", receipts);
	        return "result/info5"; // 영수증 정보를 표시하는 JSP 페이지
	    } catch (EmptyResultDataAccessException e) {
	        model.addAttribute("errorMessage", "영수증 정보를 찾을 수 없습니다.");
	        return "result/noinfo2"; // 오류 메시지를 표시하는 JSP 페이지
	    }
	 }
	
	
	/**
	 * @author 표기두
	 * @param receiptNum
	 * @param userPassword
	 * @param model
	 * @return
	 */

	 @GetMapping(value="result/checkform")
	 public String showCheckForm(@RequestParam("param") String page, Model model) {
			//RequestParameter를 이용하여 page값을 받아와서 분기 실행
			if(page.equals("update")) {
				// checkform.jsp에 form action 경로를 update로 설정
				model.addAttribute("page", "update");
				return "result/checkform";
			}else {
				// checkform.jsp에 form action 경로를 delete로 설정
				model.addAttribute("page", "delete");
				return "result/checkform";
			}
	    }
	
	@GetMapping(value="result/update/{receiptNum}/{userPassword}")
	public String updateReceipt(@PathVariable int receiptNum, @PathVariable String userPassword, Model model, RedirectAttributes redAttr) {
		//  model.addAttribute("newReceipt", marathonService.getNewReceipt(receiptNum, userPassword));
		//  return "result/updateform";
		if (!isValid(receiptNum, userPassword)) {
//			model.addAttribute("param", "update");
			redAttr.addFlashAttribute("message", "접수번호 또는 비밀번호가 다릅니다");
			return "redirect:/result/checkform?param=update"; // 에러 페이지로 리다이렉트하거나 이동합니다.
		}
		model.addAttribute("newReceipt", marathonService.getNewReceipt(receiptNum, userPassword));
		return "result/updateform";
	}

	private boolean isValid(int receiptNum, String userPassword) {
		// receiptNum과 userPassword를 데이터베이스와 비교하여 유효한지 확인할 수 있습니다.
		return marathonService.isValidReceipt(receiptNum, userPassword);
	}
	
	@PostMapping(value="result/update/{receiptNum}/{userPassword}")
	public String updateReceipt(Receipt newReceipt,@PathVariable int receiptNum, @PathVariable String userPassword, RedirectAttributes model) {
		try {
			marathonService.updateReceipt(newReceipt, receiptNum);
			model.addFlashAttribute("message", "접수 내역이 수정되었습니다");
		} catch (RuntimeException e) {
			model.addFlashAttribute("message", "접수 내역을 수정할 수 없습니다");
		}
		return "redirect:/list";
	}
	
	/**
	 * @author 김다린
	 * @param marathonId
	 * @param model
	 * @return
	 */
	@GetMapping("/{marathonId}")
	public String getMarathonInfo(@PathVariable int marathonId, Model model) {
		Marathon marathon=marathonService.getMarathonInfo(marathonId);
		model.addAttribute("marathon", marathon);
		return "marathon/view";
	}
	//테스트 시 http://localhost:8080/marathon/list 로 입력
	//마라톤 리스트가 출력됩니다.
/*	@GetMapping("/list")
	public String getAllMarathon(Model model) {
		List<Marathon> marathonList=marathonService.getMarathonList();
		model.addAttribute("marathonList",marathonList);
		return "marathon/index";
	}*/
	
	// 검색창에 입력한  값이 있으면 해당 값과 일치하는 마라톤 리스트 출력
	@GetMapping("/list")
	public String getSearchedMarathon(@RequestParam(name = "searchKeyword", required = false) String searchKeyword, Model model) {
		List<Marathon> marathonList;
		if (searchKeyword != null && !searchKeyword.isEmpty()) {
			marathonList = marathonService.searchMarathonByName(searchKeyword);
		}else {
	        marathonList = marathonService.getMarathonList();
	    }
	    model.addAttribute("marathonList", marathonList);
	    return "marathon/index";
	}
	
	/**
	 * @author 김민성
	 * @param model
	 * @return
	 */
//	@GetMapping(value="/result/delete")
//	public String deleteMarathon(Model model) {
//	    return "result/deleteform";
//	}
//	@GetMapping("/result/deleteform")
//	public String showDeleteForm() {
//	    return "result/deleteform";
//	}
	
	@GetMapping({"/result/delete", "/result/deleteform"})
	public String showDeleteForm(Model model) {
	    // GET 요청에 대한 처리로, 삭제 폼을 보여줍니다.
	    return "result/deleteform";
	}
	
	@RequestMapping(value="/result/delete", method = RequestMethod.POST)
	public String deleteMarathon(@RequestParam(required = true) Integer rcpnum, 
	                             @RequestParam(required = true) String userpassword, 
	                             RedirectAttributes redAttr, Model model){
	    try{
	        int delete = marathonService.deleteMarathon(rcpnum, userpassword);
	        if(delete > 0){
	            redAttr.addFlashAttribute("message", "접수번호 [" + rcpnum + "] 신청이 취소되었습니다.");
	            return "redirect:/list";
	        }else{
	            model.addAttribute("message", "접수번호 또는 비밀번호가 다릅니다");
	            return "/result/checkform";
	        } 
	    }catch(Exception e){
	        redAttr.addFlashAttribute("message", "접수 내역을 삭제할 수 없습니다: /n" + e.getMessage());
	        return "redirect:/result/checkform";
	    }
	}
	
	@GetMapping("/result/delete/{receiptNum}/{userPassword}")
	@PostMapping(value="/result/delete/{receiptNum}/{userPassword}")
	public String deleteMarathon(@PathVariable int receiptNum, @PathVariable String userPassword,
	                             RedirectAttributes redAttr, Model model){
	    try{
	        int delete = marathonService.deleteMarathon(receiptNum, userPassword);
	        if(delete > 0){
	            redAttr.addFlashAttribute("message", "접수번호 [" + receiptNum + "] 신청이 취소되었습니다.");
	            return "redirect:/list";
	        }else{
	            model.addAttribute("message", "접수번호 또는 비밀번호가 다릅니다");
	            return "/result/checkform";
	        }
	    }catch(Exception e){
	        redAttr.addFlashAttribute("message", "삭제 중 오류가 발생했습니다: " + e.getMessage());
	        return "redirect:/result/checkform";
	    }
	}
}