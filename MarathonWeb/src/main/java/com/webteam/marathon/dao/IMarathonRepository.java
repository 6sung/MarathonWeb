package com.webteam.marathon.dao;

import java.util.List;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.Receipt;

public interface IMarathonRepository {
	// 마라톤 대회 목록 가져오기
	List<Marathon> getMarathonList();
	
	// 대회 상세정보 가져오기
	Marathon getMarathonInfo(int marathonId);
	
	// 접수 내역 조회
	Receipt getReceiptInfo(int receiptNum);
	
	// 접수하기
	void insertMarathon(Marathon marathon);
	
	// 접수 내역 수정 페이지
	Receipt getReceiptHistory(int receiptNum, String userPassword);
	
	// 접수 내역 수정 
	void updateMarathon(Marathon marathon);
	
	// 접수 내역 삭제
	int deleteMarathon(int receiptNum, String userPassword);
}
