import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { json, useNavigate } from 'react-router-dom'
import { login } from '../apis/memberApi';


//리액트는 화면을 새로고침 할 때마다 데이터가 초기화 되기 때문에
// 로그인 했다는 정보를 일반적인 방식으로 저장해도
// 새로고침하면 로그인이 풀려버린다. 

//새로고침을 해도 정보가 사라지지않는 저장공간을 두 개 제공 
//이 두 개의 저장 공간은 client pc에 존재
//문자열 데이터만 저장 가능 

// localStorage : 여기에 저장되는 데이터는 직접 삭제하지 않는 한 반영구적으로 보전
// 인터넷이 끊겨도 컴퓨터를 재부팅해도 데이터 살아있음 
// 브라우저에 다른 탭끼리도 데이터가 공유 

// sessionStorage : 여기에 저장되는 데이터는 인터넷을 종료하면 자동으로 사라짐 
// 브라우저의 탭이 다르면 데이터 공유가 안 됨 

//사용법
// 데이터 저장 : window.sessionStorage.setItem(key,value);
// 데이터 읽기 : window.sessionStorage.getItem(key);
// 데이터 삭제 : window.sessionStorage.removeItem(key);
// 전체 데이터 삭제 : window.sessionStorage.clear();


const LogIn = ({setLoginInfo}) => {
  //sessionStorage에 데이터 입력
  //window.sessionStorage.setItem('name','camel');
  //window.sessionStorage.setItem('age',200);


  // const m = {
  //   stuNum : 1,
  //   stuName : 'hihi',
  //   score : 100
  // };

  //JSON.stringify(); // 객체를 json타입으로 변환 (객체를 문자로 변환 )
  //JSON.parse(); // json을 객체로 바꾸기
  //window.sessionStorage.setItem('member', JSON.stringify(m));

  //const data = window.sessionStorage.getItem('member')
  //console.log(data) //문자로 인식함 

  //객체나 배열을 스토리지에 저장할 때 json형태로 저장가능함 
  //json(javascript object notation) -> 자바스크립트의 객체를 문자화 시킨 것 
  //{name : 'hihi', score : 100} -> "{  }"
  //모든 언어에서 공통으로 해석할 수 있는 자료형 
  
  //const result = JSON.parse(data);
  //console.log(result)
  

  //sessionStorage에서 데이터 읽기
  // console.log(window.sessionStorage.getItem('name'));



  const navigate = useNavigate();
  const [letLogIn,setLetLogIn]=useState({});
  const [memberList,setMemberList]=useState({});

  useEffect(()=>{
    axios
    .get('/member/list')
    .then((res)=>{
      setMemberList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[]);

  function writeInfo(e){
    setLetLogIn({
      ...letLogIn,
      [e.target.name] : e.target.value
    })

    // if(letLogIn==memberList){
    //   alert('로그인됨')
    // }
    // else{
    //   alert('로그인안됨')
    // }
  }

  function goLogIn(){
    //아이디 비번 입력했는지 유효성 검사

    login(letLogIn)
    .then((res)=>{
      //조회 결과에 따라 로그인을 실행
      //조회결과가 있으면 로그인 처리
      //조회결과가 없으면 로그인이 안되겠지 다시 로그인 할 수 있도록 처리 
      // console.log(res.data)
      //const data=res.data
      if(res.data!=''){
        alert('로그인 성공')

        //sessionStrage에 로그인 한 사람의 아이디, 비밀번호, 권한 저장 
        // const loginId=data.memId;
        // const loginName=data.memName;
        // const loginRole=data.memRole;
        
        const loginInfo={
          memId : res.data.memId,
          memName : res.data.memName,
          memRole : res.data.memRole
        }

        //const {memId,memName,memRole}=data;

        window.sessionStorage.setItem('memInfo',JSON.stringify(loginInfo));
        
        setLoginInfo(loginInfo);

        navigate('/')

      }
      else{
        alert('id 혹은 pw 확인')

      }

      navigate('/')
    })
    .catch((error)=>{
      alert('로그인오류')
      console.log(error)
    })
  }


  return (
    <div className='logIn'>
      <div>
        <p>아이디</p>
        <input type='text' name='memId' onChange={(e)=>{writeInfo(e)}}></input>
      </div>
      <div>
        <p>비밀번호</p>
        <input type='password' name='memPw' onChange={(e)=>{writeInfo(e)}}></input>
      </div>

      <button type='button' onClick={(e)=>{goLogIn()}}>로그인</button>
      <button type='button' onClick={(e)=>{navigate('/')}}>목록가기</button>

    </div>
  )
}

export default LogIn