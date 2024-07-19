import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import * as api from './apis';

const StudentList=()=>{
  const navigate=useNavigate();
  const [stuList,setStuList]=useState([]);

  useEffect(()=>{
    api.getList()
    .then((res)=>{
      setStuList(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);


  return(
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>수학점수</td>
            <td>평균</td>
          </tr>
        </thead>

        <tbody>
          {
            stuList.map((stu,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td><span onClick={(e)=>{navigate(`/getDetail/${stu.stuNum}`)}}>{stu.stuName}</span></td>
                <td>{stu.korScore}</td>
                <td>{stu.engScore}</td>
                <td>{stu.mathScore}</td>
                <td>{Math.round((stu.mathScore+stu.korScore+stu.engScore)/3.0*100)/100}</td>
              </tr>
              );
            })
          }

        </tbody>

      </table>

    </div>
  ); 
}

export default StudentList;