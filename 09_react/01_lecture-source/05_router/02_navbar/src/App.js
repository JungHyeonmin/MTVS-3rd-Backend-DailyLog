import {BrowserRouter, Routes, Route} from 'react-router-dom';
import MyPage from './pages/MyPage';
import Login from './pages/Login';
import Main from './pages/Main';
import Layout from './layouts/Layout';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route index element={<Main/>}/>
            <Route path="main" element={<Main/>}/>
            <Route path="mypage" element={<MyPage/>}/>
            <Route path="login" element={<Login/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;