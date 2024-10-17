import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './BoardWirte.css'

const BoardWrite = ({loginInfo}) => {
  const navigate=useNavigate()

  const [updateData,setUpdateData]=useState({
    cateNum:2,
    memId:loginInfo.memId,
    boardTitle:'',
    boardContent:''
  })

  const [memData,setMemData]=useState({})


  function insertData(e){
    setUpdateData({
      ...updateData,
      [e.target.name]:e.target.value,
      memId:loginInfo.memId
    })
  }

  console.log(updateData)

  function goInsert(){
    axios
    .post('/board/insertBoard',updateData)
    .then((res)=>{
      alert('문의글이 등록되었습니다.')
      navigate('/itemList')
    })
    .catch((error)=>{console.log(error)})
  }


  useEffect(()=>{
    axios.get(`/member/selectMem/${loginInfo.memId}`)
    .then((res)=>{
      setMemData(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])


  // loginInfo랑 memList랑 들고와서 memId 비교 후 같으면 tel이랑 이메일 띄울까 

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
                  onChange={(e)=>{insertData(e)}}></input></div>
                <div><textarea name='boardContent'
                  onChange={(e)=>{insertData(e)}}></textarea></div>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td>{memData.memTel}</td>
            </tr>
            <tr>
              <td>이메일</td>
              <td>{memData.memEmail}</td>
            </tr>
          </tbody>
        </table>
        <button type='button' onClick={()=>{goInsert()}}>문의접수</button>
      </div>
    </div>
  )
}

export default BoardWrite
