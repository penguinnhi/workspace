import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Main from './Main';
import JoinForm from './JoinForm';
import LoginForm from './LoginForm';

function App() {


  return (
    <div className="App">
      

      <Routes>
        {/* 메인 페이지 */}
        <Route path='/' element={<Main/>}/>
        {/* 회원가입 */}
        <Route path='/joinForm' element={<JoinForm/>}/>
        {/* 로그인 */}
        <Route path='/loginForm' element={<LoginForm/>}/>

      </Routes>
    </div>
  );
}

export default App;
