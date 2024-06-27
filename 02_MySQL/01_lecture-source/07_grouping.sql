-- group by 절은 결과 집합을 특정열의 값에 따라 그룹화 하는데 사용된다.
select category_code
     , sum(category_code)
from tbl_menu
group by category_code;

select sum(menu_price)
from tbl_menu;

-- 카테고리별 메뉴의 합계, 평균, 숫자, 최소가격, 최대가격을 조회하세요.
-- sum, avg, count, min, max 함수 사용

select category_code
     , sum(menu_price)
     , avg(menu_price)
     , count(menu_price)
     , min(menu_price)
     , max(menu_price)
from tbl_menu
group by category_code;

select menu_price
     , category_code
from tbl_menu
group by menu_price, category_code
having category_code >= 5
   and category_code <= 8;

-- 카테고리별 메뉴의 합계금액을 조회
-- 단, 메뉴의 합계 금액이 30000원을 초과하는 카테고리에 대해 조회
select category_code
     , sum(menu_price)
from tbl_menu
group by menu_price, category_code
having sum(menu_price) > 30000;

-- 카테고리별 메뉴의 합계 금액이 가장 높은 카테고리의
-- 카테고리 코드, 메뉴의 합계 금액을 조회하세요.
select tbl_menu.category_code
     , sum(tbl_menu.menu_price)
from tbl_menu
group by category_code
order by max(menu_price) desc
limit 1;

select tbl_menu.category_code
     , sum(tbl_menu.menu_price)
from tbl_menu
group by category_code;
