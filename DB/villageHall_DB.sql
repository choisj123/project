--DROP TABLE "BOARD";
--DROP TABLE "USER";
--DROP TABLE "COMMENT";
--DROP TABLE "PROFILE";
--DROP TABLE "CATEGORY";
--DROP TABLE "BOARD_IMAGE"; 
--DROP TABLE "EMAIL_VERIFY";
--DROP TABLE "LIKE";


CREATE TABLE "USER" (
	"USER_NO"	NUMBER GENERATED ALWAYS AS IDENTITY,
	"USER_NICKNAME"	VARCHAR2(30)		NOT NULL,
	"USER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"USER_PW"	VARCHAR2(30)		NOT NULL,
	"USER_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"KAKAO_USER_KEY"	VARCHAR2(30)		NULL,
	"USER_DELETE_FG"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"ADMINISTER"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	CONSTRAINT CK_USER_DELETE_FG CHECK(USER_DELETE_FG IN ('Y', 'N')),
	CONSTRAINT CK_ADMINISTER CHECK(ADMINISTER IN ('Y', 'N'))
);

ALTER TABLE "USER" ADD CONSTRAINT "PK_USER" PRIMARY KEY (
	"USER_NO"
);

COMMENT ON COLUMN "USER"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "USER"."USER_NICKNAME" IS '닉네임';

COMMENT ON COLUMN "USER"."USER_EMAIL" IS '이메일';

COMMENT ON COLUMN "USER"."USER_PW" IS '비밀번호';

COMMENT ON COLUMN "USER"."USER_CREATE_DATE" IS '가입일';

COMMENT ON COLUMN "USER"."KAKAO_USER_KEY" IS '카카오 회원가입 토큰';

COMMENT ON COLUMN "USER"."USER_DELETE_FG" IS '탈퇴여부(Y,N)';

COMMENT ON COLUMN "USER"."ADMINISTER" IS '관리자여부(Y,N)';

BEGIN
    FOR I IN 1..10
    LOOP
        INSERT INTO "USER" (USER_NICKNAME, USER_EMAIL, USER_PW, USER_CREATE_DATE, KAKAO_USER_KEY,USER_DELETE_FG,ADMINISTER  ) VALUES('TEST' || I , 'TEST' || I || '@gmail.com' , 'TEST' || I, SYSDATE, NULL, DEFAULT, DEFAULT );
    END LOOP;
    
    COMMIT;
END;



CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		GENERATED ALWAYS AS IDENTITY,
	"BOARD_TITLE"	VARCHAR2(100)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"READ_COUNT"	NUMBER		DEFAULT 0 NOT NULL,
	"CATEGORY" VARCHAR2(30) 	DEFAULT '기타' NOT NULL ,
	"LATITUDE"	NUMBER(10,6)		NOT NULL,
	"LONGITUDE"	NUMBER(10,6)		NOT NULL,
	"BOARD_DELETE_FG"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"USER_NO"	NUMBER		NOT NULL,
	CONSTRAINT CK_BOARD_DELETE_FG CHECK("BOARD_DELETE_FG" IN ('Y', 'N'))
);


ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."BOARD_CREATE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."CATEGORY" IS '카테고리 이름(공지사항, FAQ, 이슈, 맛집, 취미, 친목, 추천,기타)';

COMMENT ON COLUMN "BOARD"."LATITUDE" IS '위도';

COMMENT ON COLUMN "BOARD"."LONGITUDE" IS '경도';

COMMENT ON COLUMN "BOARD"."BOARD_DELETE_FG" IS '게시글 삭제 여부(Y,N)';

COMMENT ON COLUMN "BOARD"."USER_NO" IS '회원번호';

BEGIN
    FOR I IN 1..10
    LOOP
        INSERT INTO "BOARD"(BOARD_TITLE, BOARD_CONTENT, BOARD_CREATE_DATE, READ_COUNT, CATEGORY, LATITUDE, LONGITUDE, BOARD_DELETE_FG ,USER_NO ) 
       	VALUES( '게시글 제목' || I , '게시글 내용' || I , SYSDATE, DEFAULT,  DEFAULT, '0', '0', DEFAULT, I );
    END LOOP;
    
    COMMIT;
END;

CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		GENERATED ALWAYS AS IDENTITY,
	"COMMENT_CONTENT"	VARCHAR2(500)		NOT NULL,
	"COMMENT_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"COMMENT_DELETE_FG"	CHAR(2)	DEFAULT 'N'	NOT NULL,
	"USER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	CONSTRAINT CK_COMMENT_DELETE_FG CHECK(COMMENT_DELETE_FG IN ('Y', 'N'))
);


ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."COMMENT_CREATE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DELETE_FG" IS '댓글 삭제 여부 (Y,N)';

