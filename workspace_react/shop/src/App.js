import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import data from './data';
import Book from './Book';
import axios from 'axios';

function App() {
  // 상품목록데이터
  //const item_list=data;
  let item_list=[];

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
  axios.get('/test4').then((re)=>{
    item_list=re.data;
    console.log(re.data);
    
  });
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
        Book Shop
      </div>
      <div className='banner'>
        <img src={process.env.PUBLIC_URL + 'header.jpg'}/>
        
      </div>
      
      <Book item_list={item_list}/>



        
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


        <Test name={'고길동'} age={40}></Test>
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
