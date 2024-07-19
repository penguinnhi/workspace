import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const StudentDel=()=>{
  const navigate=useNavigate();
  const [stuList,setStuList]=useState([]);
  // const params =useParams();
  //console.log(params.stuNum)

  useEffect(()=>{
    axios
    .get('/getList')
    .then((res)=>{
      setStuList(res.data);
    })
    .catch((error)=>{})
  },[]);

  function delStu1(stuNum){

    axios
    .delete(`/goDelete/${stuNum}`)
    .then((res)=>{
      alert('삭제함')
      // 삭제하고나서 새로고침
      stuList.forEach((stu,i)=>{
        if(stu.stuNum==stuNum){
          stuList.splice(i,1);
        }
      })
      setStuList([...stuList]);
    })
    .catch((error)=>{
      alert('🤢')
      console.log(error)
    })
  }



  return(


    <div>
      <table>
        <thead className="head">
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>삭제</td>
          </tr>
        </thead>

        <tbody className="listBody">
          {
            stuList.map((stu,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td>{stu.stuName}</td>
                <td><button type="button" onClick={(e)=>{delStu1(stu.stuNum)}}>삭제</button></td>
              </tr>
              );
            })
          }

        </tbody>

      </table>
      
    </div>
  );


}

export default StudentDel;