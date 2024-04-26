package com.webteam.marathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.dto.ReceiptHistory;
import com.webteam.marathon.service.IMarathonService;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;
	
	@GetMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, Model model) {
	    return "";
	}

	@PostMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, String userpassword,RedirectAttributes redAttr, Model model) {
		return "";
	}
	
	/**
	 * @author 표기두
	 * @param rcpNum - 접수 번호 
	 * @param userPassword - 접수 비밀번호
	 * @param model - 접수 DTO
	 * @return
	 */
	@GetMapping(value="/update/{receiptNum}/{userPassword}")
	public String updateReceipt(@PathVariable int receiptNum, @PathVariable String userPassword, Model model) {
		model.addAttribute("receiptHistory", marathonService.getReceiptHistory(receiptNum, userPassword));
		return "update";
	}
}
