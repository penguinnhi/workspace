import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
// import { getBoardList } from '../apis/boardApi';
import * as memberApi from '../apis/memberApi'

const RegMember = () => {
  // 버튼 활성화 여부 state 변수
  const [isDisabled,setIsDisabled]=useState(true); // 초기값 true


  const navigate = useNavigate();
  const [member,setMember]=useState({
    memId:'',
    confirmPw:'',
    gender : 'female' // 초기값을 넣어줘야 onChange되지 않아도 디폴트 값으로 들어감 
  });
  const [memberList,setMemberList]=useState([]);

  useEffect(()=>{
    axios
    .get('/member/list')
    .then((res)=>{setMemberList(res.data)})
    .catch((error)=>{console.log(error)})
  },[])

  function regInfo(e){
    // 아이디 input 태그의 값이 변경되면 회원가입 버튼을 비활성화
    if(e.target.name=='memId'){
      setIsDisabled(true)
    }

    setMember({
      ...member,
      [e.target.name] : e.target.value  
    })
  }

  function reg(){
    // const inputPwAgain=document.querySelector('.pwAgain').value
    // const inputPw=document.querySelector('.pw').value
    // inputPw==inputPwAgain ? alert('같음') : alert('다름')

    if(member.memPw!=member.confirmPw){
      alert('일치 ㄴㄴ')
      return;
    }

    //아이디 4~8글자
    const idLength = member.memId.length
    if(idLength<4 || idLength>8){
      alert('아이디는 4~8글자로')
      return
    }
    

    axios
    .post('/member/getReg',member)
    // memberApi.join()
    .then((res)=>{
      alert('가입됨')
    })
    .catch((error)=>{
      alert('가입ㄴㄴ')
      console.log(error)
    })
    navigate('/logIn')
  }

  function checkId(){
    const inputId = document.querySelector('.id').value
    if(inputId==''){
      alert('아이디를 입력하세요')
      return;
    }

    memberApi.checkId(inputId)
    .then((res)=>{
      const result = res.data
      // if(result){
      //   alert('안됨 아이디중복')
      // }
      // else{
      //   alert('됨')
      // }
      alert(result ? '아이디중복':'사용가능')

      // 사용 가능한 아이디면 버튼 활성화
      if(!result){
        setIsDisabled(false)

      }

    })
    .catch((error)=>{
      alert('중복확인오류')
      console.log(error)
    })


    
    // memberList.forEach((mem,i)=>{
    //   const dupId = [mem.memId]
    //   // console.log(dupId)

    //   dupId.forEach((id,i)=>{
    //     console.log(id)
    //     inputId==id ? alert('아이디중복') : alert('사용가능')
    //   })
    // })
    // console.log(inputId)
    // 
  }

  



  return (
    <div className='regMem'>
      <div>
        <p>아이디</p>
        <input className='id' type='text' name='memId' onChange={(e)=>{regInfo(e)}}></input>
        <button type='button' onClick={(e)=>{checkId()}}>중복확인</button>
      </div>
      <div>
        <p>비밀번호</p>
        <input type='password' className='pw' name='memPw' onChange={(e)=>{regInfo(e)}}></input>
      </div>
      <div>
        <p>비밀번호 확인</p>
        <input type='password' name='confirmPw' className='pwAgain' onChange={(e)=>{regInfo(e)}}></input>
      </div>
      <div>
        <p>이름</p>
        <input type='text' name='memName' onChange={(e)=>{regInfo(e)}}></input>
      </div>
      <div>
        <span>성별</span>
        <input type='radio' name='gender' value='male' onChange={(e)=>{regInfo(e)}} checked={member.gender=='male'}/>남
        <input type='radio' name='gender' value='female' onChange={(e)=>{regInfo(e)}} checked={member.gender=='female'} />여
      </div>

      <button type='button' className='reg-btn' onClick={(e)=>{reg()}} disabled={isDisabled}>회원가입</button>

      {/* 아이디가 중복이면 클릭 안됨. 중복이 아니면 클릭 가능한 버튼 ↓ */}
      {/* <button type='button' disabled={true}>연습용버튼</button> */}

    </div>
  )
}

export default RegMember
