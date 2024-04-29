package com.webteam.marathon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.Receipt;
import com.webteam.marathon.dto.NewReceipt;

@Repository
public class MarathonRepository implements IMarathonRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class RcpMapper implements RowMapper<Receipt>{

		@Override
		public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Receipt rcp = new Receipt();
			rcp.setReceiptNum(rs.getInt("receipt_num"));
			rcp.setUserName(rs.getString("user_name"));
			rcp.setPhoneNum(rs.getString("phone_num"));
			rcp.setUserAdd(rs.getString("user_add"));
			rcp.setUserEmail(rs.getString("user_email"));
			rcp.setUserBirth(rs.getString("user_birth"));
			rcp.setMarathonId(rs.getInt("marathon_id"));
			rcp.setUserPassword(rs.getString("user_password"));
			return rcp;
		}
		
	}
	
	@Override
	public List<Marathon> getMarathonList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marathon getMarathonInfo(int marathonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receipt getReceiptInfoNum(int receiptNum) {
		String sql = "SELECT receipt_num, user_name, phone_num, user_add, "
				+ " user_email, user_birth, marathon_id, user_password "
				+ " FROM receipt WHERE receipt_num=?";
		return jdbcTemplate.queryForObject(sql, new RcpMapper(), receiptNum);

	}

	@Override
	public void insertMarathon(Marathon marathon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NewReceipt getNewReceipt(int receiptNum, String userPassword) {
		String sql = "SELECT m.marathon_name, m.marathon_date, r.receipt_num, "
				+ "r.user_name, r.phone_num, " 
				+ "r.user_add, r.user_email, r.user_birth "
				+ "FROM marathon m JOIN receipt r "
				+ "ON r.marathon_id = m.marathon_id "
				+ "WHERE r.receipt_num = ? AND r.user_password =?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<NewReceipt>() {

			@Override
			public NewReceipt mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				NewReceipt newReceipt = new NewReceipt();
				newReceipt.setMarathonName(rs.getString("marathon_name"));
				newReceipt.setMarathonDate(rs.getDate("marathon_date"));
				newReceipt.setReceiptNum(rs.getInt("receipt_num"));
				newReceipt.setUserName(rs.getString("user_name"));
				newReceipt.setPhoneNum(rs.getString("phone_num"));
				newReceipt.setUserAdd(rs.getString("user_add"));
				newReceipt.setUserEmail(rs.getString("user_email"));
				newReceipt.setUserBirth(rs.getString("user_birth"));
				return newReceipt;
			}
			
		}, receiptNum, userPassword);
	}

	@Override
	public void updateReceipt(Receipt newReceipt, int receiptNum) {
		String sql = "UPDATE receipt SET user_name=?, phone_num=?, user_add=?, user_email=?, "
				+ "user_birth=? WHERE receipt_num= ?";
		jdbcTemplate.update(sql, 
				newReceipt.getUserName(), newReceipt.getPhoneNum(), newReceipt.getUserAdd(),
				newReceipt.getUserEmail(), newReceipt.getUserBirth(), receiptNum);
	}

	@Override
	public int deleteMarathon(int receiptNum, String userPassword) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM receipt WHERE receipt_num=? AND user_password=?";
		return jdbcTemplate.update(sql,receiptNum,userPassword);

	}

	@Override
	public Receipt getReceiptInfo(String userName, String phoneNum) {
		String sql = "SELECT receipt_num, user_name, phone_num, user_add, "
				+ " user_email, user_birth, marathon_id, user_password "
				+ " FROM receipt WHERE user_name=? AND phone_num=?";
		return jdbcTemplate.queryForObject(sql, new RcpMapper(), userName, phoneNum);
	}
}
