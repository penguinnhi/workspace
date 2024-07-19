import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import './StudentList.css';

const StudentList=()=>{
  const navigate=useNavigate();

  const [stuList,setStuList]=useState([]);

  useEffect(()=>{
    axios
    .get('/getList')
    .then((res)=>{
      setStuList(res.data);
    })
    .catch((error)=>{
      //alert('🤢')
      console.log(error)
    })
  },[]);

  


  return(
    <div>
      <table>
        <thead className="head">
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>수학점수</td>
            <td>평균</td>
          </tr>
        </thead>

        <tbody className="listBody">
          {/* if를 {} 이거 안에서는 못쓰는듯?  */}
          {
            stuList.length == 0 ?
            <tr><td colSpan={6}>조회된 데이터 없음</td></tr>
            :
            stuList.map((stu,i)=>{
              return (
              
              <tr key={i}>
                <td>{i+1}</td>
                <td className="td-name"><span onClick={(e)=>{navigate(`/stuDetail/${stu.stuNum}`)}}>{stu.stuName}</span></td>
                <td>{stu.korScore}</td>
                <td>{stu.engScore}</td>
                <td>{stu.mathScore}</td>
                <td>{Math.round((stu.mathScore+stu.engScore+stu.korScore)/3.0 * 100)/100}</td>
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