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