package com.villagehall.board.model.vo;

import java.util.List;

import com.villagehall.comment.model.vo.Comment;

public class Board {
	
	// 게시글 필드
	private int boardNo; // 게시글 번호
	private String boardTitle; // 게시글 제목
	private String boardContent; // 게시글 내용
	private String createDate; // 게시글 작성일
	private int readCount; // 게시글 조회수
	private String location; // 게시글 위치 데이터
	private String deleteFlag; // 게시글 삭제여부
	private int userNo; // 작성자 회원 번호
	private String userName; // 작성자 회원 이름
	private int commentCount; // 댓글 수
	
	private List<Comment> commentList; // 댓글 목록
	
	//기본 생성자
	public Board() {
		// TODO Auto-generated constructor stub
	}

	//매개변수
	public Board(int boardNo, String boardTitle, String boardContent, String createDate, int readCount, String location,
			String deleteFlag, int userNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.readCount = readCount;
		this.location = location;
		this.deleteFlag = deleteFlag;
		this.userNo = userNo;
	}
	
	//메서드
	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	


	
}
