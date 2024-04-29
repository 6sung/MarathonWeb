package com.webteam.marathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam.marathon.dao.IMarathonRepository;
import com.webteam.marathon.dao.MarathonRepository;
import com.webteam.marathon.dto.Marathon;
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
	public Receipt getReceiptInfo(int receiptNum) {
		return marathonRepository.getReceiptInfo(receiptNum);
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
		System.out.println("4번");
		marathonRepository.insertReceipt(receipt);
	}

	@Override
	public Receipt getReceiptHistory(int receiptNum, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMarathon(Marathon marathon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Receipt getReceiptInfo(String userName, String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}


		
	}
	
	


