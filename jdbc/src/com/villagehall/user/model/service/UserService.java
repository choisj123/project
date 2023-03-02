package com.villagehall.user.model.service;

import java.sql.Connection;
import static com.villagehall.common.JDBCTemplate.*;

import com.villagehall.user.model.dao.UserDAO;
import com.villagehall.user.model.vo.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	public String checkPw(User loginUser) throws Exception {
		
		Connection conn = getConnection();
		
		String checkPw = dao.checkPw(conn, loginUser);
		
		close(conn);
		
		return checkPw;
	}

	/** 변경할 닉네임 중복 검사 서비스
	 * @param updateNickname
	 * @return nicknameDupCheck
	 * @throws Exception
	 */
	public int nicknameDupCheck(String updateNickname) throws Exception{
		
		Connection conn = getConnection();
		
		int nicknameDupCheck = dao.nicknameDupCheck(conn, updateNickname);
		
		close(conn);
		
		return nicknameDupCheck;
	}

	/** 닉네임 변경 서비스
	 * @param userId
	 * @param updateNickname
	 * @return result
	 * @throws Exception
	 */
	public int updateNickname(String userId, String updateNickname) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateNickname(conn, userId, updateNickname);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 이메일 변경 서비스
	 * @param userId
	 * @param updateEmail
	 * @return result
	 * @throws Exception
	 */
	public int updateEmail(String userId, String updateEmail) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateEmail(conn, userId, updateEmail);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경 서비스
	 * @param userId
	 * @param userPw1
	 * @return updatePw
	 * @throws Exception
	 */
	public int updatePw(String userId, String userPw1) throws Exception {
		
		Connection conn = getConnection();
		
		int updatePw = dao.updatePw(conn, userId, userPw1);
		
		if(updatePw > 0) commit(conn);
		else				rollback(conn);
		
		close(conn);
		
		return updatePw;
	}

}
