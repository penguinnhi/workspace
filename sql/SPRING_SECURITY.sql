
-- spring security test 

CREATE TABLE SECURITY_MEMBER(
	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(100) NOT NULL
	, MEM_NAME VARCHAR(50)
	, MEM_ROLE VARCHAR(30) 
);

UPDATE security_member 
SET MEM_ROLE='ADMIN'
WHERE MEM_ID='hihi';

SELECT * FROM security_member;

-- 관리자 : admin / a123 / ADMIN
-- 매니저 : manager / m123 / MANAGER
-- 일반 : user / u123 / USER

