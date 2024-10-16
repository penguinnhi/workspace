import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const JoinForm = () => {
  const navigate=useNavigate()

  //입력한 회원정보를 저장할 state 변수
  const [joinData,setJoinData]=useState({
    memId:'',
    memPw:'',
    memName:''
  })

  //입력 태그에 값 입력시 실행되는 함수
  function insertJoinData(e){
    setJoinData({
      ...joinData,
      [e.target.name]:e.target.value
    })
  }

  //회원가입 버튼 클릭 시 실행
  function goinsert(){
    axios
    .post('/member/join',joinData)
    .then((res)=>{
      alert('회원가입 성공')
      navigate('/loginForm')
    })
    .catch((error)=>{console.log(error)})
  }

  return (
    <div>
      <h1>회원가입 페이지</h1>
      <div><input type='text' placeholder='아이디' name='memId'
        onChange={(e)=>{insertJoinData(e)}}></input></div>
      <div><input type='password' placeholder='비밀번호' name='memPw'
        onChange={(e)=>{insertJoinData(e)}}></input></div>
      <div><input type='text' placeholder='이름' name='memName'
        onChange={(e)=>{insertJoinData(e)}}></input></div>
      <div><button type='button' onClick={()=>{goinsert()}}>회원가입</button></div>
    </div>
  )
}

export default JoinForm