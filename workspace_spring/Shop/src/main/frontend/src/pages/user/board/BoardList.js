import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './BoardList.css'
import axios from 'axios'

const BoardList = ({loginInfo}) => {
  const navigate=useNavigate()

  const [adminBoard,setAdminBoard]=useState([])

  useEffect(()=>{
    axios.get('/board/selectAdminBoard')
    .then((res)=>{
      setAdminBoard(res.data)
    })
    .catch((error)=>{console.log(error)})

  },[])

  function goWrite(){
    if(Object.keys(loginInfo).length===0){
      navigate('/loginForm')
    } else {
      navigate('/boardWrite')
    }
  }

  return (
    <div className='boardList-div'>
      <div>
        <h2>📝 공지사항</h2>
        <div className='adminBoard-ul'>
          {
            adminBoard.map((board,i)=>{
              return(
                <ul key={i}>
                  <li>
                    <div><h3>{board.boardTitle}</h3></div>
                    <div>{board.boardContent}</div>
                    {
                      loginInfo.memRole==='ADMIN'?
                      <div onClick={()=>{}}>🔑</div>
                      :
                      null
                    }
                    
                  </li>
                </ul>
              )
            })
          }
        </div>
        {
          loginInfo.memRole==='ADMIN'?
          <button type='button' className='adminBtn' onClick={()=>{navigate('/admin/adminBoard')}}>글쓰기</button>
          :
          null
        }
      </div>

      <div className='one-question'>
        <h2><span onClick={()=>{goWrite()}}>🔍 1:1 문의</span></h2>
        <div>
        </div>
      </div>
    </div>
  )
}

export default BoardList
