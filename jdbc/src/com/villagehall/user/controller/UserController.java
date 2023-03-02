package com.villagehall.user.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.nonUser.controller.NonUserController;

import com.villagehall.user.model.service.UserService;
import com.villagehall.user.model.vo.User;

public class UserController {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserService service = new UserService();
	
	
	private int input = -1;
	
	
	

	// 실험용 유저 메뉴
	public void userMenu(User loginUser) {
		System.out.println(loginUser.getUserName());
		
		
		do {
			try {
				System.out.println("임시 로그인 메뉴");
				System.out.println("1. 로그인 회원 정보 수정");
				System.out.println("0. 로그아웃");
				
				System.out.print("\n메뉴 선택 :");
				
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				switch(input) {
				case 1: updateInfo(loginUser); break;
				case 0: 
					System.out.println("로그아웃이 완료되었습니다");
					loginUser = null;
					return;
				default: System.out.println("임시임");
				}
				System.out.println();
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("숫자 다시입력");
				sc.nextLine(); // 잘못된문자열 제거
			}
		} while (input != 0);
	}

	
	/**
	 *  회원 정보 수정
	 * @param loginUser 
	 */
	private void updateInfo(User loginUser) throws Exception{
		
		
		
		
		System.out.println("회원 정보 수정");
			
		// 비밀번호 확인
		System.out.print("비밀번호 입력 : ");
		String userPw = sc.next();
		
		String checkPw = service.checkPw(loginUser);
			
		System.out.println();
			
		if (userPw.equals(checkPw)) {
			do {
				System.out.println("1. 닉네임 수정 : ");
				System.out.println("2. 이메일 수정 : ");
				System.out.println("3. 비밀번호 수정 : ");
				System.out.println("0. 뒤로가기");
				
				System.out.print("메뉴선택 >>");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				switch (input) {
				case 1: updateNickname(); break;
				case 2: updateEmail(); break;
				case 3: updatePw(); break;
				case 0: System.out.println("이번메뉴 이동");
				default : System.out.println("번호 다시 입력");
				}
				System.out.println();
					
			} while(input != 0);
				
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
			
		
			
			
		
	 
	}


	private void updatePw() {
		// TODO Auto-generated method stub
		
	}


	private void updateEmail() {
		// TODO Auto-generated method stub
		
	}


	private void updateNickname() {
		// TODO Auto-generated method stub
		
	}



}
