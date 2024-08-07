import axios from 'axios';
import React, { useEffect, useState } from 'react'

const BoardList = () => {
  const [boardList,setBoardList]=useState([]);

  useEffect(()=>{
    axios
    .get('/board/list')
    .then((res)=>{
      setBoardList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  return (
  
    <div className='body'>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board,i)=>{
              return(
                <tr key={i}>
                  <td>{boardList.length-1}</td>
                  <td>{boardList.title}</td>
                  <td>{boardList.memId}</td>
                  <td>{boardList.createDate}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>

      <button type='button'>글쓰기</button>
    </div>
  )
}

export default BoardList