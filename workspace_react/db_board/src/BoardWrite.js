import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const BoardWrite=()=>{
  const navigate = useNavigate();

  //입력한 내용을 저장하는 state변수
  const [boardWrite,setBoardWrite]=useState({
    boardTitle : '',
    boardContent : '',
    boardWriter : '',
  });

  //글등록 버튼 클릭 시 실행하는 함수 
  function write(){
    //제목이 비었으면? 
    const title_input = document.querySelector('input[name="boardTitle"]');
    if(title_input.value==''){
      alert('제목😶');
      title_input.focus();
      return; // ? ?
    }

    // if(boardWrite.boardTitle){
    //   alert('제목')
    // } 이건 리액트 문법 

    if(document.querySelector('input[name="boardWriter"]').value==''){
      alert('작성자');
      document.querySelector('input[name="boardWriter"]').focus();
      return;
    }
    
    

    axios
    .post('/goWrite',boardWrite)
    .then((res)=>{
      alert('ㅇㅇ')
      navigate('/');
    })
    .catch((error)=>{
      alert('우욱🤮🤢🤮🤢')
      console.log(error)
    })
  }

  //입력값 세팅 
  function writeBoard(e){
      setBoardWrite({
      ...boardWrite,
      [e.target.name] : e.target.value
    })
  }

  // useEffect(()=>{
    
  // });


  return(
    <div>
      <table>
        <tr>
          <td className="head">제목</td>
          <td><input type="text" name="boardTitle" onChange={(e)=>{
            setBoardWrite({
              ...boardWrite,
              boardTitle : e.target.value
            })
          }}></input></td>
        </tr>
        <tr>
          <td className="head">작성자</td>
          <td><input type="text" name="boardWriter" onChange={(e)=>{writeBoard(e)}}></input></td>
        </tr>
        <tr>
          <td className="head">내용</td>
          <td><textarea name="boardContent" onChange={(e)=>{writeBoard(e)}}></textarea></td>
        </tr>
      </table>

      <button type="button" onClick={(e)=>{
        write()
      }}>글등록</button>
    </div>
  );

}

export default BoardWrite;