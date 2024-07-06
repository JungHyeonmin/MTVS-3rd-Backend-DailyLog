select *
from TB_DEPARTMENT; --  학과테이블
select *
from TB_STUDENT; -- 학생테이블
select *
from TB_PROFESSOR; -- 교수테이블
select *
from TB_CLASS; -- 수업테이블
select *
from TB_CLASS_PROFESSOR; -- 수업교수테이블
select *
from TB_GRADE;
-- 학점테이블

-- 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오.
-- 단, 출력 헤더는 "학과 명", "계열"으로 표시하도록 한다.

select department_name, category
from tb_department;



-- 2. "국어국문학과"에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이 들어왔다. 누구인가?
-- (국문학과의 '학과코드'는 학과 테이블 (tb_department)을 조회해서 찾아 내도록 하자

-- 국문학과의 학과코드 : 001, 여자 : 주민번호 뒷자리 2로 시작, 휴학 : ABSENCE = 'Y'
select distinct tb_student.STUDENT_name
from tb_department,
     tb_student
where tb_student.DEPARTMENT_NO = 001
  and ABSENCE_YN = 'Y'
  and (tb_student.STUDENT_SSN like '%-2%'
  or tb_student.STUDENT_SSN like '%-4%');


-- 3. 도서관에서 대출 도서 장기 연체자들을 찾아 이름을 게시하고자 한다.
-- 그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 적 SQL 구문을 작성하시오
-- A513079, A513090, A513091, A513110, A513119

select distinct tb_student.STUDENT_NAME
from tb_student,
     tb_department
where STUDENT_NO = 'A011032'
   or STUDENT_NO = 'A513090'
   or STUDENT_NO = 'A513091'
   or STUDENT_NO = 'A513110'
   or STUDENT_NO = 'A513119';


-- 4. 입학 정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열을 출력하시오.
select tb_department.DEPARTMENT_NAME, CATEGORY
from tb_department
where 20 <= CAPACITY
  and CAPACITY <= 30;



-- 5. 춘기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다.
-- 그럼 춘기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.

-- 없다 = is null
select tb_professor.PROFESSOR_NAME
from tb_professor
where DEPARTMENT_NO is null;



-- 6-1. 혹시 전상상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 한다.
-- 어떠한 SQL 문장을 사용하면 될 것인지 작성하시오.
select tb_student.STUDENT_NAME
from tb_student
where DEPARTMENT_NO is null;

-- 6-2. 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는 과목들은 어떤 과목인지 과목번호를 조회해보시오.
select distinct tb_class.CLASS_NO
from tb_class
where tb_class.PREATTENDING_CLASS_NO is not null;


-- 7. 춘 대학에는 어떤 계열(category)들이 있는지 조회해보시오. (사전순)

-- 사전순 정렬은 order by 를 사용한다. 기본형태는 오름차순, 사전순 정렬이다.
select distinct tb_department.CATEGORY
from tb_department
order by CATEGORY;



-- 8. '19'학번 전주 거주자들의 모임을 만들려고 한다.
-- 휴학한 사람들은 제외하고, 재학중인 학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.

select tb_student.STUDENT_NO,
       tb_student.STUDENT_NAME,
       tb_student.STUDENT_SSN,
       tb_student.ENTRANCE_DATE,
       tb_student.STUDENT_ADDRESS
from tb_student
where ABSENCE_YN = 'N'
  and ENTRANCE_DATE like '2019%'
  and STUDENT_ADDRESS like '전주시%'
order by STUDENT_NAME;