import logo from './logo.svg';
import './reset.css';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import ItemInfo from './ItemInfo';
import ItemReg from './ItemReg';
import ItemOrder from './ItemOrder';
import OrderList from './OrderList';
import ItemDetail from './ItemDetail';


function App() {
  const navigate = useNavigate();

  return (
    <div className="App">
      
      <div className='header'>
          <ul>
            <li onClick={(e)=>{navigate('/')}}>상품정보</li>
            <li onClick={(e)=>{navigate('/regItem')}}>상품등록</li>
            <li>주문하기</li>
            <li>주문목록</li>
          </ul>
      </div>

      <div>
        <Routes>
          <Route path='/' element={<ItemInfo />}/>
          <Route path='/regItem' element={<ItemReg></ItemReg>}/>
          <Route path='' element={<ItemOrder></ItemOrder>}/>
          <Route path='' element={<OrderList></OrderList>}/>
          {/* <Route path='/:itemNum' element={<ItemDetail></ItemDetail>}></Route> */}
        </Routes>
      </div>

    </div>
  );
}

export default App;
