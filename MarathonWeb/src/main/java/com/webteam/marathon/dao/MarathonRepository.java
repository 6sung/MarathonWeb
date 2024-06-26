package com.webteam.marathon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webteam.marathon.dto.Marathon;
import com.webteam.marathon.dto.NewReceipt;
import com.webteam.marathon.dto.Receipt;

@Repository
public class MarathonRepository implements IMarathonRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class RcpMapper implements RowMapper<Receipt>{
		@Override
		public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
			Receipt rcp = new Receipt();
			rcp.setReceiptNum(rs.getInt("receipt_num"));
			rcp.setUserName(rs.getString("user_name"));
			rcp.setPhoneNum(rs.getString("phone_num"));
			rcp.setUserAdd(rs.getString("user_add"));
			rcp.setUserEmail(rs.getString("user_email"));
			rcp.setUserBirth(rs.getDate("user_birth"));
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
			mar.setMarathonImg(rs.getString("marathon_img"));
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
				+"marathon_date, marathon_img from marathon where marathon_id=?";
		return jdbcTemplate.queryForObject(sql, new MarMapper(),marathonId);
	}

	@Override
	public List<Receipt> getReceiptInfo(String userName, String phoneNum) {
		String sql = "SELECT receipt_num, user_name, phone_num, user_add, "
				+ " user_email, user_birth, marathon_id, user_password "
				+ " FROM receipt WHERE user_name=? AND phone_num=?";
		return jdbcTemplate.query(sql, new RcpMapper(), userName, phoneNum);
	}

	@Override
	public void insertReceipt(Receipt receipt) {

		String sql = "insert into receipt (receipt_num, USER_NAME, PHONE_NUM, USER_ADD, " + 
				"				USER_EMAIL, USER_BIRTH, MARATHON_ID, USER_PASSWORD) " + 
				"				 VALUES (seq_receipt_num.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				receipt.getUserName(),
				receipt.getPhoneNum(),
				receipt.getUserAdd(),
				receipt.getUserEmail(),
				receipt.getUserBirth(),
				receipt.getMarathonId(),
				receipt.getUserPassword()
				);
	}

	@Override
	public int updateReceipt(Receipt newReceipt, int receiptNum) {
		String sql = "UPDATE receipt SET user_name=?, phone_num=?, user_add=?, user_email=?, "
				+ "user_birth=? WHERE receipt_num= ?";
		return jdbcTemplate.update(sql, 
				newReceipt.getUserName(), newReceipt.getPhoneNum(), newReceipt.getUserAdd(),
				newReceipt.getUserEmail(), newReceipt.getUserBirth(), receiptNum);
	}

	@Override
	public int deleteMarathon(int receiptNum, String userPassword) {
		String sql = "DELETE FROM receipt WHERE receipt_num=? AND user_password=?";
		return jdbcTemplate.update(sql,receiptNum,userPassword);
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
				NewReceipt newReceipt = new NewReceipt();
				newReceipt.setMarathonName(rs.getString("marathon_name"));
				newReceipt.setMarathonDate(rs.getDate("marathon_date"));
				newReceipt.setReceiptNum(rs.getInt("receipt_num"));
				newReceipt.setUserName(rs.getString("user_name"));
				newReceipt.setPhoneNum(rs.getString("phone_num"));
				newReceipt.setUserAdd(rs.getString("user_add"));
				newReceipt.setUserEmail(rs.getString("user_email"));
				newReceipt.setUserBirth(rs.getDate("user_birth"));
				return newReceipt;
			}
			
		}, receiptNum, userPassword);
	}

	@Override
	public List<Marathon> searchMarathonByName(String searchKeyword) {
		 // 사용자 입력이 비어있거나 띄어쓰기로만 이루어진 경우 처리
		if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
          String sql = "select * from marathon";
          return jdbcTemplate.query(sql, new MarMapper());
		}

		// 사용자 입력을 공백 기준으로 분리
		String[] searchWords = searchKeyword.split("\\s+");
		StringBuilder sql = new StringBuilder("SELECT * FROM marathon WHERE ");

		// 동적으로 쿼리문 구성
		for (int i = 0; i < searchWords.length; i++) {
			sql.append("marathon_name LIKE ?");
			if (i < searchWords.length - 1) {
				sql.append(" OR "); // 또는 AND를 사용할 수 있습니다.
			}
		}

		// 검색어에 % 추가된 상태에서의 검색어 준비
		Object[] params = new Object[searchWords.length];
		for (int i = 0; i < searchWords.length; i++) {
			params[i] = "%" + searchWords[i] + "%";
		}

		// 동적으로 구성된 SQL 문자열과 파라미터를 사용하여 쿼리 실행
		return jdbcTemplate.query(sql.toString(), new MarMapper(), params);
	}

	@Override
	public boolean isValidReceipt(int receiptNum, String userPassword) {
		String sql = "SELECT COUNT(*) FROM receipt WHERE receipt_num=? AND user_password=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, receiptNum, userPassword) == 1;
	}
	
	@Override
	public int searchReceiptNum() {
		String sql = "select Max(receipt_num) from receipt";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}