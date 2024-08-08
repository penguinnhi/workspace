import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Login = ({setLoginInfo,loginInfo}) => {
  const navigate=useNavigate();
  const [loginData,setLoginData]=useState({})


  function inputData(e){

    setLoginData({
      ...loginData,
      [e.target.name]:e.target.name
    })

  }

  function goLogin(){
    axios
    .put('/member/goLogin',loginData)
    .then((res)=>{

      const loginInfo={
        memId:res.data.memId,
        memName:res.data.memName,
        memRole:res.data.memRole
      }

      window.sessionStorage.setItem('loginInfo',JSON.stringify(loginInfo))
      setLoginInfo(loginInfo)

      if(loginInfo.memRole=='USER'){
        navigate('/itemList')
      }
      if(loginInfo.memRole=='ADMIN'){
        navigate('/admin/itemReg')
      }


    })
    .catch((error)=>{console.log(error)})
  }

  //모달창 만들고 확인버튼을 누르면 로그인 성공시 뭐할지 쓰는 함수 
  

  return (
    <div >
      
      <table className='join-table'>
        <thead></thead>
        <tbody>
          <tr>
            <td>아이디</td>
            <td><input type='text' name='memId'
            onChange={(e)=>{inputData(e)}}></input></td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type='text' name='memPw'
            onChange={(e)=>{inputData(e)}}></input></td>
          </tr>
        </tbody>

        <button type='button' onClick={(e)=>{goLogin()}}>로그인</button>

      </table>

    </div>
  )
}

export default Login