import logo from './logo.svg';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import CarManage from './pages/CarManage';
import SellInfo from './pages/SellInfo';
import SellList from './pages/SellList';
import './reset.css';

function App() {
  const navigate= useNavigate();

  return (
    <div className="App">
      
      <table className='main'>

        <thead>
          <tr>
            <td><span onClick={(e)=>{navigate('/')}}>홈</span></td>
            <td><span onClick={(e)=>{navigate('/carManage')}}>차량관리</span></td>
            <td><span onClick={(e)=>{navigate('/sellInfo')}}>판매 정보 등록</span></td>
            <td><span onClick={(e)=>{navigate('/sellList')}}>판매 목록</span></td>
          </tr>
        </thead>
        
        <tbody>
          <tr>
            <td colSpan={4}></td>
          </tr>
        </tbody>

      </table>

      <div className='content'>
        <Routes>
          <Route path='/' element={<Home></Home>}></Route>
          <Route path='/carManage' element={<CarManage></CarManage>}></Route>
          <Route path='/sellInfo' element={<SellInfo></SellInfo>}></Route>
          <Route path='/sellList' element={<SellList></SellList>}></Route>
        </Routes>
  
      </div>
    </div>
  );
}

const Home=()=>{
  return(
    <div>
      차량 관리 시스템
    </div>
  )
}


export default App;
