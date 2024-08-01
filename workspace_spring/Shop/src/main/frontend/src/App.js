import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';

function App() {
  const navigate=useNavigate();

  return (
    <div className="container">
      <div className='login-div'>
        <ul>
          <li><span>Login</span></li>
          <li><span onClick={(e)=>{navigate('/join')}}>Join</span></li>
        </ul>
        <div className='banner'>
          <div>
            <img className='banner-img' src='http://localhost:8080/images/book_banner.PNG'></img>
          </div>
          <div>🐲BOOK SHOP🐲</div>
        </div>
        </div>
      <div className='layout-div'>
      <Routes>

        {/* 일반 유저용 */}
        <Route path='/' element={<UserLayout></UserLayout>}>
          {/* 상푸 목록 화면 */}
          <Route path='/' element={<div>상품목록화면</div>}/>
          {/* 회원 가입 페이지 */}
          <Route path='/join' element={<Join/>}/>
          <Route path='test2' element={<div>2번화면</div>}/>
        </Route>

        {/* 관리자용 */}
        <Route path='/admin' element={<AdminLayout />}>
          <Route path='test1' element={<div>뿡빵뿡빵🏃‍♀️=333</div>}/>
        </Route>

      </Routes>
      </div>

      <Routes>
        <Route/>
      </Routes>

    </div>
  );
}

export default App;
