package com.villagehall.board.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.villagehall.nonUser.controller.NonUserController;
import static com.villagehall.nonUser.controller.NonUserController.*;
import com.villagehall.user.controller.UserController;
import com.villagehall.user.model.vo.User;

public class BoardController {
	
	private Scanner sc = new Scanner(System.in);
	
	private User loginUser = null;
	

	// 게시판(공지사항 전체글 인기글 FAQ
	public void BoardMenu(User loginUser) {
		
		this.loginUser = loginUser;
		
		int input = -1 ;
		
		do {
			try {
				if(loginUser != null ) {
					System.out.println("게시판 메뉴");
					System.out.println("1.공지사항");
					System.out.println("2.전체글");
					System.out.println("3.인기글");
					System.out.println("4.FAQ");
					System.out.println("9.뒤로가기");
					System.out.println("0.로그아웃");
				} else if(loginUser == null) {
					System.out.println("게시판 메뉴");
					System.out.println("1.공지사항");
					System.out.println("2.전체글");
					System.out.println("3.인기글");
					System.out.println("4.FAQ");
					System.out.println("0.뒤로가기");
				}
				
				
				System.out.println("\n메뉴선택 : ");
				
				input = sc.nextInt();
				
				sc.nextLine(); // 개행
				
				if(loginUser != null) {
					switch(input) {
					case 1: notice(); break;
					case 2: selectAllBoard(); break;
					case 3: selectFavoriteBoard(); break;
					case 4: selectFAQ(); break;
					case 9: System.out.println("이전메뉴로 돌아갑니다");
					return;
					case 0: System.out.println("로그아웃");
					loginUser = null;
					input = 0;
					
					
					NonUserController nonUserController = new NonUserController();
					nonUserController.mainMenu();
					
					
					default:
						System.out.println("번호 다시입력");
					}
		
				} else {
					switch(input) {
					case 1: notice(); break;
					case 2: selectAllBoard(); break;
					case 3: selectFavoriteBoard(); break;
					case 4: selectFAQ(); break;
					case 0: System.out.println("이전메뉴로 돌아갑니다");
					break;
					default:
						System.out.println("번호 다시입력");
					}
				}
				
				
				
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n다시 입력해주세요");
				sc.nextLine(); // 개행
			}
		} while(input != 0);
	}

	

	

	

	private void notice() {
		System.out.println("공지사항 이동확인");
	}
	
	private void selectAllBoard() {
		System.out.println("전체글 이동확인");
	}
	
	private void selectFavoriteBoard() {
		System.out.println("인기글 이동확인");
	}
	
	private void selectFAQ() {
		System.out.println("FAQ 이동확인");
	}
		
}
