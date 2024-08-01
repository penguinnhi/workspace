import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { getReplyList } from '../apis/replyApi'

const ReplyWrite = ({loginInfo}) => {
  const navigate=useNavigate();
  const {boardNum}=useParams();
  const {replyNum}=useParams();
  const {cnt}=useParams();
  const {setCnt}=useParams();
  //const [isShow,setIsShow]=useState(false);
  

  const [reply,setReply]=useState({
    replyContent:'',
    boardNum : boardNum,
    memId : loginInfo.memId
  })

  const [replyList,setReplyList]=useState([])

  useEffect(()=>{
    getReplyList(boardNum)
    .then((res)=>{
      setReplyList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })

  },[]);


  function changeReply(e){
    setReply({
      ...reply,
      [e.target.name] : e.target.value
    })
  }

  function insertReply(){
    axios
    .post('/reply/insert',reply)
    .then((res)=>{
      // setReply([...reply])
      // const re=replyList.filter((reply)=>{
      //   return(
      //     reply.replyNum=replyNum
      //   )
      // })
      // setReplyList([...re])
      alert('ㅇㅇ')
      document.querySelector('textarea').value='';

      // 추가된 댓글이 화면에 바로 보이게 코드를 작성
      setCnt(cnt+1);
      


    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div>

      <textarea name='replyContent' onChange={(e)=>{changeReply(e)}}></textarea>
      <button type='button' onClick={(e)=>{insertReply()}}>등록</button>

    </div>
  )
}

export default ReplyWrite