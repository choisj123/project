package com.villagehall.user.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.nonUser.controller.NonUserController;
import com.villagehall.user.model.service.UserService;
import com.villagehall.user.model.vo.User;

public class UserController {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserService service = new UserService();
	
	private User loginUser = null;
	
	private int input = -1;

	// 실험용 유저 메뉴
	public void userMenu(User loginUser) {
		
		int input = -1;
		
		do {
			try {
				System.out.println("임시 로그인 메뉴");
				System.out.println("1. 로그인 회원 정보 조회");
				
				System.out.print("\n메뉴 선택 :");
				
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				switch(input) {
				case 1: selectMyInfo(); break;
				default: System.out.println("임시임");
				}
				System.out.println();
				
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("숫자 다시입력");
				sc.nextLine(); // 잘못된문자열 제거
			}
		} while (input != 0);
	}

	
	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		loginUser.toString();
	}

}
