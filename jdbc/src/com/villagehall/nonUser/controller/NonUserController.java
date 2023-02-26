package com.villagehall.nonUser.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.board.controller.BoardController;
import com.villagehall.nonUser.model.service.NonUserService;
import com.villagehall.user.controller.UserController;
import com.villagehall.user.model.vo.User;

public class NonUserController {
	
	private Scanner sc = new Scanner(System.in);
	
	public static User loginUser=  null;
	
	private NonUserService service = new NonUserService();
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

	/**
	 *  회원 가입 화면
	 */
	private void signUp() {
		System.out.println("회원 가입");
		// 아이디(중복확인) 비밀번호 비밀번호확인 닉네임(중복확인) 이메일(인증) 프로필사진
		
		String userId = null;
		
		String userPw1 = null;
		String userPw2 = null;
		
		String userName = null;
		String nickname = null;
		
		String email = null;
		String phone = null;
		
		
		try {
			// 아이디 중복 확인
			while(true) {
				System.out.print("아이디입력 : ");
				userId = sc.next();
				
				int result = service.idDupCheck(userId);
				
				System.out.println();
				
				// 중복X
				if(result == 0) {
					System.out.println("사용가능아이디");
					break;
				} else { // 중복O
					System.out.println("사용중인 아이디");
				}
				System.out.println();
			}
			
			// 비밀번호 입력 (일치확인)
			
			while(true) {
				System.out.print("비밀번호 : ");
				userPw1 = sc.next();
				System.out.print("비밀번호 확인 : ");
				userPw2 = sc.next();
				
				System.out.println();
				if (userPw1.equals(userPw2)) { // 비밀번호 일치
					System.out.println("비밀번호 일치");
					break;
				} else { // 비밀번호 불일치
					System.out.println("비밀번호 불일치");
				}
				System.out.println();
			}
			
			System.out.print("이름입력 : ");
			userName = sc.next();
			
			// 닉네임 입력 (중복확인)
			while(true) {
				System.out.print("닉네임입력 : ");
				nickname = sc.next();
				
				int result = service.nicknameDupCheck(nickname);
				
				System.out.println();
				
				// 중복X
				if(result == 0) {
					System.out.println("사용가능닉네임");
					break;
				} else { // 중복O
					System.out.println("사용중인 닉네임");
				}
				System.out.println();
			}
			
			//이메일인증 , 프로필 사진 등록
			
			System.out.print("이메일 등록");
			email = sc.next();
			System.out.print("핸드폰번호 등록(- 포함)");
			phone = sc.next();
			
			// 아이디 비밀번호 닉네임 (이메일 프로필사진) 입력 완료
			
			int result = service.signUp(userId, userPw1, userName, nickname, email, phone);
			
			System.out.println();
			
			if (result > 0) {
				System.out.println("회원가입성공");
			} else {
				System.out.println("회원가입실패");
			}
			System.out.println();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 중 예외 발생");
		}
		
	}

	/**
	 * 로그인 화면
	 */
	private void login() {
		System.out.println("로그인");
		
		System.out.print("아이디 : ");
		String userId = sc.next();
		
		System.out.print("비밀번호 : ");
		String userPw = sc.next();
		
		try {
			loginUser = service.login(userId, userPw);
			
			System.out.println();
			if(loginUser != null) { // 로그인 성공
				System.out.println(loginUser.getUserName() + "님 로그인 성공");
			} else { // 로그인 실패
				System.out.println("아이디나 비밀번호 불일치");
			}
			System.out.println();
			
		} catch(Exception e) {
			System.out.println("로그인중 예외 발생");
		}
	}
}
