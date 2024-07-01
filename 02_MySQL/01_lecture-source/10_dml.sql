insert into tbl_menu
values (null, '바나나해장국', 8500, 4, 'Y');

select *
from tbl_menu;

insert
into tbl_menu ( menu_name, menu_price, category_code
              , orderable_status)
values ( '초콜릿죽', 6500, 7
       , 'Y');

select *
from tbl_menu;

insert into tbl_menu(orderable_status, menu_price, menu_name, category_code)
values ('Y', 5500, '파인애플탕', 4);

select *
from tbl_menu;

insert into tbl_menu
values (null, '참치맛아이스크림', 1700, 12, 'Y')
     , (null, '멸치맛아이스크림', 1500, 11, 'Y')
     , (null, '소시지맛아이스크림', 2500, 8, 'y');

select *
from tbl_menu;

select menu_code,
       tbl_menu.category_code
from tbl_menu
where menu_name = '초콜릿죽';

update tbl_menu
set category_code = 7
where menu_code = 24;

update
    tbl_menu
set category_code = 6
where menu_code = (select menu_code
                   from tbl_menu
                   where menu_code = '초콜릿죽');

update tbl_menu
set category_code = 6
where menu_code = (select
                       tmp.menu_code
                   FROM
                       (
                           select menu_code
                           from
                               tbl_menu
                           where
                               menu_name = '파인애플탕') tmp);

delete
from
    tbl_menu
where
    menu_code = 24;

select *
from tbl_menu;

delete from tbl_menu;

desc tbl_menu;

-- `ASCII` : 아스키 코드 값 추출
-- `CHAR` : 아스키 코드로 문자 추출
SELECT ASCII('A'), CHAR(65);


-- BIT_LENGTH : 할당된 비트 크기 반환
-- CHAR_LENGTH : 문자열의 길이 반환
-- LENGTH : 할당된 BYTE 크기 반환
SELECT BIT_LENGTH('pie'), CHAR_LENGTH('pie'), LENGTH('pie');
SELECT menu_name, BIT_LENGTH(menu_name), CHAR_LENGTH(menu_name), LENGTH(menu_name) from tbl_menu;



SELECT CONCAT('호랑이', '기린', '토끼');
SELECT CONCAT_WS(',', '호랑이', '기린', '토끼');
SELECT CONCAT_WS('-', '2023', '05', '31');

SELECT
    ELT(2, '사과', '딸기', '바나나'), FIELD('딸기', '사과', '딸기', '바나나'),
    FIND_IN_SET('바나나', '사과,딸기,바나나'), INSTR('사과딸기바나나', '딸기'), LOCATE('딸기', '사과딸기바나나');

SELECT FORMAT(123142512521.5635326, 3);

SELECT BIN(65), OCT(65), HEX(65);