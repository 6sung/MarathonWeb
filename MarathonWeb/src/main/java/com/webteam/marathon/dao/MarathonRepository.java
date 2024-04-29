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
	
	private class MarMapper implements RowMapper<Marathon>{
		@Override
		public Marathon mapRow(ResultSet rs, int rowNum) throws SQLException{
			Marathon mar = new Marathon();
			mar.setMarathonId(rs.getInt("marathon_id"));
			mar.setMarathonName(rs.getString("marathon_name"));
			mar.setMarathonMaximum(rs.getInt("marathon_maximum"));
			mar.setMarathonDate(rs.getDate("marathon_date"));
			return mar;
		}
	}
	
	@Override
	public List<Marathon> getMarathonList() {
		String sql = "select * from marathon";
		return jdbcTemplate.query(sql, new MarMapper());
	}

	@Override
	public Marathon getMarathonInfo(int marathonId) {
		String sql= "SELECT marathon_id, marathon_name, marathon_maximum, "
				+"marathon_date from marathon where marathon_id=?";
		return jdbcTemplate.queryForObject(sql, new MarMapper(),marathonId);
	}

	@Override
	public Receipt getReceiptInfo(int receiptNum) {
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
	public Receipt getReceiptHistory(int receiptNum, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMarathon(Marathon marathon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteMarathon(int receiptNum, String userPassword) {
		//String sql = "delete from employees where employee_id=? and email=?";
		//String sql = "select * from receipt where receipt_num=? and user_password=?";
		String sql = "DELETE FROM receipt WHERE receipt_num=? AND user_password=?";
		//return receiptNum;
		return jdbcTemplate.update(sql,receiptNum,userPassword);
	}
}
