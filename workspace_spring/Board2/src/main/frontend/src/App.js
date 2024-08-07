import logo from './logo.svg';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import BoardList from './pages/BoardList';
import LogInMember from './pages/LogInMember';
import RegMember from './pages/RegMember';

function App() {
  const navigate= useNavigate();


  return (
    <div className="App">

      <div className='header'>
        <div>
          <span onClick={(e)=>{navigate('/loginForm')}}>Login</span>
          <span onClick={(e)=>{navigate('/joinForm')}}>Join</span>
        </div>
        <h1>🐋</h1>
        <div>
          <select>
            <option>제목</option>
            <option>작성자</option>
          </select>
          <input type='text'></input>
          <button type='button'>검색</button>
        </div>
      </div>

      <Routes>
        <Route path='/' element={<BoardList />}/>
        <Route path='/loginForm' element={<LogInMember/>}/>
        <Route path='/joinForm' element={<RegMember/>}/>
      </Routes>

    </div>
  );
}

export default App;
