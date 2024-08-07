import React from 'react'

const Modal = ({content}) => {
  

  return (
    <div>
      <div className='modal-container'>
        <div className='modal'>

          <div className='modal-header'>
            <span onClick={(e)=>{


            }}><i class="bi bi-x-lg"></i></span>
          </div>

          <div className='modal-content'>
            {
              content()
            }
          </div>

          <div className='modal-footer'>
            <button type='button'>확인</button>
          </div>

        </div>
      </div>
    </div>
  )
}

export default Modal