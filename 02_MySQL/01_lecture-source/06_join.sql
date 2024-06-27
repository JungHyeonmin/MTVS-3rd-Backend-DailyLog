-- ⭐⭐⭐⭐⭐join⭐⭐⭐⭐⭐
-- 두 개 이상의 테이블을 관련 있는 컬럼을 통해 결합하는데 사용된다.
-- 두개의 테이블은 반드시 연관있는 컬럼이 존재해야 하며 이를 통해 join 된 테이블들의 컬럼을 모두 활용할 수 있다.
-- join 을 많이 하면 sql 의 성능이 많이 떨어진다.

-- 그럼 왜 사용해?
--  > 정규화로 쪼개놓은 db를 필요한 정보만 보기 위해서 사용한다.

-- join 할거면 DB를 왜 쪼개놓았지?
--  > 정규화 과정(불필요한 데이터의 정합성을 확보하고 이상현상(삽입, 수정, 갱신)의 발생을 피하기 위해 테이블을 분할하여 생성하는 것) 때문
--  > 중복 방지(대부분의 이상현상이 중복에 일어난다.)
--  > 코드의 표준화

-- on : join 으로 붙이는 조건, = 말고 등호를 사용해서 표기도 할 수 있다.
-- equal join, 등가조인 :
-- 등가 조인, 비등가 조인 : 조건으로 '='를 사용하는 join, '='이 아닌 '>'와 같은 등호를 사용하는 join
-- inner join, outer join : 카테고리가 일치하는 것만 join, 카테고리가 일치하지 않는 것도 join // inner join 이 기본형태다.
-- right join, left join : 왼쪽, 오른쪽의 카테고리를 비교했을 때 left, right 를 base join 으로 잡고 적으면 그대로, 많으면 null 로 채워서 출력하는 join
-- cross join : 두 테이블의 모든 가능한 조합을 반환하는 join // 이론상만 가능하고 사용하지 않는 join
-- self join : 내 카테고리를 두번 참조해서 관계를 찾기 위해 사용되는 join// 옛날 방식 잘 사용하지 않는다.

-- as : 원래 이름 대신 별칭을 붙인다. 띄어쓰기로 생략 가능하다.
-- 동작 순서는 1. from 2. join 3. select
-- 동작 순서 때문에 별칭을 작성하고 select 에 적용할 수 있다. 그래서 모든 카테고리에 별칭을 붙이는 것이 좋다. // 보통 a,b,c를 사용한다.
select a.menu_code
     , a.menu_name
     , a.category_code
     , b.category_name
from tbl_menu as a
         join tbl_category b -- as 생략 가능
              on a.category_code = b.category_code;

-- using :

select menu_code
     , menu_name
     , category_code
     , category_name
from tbl_menu
         join
     tbl_category
     using
         (category_code);

select a.category_name
     , b.menu_name
from tbl_category a
         left join tbl_menu b
                   on
                       a.category_code = b.category_code;

select *
from tbl_category;

select a.menu_name
     , b.category_name
from tbl_menu a
         right join tbl_category b
                    on a.category_code = b.category_code;