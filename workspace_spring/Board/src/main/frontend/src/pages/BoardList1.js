import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { getBoardList } from '../apis/boardApi';

// . : 현재폴더 / .. : 상위폴더 

const BoardList1 = ({loginInfo}) => {
  const navigate=useNavigate();
  const [boardList,setBoardList]=useState([]);


  useEffect(()=>{
    getBoardList()
    .then((res)=>{
      
      // console.log(res.data)
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
                  <td><span className='title' onClick={(e)=>{navigate(`/bDetail/${board.boardNum}`)}}>{board.title}</span></td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
                );
              })
            }
          </tbody>
        </table>
          

        {

          loginInfo.memId!=null ? 
          <button type='button' onClick={(e)=>{navigate('/boardWrite')}}>글쓰기</button> 
          : null 

        }
        

      </div>

    </div>
  )
}

export default BoardList1