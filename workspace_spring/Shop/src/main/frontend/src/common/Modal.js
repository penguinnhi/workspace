import React, { useRef } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Modal = ({isShow,content,setIsShow,clickCloseBtn}) => {
  //setIsShow: 모달을 닫는 코드
  //clickCloseBtn: 모달의 확인 버튼 클릭시 실행 코드

  const modalContainer=useRef();

  // function goLoginForm(){
  //   navigate('/loginForm')
  // }


  return (
    <div>
      <div className='modal-container show' ref={modalContainer}>
        <div className='modal'>

          <div className='modal-header'>
            <span onClick={(e)=>{
              modalContainer.current.className='modal-container'
              setTimeout(() => {

                setIsShow(false)
                clickCloseBtn();
              }, 300); //0.3초
              
              }}><i className="bi bi-x-lg"></i></span>
          </div>
 
          <div className='modal-content'>
            {
              content()
            }
          </div>

          <div className='modal-footer'>
            <button type='button' onClick={(e)=>{
              modalContainer.current.className='modal-container'
              setTimeout(() => {
                //모달창 닫기 
                setIsShow(false)

                //어떤 페이지에서 모달창을 실행했냐에 따라 실행 코드가 달라져야함 
                clickCloseBtn();
              }, 300);
              
              
              }}>확인</button>
          </div>

        </div>
      </div>


    </div>
  )
}

export default Modal