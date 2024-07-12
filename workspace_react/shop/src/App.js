import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import data from './data';
import Book from './Book';
import axios from 'axios';
import { Link, Route, Routes } from 'react-router-dom';
import Detail from './Detail';

function App() {
  // 상품목록데이터
  const item_list=data;
  //let item_list=[];

  // const response = axios.get('/test1');
  // console.log(response.data);

  // axios.get('/test1')
  // .then((response)=>{
  //   console.log(response.data);
  // });

  // axios.get('/test2').then((res)=>{
  //   console.log(res.data);
  // });


  // let arr=[];
  // axios.get('/test3').then((re)=>{
  //   //console.log(re.data)
  //   arr=re.data
  //   console.log(arr)
  // });

  //let a1=[];
  // axios.get('/test4').then((re)=>{
  //   item_list=re.data;
  //   console.log(re.data);
    
  // });

  //console.log(a1);

  //구조 분해 할당
  // const arr1=[1,2,3];
  // const [a,b,c] = arr1;
  // // a=1, b=2, c=3

  // const obj={
  //   stuNum : 1,
  //   stuName : 'hey',
  // };
  // const {stuNum,stuName}=obj;
  // //변수명이 key값과 동일해야된대 

  // const member={ //구조분해할당으로 데이터 빼는거 뭐라는지 모르겟음 
  //   no : 1,
  //   name : 'hihi',
  //   addr : '제주도',
  //   score : 100
  // };

  // abc(member);
  // // 모르겟음 
  
  // function abc({name,addr}){
    
  // }



  return (
    <div className="App">
      
      <div className='header'>
        
        <Link to={'/'}>Book Shop </Link>
        <Link to={'/list'}>상품 목록</Link>
        <Link to={'/detail'}>상품 상세</Link>

        
      </div>
      <div className='banner'>
        <img src={process.env.PUBLIC_URL + 'header.jpg'}/>
        
      </div>
      
      {/* 이동할 수 있는 페이지의 url들 */}
      <Routes>

        <Route path='/' element={<div>메인페이지 </div>} />

        <Route path='/list' element={<Book item_list={item_list}/>}/>

        <Route path='/detail/:id' element={<Detail item_list={item_list}/>} />
        {/* /detail/:id/:name <- 여러개 데이터 가져가기 가능 */}
        <Route path='*' element={<div>hey 모두들 내가 누군지 아니 잘못된 페이지 </div>} />

      </Routes>

      {/* path='*' : 나머지 경로를 뺀 모든 경로 */}

      {/* <Book item_list={item_list}/> */}



        
{/* 
        <div>
          <img src={process.env.PUBLIC_URL + 'book_2.jpg'}/>
          <div>상품명 : {item_list[1].itemName}</div>
          <div>가격</div>
        </div>

        <div>
          <img src={process.env.PUBLIC_URL + 'book_3.jpg'}/>
          <div>상품명 : {item_list[2].itemName}</div>
          <div>가격</div>
        </div> */}


        {/* <Test name={'고길동'} age={40}></Test> */}
        {/* props로 안받고 key값으로 받는다는거 같은데?  */}
        
      </div>
  );
}

const Test = ({name,age})=>{
  // console.log(name)
  // console.log(age)

  // const {name}=props; 
  //name이라는 key값을 가진거를 name이라는 변수로 받아오겠음 

  return(
    
    <div>
       
    </div>
  );
}

export default App;
