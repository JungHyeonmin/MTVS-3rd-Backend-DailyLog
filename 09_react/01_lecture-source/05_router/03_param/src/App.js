// BrowserRouter : react-react-dom에서 제공하는 컴포넌트로, url의 변화를 감지하고 적절한 컴포넌트를 렌더링 하는 역할
// Router: 
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Layout from './layouts/Layout';
import Main from './pages/Main';
import About from './pages/About';
import Menu from './pages/Menu';
import MenuDetails from './pages/MenuDetails';
import MenuSearchResult from './pages/MenuSearchResult';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Main />} />
          <Route path="main" element={<Main />} />
          <Route path="about" element={<About />} />
          <Route path="menu">
            <Route index element={<Menu />} />
            <Route path=":menuCode" element={<MenuDetails />} />
            <Route path="search" element={<MenuSearchResult />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

 // 외부 API 파일에서 정의된 함수, 메뉴의 상세 정보를 불러오는 API 호출 함수