
-- 이것은 주석입니다.. 하이픈 뒤에 띄어쓰기 해야함 
-- 1일차 데이터 조회 기본 SQL 
-- 춥다 
-- 데이터 조회 문법 / 대소문자 구분하지 않음 근데 거의 대문자 사용함
-- 배고프다 
-- SELECT 조회할 열(=컬럼) [FROM 테이블명] [WHERE 조건]; []생략가능

-- EMP 테이블의 사번, 이름, 급여 정보를 조회하는 쿼리 
SELECT EMPNO, ENAME, SAL FROM emp;

-- EMP 테이블의 모든 정보를 조회하는 쿼리문 
SELECT * FROM emp;

-- 별칭 사용 (컬럼명을 조회할 때 임의로 변경)
SELECT EMPNO AS 사번 FROM emp;

SELECT EMPNO AS 사번, ENAME 사원명 -- AS 생략가능 
FROM emp; 

-- 조건에 맞는 데이터만 조회
-- 급여가 400 이상인 사원의 사번, 이름, 직급, 급여를 조회
-- 같다 : = / 다르다 : ! =, <> 
-- 그리고 : AND / 이거나,또는 : OR 
SELECT EMPNO,ENAME,JOB,SAL
FROM emp 
WHERE SAL >= 600; 

-- 급여가 600이하이고 직급은 사원인 사원들의 사번, 이름, 직급, 급여를 조회
SELECT EMPNO AS 사번,ENAME,JOB,SAL
FROM emp
WHERE SAL<=600 AND JOB='사원';

SELECT * FROM emp;

-- 커미션이 NULL인 사원의 사번, 사원명, 커미션을 조회
-- 조건에서 NULL 여부를 확인할 때는 주의 필수 
SELECT EMPNO,ENAME,COMM
FROM emp
WHERE COMM IS NULL; -- 주의하셔야함 / IS NOT NULL : NULL이 아닌거 

-- 직급이 과장이 아닌 사원들 중 커미션을 받는 사원들의 사번,이름,직급,커미션 정보를 조회
SELECT EMPNO,ENAME,JOB,COMM
FROM emp
WHERE JOB!='과장' 
AND COMM IS NOT NULL;

-- 부서 번호가 30번이 아닌 사원들 중에서 급여가 700이하이고 직급은 사원인 직원들의 모든정보를 조회
SELECT *
FROM emp
WHERE DEPTNO!=30 
AND SAL <=700 
AND JOB='사원';

-- 급여가 400이하이거나 700이상인 사원 중
-- 직급은 과장이면서 커미션은 NULL인 직원들의 사번, 사원명, 급여, 직급, 커미션을 조회
-- 단, 커미션은 인센티브라는 별칭을 사용하여 조회한다
SELECT EMPNO,ENAME,SAL,JOB,COMM AS 인센티브
FROM emp
WHERE (SAL<=400 OR SAL>=700) 
AND JOB='과장' 
AND COMM IS NULL; 

