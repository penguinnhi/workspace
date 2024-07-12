import { useNavigate } from 'react-router-dom';
import './Write.css';
import { useState } from 'react';
import App from './App';

function Wrtie({board_list, setBoardList}){
  

  const navigate=useNavigate();

  //입력한 모든 정보를 저장하는 state 변수
  const [inputBoard,setInputBoard]=useState({
    boardNum : 0,
    title:'',
    content:'',
    writer:'',
    createDate:''
  });

  function upBoard(e){
    setInputBoard({
      ...inputBoard,
      [e.target.name] : e.target.value
    });
  }

  return(

    <div>

      <h1>작성</h1>

      <table className='writeTable'>
        <tr>
          <td className="name">글번호</td>
          <td><input type="text" name='boardNum' onChange={(e)=>{
            setInputBoard({
              ...inputBoard,
              [e.target.name]: Number(e.target.value)
            })
          }}></input></td>
        </tr>
        <tr>
          <td className="name">제목</td>
          <td><input type="text" name='title' onChange={(e)=>{
            upBoard(e);
          }}></input></td>
        </tr>
        <tr>
          <td className="name">작성자</td>
          <td><input type="text" name='writer' onChange={(e)=>{
            upBoard(e);
          }}></input></td>
        </tr>
        <tr>
          <td className="name">작성일</td>
          <td><input type="date" name='createDate' onChange={(e)=>{
            upBoard(e);
          }}></input></td>
        </tr>
        <tr>
          <td className="name">내용</td>
          <td><textarea name='content' onChange={(e)=>{
            upBoard(e);
          }}></textarea></td>
        </tr>
  
      </table>
  
        <button type="button" onClick={(e)=>{
          
          // board_list.push(inputBoard);
          setBoardList([...board_list, inputBoard]);
          //[원래있던배열,새배열추가]

          // console.log(`등록 후 게시글 목록`);
          // console.log(board_list);

          navigate(`/`);
        }}>글등록</button>

      <div>
        {inputBoard.boardNum}
        {inputBoard.title}
        {inputBoard.content}
        {inputBoard.writer}
        {inputBoard.createDate}
      </div>  
      {/* 이거를 목록페이지로 보내면 될듯? 어떻게?  */}


    </div>

  );

}

export default Wrtie;