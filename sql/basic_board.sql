-- 테이블 삭제
DROP TABLE basic_board; --  테이블 삭제
DELETE FROM basic_board; -- 데이터 삭제 


-- 게시판 프로그램 테이블 생성

CREATE TABLE BASIC_BOARD (
	-- 컬럼명 데이터타입 [제약조건들] 
	-- / DATETIME 날짜,시분초까지 나옴, UNIQUE 중복 불가, 빈 문자열 != NULL
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY 
	, TITLE VARCHAR(50) NOT NULL
	, WRITER VARCHAR(50) NOT NULL 
	, CONTENT VARCHAR(100)  
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
	, READ_CNT INT DEFAULT 0
	
);

INSERT INTO basic_board (TITLE,WRITER,CONTENT) 
VALUES ('COUNT ON ME', '작성자', 'YOU CAN COUNT ON ME LIKE ONE TWO THREE I`LL BE THERE');

INSERT INTO basic_board (TITLE,WRITER,CONTENT) 
VALUES ('PUZZLE', '쥬얼리', '그대 갑자기 사라져버리는 꿈들을 요즘들어 자주 본다며');


INSERT INTO basic_board (TITLE,WRITER,CONTENT) 
VALUES ('BUTTERFLY', '디지몬', '그래 그리 쉽지는 않겠지 나를 허락해준 세상이라 손쉽게 다가오는 아름답고 감미로운 공간은 아냐');


SELECT * FROM basic_board;

-- 아이디가 자바인 회원이 작성한 게시글의 글 제목,내용,작성자id,작성자명을 조회
SELECT B.TITLE,B.CONTENT,M.MEM_ID,M.MEM_NAME
FROM board B,board_member M
WHERE M.MEM_ID='hihi'; 



