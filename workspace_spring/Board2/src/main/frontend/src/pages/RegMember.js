import axios from 'axios'
import React, { useState } from 'react'

const RegMember = () => {
  const [memData,setMemData]=useState({
    gender:'여'
  })



  function isDup(){
    const inputId=document.querySelector('.id').value

    if(inputId==''){
      alert('아이디를 입력')
    }

    axios
    .get(`/member/isDup/${inputId}`)
    .then((res)=>{
      alert(res.data?'중복':'사용 가능')
    })
    .catch((error)=>{
      console.log(error)
    })
    
  }

  function inputData(e){
    setMemData({
      ...memData,
      [e.target.name]:e.target.value
    })
  }

  function goJoin(){
    
    axios
    .post('/member/join',memData)
    .then((res)=>{
      alert('가입됨')
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  return (
    <div>
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input type='text' name='memId' className='id' onChange={(e)=>{inputData(e)}}></input>
              <button type='button' onClick={(e)=>{isDup()}}>중복확인</button>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type='password' name='memPw' onChange={(e)=>{inputData(e)}}></input></td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type='password' name='confirmPw'></input></td>
          </tr>
          <tr>
            <td>이름</td>
            <td><input type='text' name='memName' onChange={(e)=>{inputData(e)}}></input></td>
          </tr>
          <tr>
            <td>성별</td>
            <td name='gender' onChange={(e)=>{inputData(e)}}>
              <input type='radio' value={'남'}></input>남
              <input type='radio' value={'여'}></input>여
            </td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={(e)=>{goJoin()}}>회원가입</button>
    </div>
  )
}

export default RegMember