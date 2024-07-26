import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { getReplyList } from '../apis/replyApi';

const ReplyContent = ({loginInfo}) => {
  const [replyList,setReplyList]=useState([])
  const {boardNum}=useParams();
  //console.log({boardNum})


  useEffect(()=>{
    getReplyList(boardNum)
    .then((res)=>{
      setReplyList(res.data)
      //console.log(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[]);


  function delReply(replyNum){
    axios
    .delete(`/reply/delete/${replyNum}`)
    .then((res)=>{
      alert('댓글삭제')
      const re=replyList.filter((reply)=>{
        return(
          reply.replyNum!=replyNum
        )
      })
      setReplyList([...re]);

    })
    .catch((error)=>{console.log(error)})
  }


  return (
    <div>
      {
        replyList.map((re,i)=>{
          return(

          <div className='replyContent' key={i}>
            
            <p>{re.memId} </p> 
            <p className='replyDetail'>{re.replyDate}</p>
            <p>{re.replyContent}</p>
            <p className='replyDetail'>{i+1}번재 댓글임</p>

            {loginInfo.memId==re.memId ? 
            <button type='button' onClick={(e)=>{delReply(re.replyNum)}}>삭제</button> : null}

          </div>

          );
        })
      }
    </div>
  );
}

export default ReplyContent