COMMENT ON COLUMN "COMMENT"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글 번호';

BEGIN
    FOR I IN 1..10
    LOOP
        INSERT INTO "COMMENT"(COMMENT_CONTENT, COMMENT_CREATE_DATE, COMMENT_DELETE_FG, USER_NO, BOARD_NO) 
       	VALUES( '댓글 내용' || I , SYSDATE, DEFAULT, I, I );
    END LOOP;
    
    COMMIT;
END;

CREATE TABLE "PROFILE" (
	"PROFILE_NO"	NUMBER		GENERATED ALWAYS AS IDENTITY,
	"PROFILE_NAME"	VARCHAR2(255)	DEFAULT '미정'	NOT NULL,
	"PROFILE_PATH"	VARCHAR2(500)	DEFAULT '미정'	NOT NULL,
	"PROFILE_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"USER_NO"	NUMBER		NOT NULL
);

ALTER TABLE "PROFILE" ADD CONSTRAINT "PK_PROFILE" PRIMARY KEY (
	"PROFILE_NO"
);

COMMENT ON COLUMN "PROFILE"."PROFILE_NO" IS '파일 번호';

COMMENT ON COLUMN "PROFILE"."PROFILE_NAME" IS '파일 이름';

COMMENT ON COLUMN "PROFILE"."PROFILE_PATH" IS '파일 경로';

COMMENT ON COLUMN "PROFILE"."PROFILE_CREATE_DATE" IS '생성일';

COMMENT ON COLUMN "PROFILE"."USER_NO" IS '회원번호';


BEGIN
    FOR I IN 1..10
    LOOP
        INSERT INTO "PROFILE"(PROFILE_NAME,PROFILE_PATH,PROFILE_CREATE_DATE, USER_NO) 
       	VALUES( '파일 이름' || I ,'파일 경로' || I , SYSDATE, I );
    END LOOP;
    
    COMMIT;
END;


CREATE TABLE "BOARD_IMAGE" (
	"IMAGE_NO"	NUMBER		GENERATED ALWAYS AS IDENTITY,
	"IMAGE_NAME"	VARCHAR2(255)	DEFAULT '미정'	NOT NULL,
	"IMAGE_PATH"	VARCHAR2(500)	DEFAULT '미정'	NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

ALTER TABLE "BOARD_IMAGE" ADD CONSTRAINT "PK_BOARD_IMAGE" PRIMARY KEY (
	"IMAGE_NO"
);

COMMENT ON COLUMN "BOARD_IMAGE"."IMAGE_NO" IS '이미지 번호';

COMMENT ON COLUMN "BOARD_IMAGE"."IMAGE_NAME" IS '이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMAGE"."IMAGE_PATH" IS '이미지 파일 경로';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_NO" IS '게시글 번호';



CREATE TABLE "EMAIL_VERIFY" (
	"EMAIL_KEY"	NUMBER		NOT NULL,
	"USER_NO"	NUMBER		NOT NULL,
	"EMAIL_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL
);


ALTER TABLE "EMAIL_VERIFY" ADD CONSTRAINT "PK_EMAIL_VERIFY" PRIMARY KEY (
	"EMAIL_KEY"
);

COMMENT ON COLUMN "EMAIL_VERIFY"."EMAIL_KEY" IS '이메일 인증키';

COMMENT ON COLUMN "EMAIL_VERIFY"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "EMAIL_VERIFY"."EMAIL_CREATE_DATE" IS '생성일';



CREATE TABLE "LIKE" (
	"USER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

ALTER TABLE "LIKE" ADD CONSTRAINT "PK_LIKE" PRIMARY KEY (
	"USER_NO",
	"BOARD_NO"
);

COMMENT ON COLUMN "LIKE"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "LIKE"."BOARD_NO" IS '게시글 번호';










ALTER TABLE "BOARD" ADD CONSTRAINT "FK_USER_TO_BOARD_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "USER" (
	"USER_NO"
);
ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_USER_TO_COMMENT_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "USER" (
	"USER_NO"
);
ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);
ALTER TABLE "PROFILE" ADD CONSTRAINT "FK_USER_TO_PROFILE_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "USER" (
	"USER_NO"
);
ALTER TABLE "BOARD_IMAGE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMAGE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);
ALTER TABLE "EMAIL_VERIFY" ADD CONSTRAINT "FK_USER_TO_EMAIL_VERIFY_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "USER" (
	"USER_NO"
);

ALTER TABLE "LIKE" ADD CONSTRAINT "FK_USER_TO_LIKE_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "USER" (
	"USER_NO"
);
ALTER TABLE "LIKE" ADD CONSTRAINT "FK_BOARD_TO_LIKE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);







