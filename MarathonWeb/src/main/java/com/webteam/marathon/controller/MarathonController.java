package com.webteam.marathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.service.IMarathonService;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;
	
	/*@GetMapping(value="/delete")
	public String deleteMarathon(int rcpnum, Model model) {
	    return "";
	}

	@PostMapping(value="/delete")
	public String deleteMarathon(int rcpnum, String userpassword,RedirectAttributes redAttr, Model model) {
		return "";
	}*/
	
	/*@GetMapping("/info")
	public String getFileList(Model model) {
		model.addAttribute("info", marathonService.getMarathonInfo());
		return "info";
	}*/
	
    // 영수증 정보 가져오기
	@GetMapping("/result/info2/{receiptNum}")
	public String getReceiptInfoNum(@PathVariable int receiptNum, Model model) {
	    try {
	        Receipt receipt = marathonService.getReceiptInfoNum(receiptNum);
	        model.addAttribute("receipt", receipt);
	        return "result/info2";
	    } catch (EmptyResultDataAccessException e) {
	        model.addAttribute("errorMessage", "영수증 정보를 찾을 수 없습니다.");
	        return "result/noinfo2"; // 오류 메시지를 표시하는 JSP 페이지
	    }
	}

    // 사용자 이름과 전화번호로 영수증 정보 검색
	@GetMapping("/result/info5")
	public String getReceiptInfo(Model model) {
	        return "result/info5"; // 영수증 정보를 표시하는 JSP 페이지 
	}
	@PostMapping("/result/info5")
	public String getReceiptInfo(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "phoneNum", required = false) String phoneNum, Model model) {
		 try {
		        List<Receipt> receipts = marathonService.getReceiptInfo(userName, phoneNum);
		        model.addAttribute("receipts", receipts);
		        return "result/info5"; // 영수증 정보를 표시하는 JSP 페이지
		    } catch (EmptyResultDataAccessException e) {
		        model.addAttribute("errorMessage", "영수증 정보를 찾을 수 없습니다.");
		        return "result/noinfo2"; // 오류 메시지를 표시하는 JSP 페이지
		    }
		}
	
	

/*		@GetMapping("/result/info5")
	public String getReceiptInfo(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "phoneNum", required = false) String phoneNum, Model model) {
	    try {
	        List<Receipt> receipts = marathonService.getReceiptInfo(userName, phoneNum);
	        model.addAttribute("receipts", receipts);
	        return "result/info5"; // 영수증 정보를 표시하는 JSP 페이지
	    } catch (EmptyResultDataAccessException e) {
	        model.addAttribute("errorMessage", "영수증 정보를 찾을 수 없습니다.");
	        return "result/noinfo2"; // 오류 메시지를 표시하는 JSP 페이지
	    }
	}*/

        
    
    @GetMapping("result/info4")
    public String getAllReceiptInfo(Model model) {
    	List<Receipt> receiptsList = marathonService.getAllReceiptInfo();
    	model.addAttribute("receiptsList", receiptsList);
    	return "result/info4";
    }
}
