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

}
