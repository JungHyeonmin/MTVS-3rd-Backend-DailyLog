select      -- 확인하고 싶은 카테고리명
    category_code
from        -- 확인하고 싶은 테이블 명
    tbl_menu
order by    -- 오름차순 정렬
    category_code;

select
    distinct tbl_category.ref_category_code -- distinct : 중복제거
from
    tbl_category;

-- sql syntax error : 문법 에러
-- distinct는 하나의 콜럼에서 중복된 값을 제거하지만 두개이상의 콜럼에서는 모든 요소가 같아야 중복으로 판단한다.
select distinct tbl_menu.category_code
     , tbl_menu.orderable_status
from tbl_menu;


