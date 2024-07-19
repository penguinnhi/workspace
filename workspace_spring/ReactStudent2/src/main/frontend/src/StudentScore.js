import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
// import * as api from './apis';
import { getList } from './apis';
//getList라는 변수만 들고 오겠다는 거 (구조분해할당) 이렇게 호출하면 as api 의 api.변수 이렇게 호출 안 해도 되고 getList로 바로 호출 가능함

const StudentScore = () => {
  const navigate=useNavigate();
  const [stuList,setStuList]=useState([]);

  useEffect(()=>{
    getList()
    .then((res)=>{
      setStuList(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);

  // useEffect(()=>{
  //   api.getList.then().catch()
  // },[]);

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>성적입력</td>
          </tr>
        </thead>

        <tbody>
          {
            stuList.map((stu,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td>{stu.stuName}</td>
                <td><button type='button' onClick={(e)=>{navigate(`/inputScore/${stu.stuNum}`)}}>입력</button></td>
              </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default StudentScore