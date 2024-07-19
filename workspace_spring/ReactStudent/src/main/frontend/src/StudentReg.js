import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const StudentReg=()=>{
  const navigate = useNavigate();

  const [stuReg,setStuReg]=useState({
    stuName : '',
    stuAge : 0,
    stuTel : '',
    stuAddr: ''
  });

  function changeStu(e){
    setStuReg({
      ...stuReg,
      [e.target.name] : e.target.value  
    })
  }

  function regStu(){
    //이름 입력했는지 확인
    const inputName = document.querySelector('input[name="stuName"]')
    if(inputName.value==''){
      alert('이름')
      inputName.focus()
      return
    }

    axios
    .post('/regStu',stuReg)
    .then((res)=>{
      alert('등록됨')
      navigate('/');
    })
    .catch((error)=>{
      alert('🤢')
      console.log(error)
    })
  }

  return(
    <div>
      
      <table>
        <thead></thead>
        <tbody className="regBody">
        <tr>
          <td>이름</td>
          <td><input type="text" name="stuName" onChange={(e)=>{changeStu(e)}}></input></td>
        </tr>
        <tr>
          <td>나이</td>
          <td><input type="text" name="stuAge" onChange={(e)=>{changeStu(e)}}></input></td>
        </tr>
        <tr>
          <td>연락처</td>
          <td><input type="text" name="stuTel" onChange={(e)=>{changeStu(e)}}></input></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><input type="text" name="stuAddr" onChange={(e)=>{changeStu(e)}}></input></td>
        </tr>
        </tbody>
      </table>

      <button type="button" className="btn" onClick={(e)=>{regStu()}}>글쓰기 </button>

    </div>


  );

}

export default StudentReg;