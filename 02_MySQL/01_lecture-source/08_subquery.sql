-- subqueries : 쿼리 안에 쿼리가 있는 것
-- 아래처럼 ()안에 쿼리문을 넣어서 조건을 추가한다.

-- 민트미역국과 같은 카테고리의 메뉴들의 정보를 조회하세요. (민트미역국 제외)
select *
from tbl_menu
where tbl_menu.menu_name != '민트미역국'
  and category_code = (select category_code
                       from tbl_menu
                       where menu_name = '민트미역국');


select count(*) as 'count'
from tbl_menu
group by category_code;

select max(count)
from (select count(*) as 'count'
      from (tbl_menu)
      group by category_code) as countmenu;

-- union : 두 개 이상의 SELECT 문의 결과를 결합하여 중복된 레코드를 제거한 후 반환하는 SQL 연산자이다.

SELECT
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
    tbl_menu
WHERE
    category_code = 10
UNION
SELECT
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
    tbl_menu
WHERE
    menu_price < 9000;