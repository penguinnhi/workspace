import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const BoardList1 = () => {
  const navigate=useNavigate();
  const [boardList,setBoardList]=useState([]);

  useEffect(()=>{
    axios
    .get('/board/list')
    .then((res)=>{
      
      console.log(res.data)
      setBoardList(res.data)
    })
    .catch((error)=>{
      // alert('ㄴㄴ')
      console.log(error)
    })
  },[]);

  return (
    <div>

      <div className='searchBox'>
        <select>
          <option>제목</option>
          <option>작성자</option>
        </select>
        <input type='text' name='search'></input>
        <button type='button'>검색</button>
      </div>

      <div className='board'>
        <table>
          <colgroup>
            <col width='10%'></col>
            <col width='*'></col>
            <col width='10%'></col>
            <col width='30%'></col>
          </colgroup>
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
                  <td>{boardList.length-i}</td>
                  <td>{board.title}</td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
                );
              })
            }
          </tbody>
        </table>
          
        <button type='button'>글쓰기</button>

      </div>

    </div>
  )
}

export default BoardList1