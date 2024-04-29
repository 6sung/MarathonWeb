package com.webteam.marathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webteam.marathon.dto.Marathon;
import java.util.List;

import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.dto.NewReceipt;
import com.webteam.marathon.service.IMarathonService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;
	
	@GetMapping("/{marathonId}")
	public String getMarathonInfo(@PathVariable int marathonId, Model model) {
		Marathon marathon=marathonService.getMarathonInfo(marathonId);
		model.addAttribute("marathon", marathon);
		return "marathon/view";
	}
	//테스트 시 http://localhost:8080/marathon/list 로 입력
	//마라톤 리스트가 출력됩니다.
	@GetMapping("/list")
	public String getAllMarathon(Model model) {
		List<Marathon> marathonList=marathonService.getMarathonList();
		model.addAttribute("marathonList",marathonList);
		return "marathon/index";
	}
	
	/**
	 * @author 표기두
	 * @param receiptNum - 접수 번호 
	 * @param userPassword - 접수 비밀번호
	 * @param model - 접수 DTO
	 * @return
	 */
	@GetMapping(value="/update/{receiptNum}/{userPassword}")
	public String updateReceipt(@PathVariable int receiptNum, @PathVariable String userPassword, Model model) {
		model.addAttribute("newReceipt", marathonService.getNewReceipt(receiptNum, userPassword));
		return "updateform";
	}
	
	@PostMapping(value="/update/{receiptNum}/{userPassword}")
	public String updateReceipt(Receipt newReceipt,@PathVariable int receiptNum, @PathVariable String userPassword, RedirectAttributes model) {
		try {
			marathonService.updateReceipt(newReceipt, receiptNum);
			model.addFlashAttribute("message", "접수 내역이 수정되었습니다");
		} catch (RuntimeException e) {
			model.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/";
	}
	@GetMapping(value="/result/delete")
	public String deleteMarathon(Model model) {
	    return "result/deleteform";
	}
	@GetMapping("/result/deleteform")
	public String showDeleteForm() {
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
	            return "redirect:/result/deleteform";
	        }else{
	            model.addAttribute("message", "접수번호 또는 비밀번호가 다릅니다");
	            return "/result/deleteform";
	        }
	    }catch(Exception e){
	        redAttr.addFlashAttribute("message", "삭제 중 오류가 발생했습니다: " + e.getMessage());
	        return "redirect:/result/deleteform";
	    }
	}
}
