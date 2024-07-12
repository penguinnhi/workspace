import { useNavigate, useParams } from "react-router-dom";
import './Detail.css';
import { useState } from "react";
import Delete from "./Delete";

function Detail({board_list}){
  const navigate=useNavigate();

  let {id}=useParams();
  // == const params=useParams();
  //    const id=params.id;

  let findBoard=null;
  board_list.forEach((board,i)=>{
    if(board.boardNum==id){
      findBoard=board;
    }
  })

  const [del,setDel]=useState();

  

  return(


    <div className="detail">
      <h1>게시글 상세 화면</h1> 
  
      <table>
        <tbody>
          <tr>
            <td className="name">글 번호</td>
            <td>{findBoard.boardNum}</td>
            <td className="name">작성자</td>
            <td>{findBoard.writer}</td>
            <td className="name">작성일</td>
            <td>{findBoard.createDate}</td>
          </tr>
          <tr>
            <td className="name">제목</td>
            <td colSpan={5}>{findBoard.title}</td>
          </tr>
          <tr>
            <td className="name">내용</td>
            <td colSpan={5}>{findBoard.content}</td>
          </tr>
        </tbody>
  
      </table>

      <button type="button" onClick={(e)=>{
        navigate(-1);
      }}>뒤로가기</button>
      <button type="button" onClick={(e)=>{
        <Delete board_list={board_list}></Delete>
        navigate(`/`);
      }}>삭제</button>
    </div>


  );
}

export default Detail;