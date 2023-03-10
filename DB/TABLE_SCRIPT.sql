/*
DROP SEQUENCE SEQ_USER_NO;
DROP SEQUENCE SEQ_BOARD_NO;
DROP SEQUENCE SEQ_COMMENT_NO;
DROP TABLE "COMMENT";
DROP TABLE "BOARD";
DROP TABLE "USER";
*/


-- 회원 테이블 생성
CREATE TABLE "USER"(
	USER_NO NUMBER PRIMARY KEY,
	USER_ID VARCHAR2(16) NOT NULL,
	USER_PW VARCHAR2(20) NOT NULL,
	USER_NAME VARCHAR2(10) NOT NULL,
	NICKNAME VARCHAR2(25) NOT NULL,
	EMAIL VARCHAR2(50) NOT NULL,
	PHONE VARCHAR2(13),
	PROFILE VARCHAR2(100),
	ENROLL_DATE DATE DEFAULT SYSDATE,
	U_SECESSION_FG CHAR(1) DEFAULT 'N' CHECK( U_SECESSION_FG IN ('Y','N') ),
	UNIQUE(USER_ID),
	UNIQUE(NICKNAME),
	UNIQUE(EMAIL)
);

-- 회원 코멘트
COMMENT ON COLUMN "USER".USER_NO IS '회원 번호';
COMMENT ON COLUMN "USER".USER_ID IS '아이디';
COMMENT ON COLUMN "USER".USER_PW IS '비밀번호';
COMMENT ON COLUMN "USER".USER_NAME IS '회원 이름';
COMMENT ON COLUMN "USER".NICKNAME IS '닉네임';
COMMENT ON COLUMN "USER".EMAIL IS '이메일';
COMMENT ON COLUMN "USER".PHONE IS '연락처';
COMMENT ON COLUMN "USER".PROFILE IS '프로필 사진';
COMMENT ON COLUMN "USER".ENROLL_DATE IS '가입일';
COMMENT ON COLUMN "USER".U_SECESSION_FG IS '탈퇴여부';

--회원번호 시퀀스 생성
CREATE SEQUENCE SEQ_USER_NO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

--회원 등록 테스트용
INSERT INTO "USER" 
VALUES( SEQ_USER_NO.NEXTVAL, 'user01', 'pass01', '테스트', '닉네임테스트',
		'test@test.com', '010-0000-0000', NULL, DEFAULT, DEFAULT);
		
COMMIT;

-- 게시판 테이블 생성
CREATE TABLE "BOARD" (
	BOARD_NO NUMBER PRIMARY KEY,
	BOARD_TITLE VARCHAR2(100) NOT NULL,
	BOARD_CONTENT VARCHAR2(1000) NOT NULL,
	B_CREATE_DATE DATE DEFAULT SYSDATE,
	READ_COUNT NUMBER DEFAULT 0,
	LOCATION VARCHAR(40) DEFAULT '0.0.0.0',
	B_DELETE_FG CHAR(1) DEFAULT 'N' CHECK( B_DELETE_FG IN ('N', 'Y') ),
	USER_NO NUMBER REFERENCES "USER"
);

-- 게시판 코멘트
COMMENT ON COLUMN "BOARD".BOARD_NO 		IS '게시글 번호';
COMMENT ON COLUMN "BOARD".BOARD_TITLE 	IS '게시글 제목';
COMMENT ON COLUMN "BOARD".BOARD_CONTENT IS '게시글 내용';
COMMENT ON COLUMN "BOARD".B_CREATE_DATE 	IS '게시글 작성일';
COMMENT ON COLUMN "BOARD".READ_COUNT 	IS '게시글 조회수';
COMMENT ON COLUMN "BOARD".LOCATION IS '게시글 위치 데이터';
COMMENT ON COLUMN "BOARD".B_DELETE_FG 	IS '게시글 삭제여부';
COMMENT ON COLUMN "BOARD".USER_NO 	IS '작성자 회원 번호';

-- 게시판 번호 시퀀스 생성
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;

-- 게시글 등록 테스트
INSERT INTO BOARD 
VALUES(SEQ_BOARD_NO.NEXTVAL, '게시글 인서트 테스트2', '테스트 2번째',DEFAULT, DEFAULT ,DEFAULT, DEFAULT, 1);

COMMIT;

-- 댓글 테이블 생성
CREATE TABLE "COMMENT"(
	COMMENT_NO NUMBER PRIMARY KEY,
	COMMENT_CONTENT VARCHAR2(300) NOT NULL,
	C_CREATE_DATE DATE DEFAULT SYSDATE,
	C_DELETE_FG CHAR(1) DEFAULT 'N' CHECK(C_DELETE_FG IN ('N', 'Y')),
	USER_NO NUMBER REFERENCES "USER",
	BOARD_NO NUMBER REFERENCES "BOARD"
);

-- 댓글 코멘트 작성
COMMENT ON COLUMN "COMMENT".COMMENT_NO IS '댓글 번호';
COMMENT ON COLUMN "COMMENT".COMMENT_CONTENT IS '댓글 내용';
COMMENT ON COLUMN "COMMENT".C_CREATE_DATE IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT".C_DELETE_FG IS '댓글 삭제 여부';
COMMENT ON COLUMN "COMMENT".USER_NO IS '댓글 작성자 회원 번호';
COMMENT ON COLUMN "COMMENT".BOARD_NO IS '댓글이 작성된 게시글 번호';

-- 댓글 번호 시퀀스 생성
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE;

-- 댓글 등록 테스트
INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플 내용 샘플', DEFAULT, DEFAULT, 1, 1 );

COMMIT;