import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const BoardList=()=>{
  //게시글 목록이 저장할 state 변수
  const [boardList,setBoardList]=useState([]);
  const navigate = useNavigate();

  //게시글 목록 조회 
  useEffect(()=>{
    axios
    .get('/boardList')
    .then((res)=>{
      console.log(...res.data);
      setBoardList(res.data);
    })
    .catch((error)=>{
      alert('오류남🤮 /n 개발자 모드로 콘솔 확인하세요')
      console.log(error);
    })
  },[]);


  return(

    <div>
      <table>
        <thead>
          <tr className="head">
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>

        <tbody>
          {
            boardList.map((board,i)=>{
              return(
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td className="title"><span onClick={(e)=>{
                    navigate(`/getDetail/${board.boardNum}`);
                  }}>{board.boardTitle}</span></td>
                  <td>{board.boardWriter}</td>
                  <td>{board.createDate}</td>
                </tr>
              );
            })
          }
        </tbody>

      </table>

      <button type="button" onClick={(e)=>{navigate('/goWrite')}}>글쓰기</button>

    </div>
  );

}

export default BoardList;