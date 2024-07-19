import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const StudentDetail=()=>{
  const navigate=useNavigate();
  const params=useParams();

  const [stuDetail,setStuDetail]=useState({});

  useEffect(()=>{

    axios
    .get(`/getDetail/${params.stuNum}`)
    .then((res)=>{
      setStuDetail(res.data);
    })
    .catch((error)=>{
      alert('🙃')
      console.log(error)
    })

  },[]);
  

  return(

    <div>
      <table>
        <thead></thead>
        <tbody className="detailBody">
        <tr>
          <td>이름</td>
          <td>{stuDetail.stuName}</td>
          <td>나이</td>
          <td>{stuDetail.stuAge}</td>
        </tr>
        <tr>
          <td>연락처</td>
          <td>{stuDetail.stuTel}</td>
          <td>주소</td>
          <td>{stuDetail.stuAddr}</td>
        </tr>
        <tr>
          <td>국어점수</td>
          <td>{stuDetail.korScore}</td>
          <td>영어점수</td>
          <td>{stuDetail.engScore}</td>
        </tr>
        <tr>
          <td>수학점수</td>
          <td>{stuDetail.mathScore}</td>
          <td>평균</td>
          <td>{(stuDetail.mathScore+stuDetail.engScore+stuDetail.korScore)/3.0}</td>
        </tr>
        </tbody>
        

      </table>

      <button type="button" onClick={(e)=>{navigate(-1)}} className="btn">뒤로가기</button>
    </div>

  );

}

export default StudentDetail;