import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Viewer from './Viewer';
import Controller from './Controller';

function App() {
  //console.log(1);
  let [count,setCount]=useState(0);
  
  //함수 ㅇㅇ 컴포넌트 ㄴㄴ 
  function changeCount(num){
    //console.log(num);
    const result=count + Number(num); // ?? 
    //console.log(result);
    setCount(result); //신기하네 
    //setCount({count});
  }

  return (
    <div className="App">
      <div className='container'>
        <h2>Simple Counter</h2>

        <Viewer count={count}/> 

        <Controller changeCount={changeCount}/>

      </div>



    </div>
  );
}





export default App;
