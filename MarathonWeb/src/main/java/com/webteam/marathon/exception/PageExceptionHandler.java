package com.webteam.marathon.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webteam.marathon.service.IMarathonService;

@ControllerAdvice
public class PageExceptionHandler {
	
    @ExceptionHandler(RuntimeException.class)
    public String handleException(Exception e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "알수없는 오류로 메인 페이지로 돌아갑니다.");
        return "redirect:/list";
    }
    
    @Autowired
	IMarathonService marathonService;
    
    public boolean isValid(int receiptNum, String userPassword) {
		return marathonService.isValidReceipt(receiptNum, userPassword);
	}
}