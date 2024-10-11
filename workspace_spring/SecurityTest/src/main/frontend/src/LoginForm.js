import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const LoginForm = () => {
  const navigate=useNavigate()

  //입력한 로그인 정보를 저장할 state 변수
  const [loginData,setLoginData]=useState({
    memId:'',
    memPw:''
  })

  //입력한 정보로 로그인 데이터 변경하는 함수
  const changeLoginData=(e)=>{
    setLoginData({
      ...loginData,
      [e.target.name]:e.target.value
    })
  }

  //로그인 버튼 클릭 시 실항 함수
  const goLogin=()=>{
    axios.post('/member/login',loginData)
    .then((res)=>{
      alert('환영합니다.')
      console.log(res)
      navigate('/')
    })
    .catch((error)=>{console.log(error)})
  }

  //아이디와 비밀번호 input 태그의 name 속성은 반드시 
  // 자바의 LoginFilter 클래스 생성자 안에서 설정한 Parameter 이름으로 지정
  return (
    <div>
      <h1>로그인</h1>
      <div><input type='text' placeholder='아이디' name='memId'
        onChange={(e)=>{changeLoginData(e)}}></input></div>
      <div><input type='password' placeholder='비밀번호' name='memPw'
        onChange={(e)=>{changeLoginData(e)}}></input></div>
      <div><button type='button' onClick={()=>{goLogin()}}>로그인</button></div>
    </div>
  )
}

export default LoginForm