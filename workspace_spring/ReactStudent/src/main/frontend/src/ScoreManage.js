import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const ScoreManage=()=>{
  const navigate =useNavigate();
  const [stuList,setStuList]=useState([]);

  useEffect(()=>{
    axios
    .get('/getList')
    .then((res)=>{
      setStuList(res.data);
    })
    .catch((error)=>{
      alert('ㄴㄴ')
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
            <td>성적입력</td>
          </tr>
        </thead>

        <tbody className="listBody">
          {
            stuList.map((stu,i)=>{
              return(
                <tr key={i}>
                  <td>{i+1}</td>
                  <td>{stu.stuName}</td>
                  <td><button type="button" onClick={(e)=>{navigate(`/inputScore/${stu.stuNum}`)}}>입력</button></td>
                </tr>
              );
            })
          }

        </tbody>
      </table>


    </div>
  );

}

export default ScoreManage;