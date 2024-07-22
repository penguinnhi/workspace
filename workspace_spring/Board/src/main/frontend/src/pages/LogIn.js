import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const LogIn = () => {
  const navigate = useNavigate();
  const [letLogIn,setLetLogIn]=useState({});

  function writeInfo(e){
    setLetLogIn({
      ...letLogIn,
      [e.target.name] : e.target.value
    })

    if(letLogIn){
      
    }
  }

  function goLogIn(){
    axios
    .get('/member/logIn')
    .then((res)=>{
        
    })
    .catch((error)=>{
      alert('로그인오류')
      console.log(error)
    })
    navigate('/')
  }

  return (
    <div className='logIn'>
      <div>
        <p>아이디</p>
        <input type='text' name='memId' onChange={(e)=>{writeInfo(e)}}></input>
      </div>
      <div>
        <p>비밀번호</p>
        <input type='text' name='memPw' onChange={(e)=>{writeInfo(e)}}></input>
      </div>

      <button type='button' onClick={(e)=>{goLogIn()}}>로그인</button>
      <button type='button' onClick={(e)=>{navigate('/')}}>목록가기</button>

    </div>
  )
}

export default LogIn