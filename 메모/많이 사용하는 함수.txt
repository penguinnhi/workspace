
-- 많이 사용하는 함수

SELECT 'JAVA',123;
SELECT 'JAVA' FROM board;

-- 문자열 나열 함수
SELECT 'JAVA','HELLO' , CONCAT('JAVA','HELLO');
SELECT BOARD_NUM,TITLE, CONCAT(BOARD_NUM,'_',TITLE) AS BOARD_INFO
FROM board;

-- 문자열의 길이 
SELECT 'JAVA', LENGTH('JAVA'), 'HELLO', LENGTH('HELLO');

-- 일부 문자열 추출 
-- SUBSTRING(원본글자, 추출시작 인덱스(1부터 시작), 추출 개수)
SELECT 'ABCDEFG'
, SUBSTRING('ABCDEFG',3)
, SUBSTRING('ABCDEFG',3,2);

-- 대소문자 변경 함수 
SELECT 'Mysql', UPPER('Mysql'), LOWER('Mysql');

-- 문자나 숫자의 자릿수 맞추기 
SELECT LPAD('LEFT',5,'#'), RPAD('RIGHT',6,'!'), LPAD('001',10,'0');

-- 문자열의 좌우 공백 제거 
SELECT '  AA BB  ',LTRIM('  AA BB  '),RTRIM('  AA BB  '),TRIM('  AA BB  ');

-- 문자열 치환 함수 
SELECT '010 1111 2222', REPLACE('010 1111 2222',' ','-');

-- 반올림 함수
SELECT 123.456,ROUND(123.456,2);

-- 연산 및 나머지 연산자
SELECT 10+10, 2*3, 15/4, MOD(10,3);

-- NULL 데이터를 치환하는 함수
SELECT COMM, IFNULL(COMM,0) FROM emp;


-- DB시험 EMP테이블 기준으로 냄 
-- 단일 행 함수 : 데이터의 개수와 상관없이 조회 결과 하나의 행 결과만 갖는 함수 
-- SUM(), MAX(), MIN(), AVG(), COUNT()
SELECT * FROM emp;

-- 모든 사원의 급여 총합 및 커미션 총합을 조회 
-- SUM(10,10) < 이런 쿼리는 불가
SELECT SUM(SAL) AS 급여총합, SUM(COMM) AS 커미션총합 FROM emp;

-- SUM() 함수의 위의 함수와의 다른점 ? 
-- SUM() 함수는 데이터의 수와 상관없이 무조건 하나의 조회 결과 
SELECT LENGTH(ENAME), LENGTH(JOB) FROM emp;

-- **쿼리 조회 시 조회하는 모든 컬럼의 조회 행 개수는 모두 일치해야함 
-- 모든 사원의 이름과 급여의 합을 조회
-- (사원 수만큼 조회되고)(하나의 조회결과만 나와서 조회안됨)


SELECT SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL), COUNT(SAL) FROM emp;

-- 테이블에 있는 데이터의 수
SELECT COUNT(*) FROM emp;
-- 추천하는 방법 : COUNT(PK)
SELECT COUNT(EMPNO) FROM emp;

-- NULL데이터를 COUNT에서 제외함
SELECT COUNT(COMM) FROM emp;

-- 평균 계산 시 NULL 데이터 주의
SELECT AVG(COMM) FROM emp;

-- COMM 컬럼의 평균 값을 계산하는 다른 방법 
SELECT ROUND(AVG(IFNULL(COMM,0)),2) AS COMM평균 FROM emp;


-- 날짜 관련 함수 및 기능



-- 현재 날짜 및 시간 조회 
SELECT NOW();
-- 현재 날짜만 조회
SELECT CURRENT_DATE();
-- 현재 시간만 조회
SELECT CURRENT_TIME();

-- 날씨 조회 시 포맷(형태) 지정하기
-- DATE_FORMAT(조회할 날짜, 포맷)
-- Y: 연도를 4자리로 표현 , y : 연도를 2자리로 표현
-- M : 월을 문자로 표현(영어식) , m : 월을 두 자리 숫자로 표현
-- D : 일자를 서수식으로 표현 , d : 일자를 두 자리 숫자로 표현
-- H : 시간을 24시간기준으로 표현 , h : 시간을 12시간 기준으로 표현
-- i : 분을 두 자리 숫자로 표현 , s : 초를 두 자리 숫자로 표현 
SELECT NOW()
, DATE_FORMAT(NOW(),'%Y-%m-%d') AS NOW
, DATE_FORMAT(NOW(),'%y-%M-%D') AS NOW1
, DATE_FORMAT(NOW(),'%Y%m%d') AS NOW2
, DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s') AS NOW3;

-- 날짜 및 시간에서 특정 정보만 추출하기
SELECT NOW()
	, YEAR(NOW()) AS Y
	, MONTH(NOW()) AS M
	, DAY(NOW()) AS D
	, HOUR(NOW()) AS H
	, MINUTE(NOW()) AS M 
	, SECOND(NOW()) AS S;


SELECT * FROM emp;
-- 2월에 입사한 사원의 사번, 이름, 입사일을 조회 
-- 입사일은 2024-10-10 형태로 조회
SELECT EMPNO, ENAME, DATE_FORMAT(HIREDATE,'%Y-%m-%d') AS DATE
FROM emp
-- WHERE MONTH(HIREDATE)=2; 시험에 나옵니다 ********************************************
WHERE SUBSTRING(HIREDATE,6,2)=2;

-- 날짜 및 시간 연산 
SELECT NOW()
	, ADDDATE(NOW(),INTERVAL 10 DAY) AS P
	, ADDDATE(NOW(),INTERVAL -10 DAY) AS M
	, ADDDATE(NOW(),INTERVAL 2110 YEAR) AS '미래'
	, ADDDATE(NOW(),INTERVAL 3 MONTH) AS MON;

-- 날짜 및 시간 차이
--  월차이 , 매개 변수의 형태는 반드시 YYYYMM 
SELECT PERIOD_DIFF(202407,202401) AS '6';
-- 일 차이 
SELECT DATEDIFF(CURRENT_DATE(),'2025-08-06');