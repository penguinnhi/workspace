
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Join from './pages/user/Join';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import LoginForm from './pages/user/Login';
import { useEffect, useState } from 'react';
import ItemReg from './pages/admin/ItemReg';
import ItemList from './pages/user/ItemList';

function App() {
  const navigate=useNavigate();

  const [loginInfo,setLoginInfo]=useState({})

  useEffect(()=>{

    if(window.sessionStorage.getItem('loginInfo')!=null){

      setLoginInfo(JSON.parse(window.sessionStorage.getItem('loginInfo')))
    
    }

  },[])

  function goLogout(){
    window.sessionStorage.removeItem('loginInfo')
    setLoginInfo({})
    alert('로그아웃 됨')
    navigate('/')
  }

  return (
    <div className="container">


      <div className='login-div'>
        {
          loginInfo==null?
          <div>
            <span onClick={(e)=>{navigate('/loginForm')}}>Login</span>
            <span onClick={(e)=>{navigate('/join')}}>Join</span>
          </div>
          :
          <div>
            <p>{loginInfo.memName}님 ㅎㅇ</p>
            <p onClick={(e)=>{goLogout()}}>Logout</p>
          </div>
        }

      </div>

      <div className='layout-div'>
        <Routes>
          

          {/* 유저 */}
          <Route path='/' element={<UserLayout/>}>
            <Route path='/loginForm' element={<LoginForm setLoginInfo={setLoginInfo} loginInfo={loginInfo}/>}/>
            <Route path='/join' element={<Join/>}/>
            <Route path='/itmeList' element={<ItemList/>}/>
          </Route>

          {/* 관리자 */}
          <Route path='/admin' element={<AdminLayout/>}>
            <Route path='itemReg' element={<ItemReg/>}/>
          </Route>
          

        </Routes>
      </div>


    </div>
  );
}

export default App;
