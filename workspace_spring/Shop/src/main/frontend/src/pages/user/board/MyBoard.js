import axios from 'axios';
import React from 'react'
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './MyBoard.css'

const MyBoard = ({loginInfo}) => {
  const navigate=useNavigate()

  const [myBoard,setMyBoard]=useState([])
  

  useEffect(()=>{
    axios
    .get(`/board/selectMyBoard/${loginInfo.memId}`)
    .then((res)=>{
      setMyBoard(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  const goDel=(boardNum)=>{

    if(window.confirm('게시글을 삭제하시겠습니까?')){
      axios.delete(`/board/delMyBoard/${boardNum}`)
      .then(res=>{
        alert('게시글이 삭제되었습니다.')

        myBoard.forEach((board,i)=>{
          if(board.boardNum==boardNum){
            myBoard.splice(i,1)
          }
        })
        setMyBoard([...myBoard])

      })
      .catch(error=>console.log(error))
    }

  }


  return (
    <div className='boardList-div'>
      <h2>마이 페이지</h2>
      <div className='myBoard-ul'>
        <h3>📝 내가 작성한 글</h3>
        {
          myBoard.map((b,i)=>{
            return(
              <ul key={i}>
                <li>
                  <span onClick={()=>{navigate(`/boardUpdate/${b.boardNum}`)}}> - {b.boardTitle}</span>
                  <span onClick={()=>{goDel(b.boardNum)}}>  ❌</span>
                </li>
                <li>{b.boardContent}</li>
              </ul>
            )
          })
        }</div>
    </div>
  )
}

export default MyBoard
