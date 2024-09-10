import itemStyle from './MenuItem.module.css';
import { Link } from 'react-router-dom'; // Link : 내가 이동하고자 하는 경로(URL)로 이동할 수 있는 컴포넌트

function MenuItem({ menu }) { // 부모 컴포너트로부터 menu라는 객체를 전달 받아 그 데이터를 화면에 렌더링한다.

    return (
        <>
            <Link to={`/menu/${menu.menuCode}`}>
                <div className={itemStyle.MenuItem}>
                    <h3>이름 : {menu.menuName}</h3>
                    <h3>가격 : {menu.menuPrice}</h3>
                    <h3>종류 : {menu.menuCategory}</h3>
                </div>
            </Link >
        </>
    )
}

export default MenuItem;