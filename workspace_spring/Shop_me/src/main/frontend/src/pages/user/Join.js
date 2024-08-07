import axios from 'axios';
import React, { useRef, useState } from 'react'
import { useDaumPostcodePopup } from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom'
import Modal from '../common/Modal';
import { joinValidate } from '../validate.js/joinValidate';

const Join = () => {
  const [isShow,setIsShow]=useState(false)
  const [isShow1,setIsShow1]=useState(false)
  const clickbtn=()=>{
    setIsShow(!isShow)
  }
  const [isValidate,setIsValidate]=useState(false)

  const open=useDaumPostcodePopup();

  function handleComplete(data){
    setJoinData({
      ...joinData,
      post:data.zonecode,
      memAddr:data.address
    })
  }

  function handleClick(){
    open({onComplete:handleComplete})
  }

  const email_1=useRef();
  const email_2=useRef();

  const navigate=useNavigate();
  const [joinData,setJoinData]=useState({
    memId:'',
    memPw:'',
    confirmPw:'',
    name:'',
    post:'',
    memAddr:'',
    addrDetail:''
  })


  const memId_valid_tag=useRef();
  const memPw_valid_tag=useRef();
  const confirmPw_valid_tag=useRef();


  const vaild_tag=[
    memId_valid_tag,
    memPw_valid_tag,
    confirmPw_valid_tag
  ];

  function checkId(){
    const inputId=document.querySelector('input[name=memId]').value
    if(inputId==''){
      alert('아이디를 입력하세요')
    }


    axios
    .get(`/member/isDup/${inputId}`)
    .then((res)=>{
      
      res.data?  setIsShow1(true):setIsShow(false) 
    })
    .catch((error)=>{
      alert('중복확인오류')
      console.log(error)
    })

  }
  
  function modalContent(){
    <div>
      ㅊㅊ
    </div>
  }

  
  function inputJoinData(e){

        //이메일을 변경 했으면....
    // if(e.target.name=='memEmail'){
    //   const email=email_1.current.value+email_2.current.value
    //   console.log(email)

    //   setJoinData({
    //     ...joinData,
    //     [e.target.name]:email
    //   })

    // }
    // else{
    //   setJoinData({
    //     ...joinData,
    //     [e.target.name]:e.target.value
    //   })
    // }

    // e.target.name=='memEmail'?
    // setJoinData({
    //   ...joinData,
    //   [e.target.name]:email_1.current.value+email_2.current.value
    // })
    // :
    // setJoinData({
    //   ...joinData,
    //   [e.target.name]:e.target.value
    // })

    const newData={
      ...joinData,
      [e.target.name]:e.target.name!='memEmail'?
      e.target.value
      :
      email_1.current.value+email_2.current.value
    }

    // 유효성검사
    const result = joinValidate(vaild_tag,newData,e.target.name)
    setIsValidate(result)
    


    setJoinData(newData)

  }


  function joinMem(){
    if(joinData.memPw!=joinData.confirmPw){
      alert('비밀번호 다름')
      return
    }

    axios
    .post('/member/insert',joinData)
    .then((res)=>{

      alert('등록됨')

    })
    .catch((error)=>{
      alert('등록오류')
      console.log(error)
    })
  }




  return (
    <div className='join-form'>

      {
        isShow?
        <Modal content={modalContent}/>
        :
        null
      }

      
      <table className='join-table'>

        <thead></thead>

        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input type='text' name='memId' id='id' className='small-input' onChange={(e)=>{inputJoinData(e)}}></input>
              <button type='button' onClick={(e)=>{checkId()}}>중복확인</button>
              {
                isShow1?<div>사용못함</div>:<div>사용가능</div>
              }
              <div className='feedback' ref={memId_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type='password' name='memPw' onChange={(e)=>{inputJoinData(e)}}></input>
            <div className='feedback' ref={memPw_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type='password' name='confirmPw' onChange={(e)=>{inputJoinData(e)}}></input>
            <div className='feedback' ref={confirmPw_valid_tag}></div>
            </td>
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
              <input type='text' name='post' value={joinData.post} placeholder='우편번호' className='small-input' onChange={(e)=>{inputJoinData(e)}}></input>
              <button type='button' onClick={handleClick}>검색</button>  
            </td>
          </tr>
          <tr>
            <td><input type='text' name='memAddr' value={joinData.memAddr} onChange={(e)=>{inputJoinData(e)}} placeholder='주소'></input></td>
          </tr>
          <tr>
            <td><input type='text' name='addrDetail' onChange={(e)=>{inputJoinData(e)}} placeholder='상세주소'></input></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type='text' name='memEmail' onChange={(e)=>{inputJoinData(e)}} className='small-input' ref={email_1}></input>
              <span>@</span>
              <select name='memEmail' onChange={(e)=>{inputJoinData(e)}} ref={email_2}>
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