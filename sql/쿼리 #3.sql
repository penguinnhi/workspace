
-- DB 연결 연습용 테이블
CREATE TABLE TEST_MEMBER(
	MEM_NUM INT PRIMARY KEY
	, MEM_NAME VARCHAR(50)
	, MEM_AGE INT
	, MEM_ADDR VARCHAR(50)
	
);

SELECT * FROM test_member;


-- 데이터 삽입 
INSERT INTO test_member VALUES (1, '홍길동', 20, '서울시');
INSERT INTO test_member VALUES (2, '김수한무', 30, '청주시');
INSERT INTO test_member VALUES (3, '거북이', 25, '울산시');
INSERT INTO test_member VALUES (4, '두루미', 10, '부산시');
INSERT INTO test_member VALUES (5, '장길산', 40, '인천시');
COMMIT;
