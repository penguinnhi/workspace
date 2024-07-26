import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import ReplyContent from './ReplyContent';
import ReplyWrite from './ReplyWrite';
//import { getBoardList } from '../apis/boardApi';
import { getBoardDetail } from '../apis/boardApi';

const BoardDetail = ({loginInfo}) => {
  const [isShow,setIsShow]=useState(false);
  const clickReply=()=>{
    setIsShow(!isShow)
  }

  const navigate=useNavigate();
  const [boardList,setBoardList]=useState([]);
  // const [replyList,setreplyList]=useState([]);
  const {boardNum} = useParams();
  
  useEffect(()=>{
    axios
    .get(`/board/detail/${boardNum}`)
    .then((res)=>{setBoardList(res.data)})
    .catch((error)=>{console.log(error)})
  },[]);

  //db에서 데이터 조회 여러개 동시에 실행하기
  // useEffect(()=>{
  //   axios
  //   .all([getBoardDetail(boardNum),axios.get(`/reply/list`)])
  //   .then(axios.spread((res1,res2)=>{
  //     setBoardList(res1.data)
  //     setreplyList(res2.data)
  //   }))
  //   .catch((error)=>{console.log(error)})
  // },[]);



  function delBoard(){
    axios
    .delete(`/board/delBoard/${boardNum}`)
    .then((res)=>{
      alert('게시글 삭제됨')
      navigate('/')

    })
    .catch((error)=>{
      alert('삭제오류')
      console.log(error)})
  }

  return (
    <div>

     <div className='boardContent'>
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{boardList.createDate}</td>
            <td>작성자</td>
            <td>{boardList.memId}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>{boardList.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>{boardList.content}</td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={(e)=>{navigate('/')}}>목록가기</button>


      {
        loginInfo.memId==null?null:<button type='button' onClick={(e)=>{clickReply()}}>댓글쓰기</button>
      }
      

      {
        loginInfo.memId==boardList.memId || loginInfo.memRole=='ADMIN' ? 
        <div>
          <button type='button' onClick={(e)=>{navigate(`/boardUpdate/${boardNum}`)}}>수정</button>
          <button type='button' onClick={(e)=>{delBoard()}}>삭제</button>
        </div>
        :
        null
      }

     </div>

      {
        isShow ? <ReplyWrite loginInfo={loginInfo} boardNum={boardNum}></ReplyWrite> : null
      }

     <div className='replyContent'>
      <ReplyContent boardNum={boardNum} loginInfo={loginInfo}></ReplyContent>
     </div>



    </div>
  )
}

export default BoardDetail