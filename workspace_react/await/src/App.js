import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { getList } from './testApi';

function App() {

  
  function test1(){

    let cnt='';

    axios.get('/test1')
    .then(res=>{
      
      console.log(res.data)
      cnt=res.data;

    })
    .catch(error=>console.log(error))

    console.log(cnt)

  }

  // async가 붙으면 함수가 비동기 방식으로 진행 
  async function test2(){
    // await 명령어 사용 시 동기 방식으로 진행 

    try{
      let cnt=''
      const res = await axios.get('/test1')
      cnt=res.data
      console.log(cnt) // test1
    }catch(error){
      console.log(error)
    }

  }

  function test3(){
    console.log(1)
    test2()
    console.log(2)
  }


  return (
    <div className="App">
      <div>
        <button type='button' onClick={test1}>test1</button>
        <button type='button' onClick={test3}>test3</button>
        <button type='button' onClick={getList}>getList</button>
        {/* <button type='button' onClick={test1()}>test1</button> */}
        {/* <button type='button' onClick={()=>test1()}>test1</button> */}
      </div>
    </div>
  );
}


export default App;
