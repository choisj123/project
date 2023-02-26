package com.villagehall.nonUser.model.service;

import static com.villagehall.common.JDBCTemplate.*;

import java.sql.Connection;

import com.villagehall.nonUser.model.dao.NonUserDAO;
import com.villagehall.user.model.vo.User;

public class NonUserService {

	private NonUserDAO dao = new NonUserDAO();
	
	/** 아이디 중복 검사 서비스
	 * @param userId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String userId) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, userId);
		
		close(conn);
		
		return result;
	}

	/** 닉네임 중복 검사 서비스
	 * @param nickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String nickname) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.nicknameDupCheck(conn, nickname);
		
		close(conn);
		
		return result;
	}

	/** 회원 가입 서비스
	 * @param userId
	 * @param userPw1
	 * @param userName (이메일 프로필사진 보류)
	 * @param nickname 
	 * @param email 
	 * @param phone 
	 * @return result
	 * @throws Exception
	 */
	public int signUp(String userId, String userPw1, String userName, String nickname, String email, String phone) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, userId, userPw1, userName, nickname, email, phone);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 로그인 서비스
	 * @param userId
	 * @param userPw
	 * @return loginUser
	 * @throws Exception
	 */
	public User login(String userId, String userPw) throws Exception{

		Connection conn = getConnection();
		
		User loginUser = dao.login(conn, userId, userPw);
		
		close(conn);
		
		return loginUser;
	}

}
