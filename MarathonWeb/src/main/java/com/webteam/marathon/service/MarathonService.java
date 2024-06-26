package com.webteam.marathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam.marathon.dao.IMarathonRepository;
import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.NewReceipt;
import com.webteam.marathon.dto.Receipt;

@Service
public class MarathonService implements IMarathonService{
	
	@Autowired
	IMarathonRepository marathonRepository;
	
	@Override
	@Transactional("transactionManager")
	public int deleteMarathon(int receiptNum, String userPassword) {
		return marathonRepository.deleteMarathon(receiptNum, userPassword);
	}

	@Override
	public List<Receipt> getReceiptInfo(String userName, String phoneNum) {
		return marathonRepository.getReceiptInfo(userName, phoneNum);
	}

	@Override
	public List<Marathon> getMarathonList() {
		return marathonRepository.getMarathonList();
	}

	@Override
	public Marathon getMarathonInfo(int marathonId) {
		return marathonRepository.getMarathonInfo(marathonId);
	}

	@Override
	public void insertReceipt(Receipt receipt) {
		marathonRepository.insertReceipt(receipt);
	}

	@Override
	public NewReceipt getNewReceipt(int receiptNum, String userPassword) {
		return marathonRepository.getNewReceipt(receiptNum, userPassword);
	}
	
	@Override
	public int updateReceipt(Receipt newReceipt, int receiptNum) {
		return marathonRepository.updateReceipt(newReceipt, receiptNum);
	}

	
	@Override
	public List<Marathon> searchMarathonByName(String searchKeyword) {
		return marathonRepository.searchMarathonByName(searchKeyword);
	}
	
	@Override
	public boolean isValidReceipt(int receiptNum, String userPassword) {
		return marathonRepository.isValidReceipt(receiptNum, userPassword);
	}
	
	@Override
	public int searchReceiptNum() {
		return marathonRepository.searchReceiptNum();
	}
}
