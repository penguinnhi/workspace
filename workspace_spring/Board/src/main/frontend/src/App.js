import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import BoardList1 from './pages/BoardList1.js';
import RegMember from './pages/RegMember.js';
import LogIn from './pages/LogIn.js';
import BoardWrite from './pages/BoardWrite.js';

function App() {
  const navigate = useNavigate();

  return (
    <div className="container">

      
      <div className='header'>
        <div>
          <span onClick={(e)=>{navigate('/logIn')}}>Login </span>
          <span onClick={(e)=>{navigate('/regMember')}}>Join</span>
        </div>
  
        <h1>자유게시판</h1>
      </div>

      <div className='content'>
        <Routes>
          <Route path='/' element={<BoardList1></BoardList1>}></Route>
          <Route path='/regMember' element={<RegMember></RegMember>}></Route>
          <Route path='/logIn' element={<LogIn></LogIn>}></Route>
          {/* <Route path='/boardWrite'element={<BoardWrite></BoardWrite>}></Route> */}
        </Routes>   
      </div>   

    </div>
  );
}

export default App;
