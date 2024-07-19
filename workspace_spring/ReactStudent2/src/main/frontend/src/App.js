import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import StudentList from './StudentList';
import StudentReg from './StudentReg';
import StudentDetail from './StudentDetail';
import StudentDel from './StudentDel';
import StudentScore from './StudentScore';
import InputScore from './InputScore';
import * as api from './apis';

function App() {
  const navigate = useNavigate();
  return (
    <div className="App">

      <api.myName></api.myName>
      
      <div className='header'>
        <ul>
          <li onClick={(e)=>{navigate('/')}}>학생정보조회</li>
          <li onClick={(e)=>{navigate('/regStu')}}>학생등록</li>
          <li onClick={(e)=>{navigate('/delStu')}}>학생삭제</li>
          <li onClick={(e)=>{navigate('/updateScore')}}>성적관리</li>
        </ul>
      </div>

      <Routes>
        <Route path='/' element={<StudentList />}/>
        <Route path='/regStu' element={<StudentReg />}/>
        <Route path='/getDetail/:stuNum' element={<StudentDetail />}/>
        <Route path='/delStu' element={<StudentDel />}/>
        <Route path='/updateScore' element={<StudentScore />}/>
        <Route path='/inputScore/:stuNum' element={<InputScore />}/>
      </Routes>

    </div>
  );
}

export default App;
