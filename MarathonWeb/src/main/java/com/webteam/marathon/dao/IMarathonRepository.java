package com.webteam.marathon.dao;

import java.util.List;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.NewReceipt;
import com.webteam.marathon.dto.Receipt;

public interface IMarathonRepository {
	// 마라톤 대회 목록 가져오기
	List<Marathon> getMarathonList();
	
	// 마라톤 대회 검색목록 가져오기
	List<Marathon> searchMarathonByName(String searchKeyword);
	
	// 대회 상세정보 가져오기
	Marathon getMarathonInfo(int marathonId);
	
	// 접수 내역 조회
	List<Receipt> getReceiptInfo(String userName, String phoneNum);
	
	// 접수하기
	void insertReceipt(Receipt receipt);
	
	// 접수 내역 수정 
	int updateReceipt(Receipt newReceipt, int receiptNum);
	NewReceipt getNewReceipt(int receiptNum, String userPassword);
	
	// 접수 내역 삭제
	int deleteMarathon(int receiptNum, String userPassword);
	
	int searchReceiptNum();
	
	boolean isValidReceipt(int receiptNum, String userPassword);

	
	
	
}
