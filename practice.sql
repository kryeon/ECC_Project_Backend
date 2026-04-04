-- 테이블 생성
CREATE TABLE student (
  no   INTEGER,
  name VARCHAR(20),
  age  INTEGER
);

-- 데이터 삽입
INSERT INTO student VALUES (1, '김', 20);
INSERT INTO student VALUES (2, '이', 22);
INSERT INTO student VALUES (3, '박', NULL);

-- 집계 함수
SELECT SUM(age) FROM student;
SELECT AVG(age) FROM student;