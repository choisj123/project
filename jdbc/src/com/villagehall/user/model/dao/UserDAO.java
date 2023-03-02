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

}
