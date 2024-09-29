import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import LoginForm from './pages/user/LoginForm';
import ItemList from './pages/user/ItemList';
import ItemReg from './pages/admin/ItemReg';
import { useEffect, useState } from 'react';
import ItemDetail from './pages/user/ItemDetail';
import CateList from './pages/user/CateList';
import ItemManage from './pages/admin/ItemManage';
import CateManage from './pages/admin/CateManage';
import SaleHistoryOfMonth from './pages/admin/SaleHistoryOfMonth';
import SearchUser from './pages/admin/SearchUser';
import RecordOfMonth from './pages/admin/RecordOfMonth';
import CartList from './pages/user/CartList';

function App() {
  const navigate=useNavigate();


  //로그인 정보를 저장할 수 있는 state 변수 
  const [loginInfo,setLoginInfo]=useState({})


  const loginInfoString=window.sessionStorage.getItem('loginInfo')
  
  //로그인 성공 시 loginInfo에 로그인 정보를 저장하지만
  // 새로고침하면 App.js 다시 시작하면서 loginInfo 변수 값이 초기화된다.
  //새로고침해도 sessionStorage 정보는 존재함, 
  // 새로고침 할 때 만약 로그인 정보가 sessionStorage에 남아있다면
  //loginInfo state변수에 로그인 정보를 저장해야함 

  //새로고침!=재렌더링
  //새로고침하면 state변수 값이 초기화
  //재렌더링(state변수 값이 바뀌면 리액트가 알아서 하는거 )하면 state변수 값은 보존됨
  
  //state 변경함수는 모든 코드가 실행된 후 일괄적으로 한번에 처리 
  //state 변경함수는 비동기 방식이기 때문에 주의

  //App.js가 mount(새로고침)되면 실행
  useEffect(()=>{
    //세션에 저장된거 들고옴
    //세션에 정보가 있다면~ 
    if(loginInfoString!=null){
      //로그인 정보를 loginInfo에 저장
      //1 세션에서 가져온 데이터를 객체로 변환
      setLoginInfo(JSON.parse(window.sessionStorage.getItem('loginInfo')))
      
    }


  },[]);


  function goLogout(){
    window.sessionStorage.removeItem('loginInfo')
    setLoginInfo({})
    alert('로그아웃됨')
    navigate('/')
  }

  //빈 객체인지 확인하는 코드
  //Object.keys() 객체 안의 모든 키 값을 가져옴 
  // console.log( Object.keys(loginInfo).length )

  function adminInfo(){
    if(loginInfo.memRole=='ADMIN'){
      navigate('/admin')
    }
    else{

    }
  }


  return (
    <div className="container">
      <div className='main-top-div'>
        
        <div className='main-top'>
          {/* <div className='logo'>🐲</div> */}
          {
            Object.keys(loginInfo).length==0
            ?
            <div className='loginDetail'>
              <ul>
                <li><span onClick={(e)=>{navigate('/loginForm')}}>Login</span></li>
                <li><span onClick={(e)=>{navigate('/join')}}>Join</span></li>
              </ul>
            </div>
            :
            <div className='loginDetail'>
              <div>
                <span onClick={(e)=>{adminInfo()}}>{loginInfo.memName}님🐥</span>
                <span onClick={(e)=>{navigate(`/cart/${loginInfo.memId}`)}}>🛒</span>
                <span onClick={(e)=>{goLogout()}}>Logout</span>
              </div>
            </div>
          }
        </div>


        <div className='banner'>
          <h1 className='title' 
            onClick={(e)=>{navigate('/')}}> 😾 고양이 서점</h1>
        </div>


      </div>

      <div className='layout-div'>


        <Routes>

          {/* 일반 유저용 */}
          <Route path='/' element={<UserLayout></UserLayout>}>
            {/* 메인 홈 */}
            <Route path='/' element={<Home/>}/>
            {/* 상푸 목록 화면 */}
            <Route path='/itemList' element={<ItemList loginInfo={loginInfo}/>}/>
            {/* 카테고리별  */}
            <Route path='/cateList/:cateCode' element={<CateList/>}/>
            {/* 상세페이지 */}
            <Route path='/detail/:itemCode' element={<ItemDetail loginInfo={loginInfo}/>}/>
            {/* 장바구니 */}
            <Route path='/cart/:memId' element={<CartList loginInfo={loginInfo}/>}/>
            {/* 회원 가입 페이지 */}
            <Route path='/join' element={<Join/>}/>
            {/* 로그인 페이지 */}
            <Route path='/loginForm' element={<LoginForm setLoginInfo={setLoginInfo} loginInfo={loginInfo}/>}/>
          </Route>
          


          {/* 관리자용 */}
          <Route path='/admin' element={<AdminLayout />}>
            <Route path='test1' element={<div>뿡빵뿡빵🏃‍♀️=333</div>}/>
            
            {/* 상품관리 */}
            <Route path='itemReg' element={<ItemReg/>}/>
            <Route path='itemManage' element={<ItemManage/>}/>
            <Route path='cateManage' element={<CateManage/>}/>

            {/* 구매관리 */}
            <Route path='saleHistoryOfMonth' element={<SaleHistoryOfMonth/>}/>

            {/* 유저관리 */}
            <Route path='searchUser' element={<SearchUser/>}/>

            {/* 매출관리 */}
            <Route path='recordOfMonth' element={<RecordOfMonth/>}/>
            
          </Route>

        </Routes>
      </div>


    </div>
  );
}


function Home(){

  return(


    <div className='home-img-div'>
      <img className='home-img' 
        src='http://localhost:8080/upload/animal-8082317_1280.jpg'></img>
    </div>

  )

}

export default App;
