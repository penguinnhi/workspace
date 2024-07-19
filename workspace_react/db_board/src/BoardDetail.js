import axios from "axios";
import { useEffect, useState } from "react";
import { Navigate, useNavigate, useParams } from "react-router-dom";

const BoardDetail=()=>{
  //DB에서 상세 조회 한 내용을 화면에 출력
  //그니까 그걸 어떻게 하냐고 

  const params = useParams();
  const navigate = useNavigate();
  

  const [boardDetail,setBoardDetail]=useState({});

  let findBoard=null;
  

  useEffect(()=>{
    axios
    .get(`/getDetail/${params.boardNum}`)
    .then((res)=>{
      console.log(res.data)
      setBoardDetail(res.data)
    })
    .catch((error)=>{
      console.log('🤮🤢');
      console.log(error)
    })
  },[]);

  function back(){
    navigate(-1)
  }

  function delete1(){

    if(window.confirm('삭제?')){
      axios
      .delete(`/goDelete/${params.boardNum}`)
      .then((res)=>{
        alert('삭제됨')
        navigate('/');
      })
      .catch((error)=>{
        alert('👽👽')
        console.log(error)
      })
    
    }
    
  }



  return(
    <div>
      <table>
        <thead>
        <tr>
          <td className="head">글번호</td>
          <td>{boardDetail.boardNum}</td>
          <td className="head">작성자</td>
          <td>{boardDetail.boardWriter}</td>
          <td className="head">작성일</td>
          <td>{boardDetail.createDate}</td>
        </tr>
        </thead>

        <tbody>
        <tr>
          <td className="head">제목</td>
          <td colSpan={5}>{boardDetail.boardTitle}</td>
        </tr>
        <tr>
          <td className="head">내용</td>
          <td colSpan={5}>{boardDetail.boardContent}</td>
        </tr>
        </tbody>
      </table>

      <button type="button" onClick={(e)=>{back()}}>뒤로가기</button>
      <button type="button" onClick={(e)=>{delete1()}}>삭제</button>
      <button type="button" onClick={(e)=>{
        navigate(`/goUpdate/${params.boardNum}`)
      }}>수정</button>
    </div>
  );
}

export default BoardDetail;