import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const BoardUpdate = () => {

  const navigate=useNavigate();
  const [boardList,setBoardList]=useState([]);
  // const [board,setBoard]=useState({});

  const {boardNum} = useParams();
  const [changeBoard,setChangeBoard]=useState({
    boardNum : boardNum
   });
 
  
  useEffect(()=>{
    axios
    .get(`/board/detail/${boardNum}`)
    .then((res)=>{setBoardList(res.data)})
    .catch((error)=>{console.log(error)})
  },[]);
  
  function changeBoard1(e){
    setChangeBoard({
      ...changeBoard,
      [e.target.name] : e.target.value
    })
    //console.log(changeBoard)
  }

  function updateBoard(){
    axios
    .post(`/board/update`,changeBoard)
    .then((res)=>{
      console.log(res.data)
      navigate(`/bDetail/${boardNum}`)
    })
    .catch((error)=>{console.log(error)})
  }


  return (
    <div>

      <div className='boardContent'>
        <table>
          <thead></thead>
          <tbody>
            <tr>
              <td>작성일</td>
              <td>{boardList.createDate}</td>
              <td>작성자</td>
              <td>{boardList.memId}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={3}>
                <input type='text' name='title' onChange={(e)=>{changeBoard1(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={3}>
                <textarea name='content' onChange={(e)=>{changeBoard1(e)}}></textarea>
              </td>
            </tr>
          </tbody>
        </table>

        <button type='button' onClick={(e)=>{navigate(-1)}}>뒤로가기</button>
        <button type='button' onClick={(e)=>{updateBoard()}}>수정</button>


      </div>

    </div>
  )
}

export default BoardUpdate