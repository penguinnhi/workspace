import logo from './logo.svg';
import './App.css';
import List from './List';
import { Route, Routes } from 'react-router-dom';
import data from './data';
import Detail from './Detail';
import Wrtie from './Write';
import { useState } from 'react';
import InputTest from './InputTest';

function App() {
  // const board_list=data;
  const [boardList,setBoardList]=useState(data);



  return (
    <div className="App">
      
      

      <Routes>
        
        <Route path='/' element={<List board_list={boardList}></List>}/>

        <Route path='/detail/:id' element={<Detail board_list={boardList}></Detail>}/>

        <Route path='/writeForm' element={<Wrtie board_list={boardList} setBoardList={setBoardList}></Wrtie>}></Route>

        {/* input값 입력받기 연습 */}
        <Route path='/test' element={<InputTest></InputTest>}></Route>


      </Routes>


      {/* <div>
        이름 : <input type='text' onChange={(e)=>{
          // console.log(e.target.value);
          // inputData=e.target.value;
          setInputData(e.target.value);

        }}/> <br /> */}
        {/* e.target : 이벤트가 발생하고 있는 태그 (=input 태그)  */}
        {/* 나이 : <input type='text' onChange={(e)=>{
          setInputData2(e.target.value);
        }}/>
      </div> */}

      
      

    </div>
  );
}

export default App;
