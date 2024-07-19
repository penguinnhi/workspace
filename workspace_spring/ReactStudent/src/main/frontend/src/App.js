import logo from './logo.svg';
import './reset.css';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import StudentList from './StudentList';
import StudentReg from './StudentReg';
import StudentDel from './StudentDel';
import ScoreManage from './ScoreManage';
import StudentDetail from './StudentDetail';
import InputScore from './InputScore';

function App() {
  const navigate=useNavigate();

  return (
    <div className="container">

      <div className='header'>
        
          <ul>
            <li onClick={(e)=>{navigate('/')}}>학생정보조회</li>
            <li onClick={(e)=>{navigate('/getStu')}}>학생등록</li>
            <li onClick={(e)=>{navigate('/delStu')}}>학생삭제</li>
            <li onClick={(e)=>{navigate('/score')}}>성적관리</li>   
          </ul>
        
      </div>

      <div className='route'>
        <Routes>
          <Route path='/' element={<StudentList />}/>
          <Route path='/stuDetail/:stuNum' element={<StudentDetail />}/>
          <Route path='/getStu' element={<StudentReg />}/>
          <Route path='/delStu' element={<StudentDel />}/>
          <Route path='/score' element={<ScoreManage/>}/>
          <Route path='/inputScore/:stuNum' element={<InputScore/>}/>
        </Routes>
      </div>

    </div>
  );
}

export default App;
