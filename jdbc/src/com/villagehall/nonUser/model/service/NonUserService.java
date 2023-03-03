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

	/** 아이디 찾기 서비스
	 * @param email
	 * @return findId
	 * @throws Exception
	 */
	public String findId(String email) throws Exception {

		Connection conn = getConnection();
		
		String findId = dao.findId(conn, email);
		
		close(conn);
		
		return findId;
	}

	/** 이메일체크 서비스 (아이디확인후 아이디,이메일 일치하는 회원 조회)
	 * @param userId
	 * @param email
	 * @return emailCheck
	 * @throws Exception
	 */
	public int emailCheck(String userId, String email) throws Exception{
		
		Connection conn = getConnection();
		
		int emailCheck = dao.emailCheck(conn, userId, email);
		
		close(conn);
		
		return emailCheck;
	}

	/** 비밀번호 찾기 서비스(변경)
	 * @param userId
	 * @param userPw1
	 * @return findPw
	 * @throws Exception
	 */
	public int findPw(String userId, String userPw1) throws Exception{
		
		Connection conn = getConnection();
		
		int findPw = dao.findPw(conn, userId, userPw1);
		
		if(findPw > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return findPw;
	}

}
