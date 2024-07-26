CREATE TABLE basic_board3 (
	-- 컬럼명 데이터타입 [제약조건들] 
	-- / DATETIME 날짜,시분초까지 나옴, UNIQUE 중복 불가, 빈 문자열 != NULL
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY 
	, TITLE VARCHAR(50) NOT NULL
	, WRITER VARCHAR(50) NOT NULL 
	, CONTENT VARCHAR(100)  
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
	, READ_CNT INT DEFAULT 0
	
);


SELECT * FROM basic_board3;

DELETE FROM basic_board3;