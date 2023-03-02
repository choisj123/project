package com.villagehall.user.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static com.villagehall.common.JDBCTemplate.*;

import com.villagehall.user.model.vo.User;

public class UserDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public UserDAO() {
		try {
			prop = new Properties(); // Properties 객체 생성
			
			prop.loadFromXML(new FileInputStream("user-query.xml"));
			// main-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 비밀번호 확인용 DAO
	 * @param conn
	 * @param loginUser
	 * @return checkPw
	 * @throws Exception
	 */
	public String checkPw(Connection conn, User loginUser) throws Exception {
		
		String checkPw = null;
		
		try {
			
			String sql = prop.getProperty("checkPw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser.getUserId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkPw = rs.getString("USER_PW");
			}
			
			
		} finally {
			close(rs);
		}
				
		
		return checkPw;
	}

	/** 변경할 닉네임 중복검사 DAO
	 * @param conn
	 * @param updateNickname
	 * @return nicknameDupCheck
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String updateNickname) throws Exception{
		
		int nicknameDupCheck = 0;
		
		try {
			
			String sql = prop.getProperty("nicknameDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nicknameDupCheck = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return nicknameDupCheck;
	}

	/** 닉네임 변경 DAO
	 * @param conn
	 * @param userId
	 * @param updateNickname
	 * @return result
	 * @throws Exception
	 */
	public int updateNickname(Connection conn, String userId, String updateNickname) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateNickname");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateNickname);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateEmail(Connection conn, String userId, String updateEmail) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateEmail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateEmail);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 비밀번호 수정 DAO
	 * @param conn
	 * @param userId
	 * @param userPw1
	 * @return updatePw
	 * @throws Exception
	 */
	public int updatePw(Connection conn, String userId, String userPw1) throws Exception {
		
		int updatePw = 0;
		
		try {
			
			String sql = prop.getProperty("updatePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPw1);
			pstmt.setString(2, userId);
			
			updatePw = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return updatePw;
	}

}
