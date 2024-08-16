// import {Link} from 'react-router-dom';

// function Navbar() {

//     return (
//         // <div>
//         //     <ul>
//         //         <li><a gref={"/"}>Home</a></li>
//         //         <li><a gref={"/mypage"}>마이페이지</a></li>
//         //         <li><a gref={"/login"}>로그인</a></li>
//         //     </ul>
//         // </div>

//         <div>
//             <ul>
//                 <li><Link to="/">Home</Link></li>
//                 <li><Link to="/mypage">마이페이지</Link></li>
//                 <li><Link to="/login">로그인</Link></li>
//             </ul>
//         </div>
//     );
// }

// export default Navbar;

import { NavLink } from 'react-router-dom';

function Navbar() {

    const activeStyle = {
        backgroundColor: 'blue'
    };


    return (
        <div>

            <li><NavLink to="/main" style={({ isActive }) => isActive ? activeStyle : undefined}>Home</NavLink></li>
            <li><NavLink to="/mypage" style={({ isActive }) => isActive ? activeStyle : undefined}>마이페이지</NavLink></li>
            <li><NavLink to="/login" style={({ isActive }) => isActive ? activeStyle : undefined}>로그인</NavLink></li>
        </div>
    );
}

export default Navbar;