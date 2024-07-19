import axios from 'axios'
import React from 'react'

// 서버와 통신하는 기능을 모아놓은 js

//학생 목록 조회 api
// export const getList = axios.get('/getList');

export const getList=()=>{
  const response = axios.get('/getList');
  return response;
}

export const getDetail = (stuNum)=>{
  const de=axios.get(`/getDetail/${stuNum}`);
  return de;
}

// 학생의 점수 정보 등록
export const updateScore=(data)=>{
  const up=axios.put('/updateScore',data);
  return up
}

// export const insertStu = axios.post('/insertStu',regStu)

export let myName='kim';

const apis = () => {
  return (
    <div>apis</div>
  )
}

export default apis