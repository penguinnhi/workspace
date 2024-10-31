
-- 서브쿼리


SELECT * FROM emp;
SELECT * FROM dept;

-- 모든 사원 급여 평균보다 급여가 높은 사원의 
-- 사번, 이름, 급여를 조회 
-- 서브쿼리 사용
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL>(SELECT AVG(SAL) FROM EMP);

-- WHERE절에 서브쿼리가 있고, 
-- WHERE절에 비교 연산이 '=','>','<'와 같이 크기 비교 연산이라면 
-- 서브쿼리의 조회결과 행은 반드시 하나여야 한다. 


-- IN연산자 : OR랑 같음 (SAL = 500 OR SAL = 600 ... )
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL IN (500,600,700);

-- 만약 WHERE절에 서브쿼리의 질의 결과 여러 행의 데이터가 조회되면 
-- IN 연산자를 사용하여 쿼리를 수행할 수 있다. 
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL IN (SELECT SAL FROM emp WHERE SAL>500);


-- WHERE절에 서브쿼리 실행 결과 데이터가 여러 행 조회되면 
-- IN 연산자말고 ALL, ANY 키워드를 사용할 수도 있다. 

-- ALL : 서브쿼리 질의 결과 모든 데이터가 전부 조건에 만족하는 결과만 조회
-- 최댓값의 조건이 만족하면 조회 
-- 서브쿼리에서 조회된 결과보다 높은 것을 조회하겠다..? 
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL >= ALL (SELECT SAL FROM emp WHERE SAL>500); -- 서브쿼리 : 600,520,1000,560
-- 위의 쿼리와 같음 
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL >= (SELECT MAX(SAL) FROM emp WHERE SAL>500);
-- 같..다는데? 
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL <= (SELECT MIN(SAL) FROM emp WHERE SAL>500);



-- ANY : 서브쿼리 질의 결과 조회되는 데이터 중 하나라도 조건에 성립되면 조회
-- 최솟값의 조건이 만족하면 조회
-- =ANY : IN과 같음 
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL >= ANY (SELECT SAL FROM emp WHERE SAL>500);
-- 위의 쿼리와 같음
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL >= (SELECT MIN(SAL) FROM emp WHERE SAL>500);






-- DISTINCT : 중복제외 
SELECT DISTINCT DEPTNO FROM emp;

-- 모든 컬럼 앞에 DISTINCT가 추가되면 나열한 모든 컬럼에 대해 중복을 제거 
-- 컬럼이 여러개면 '모든' 컬럼의 값이 중복인 행만 제거 
SELECT DISTINCT DEPTNO, JOB FROM emp; 

-- UNION ALL, UNION : 두 개 이상의 SELECT 를 동시에 진행 
-- 각각의 조회문의 컬럼명은 달라도 쿼리 실행에 영향을 미치지 않음 
-- 컬럼명은 달라도 되지만 오라클에서는 컬럼의 자료형이 같아야 함 
-- 각각의 SELECT절의 컬럼의 개수가 같아야 함
SELECT EMPNO,ENAME,JOB FROM emp WHERE JOB = '사원'
UNION ALL
SELECT EMPNO,SAL,JOB FROM emp WHERE JOB = '과장'; 

-- UNION ALL : 각 쿼리 결과 조회되는 데이터가 중복이더라도 조회 가능
-- UNION : 각 쿼리의 실행 결과 중복인 데이터는 하나만 조회 가능 
SELECT EMPNO,ENAME,JOB FROM emp WHERE JOB = '사원'
UNION
SELECT EMPNO,ENAME,JOB FROM emp WHERE JOB = '사원'; 




-- EXISTS :
-- 서브쿼리의 WHERE절이 중요  
SELECT DEPTNO,DNAME
FROM dept
WHERE EXISTS (SELECT * FROM emp WHERE DEPTNO = dept.DEPTNO); 

