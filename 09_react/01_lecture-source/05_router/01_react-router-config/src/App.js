import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './pages/Main';
import About from './pages/About';
import Menu from './pages/Menu';

// BrowserRouter : 라우팅이 필요한 컴포넌트들을 감싸는 컴포넌트
// Routes : Route를 묶어주는 단위
// Route : url 요청 주소와 컴포넌트를 매핑해주는 단위

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* <Route path="/" element={<Main/>}/> */}
          <Route index element={<Main/>}/>
          <Route path='/about' element={<About/>}/>
          <Route path='/menu' element={<Menu/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;