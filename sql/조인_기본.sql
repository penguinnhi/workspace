
-- 서브 쿼리 : 하나의 쿼리 안에 또 다른 쿼리가 존재하는 문법
-- 서브쿼리는 반드시 () 소괄호 안에 작성한다. 


-- 사원 이름이 김사랑인 사원이 소속된 부서명을 조회 
-- 조인
SELECT DNAME
FROM dept,emp
WHERE ENAME='김사랑'
AND dept.DEPTNO=emp.DEPTNO;

--서브쿼리
SELECT * FROM emp; -- 김사랑 사원은 부서번호가 20이다
SELECT * FROM dept; -- 부서번호가 20인 부서명은 인사부다

SELECT DNAME
FROM dept
WHERE DEPTNO=(
SELECT DEPTNO
FROM emp
WHERE ENAME='김사랑');

SELECT DEPTNO
FROM emp
WHERE ENAME='김사랑';


-- 모든 사원의 평균 급여보다 더 많은 급여를 갖는 사원의 사번, 이름, 급여를 조회 
SELECT EMPNO,ENAME,SAL
FROM emp
WHERE SAL>(SELECT AVG(SAL) FROM EMP);

SELECT AVG(SAL)
FROM emp;


-- 인사부에 소속된 직원 중 하반기에 입사한 사원들의 사번, 이름, 입사일을 조회
-- 단, 입사일은 2024년 08월 07일 형태로 조회 
SELECT EMPNO,ENAME,DATE_FORMAT(HIREDATE,'%Y년 %m월 %d일') AS 입사일
FROM emp
WHERE DEPTNO=(
SELECT DEPTNO
FROM dept
WHERE DNAME='인사부')
AND 7<=MONTH(HIREDATE)
AND 12>MONTH(HIREDATE);


SELECT HIREDATE,ENAME
FROM emp
WHERE MONTH(HIREDATE)=8;


-- 사번, 사원명, 부서번호, 부서명 조회
-- 서브 쿼리 데이터가 하나만 나와야 조회가 가능 
SELECT EMPNO,ENAME,DEPTNO,(
SELECT DNAME 
FROM dept
WHERE dept.DEPTNO=emp.DEPTNO 
) AS DNAME
FROM emp;

SELECT DNAME
FROM dept;


SELECT * FROM board;
SELECT * FROM board_member;

-- 글번호가 10번이하인 게시글의 글 번호, 제목, 작성자ID, 작성자 이름을 조회 

-- 1 조인
SELECT BOARD_NUM,TITLE,B.MEM_ID,MEM_NAME
FROM board B, board_member M
WHERE BOARD_NUM <= 10
AND B.MEM_ID=M.MEM_ID;

-- 2 서브쿼리
SELECT BOARD_NUM,TITLE,MEM_ID,(
SELECT MEM_NAME
FROM board_member
WHERE board.MEM_ID=board_member.MEM_ID) AS MEM_NAME
FROM board
WHERE BOARD_NUM<=10;


-- + 서브쿼리 두 개 조회 가능함 / 서브쿼리 안에 서브쿼리도 가능함 
SELECT BOARD_NUM,TITLE,MEM_ID,(
SELECT MEM_NAME
FROM board_member
WHERE board.MEM_ID=board_member.MEM_ID) AS MEM_NAME,
(SELECT MEM_ROLE
FROM board_member
WHERE BOARD.MEM_ID=MEM_ID)AS MEM_ROLE
FROM board
WHERE BOARD_NUM<=10;



