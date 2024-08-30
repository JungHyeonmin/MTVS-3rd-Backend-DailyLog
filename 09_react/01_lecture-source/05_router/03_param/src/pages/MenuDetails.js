//Hooks Parameter값을 URL을 통해서 넘겨받은 페이지에서 사용할 수 있도록 해주는 것
import {useParams} from 'react-router-dom'; 
import {useState, useEffect} from 'react';
import { getMenuDetail } from '../apis/MenuAPI'; // 외부 API 파일에서 정의된 함수, 메뉴의 상세 정보를 불러오는 API 호출 함수

function MenuDetails() {

    // 구조 분해 할당: 배열이나 객체의 속성을 해체하여 그 값을 개별 변수에 담을 수 있게 하는 {} JS 표현식이다.
    // useParams를 사용하여 URL에서 menuCode라는 매개변수를 추출합니다.
    //      - 예를 들어, URL이 /menu/1234라면 menuCode는 1234가 됩니다.
    const {menuCode} = useParams();
    
    const [menu, setMenu] = useState({
        menuName: '',
        menuPrice: 0,
        categoryName: '',
        detail: {}
    });

    useEffect(
        () => {
            setMenu(getMenuDetail(menuCode));
        },
        []
    );

    return (
        <>
            <h2>메뉴 상세 설명</h2>
            <h3>메뉴 이름 : {menu.menuName}</h3>
            <h3>메뉴 가격 : {menu.menuPrice}</h3>
            <h3>메뉴 종류 : {menu.categoryName}</h3>
            <h3>메뉴 설명 : {menu.detail.description}</h3>

            <img src={menu.detail.image} style={{maxWidth: 500}}/>
        </>
    );
}

export default MenuDetails;