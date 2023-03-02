package com.villagehall.user.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.board.controller.BoardController;
import com.villagehall.nonUser.controller.NonUserController;

import com.villagehall.user.model.service.UserService;
import com.villagehall.user.model.vo.User;

public class UserController {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserService service = new UserService();
	private BoardController boardController = new BoardController();
	
	private User loginUser = null;
	
	
	private int input = -1;
	
	
	

	// 실험용 유저 메뉴
	public void userMenu(User loginUser) {
		
		this.loginUser = loginUser;
		
		System.out.println(loginUser.getUserName());
		
		
		do {
			try {
				System.out.println("임시 로그인 메뉴");
				System.out.println("1. 로그인 회원 정보 수정");
				System.out.println("2. 게시판");
				System.out.println("0. 로그아웃");
				
				System.out.print("\n메뉴 선택 :");
				
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				switch(input) {
				case 1: updateInfo(loginUser); break;
				case 2: boardController.BoardMenu(loginUser); break; // 게시판 이동
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
				System.out.println("9. 뒤로가기");
				System.out.println("0. 로그아웃");
				
				System.out.print("메뉴선택 >>");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				switch (input) {
				case 1: updateNickname(loginUser); break;
				case 2: updateEmail(loginUser); break;
				case 3: updatePw(loginUser); break;
				case 9: System.out.println("이전메뉴 이동");
				return;
				case 0: System.out.println("로그아웃되셨습니다");
				loginUser = null;
				return;
				default : System.out.println("번호 다시 입력");
				}
				System.out.println();
					
			} while(input != 0);
				
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	 
	}

	
	/** 닉네임 변경 화면
	 * @param loginUser
	 */
	private void updateNickname(User loginUser) {
		
		String CurrentNickname = loginUser.getNickname();
		String userId = loginUser.getUserId();
		
		try {
			while(true) {
				System.out.print("변경할 닉네임 : ");
				String updateNickname = sc.next();
				
				int nicknameDupCheck = service.nicknameDupCheck(updateNickname);
				
				System.out.println();
				
				if(nicknameDupCheck == 0) {
					
					int result = service.updateNickname(userId, updateNickname);
					
					System.out.println();
					
					if (result > 0) {
						System.out.println(CurrentNickname + "님의 닉네임이 " + 
					updateNickname + "(으)로 변경되었습니다");
						break;
					} else {
						System.out.println("닉네임 변경 실패");
						break;
					}
					
				} else {
					System.out.println("사용중인 닉네임 입니다");
				}
				System.out.println();
			}
						
		} catch(Exception e) {
			System.out.println("닉네임 변경 중 오류 발생");
			e.printStackTrace();
		}
		
		
	}	
	
	/** 이메일 변경화면(인증X)
	 * @param loginUser
	 */
	private void updateEmail(User loginUser) {
		
		String currentEmail = loginUser.getEmail();
		String userId = loginUser.getUserId();
		
		try {
			System.out.println("변경할 이메일 : ");
			String updateEmail = sc.next();
			
			int result = service.updateEmail(userId, updateEmail);
			
			System.out.println();
			
			if (result > 0) {
				System.out.println("이메일이 변경되었습니다");
				System.out.println(currentEmail + "->" + updateEmail);
				return;
			} else {
				System.out.println("이메일 변경 실패");
				return;
			}
			
		} catch(Exception e) {
			System.out.println("이메일 변경 도중 오류 발생");
			e.printStackTrace();
		}
	}
	
	/** 비밀번호 수정 화면
	 * @param loginUser
	 */
	private void updatePw(User loginUser) {
		
		String userId = loginUser.getUserId();
		
		try {
			
			while(true) {
				System.out.print("변경할 비밀번호 : ");
				String userPw1 = sc.next();
				System.out.print("변경할 비밀번호 확인 : ");
				String userPw2 = sc.next();
				
				System.out.println();
				if (userPw1.equals(userPw2)) { // 비밀번호 일치
					
					int updatePw = service.updatePw(userId, userPw1);
					if(updatePw > 0) {
						System.out.println("비밀번호를 변경하였습니다");
					} else {
						System.out.println("비밀번호 변경 실패");
					}
					System.out.println();
					return;
					
				} else { // 비밀번호 불일치
					System.out.println("비밀번호 불일치");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			System.out.println("비밀번호 변경 중 오류 발생");
			e.printStackTrace();
		}
	}


	


	



}
