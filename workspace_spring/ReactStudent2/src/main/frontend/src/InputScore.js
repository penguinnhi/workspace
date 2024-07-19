import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const InputScore = () => {
  //성적 입력을 하려는 학생이름, 국어,영어,수학 점수를 조회
  //studentScore에서 올 때 리스트를 가져오는건가 

  const navigate=useNavigate();
  // const [stuDetail,setStuDetail]=useState({});
  const [changeScore,setChangeScore]=useState({});
  const {stuNum}=useParams();

  useEffect(()=>{
    axios
    .get(`/getDetail/${stuNum}`)
    .then((res)=>{
      setChangeScore(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);


  function putScore(e){
    setChangeScore({
      ...changeScore,
      [e.target.name] : e.target.value  
    })
  }


  function inScore(){
    axios
    .put('/updateScore',changeScore)
    .then((res)=>{
      alert('ㅇㅇ')
      navigate('/')
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  }


  return (
    <div>

      <p>{changeScore.stuName} 학생의 성적 입력</p>

      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>국어</td>
            <td><input type='text' name='korScore' value={changeScore.korScore} onChange={(e)=>{putScore(e)}}></input></td>
          </tr>
          <tr>
            <td>영어</td>
            <td><input type='text' name='engScore' value={changeScore.engScore} onChange={(e)=>{putScore(e)}}></input></td>
          </tr>
          <tr>
            <td>수학</td>
            <td><input type='text' name='mathScore' value={changeScore.mathScore} onChange={(e)=>{putScore(e)}}></input></td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={(e)=>{inScore()}}>점수등록</button>
    </div>
  )
}

export default InputScore