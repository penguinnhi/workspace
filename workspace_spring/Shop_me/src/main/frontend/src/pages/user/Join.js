import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Join = () => {
  const navigate=useNavigate();
  const [joinData,setJoinData]=useState({})

  function checkId(){
    const inputId=document.querySelector('input[name=memId]').value
    if(inputId==''){
      alert('아이디를 입력하세요')
    }


    axios
    .get(`/member/isDup/${inputId}`)
    .then((res)=>{
      
      alert(res.data?'아이디 중복':'사용 가능')
    })
    .catch((error)=>{
      alert('중복확인오류')
      console.log(error)
    })

  }

  
  function inputJoinData(e){
    setJoinData({
      ...joinData,
      [e.target.name]:e.target.value
    })
  }


  function joinMem(){
    // if(joinData.memPw!=)

    axios
    .post('/member/insert',joinData)
    .then((res)=>{
      
      alert('등록됨')
      navigate('/')

    })
    .catch((error)=>{
      alert('등록오류')
      console.log(error)
    })
  }


  return (
    <div className='join-form'>
      
      <table className='join-table'>

        <thead></thead>

        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input type='text' name='memId' id='id' className='small-input' onChange={(e)=>{inputJoinData(e)}}></input>
              <button type='button' onClick={(e)=>{checkId()}}>중복확인</button>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type='password' name='memPw' onChange={(e)=>{inputJoinData(e)}}></input></td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type='password'></input></td>
          </tr>
          <tr>
            <td>이름</td>
            <td><input type='text' name='memName' onChange={(e)=>{inputJoinData(e)}}></input></td>
          </tr>
          <tr>
            <td>연락처</td>
            <td><input type='text' name='memTel' onChange={(e)=>{inputJoinData(e)}} placeholder='숫자만 입력하세요'></input></td>
          </tr>
          <tr>
            <td rowSpan={3}>주소</td>
            <td>
              <input type='text' name='post' placeholder='우편번호' className='small-input' onChange={(e)=>{inputJoinData(e)}}></input>
              <button type='button'>검색</button>  
            </td>
          </tr>
          <tr>
            <td><input type='text' name='memAddr' onChange={(e)=>{inputJoinData(e)}} placeholder='주소'></input></td>
          </tr>
          <tr>
            <td><input type='text' name='addrDetail' onChange={(e)=>{inputJoinData(e)}} placeholder='상세주소'></input></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type='text' name='memEmail' onChange={(e)=>{inputJoinData(e)}} className='small-input'></input>
              <span>@</span>
              <select name='memEmail' onChange={(e)=>{inputJoinData(e)}}>
                <option value='naver.com'>naver.com</option>
                <option value='gmail.com'>gmail.com</option>
              </select>
            </td>
          </tr>
        </tbody>
      </table>

      <div className='btn'>
        <button type='button' onClick={(e)=>{joinMem()}}>회원가입</button>
      </div>

    </div>
  )
}

export default Join