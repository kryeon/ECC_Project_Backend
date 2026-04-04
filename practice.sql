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
SELECT MIN(age) FROM student;
SELECT MAX(name) FROM student;

-- 열 추가 : ALTER TABLE
ALTER TABLE student ADD score INTEGER;

--뷰 만들기
CREATE VIEW young_student AS
SELECT no, name FROM student WHERE age < 22;

SELECT * FROM young_student;

--인덱스 만들기
CREATE INDEX idx_student ON student(no);