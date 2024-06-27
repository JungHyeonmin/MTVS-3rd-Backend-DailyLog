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