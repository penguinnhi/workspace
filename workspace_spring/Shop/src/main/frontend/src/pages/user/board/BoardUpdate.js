import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const BoardUpdate = ({loginInfo}) => {
  const navigate=useNavigate()

  const [boardData,setBoardData]=useState({})
  const [memData,setMemData]=useState({})
  const {boardNum}=useParams()

  const [changeData,setChangeData]=useState({
    boardNum:boardNum,
    boardTitle:'',
    boardContent:''
  })

  useEffect(()=>{
    axios.get(`/board/myBoardDetail/${boardNum}`)
    .then((res)=>{
      setBoardData(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  useEffect(()=>{
    axios.get(`/member/selectMem/${loginInfo.memId}`)
    .then((res)=>{
      setMemData(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  const insertData=(e)=>{
    setChangeData({
      ...changeData,
      [e.target.name]:e.target.value
    })
  }

  const goInsert=()=>{

    axios.post(`/board/updateMyBoard`,changeData)
    .then((res)=>{
      alert('수정이 완료되었습니다.')
      navigate('/myBoard')
    })
    .catch((error)=>{console.log(error)})

  }

  return (
    <div>
      <div className='board-div'>
        <h2>1:1 문의</h2>
        <table className='board-table'>
          <thead></thead>
          <tbody>
            <tr>
              <td>고객명</td>
              <td>{loginInfo.memId}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <div><input type='text' name='boardTitle' 
                  defaultValue={boardData.boardTitle}
                  onChange={(e)=>{insertData(e)}}></input></div>
                <div><textarea name='boardContent' 
                  defaultValue={boardData.boardContent}
                  onChange={(e)=>{insertData(e)}}></textarea></div>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td><input type='text' defaultValue={memData.memTel}></input></td>
            </tr>
            <tr>
              <td>이메일</td>
              <td><input type='text' defaultValue={memData.memEmail}></input></td>
            </tr>
          </tbody>
        </table>
        <button type='button' onClick={()=>{goInsert()}}>문의 수정</button>
      </div>
    </div>
  )
}

export default BoardUpdate
