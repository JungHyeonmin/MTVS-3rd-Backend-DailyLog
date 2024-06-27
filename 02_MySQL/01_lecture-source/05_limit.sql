-- limit n1: n1개를 지정해서 출력, limit n1, n2 : (index)n1부터 n2개 출력
-- limit ?,? : 사용자가 ?를 입력하여 사용
-- offset : 시작할 행의 번호
-- row_count : 이후 행부터 반환 받을 행의 개수
select menu_code
     , menu_name
     , menu_price
from tbl_menu
order by menu_price desc
limit ?, ?;