import axios from 'axios'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import { securityApi } from './securityAxios'

const Main = () => {
  const navigate=useNavigate()


  //서버로 요청 시 요청 헤더에 토큰을 가져가는 코드 
  const test=()=>{
    axios
    .get("/getToken",{
      headers : {
        'Authorization' : localStorage.getItem('Authorization')
      }
    })
    .then((res)=>{})
    .catch((error)=>{console.log(error)})
    
  }

  const test1 =()=>{
    securityApi.get('/test1')
    .then(res=>{
      console.log('성공!')
    })
    .catch(error=>console.log(error))
  }

  const test2 =()=>{
    securityApi.get('/test2')
    .then(res=>{
      console.log('성공!')
    })
    .catch(error=>{
      if(error.response.status == 403){
        // alert('이 페이지에 접근하려면 로그인하셔야 합니다. \n 로그인 페이지로 이동합니다.')
        // navigate('/loginForm')
      }
      console.log(error)
    })
  }

  const test3 =()=>{

  }

  const test4 =()=>{
    axios.get('/test4',{
      headers : {
        'Authorization' : localStorage.getItem('Authorization')
      }
    })
    .then(res=>{
      console.log('성공!')
    })
    .catch(error=>console.log(error))
  }

  const test5 =()=>{

  }




  return (
    <div>
      <h1>🤑</h1>
      
      <h3><span onClick={()=>{navigate('/loginForm')}}>로그인</span></h3>
      <h3><span onClick={()=>{navigate('/joinForm')}}>회원가입</span></h3>

      <h3><span onClick={()=>{test1()}}>MainController - test1 메서드 : 누구나 접근</span></h3>
      <h3><span onClick={()=>{test2()}}>MainController - test2 메서드 : 인증된 사람만 접근 가능</span></h3>
      <h3><span onClick={()=>{test3()}}>MainController - test3 메서드 : 인증된 일반회원만 접근</span></h3>
      <h3><span onClick={()=>{test4()}}>MainController - test4 메서드 : 인증된 관리자만 접근</span></h3>
      <h3><span onClick={()=>{test5()}}>MainController - test5 메서드 : 인증된 매니저/관리자만 접근</span></h3>

      <h3><span onClick={()=>{test()}}>서버에 토큰 가져가기</span></h3>
      
    </div>
  )
}

export default Main