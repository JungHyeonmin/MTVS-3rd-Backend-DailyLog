import {useState, useEffect} from 'react';
import MenuItem from '../components/MenuItem';
import {getMenuList} from '../apis/MenuAPI';
import boxStyle from './Menu.module.css';
import {useNavigate} from 'react-router-dom';

function Menu() {

    const [menuList, setMenuList] = useState([]);
    const [searchValue, setSearchValue] = useState('');
    const navigate = useNavigate(); 

    const onClickHandler = () => {
        console.log(searchValue);

        navigate(`/menu/search?menuName=${searchValue}`);
    }

    useEffect(
        () => {
            setMenuList(getMenuList());
        },
        []
    );

    return (
        <>
            <h1>판매 메뉴 목록</h1>
            <div>
                <input 
                    type="search" 
                    name="menuName"
                    onChange={e => setSearchValue(e.target.value)}
                />
                <button onClick={onClickHandler}>검색</button>
            </div>
            
            <div className={boxStyle.MenuBox}>
               {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)} 
            </div>
        </>
    );
}

export default Menu;