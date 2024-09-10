import {useState, useEffect} from 'react';
import {getMenuList} from '../apis/MenuAPI';
import {useNavigate} from 'react-router-dom';
import MenuItem from '../components/MenuItem';
import boxStyle from './Menu.module.css';

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
                {/* menuList를 순회하면서 key={menu.menuCode} : 고유 식별키, menu={menu} : props 전달*/}
               {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)} 
            </div>
        </>
    );
}

export default Menu;