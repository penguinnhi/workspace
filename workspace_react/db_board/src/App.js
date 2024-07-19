import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import AxiosTest from './AxiosTest';
import BoardDetail from './BoardDetail';
import BoardWrite from './BoardWrite';
import BoardUpdate from './BoardUpdate';

function App() {

  return (
    <div className="App">
      
      <Routes>
        {/* axios 예제 페이지 */}
        {/* <Route path='/axios' element={<AxiosTest />}/> */}

        {/* 게시글 목록 페이지 */}
        <Route path='/' element={<BoardList />} />

        <Route path='/getDetail/:boardNum' element={<BoardDetail />} />

        <Route path='/goWrite' element={<BoardWrite />}/>

        <Route path='/goDelete/:boardNum' element={<div>ㅇㅇ</div>}/>
        
        <Route path='/goUpdate/:boardNum' element={<BoardUpdate />}/>

      </Routes>

    </div>
  );
}

export default App;
