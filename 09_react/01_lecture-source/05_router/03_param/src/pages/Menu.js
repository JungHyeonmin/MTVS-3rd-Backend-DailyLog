import {useState, useEffect} from 'react';
import MenuItem from '../components/MenuItem';
import {getMenuList} from '../apis/MenuAPI';
import boxStyle from './Menu.module.css';

function Menu() {

    const [menuList, setMenuList] = useState([]);

    useEffect(
        () => {
            setMenuList(getMenuList());
        },
        []
    );

    return (
        <>
            <h1>판매 메뉴 목록</h1>
            <div className={boxStyle.MenuBox}>
               {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)} 
            </div>
        </>
    );
}

export default Menu;