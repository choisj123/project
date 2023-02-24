package com.villagehall.comment.model.vo;

public class Comment {
	
	// 댓글 필드
	private int commentNo; // 댓글 번호
	private String commentContent; // 댓글 내용
	private String createDate; // 댓글 작성일
	private String secessionFlag; // 댓글 삭제여부
	private int userNo; // 작성자 회원 번호
	private String userName; // 작성자 회원 이름
	private int boardNo; // 작성된 게시글 번호
	
	
	// 기본생성자
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	// 매개변수 생성자
	public Comment(int commentNo, String commentContent, String createDate, String secessionFlag, int userNo,
			int boardNo) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.createDate = createDate;
		this.secessionFlag = secessionFlag;
		this.userNo = userNo;
		this.boardNo = boardNo;
	}
	
	// 메서드
	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}


	public String getCommentContent() {
		return commentContent;
	}


	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getSecessionFlag() {
		return secessionFlag;
	}


	public void setSecessionFlag(String secessionFlag) {
		this.secessionFlag = secessionFlag;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
	

}
