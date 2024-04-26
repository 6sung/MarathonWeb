package com.webteam.marathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.service.IMarathonService;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;
	
	@GetMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, Model model) {
	    model.addAttribute("rcp", marathonService.getReceiptInfo(rcpnum));
	    return "hr/delete";
	}

	@PostMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, String userpassword,RedirectAttributes redAttr, Model model) {
		try {
			int delete = marathonService.deleteMarathon(rcpnum,userpassword);
			if(delete > 0) {
				redAttr.addFlashAttribute("message","접수번호 "+rcpnum+"의 신청이 취소되었습니다.");
				return "redirect:/hr/deleteform";//"redirect:/hr/list";
			}
			else {
				model.addAttribute("message","접수번호 또는 비밀번호가 다릅니다");
				//model.addAttribute("rcp",marathonService.getReceiptInfo(rcpnum, userpassword));
				return "hr/deleteform";
			}
		}catch(RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			//model.addAttribute("rcp",marathonService.getReceiptInfo(rcpnum, userpassword));
			return "hr/deleteform";
		}
	}
}
