import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";


const InputScore=()=>{
  const navigate = useNavigate();

  const [inputScore,setInputScore]=useState({
    stuName : '',
    stuNum : 0,
    korScore : 0,
    engScore : 0,
    mathScore : 0
  });
  const params = useParams(); 
  //console.log(params.stuNum)
  // App에서 넘어오는 거를 받는게 params

  // const [stuList,setStuList]=useState([]);

  function changeScore(e){
    setInputScore({
      ...inputScore,
      [e.target.name] : e.target.value
    })
  }

  useEffect(()=>{

    axios
    .get(`/getDetail/${params.stuNum}`)
    .then((res)=>{
      setInputScore(res.data)
      console.log(res.data)
    })
    .catch((error)=>{
      alert('🙃')
      console.log(error)
    })

  },[]);
  

  

  function inputScore1(){

    axios
    .put(`/inputScore`,inputScore)
    .then((res)=>{
      alert('등록됨')
      navigate('/')
    })
    .catch((error)=>{
      alert('🤢')
      console.log(error);
    })
  }

  return(
    <div>
      
      <p>{inputScore.stuName}학생의 성적입력</p>

      <table>
        <tbody className="regBody">
        <tr>
          <td>국어</td>
          <td><input type="text" name="korScore" onChange={(e)=>{changeScore(e)}}></input></td>
        </tr>
        <tr>
          <td>영어</td>
          <td><input type="text" name="engScore" onChange={(e)=>{changeScore(e)}}></input></td>
        </tr>
        <tr>
          <td>수학</td>
          <td><input type="text" name="mathScore" onChange={(e)=>{changeScore(e)}}></input></td>
        </tr>
        </tbody>
      </table>

      <button type="button" className="btn" onClick={(e)=>{
        inputScore1()
      }}>점수등록</button>
    </div>
  );
}
export default InputScore;