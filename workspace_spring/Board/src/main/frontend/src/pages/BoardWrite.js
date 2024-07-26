import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { insertBoard } from '../apis/boardApi';

const BoardWrite = ({loginInfo}) => {
  //작성자id를 들고올거임 로그인했을때의 아이디로 작성을 할거니까... 
  const navigate = useNavigate();
  const [board,setBoard] = useState({
    memId:loginInfo.memId,
    title : '',
    content : ''
  });

  function writeBoard(e){
    setBoard({
      ...board,
      [e.target.name]:e.target.value
    })
  }

  function upBoard(){
    insertBoard(board)
    .then((res)=>{
      alert('글이 등록됨')
      navigate('/')
    })
    .catch((error)=>{
      alert('글등록안됨')
      console.log(error)})
  }

  return (
    <div className='container'>

      <table className='write'>
        <thead></thead>
        <tbody>
          <tr>
            <td>제목</td>
            <td><input type='text' name='title' onChange={(e)=>{writeBoard(e)}}></input></td>
          </tr>
          <tr>
            <td>내용</td>
            <td><textarea name='content' onChange={(e)=>{writeBoard(e)}}></textarea></td>
          </tr>
        </tbody>
      </table>
      
      <button type='button' onClick={(e)=>{upBoard()}}>글등록</button>

    </div>
  )
}

export default BoardWrite