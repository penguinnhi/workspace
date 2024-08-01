
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Join from './pages/user/Join';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';

function App() {
  const navigate=useNavigate();

  return (
    <div className="container">
      <div className='login-div'>
        <span>Login</span>
        <span onClick={(e)=>{navigate('/join')}}>Join</span>
      </div>

      <div className='layout-div'>
        <Routes>
          <Route path='/join' element={<Join/>}/>



          {/* 유저 */}
          <Route path='/' element={<UserLayout/>}>
            <Route/>
          </Route>

          {/* 관리자 */}
          <Route path='/admin' element={<AdminLayout/>}>
            <Route/>
          </Route>
          

        </Routes>
      </div>


    </div>
  );
}

export default App;
