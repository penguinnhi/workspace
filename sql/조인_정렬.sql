-- 여러테이블의 내용을 동시에 조회하기 (조인,JOIN)
SELECT * FROM emp;
SELECT * FROM dept;

-- 사원번호, 사원명, 부서명을 조회 (EMP 테이블의 DEPTNO를 보고 DEPT의 부서명을
-- EMP테이블에서 DEPTNO 확인 : 20
-- DEPT테이블에서 DEPTNO가 20인 데이터 확인

-- 조인 조건 : 두 테이블이 공통으로 지니는 컬럼의 값이 같은 데이터만 조회 
SELECT EMP.EMPNO, EMP.ENAME, DEPT.DNAME 
FROM emp,dept
WHERE emp.DEPTNO=dept.DEPTNO;
-- WHERE절 조인조건이 제일 중요함

SELECT DEPT.DNAME FROM dept;

-- 조인+별칭
SELECT ENAME AS 사원명
	, EMPNO 사원번호
	, 사원.SAL 급여
FROM emp 사원;

-- 직급이 대리인 사원들의 사원번호, 사원명, 직급, 부서번호, 부서명, 부서의 지역 조회
SELECT EMPNO, ENAME, JOB, DNAME, LOC
FROM emp E,dept D
WHERE E.DEPTNO=D.DEPTNO AND JOB='대리'; 

-- 조회시 데이터를 정렬하여 조회하기

-- 사번 사원명 급여를 조회/ 급여기준 오름차순 정렬
-- 오름차순 : ASC 생략가능 / 내림차순 : DESC
SELECT EMPNO,ENAME,SAL
FROM emp
ORDER BY SAL ASC;

-- 부서번호가 30번이 아닌 사원들의 사원명,부서번호 조회/  사원명 기준 내림차순
SELECT ENAME,DEPTNO
FROM emp
WHERE DEPTNO != 30
ORDER BY ENAME DESC;

-- 부서명이 인사부가 아니면서 급여가 300이상인 사원들의 사번,사원명,부서번호,부서명,급여 
-- 부서번호기준 오름차순정렬
SELECT EMPNO,ENAME,dept.DEPTNO,DNAME,SAL
FROM emp,dept
WHERE dept.DEPTNO=emp.DEPTNO AND DNAME!='인사부' AND SAL>=300
ORDER BY DEPTNO;

-- 
SELECT EMPNO, ENAME, JOB, SAL
FROM emp
ORDER BY JOB ASC, SAL DESC;
