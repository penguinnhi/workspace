import axios from "axios";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const BoardUpdate=()=>{
  const navigate = useNavigate();
  const params = useParams();

  const [boardUpdate,setBoardUpdate]=useState({
    boardTitle : '',
    boardContent : '',
    boardWriter : '',
  });


  function update1(){
    axios
    .put(`/goUpdate/${params.boardNum}`,boardUpdate)
    .then((res)=>{
      alert('수정')
      navigate(`/getDetail/${params.boardNum}`);
    })
    .catch((error)=>{
      alert('🤢')
      console.log(error);
    })
  }

  function updateBoard(e){
    setBoardUpdate({
      ...boardUpdate,
      [e.target.name] : e.target.value
    })
  }

  return(

    <div>

      <table>
        <thead>
        <tr>
          <td className="head">글번호</td>
          {/* <td>{boardDetail.boardNum}</td> */}
          <td className="head">작성자</td>
          {/* <td>{boardDetail.boardWriter}</td> */}
          <td className="head">작성일</td>
          {/* <td>{boardDetail.createDate}</td> */}
        </tr>
        </thead>

        <tbody>
        <tr>
          <td className="head" name="boardTitle" onChange={(e)=>{updateBoard(e)}}>제목</td>
          <td colSpan={5}><input type="text"></input></td>
        </tr>
        <tr>
          <td className="head" name="boardContent" onChange={(e)=>{updateBoard(e)}}>내용</td>
          <td colSpan={5}><textarea></textarea></td>
        </tr>
        </tbody>
      </table>

      <button type="button" onClick={(e)=>{update1()}}>수정</button>

    </div>


  );
}

export default BoardUpdate;