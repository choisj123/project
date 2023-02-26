package com.villagehall.user.model.vo;

public class User {
	
	// 회원 필드
	private int userNo; // 회원 번호
	private String userId; // 아이디
	private String userPw; // 비밀번호
	private String userName; // 회원 이름
	private String nickname; // 닉네임
	private String email; // 이메일
	private String phone; // 연락처
	private String profile; // 프로필 사진
	private String enrollDate; // 가입일
	private String secessionFlag; // 탈퇴여부
	
	// 기본 생성자
	public User() {
		// TODO Auto-generated constructor stub
	}

	//매개변수 생성자
	public User(int userNo, String userId, String userPw, String userName, String nickname, String email, String phone,
			String profile, String enrollDate, String secessionFlag) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.profile = profile;
		this.enrollDate = enrollDate;
		this.secessionFlag = secessionFlag;
	}
	
	// 매개변수 생성자2 (비밀번호 탈퇴여부 제외)
	public User(int userNo, String userId, String userName, String nickname, String email, String phone, String profile,
			String enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.profile = profile;
		this.enrollDate = enrollDate;
	}

	//메서드
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getSecessionFlag() {
		return secessionFlag;
	}

	public void setSecessionFlag(String secessionFlag) {
		this.secessionFlag = secessionFlag;
	}
	

}
