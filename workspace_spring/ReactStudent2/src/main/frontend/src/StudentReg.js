import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { insertStu } from './apis';

const StudentReg = () => {
  const [regStu,setRegStu]=useState({});
  const navigate=useNavigate();

  function inputStu(e){
    setRegStu({
      ...regStu,
      [e.target.name] : e.target.value
    })
  }

  function regStudent(){
    axios
    .post('/insertStu',regStu)
    .then((res)=>{
      alert('ㅇㅇ')
      navigate('/')
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  }

  return (
    <div>
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>이름</td>
            <td><input type='text' name='stuName' onChange={(e)=>{inputStu(e)}}></input></td>
          </tr>
          <tr>
            <td>나이</td>
            <td><input type='text' name='stuAge' onChange={(e)=>{inputStu(e)}}></input></td>
          </tr>
          <tr>
            <td>연락처</td>
            <td><input type='text' name='stuTel' onChange={(e)=>{inputStu(e)}}></input></td>
          </tr>
          <tr>
            <td>주소</td>
            <td><input type='text' name='stuAddr' onChange={(e)=>{inputStu(e)}}></input></td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={(e)=>{regStudent()}}>글쓰기</button>
    </div>
  )
}

export default StudentReg;