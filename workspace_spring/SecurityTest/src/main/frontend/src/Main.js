import React from 'react'
import { useNavigate } from 'react-router-dom'

const Main = () => {
  const navigate=useNavigate()

  return (
    <div>
      <h1>🤑</h1>
      
      <h3><span onClick={()=>{navigate('/loginForm')}}>로그인</span></h3>
      <h3><span onClick={()=>{navigate('/joinForm')}}>회원가입</span></h3>
      <h3>관리자 페이지로 이동</h3>
      <h3>일반 회원 페이지로 이동</h3>
      
    </div>
  )
}

export default Main