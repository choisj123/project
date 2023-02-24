package com.villagehall.user.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.user.model.service.UserService;
import com.villagehall.user.model.vo.User;

public class UserController {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserService service = new UserService();
	
	private User loginUser = null;
	
	private int input = -1;

	// 실험용 유저 메뉴
	public static void userMenu(User loginUser) {
		
		this.loginUser = loginUser;
		
		int input = -1;
		
		do {
			try {
				
				
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("숫자 다시입력");
				sc.nextLine(); // 잘못된문자열 제거
			}
		} while (input == 0);
	}

}
