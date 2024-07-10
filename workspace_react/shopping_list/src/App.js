import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import List from './List';
import Add from './Add';

function App() {
  //장보기목록
  const [cart,setCart]=useState(['계란 한판','생수','불고기용 돼지고기']);



  function addCart(){
      
  }

  return (
    
    
    <div className="App">
      <h2>To do List</h2>

      <List cart={cart} setCart={setCart} />

      <br></br>

      <Add cart={cart} setCart={setCart}/>


    </div>
  );
}

export default App;
