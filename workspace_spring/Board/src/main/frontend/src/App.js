import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import BoardList1 from './pages/BoardList1.js';
import RegMember from './pages/RegMember.js';
import LogIn from './pages/LogIn.js';
import BoardWrite from './pages/BoardWrite.js';
import BoardDetail from './pages/BoardDetail.js';
import BoardUpdate from './pages/BoardUpdate.js';
import { useEffect, useState } from 'react';
import ReplyWrite from './pages/ReplyWrite.js';

function App() {
  const navigate = useNavigate();

  const [loginInfo,setLoginInfo]=useState({});

  const loginDataString=window.sessionStorage.getItem('memInfo');

  useEffect(()=>{
    
    if(window.sessionStorage.getItem('memInfo') != null){
      const loginData=JSON.parse(window.sessionStorage.getItem('memInfo'))
      setLoginInfo(loginData);
    }

  },[]);
  
  function logOut(){
    window.sessionStorage.removeItem('memInfo');
    setLoginInfo({});
    alert('로그아웃 되었')
    navigate('/')
  }

  return (
    <div className="container">

      <div className='header'>

      {
          loginInfo.memId==null ? 
          <div>
            <span onClick={(e)=>{navigate('/logIn')}}>Login </span>
            <span onClick={(e)=>{navigate('/regMember')}}>Join</span>
          </div> 
          :
          <div>
            <p>🐣{loginInfo.memName}🐣님 반갑</p>
            <span onClick={(e)=>{
              logOut()
            }}>로그아웃</span>
          </div>
        }

        {/* <div> */}
          {/* 로그인 안 했을 때 */}
          {/* <span onClick={(e)=>{navigate('/logIn')}}>Login </span> */}
          {/* <span onClick={(e)=>{navigate('/regMember')}}>Join</span> */}

          {/* 로그인 했을 때  */}
          {/* <span>님 반갑</span> */}
        {/* </div> */}
  
        <h1>자유게시판</h1>
      </div>

      <div className='content'>

        <Routes>
          <Route path='/' element={<BoardList1 loginInfo={loginInfo}></BoardList1>}></Route>
          <Route path='/regMember' element={<RegMember ></RegMember>}></Route>
          <Route path='/logIn' element={<LogIn setLoginInfo={setLoginInfo}></LogIn>}></Route>
          <Route path='/boardWrite'element={<BoardWrite loginInfo={loginInfo}></BoardWrite>}></Route>
          <Route path='/bDetail/:boardNum' element={<BoardDetail loginInfo={loginInfo} setLoginInfo={setLoginInfo}></BoardDetail>}></Route>
          <Route path='/boardUpdate/:boardNum' element={<BoardUpdate ></BoardUpdate>}></Route>


        </Routes>
      
      </div>   


    </div>
  );
}


export default App;
