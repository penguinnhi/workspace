import axios from 'axios'
import React, { useRef, useState } from 'react'
import { useDaumPostcodePopup } from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';
import Modal from '../../common/Modal';
import { joinValidate } from '../../validate/joinValidate';
import './Join.css'

const Join = () => {


  // 모달 렌더링 여부
  const [isShow,setIsShow]=useState(false)


  const [joinData,setJoinData]=useState({
    memId:'',
    memPw:'',
    confirmPw:'',
    memName:'',
    memTel:'',
    post:'',
    memAddr:''
  })
  


  //daum 주소 api 팝업창을 띄우기 위한 변수
  const open=useDaumPostcodePopup();

  //주소 검색 팝업창이 닫힐 때 실행되는 함수
  function handleComplete(data){
    //우편번호
    //console.log(data.zonecode)

    //도로명주소
    //console.log(data.address)

    //input태그에 검색한 내용을 넣어주기
    setJoinData({
      ...joinData,
      post:data.zonecode,
      memAddr:data.address
    })

  }

  //검색 버튼 클릭 시 실행되는 함수 
  // 이거 뭐임? 
  function handleClick(){
    open({onComplete : handleComplete})

  }


  const navigate=useNavigate();
  const email_1=useRef();
  const email_2=useRef();


  //유효성 검사 결과를 저장하는 변수 
  const [validate_result,setValidResult]=useState(false);

  const memId_valid_tag=useRef();
  const memName_valid_tag=useRef();
  const memPw_valid_tag=useRef();
  const confirmPw_valid_tag=useRef();
  const memTel_valid_tag=useRef();

  const valid_tag=[
    memId_valid_tag
    ,memName_valid_tag
    ,memPw_valid_tag
    ,confirmPw_valid_tag
    ,memTel_valid_tag
  ];
  //const valid_tag=useRef([])
  
  

  function inputData(e){
    //입력한 데이터 
    const newData={
      ...joinData,
      [e.target.name] : e.target.name!='memEmail'?
      e.target.value : email_1.current.value+email_2.current.value
    }
    // console.log(joinData.confirmPw)
    
    //입력한 데이터 validation 처리 : 모든 데이터가 유효한 데이터면 return true
    const result = joinValidate(newData,valid_tag,e.target.name)
    // console.log(result)
    setValidResult(result)

    // 유효성 검사가 끝난 데이터를 joinData에 저장
    setJoinData(newData)

    
  }

  //id중복여부 저장할 변수
  const [isCheckId,setIsCheckId]=useState(false)

  function isDup(){
    const inputId=joinData.memId
    if(inputId==''){
      alert('아이디를 입력해주세요.')
    }

    axios
    .get(`/member/isDup/${inputId}`)
    .then((res)=>{
      if(res.data){
        alert('중복 아이디입니다.')
      }
      else{
        alert('사용 가능한 아이디입니다.')
        setIsCheckId(true)
        
      }
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  function goJoin(){
    //유효성 검사 결과가 false면 회원가입 로직 중지 
    if(!validate_result){
      alert('입력 데이터를 확인하셔요.🙃')
      return
    }

    // return문을 주면 리턴을 만나는 즉시 종료됨 


    //id 중복 검사를 했는지 확인
    if(!isCheckId){
      alert('아이디 중복검사 ㄱ ')
      return
    }


    axios
    .post('/member/join',joinData)
    .then((res)=>{
      setIsShow(true)
      // navigate('/loginForm')
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  //모달창 안의 내용을 생성하는 함수
  function setModalContent(){

    return(
      <div>💰💰💰ㅊㅋ👽💰💰</div>
    )

  }

  //모달창을 닫으면 실행되는 함수
  function onclickModalBtn(){
    navigate('/loginForm')

  }
  

  return (
    <div className='join-div'>
      <h2>회원가입</h2>
      

      <div>
  
        <table className='join-table'>
          <thead></thead>
          <tbody>
            <tr>
              <td>아이디</td>
              <td>
                <div className='inline-input'>
                  <input type='text' name='memId' 
                    className='join-input' placeholder='4~12자리의 영문자'
                    onChange={(e)=>{inputData(e); setIsCheckId(false);}}></input>
                  <button type='button' className='join-Btn' 
                  onClick={(e)=>{isDup()}}>중복확인</button>
                </div>
                <div className='feedback' ref={valid_tag[0]} ></div>
              </td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td><input type='password' name='memPw' 
                className='join-input' placeholder='영문,숫자를 조합하여 4~12자리'
                onChange={(e)=>{inputData(e)}}></input>
              <div  className='feedback' ref={memPw_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td><input type='password' name='confirmPw' 
                className='join-input' placeholder='비밀번호를 다시 한 번 입력해주세요.'
                onChange={(e)=>{inputData(e)}}></input>
              <div className='feedback' ref={confirmPw_valid_tag} ></div>
              </td>
            </tr>
            <tr>
              <td>이름</td>
              <td>
                <input type='text' name='memName' 
                  className='join-input' 
                  onChange={(e)=>{inputData(e)}}></input>
                <div className='feedback' ref={valid_tag[1]}></div>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td><input type='text' name='memTel' 
                className='join-input' 
                onChange={(e)=>{inputData(e)}}></input>
              <div className='feedback' ref={memTel_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td rowSpan={3}>주소</td>
              <td>
                <div className='inline-input'>
                  <input type='text' name='post' value={joinData.post} 
                    className='join-input' 
                    onChange={(e)=>{inputData(e)}} placeholder='우편번호' readOnly={true} 
                    onClick={handleClick}></input>
                  <button type='button' className='join-Btn'
                    onClick={handleClick}>검색</button>
                </div>
              </td>
            </tr>
            <tr>
              <td><input type='text' name='memAddr' value={joinData.memAddr} 
                className='join-input' onChange={(e)=>{inputData(e)}} placeholder='주소' readOnly={true} 
                onClick={handleClick}></input></td>
            </tr>
            <tr>
              <td><input type='text' name='addrDetail' className='join-input' 
                onChange={(e)=>{inputData(e)}} placeholder='상세주소'></input></td>
            </tr>
            <tr>
              <td>이메일</td>
              <td>
                <div className='inline-select'>
                  <input type='text' name='memEmail' className='join-input' ref={email_1} 
                    onChange={(e)=>{inputData(e)}}></input>
                  <select name='memEmail' className='join-input' ref={email_2} 
                    onChange={(e)=>{inputData(e)}}>
                    <option value={'@naver.com'}>naver.com</option>
                    <option value={'@gmail.com'}>gmail.com</option>
                  </select>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
  
        <button type='button' className='get-join-btn'
          onClick={(e)=>{goJoin()}}>회원가입</button>
  
      </div>



      {/* 회원가입 성공 시 열리는 모달 */}
      {
        isShow?
        <Modal isShow={isShow} 
        setIsShow={setIsShow} 
        content={setModalContent} 
        clickCloseBtn={onclickModalBtn}/>
        :
        null
      }


    </div>
  )
}


export default Join