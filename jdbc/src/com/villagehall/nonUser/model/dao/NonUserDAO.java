package com.villagehall.nonUser.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.villagehall.user.model.vo.User;

import static com.villagehall.common.JDBCTemplate.*;

public class NonUserDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public NonUserDAO() {
		try {
			prop = new Properties(); // Properties 객체 생성
			
			prop.loadFromXML(new FileInputStream("non-user-query.xml"));
			// non-user-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param userId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String userId) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("idDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 닉네임 중복검사 DAO
	 * @param conn
	 * @param nickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String nickname) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("nicknameDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 회원가입 DAO
	 * @param conn
	 * @param userId
	 * @param userPw1
	 * @param userName (이메일, 프로필사진 보류)
	 * @param nickname 
	 * @param email 
	 * @param phone 
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, String userId, String userPw1, String userName, String nickname, String email, String phone) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw1);
			pstmt.setString(3, userName);
			pstmt.setString(4, nickname);
			pstmt.setString(5, email);
			pstmt.setString(6, phone);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 로그인 DAO
	 * @param conn
	 * @param userId
	 * @param userPw
	 * @return loginUser
	 * @throws Exception
	 */
	public User login(Connection conn, String userId, String userPw) throws Exception{
		
		User loginUser = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginUser = new User (rs.getInt("USER_NO"), userId, rs.getString("USER_NAME"), rs.getString("NICKNAME"),
						 rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("PROFILE"), rs.getString("ENROLL_DATE"));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginUser;
	}

	/** 아이디 찾기 DAO
	 * @param conn
	 * @param email
	 * @return findId
	 * @throws Exception
	 */
	public String findId(Connection conn, String email) throws Exception{
		
		String findId = null;
		
		try {
			String sql = prop.getProperty("findId");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				findId = rs.getString("USER_ID");
			}
						
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return findId;
	}

	public int emailCheck(Connection conn, String userId, String email) throws Exception{
		
		int emailCheck = 0;
		
		try {
			
			String sql = prop.getProperty("emailCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emailCheck = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return emailCheck;
				
	}

	/** 비밀번호 찾기 DAO
	 * @param conn
	 * @param userId
	 * @param userPw1
	 * @return findPw
	 * @throws Exception
	 */
	public int findPw(Connection conn, String userId, String userPw1) throws Exception {
		
		int findPw = 0;
		
		try {
			
			String sql = prop.getProperty("findPw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPw1);
			pstmt.setString(2, userId);
			
			findPw = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return findPw;
	}

}
