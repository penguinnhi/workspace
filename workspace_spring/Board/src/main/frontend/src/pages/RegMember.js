import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const RegMember = () => {
  const navigate = useNavigate();
  const [member,setMember]=useState({});

  function regInfo(e){
    setMember({
      ...member,
      [e.target.name] : e.target.value  
    })
  }

  function reg(){
    axios
    .post('/member/getReg',member)
    .then((res)=>{
      alert('가입됨')
    })
    .catch((error)=>{
      alert('가입ㄴㄴ')
      console.log(error)
    })
    navigate('/logIn')
  }

  function dup(){

  }

  return (
    <div className='regMem'>
      <div>
        <p>아이디</p>
        <input className='id' type='text' name='memId' onChange={(e)=>{regInfo(e)}}></input>
        <button type='buttn' onClick={(e)=>{dup()}}>중복확인</button>
      </div>
      <div>
        <p>비밀번호</p>
        <input type='password' name='memPw' onChange={(e)=>{regInfo(e)}}></input>
      </div>
      <div>
        <p>비밀번호 확인</p>
        <input type='password'></input>
      </div>
      <div>
        <p>이름</p>
        <input type='text' name='memName' onChange={(e)=>{regInfo(e)}}></input>
      </div>
      <div>
        <span>성별</span>
        <input type='radio' name='gender' value='male' onChange={(e)=>{regInfo(e)}} />남
        <input type='radio' name='gender' value='female' onChange={(e)=>{regInfo(e)}} checked />여
      </div>
      <button type='button' onClick={(e)=>{reg()}}>회원가입</button>
    </div>
  )
}

export default RegMember
