package com.webteam.marathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.service.IMarathonService;

@Controller
public class MarathonController {
	@Autowired
	IMarathonService marathonService;

	@GetMapping("/receipt/insert")
	public String insertReceipt(Model model) {
		model.addAttribute("marathonList", marathonService.getMarathonList());
		System.out.println("1번");
		return "receipt/insert";
	}

	@PostMapping(value="/receipt/insert")
	public String insertReceipt(Receipt receipt, RedirectAttributes redirectAttrs) {
			System.out.println(receipt.toString());
			try {
				marathonService.insertReceipt(receipt);
				redirectAttrs.addFlashAttribute("message", receipt.getUserName() + "님 참가 신청이 완료되었습니다.");
				System.out.println("2번");
			}catch(RuntimeException e) {
				redirectAttrs.addFlashAttribute("message", e.getMessage());
				e.printStackTrace();
				System.out.println("3번");
			}
			return "redirect:/receipt/insert";
	}

	//해당 마라톤아이디를 입력하면 마라톤 아이디에 해당하는 정보가 나옵니다
	@GetMapping("/{marathonId}")
	public String getMarathonInfo(@PathVariable int marathonId, Model model) {
		Marathon marathon=marathonService.getMarathonInfo(marathonId);
		model.addAttribute("marathon", marathon);
		return "marathon/view";
	}
	//테스트 시 http://localhost:8080/marathon/marform/list 로 입력
	//마라톤 리스트가 출력됩니다.
	@GetMapping("/list")
	public String getAllMarathon(Model model) {
		List<Marathon> marathonList=marathonService.getMarathonList();
		model.addAttribute("marathonList",marathonList);
		return "marathon/index";
	}
	
	@GetMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, Model model) {
		return "";
	}

	@PostMapping(value="/hr/delete")
	public String deleteMarathon(int rcpnum, String userpassword,RedirectAttributes redAttr, Model model) {
		return "";
	}
}
