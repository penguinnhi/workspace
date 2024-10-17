import React, { useState } from 'react'
import './AdminBoard.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const AdminBoard = ({loginInfo}) => {
  const navigate=useNavigate()

  const [adminBoardData,setAdminBoardData]=useState({
    cateNum:1,
    memId:loginInfo.memId,
    boardTitle:'',
    boardContent:''
  })


  const insertData=(e)=>{
    setAdminBoardData({
      ...adminBoardData,
      [e.target.name]:e.target.value
    })
  }

  const goInsert=()=>{
    axios
    .post('/board/insertBoard',adminBoardData)
    .then((res)=>{
      alert('공지사항이 등록되었습니다.')
      navigate('/boardList')
    })
    .catch(error=>console.log(error))
  }

  return (

      <div className='adminBoard-div'>
        <h2>공지사항 작성</h2>
        <table className='adminBoard-table'>
            <thead></thead>
            <tbody>
              <tr>
                <td>제목</td>
                <td><input type='text' name='boardTitle'
                    onChange={(e)=>{insertData(e)}}></input></td>
              </tr>
              <tr>
                <td><div>내용</div></td>
                <td>
                  <div className='adminBoard-content'>
                    <textarea type='text' name='boardContent' onChange={(e)=>{insertData(e)}}></textarea>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
          <button type='button' onClick={()=>{goInsert()}}>글쓰기</button>
      </div>

  )
}

export default AdminBoard
