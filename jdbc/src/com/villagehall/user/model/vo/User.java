package com.villagehall.user.model.vo;

public class User {
	
	// 회원 필드
	private int userNo; // 회원 번호
	private String userNickname; // 닉네임
	private String userEmail; // 이메일
	private String userPw; // 비밀번호
	private String userCreateDate; // 가입일
	private String kakaoUserKey; // 카카오 유저키
	private String userDeleteFG; // 탈퇴여부
	private String administer; // 관리자 여부
	
	// 기본 생성자
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userNo, String userNickname, String userEmail, String userPw, String userCreateDate,
			String kakaoUserKey, String userDeleteFG, String administer) {
		super();
		this.userNo = userNo;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userCreateDate = userCreateDate;
		this.kakaoUserKey = kakaoUserKey;
		this.userDeleteFG = userDeleteFG;
		this.administer = administer;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(String userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	public String getKakaoUserKey() {
		return kakaoUserKey;
	}

	public void setKakaoUserKey(String kakaoUserKey) {
		this.kakaoUserKey = kakaoUserKey;
	}

	public String getUserDeleteFG() {
		return userDeleteFG;
	}

	public void setUserDeleteFG(String userDeleteFG) {
		this.userDeleteFG = userDeleteFG;
	}

	public String getAdminister() {
		return administer;
	}

	public void setAdminister(String administer) {
		this.administer = administer;
	}
	
}
