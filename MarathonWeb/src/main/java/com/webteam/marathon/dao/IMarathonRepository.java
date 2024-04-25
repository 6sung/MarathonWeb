package com.webteam.marathon.dao;

import java.util.List;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.Receipt;

public interface IMarathonRepository {
	// 마라톤 대회 목록 가져오기
	public List<Marathon> getMarathonList();
	
	// 대회 상세정보 가져오기
	public Marathon getMarathonInfo(int marathonId);
	
	// 접수 내역 조회
	public Receipt getReceiptInfo(int receiptNum, String userPassword);
	
	// 접수하기
	public void insertMarathon(Marathon marathon);
	
	// 접수 내역 수정 페이지
	public Receipt getReceiptHistory(int receiptNum, String userPassword);
	
	// 접수 내역 수정 
	public void updateMarathon(Marathon marathon);
	
	// 접수 내역 삭제
	public void deleteMarathon(int receiptNum, String userPassword);
	
}
