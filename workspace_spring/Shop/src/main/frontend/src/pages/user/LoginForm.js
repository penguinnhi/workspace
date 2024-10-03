import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Modal from '../../common/Modal'
import './LoginForm.css'

const LoginForm = ({setLoginInfo,loginInfo}) => {
  //로그인버튼 클릭시 화면에 보여지는 모달창의 상태
  const [beforeLoginmodal,setBeforeLoginModal]=useState(false)

  const [afterLoginModal,setAfterLoginModal]=useState(false)

  //로그인 성공 실패 여부를 저장하는 변수
  const [isLoginSuccess,setIsLoginSuccess]=useState(false)

  const navigate=useNavigate();
  const [inputData,setInputData]=useState({
    memId:'',
    memName:'',
    memRole:''
  })

  function inputLogin(e){
    setInputData({
      ...inputData,
      [e.target.name]:e.target.value
    })
  }

  // console.log(inputData)

  function goLogin(){
    
    


    if(inputData.memId==''||inputData.memPw==''){
      // alert('아이디,비밀번호는 필수입력입니다.')
      setBeforeLoginModal(true)
      return
    }
    
    
    axios
    .put(`/member/goLogin`,inputData)
    .then((res)=>{
      // console.log(res.data)
      //자바에서 null데이터가 전달되면 res.data는 ''빈문자로 변환
      setAfterLoginModal(true)
      

      if(res.data!=''){
        setIsLoginSuccess(true)
        const loginInfo={
          memId:res.data.memId,
          memName:res.data.memName,
          memRole:res.data.memRole
        }
  
        window.sessionStorage.setItem('loginInfo',JSON.stringify(loginInfo))
        //저장하는거임
        setLoginInfo(loginInfo)

        // alert('로그인 됨')

      }
      else{
        setIsLoginSuccess(false)
      }
        
    })
    .catch((error)=>{
      alert('로그인 오류')
      console.log(error)
    })

  }

  function drawModalContent(){
     
    return(
      <div>
        {
          isLoginSuccess
          ?
          <div>환영합니다🥳</div>
          :
          <div>존재하지 않는 회원입니다.</div>
        }
      </div>

    )
  }

  function handleBtn(){
    if(isLoginSuccess){// 로그인 성공 시 확인 버튼 내용
              
      if(loginInfo.memRole=='USER'){
        navigate('/itemList')
        return
      }
      else if(loginInfo.memRole=='ADMIN'){
        navigate('/admin/itemManage')
        return
      }

    }
    else{// 로그인 실패 시 확인 버튼 내용

    }
  }

  function handleKeyPress(e){
    if(e.key==='Enter'){
      goLogin()
    }
  }


  return (
    <div className='login-div'>
      <h2>로그인</h2>
      
      <div>
        <table className='login-table'>
          <thead></thead>
          <tbody>
            <tr>
              <td><input type='text' name='memId' placeholder='아이디를 입력하세요' className='login-input'
              onChange={(e)=>{inputLogin(e)}}></input></td>
            </tr>
            <tr>
              <td><input type='password' name='memPw' placeholder='비밀번호를 입력하세요' className='login-input'
                onKeyDown={(e)=>{handleKeyPress(e)}}
                onChange={(e)=>{inputLogin(e)}}></input></td>
            </tr>
          </tbody>
        </table>
        <button type='button' className='login-Btn'
          onClick={(e)=>{goLogin();}}>로그인</button>
      </div>

      {/* 로그인 중 아이디,비밀번호 입력여부를 확이하는 모달창 */}
      {
        beforeLoginmodal
        ?
        <Modal content={()=>{
          return(
            <div>아이디와 비밀번호는 필수입력입니다.🙃</div>
          )
        }}
        setIsShow={
          setBeforeLoginModal}
        clickCloseBtn={()=>{
          // setBeforeLoginModal(false)
        }}/>
        :
        null
      }
      {
        afterLoginModal
        ?
        <Modal content={drawModalContent}
        setIsShow={setAfterLoginModal}
        clickCloseBtn={handleBtn}/>
        :
        null
      }


    </div>
  )
}

export default LoginForm