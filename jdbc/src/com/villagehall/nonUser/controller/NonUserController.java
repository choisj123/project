package com.villagehall.nonUser.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.board.controller.BoardController;
import com.villagehall.user.controller.UserController;
import com.villagehall.user.model.vo.User;

public class NonUserController {
	
	private Scanner sc = new Scanner(System.in);
	
	public static User loginUser=  null;
	
	private UserController userController = new UserController();
	private BoardController boardController = new BoardController();
	
	public void mainMenu() {
		
		int input = -1;
		
		do {
			try {
				// 로그인 X
				if(loginUser == null) {
					System.out.println("메서드 확인용 디스플레이");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴선택:");
					
					input = sc.nextInt();
					
					sc.nextLine(); // 개행
					
					switch(input) {
					case 1: login(); break; // 로그인
					case 2: signUp(); break; // 회원 가입
					case 0:
						System.out.println("프로그램 종료");
						break;
					default:
						System.out.println("번호 다시입력");
					}
					
				} else { // 로그인 O
					UserController.userMenu(loginUser);
				}
				
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n다시입력해주세요");
				sc.nextLine(); // 잘못된문자열 제거
				
			}
		} while(input != 0);
		
	}

	private void signUp() {
		// TODO Auto-generated method stub
		
	}

	private void login() {
		// TODO Auto-generated method stub
		
	}
}
