import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { getReplyList } from '../apis/replyApi';

const ReplyContent = ({loginInfo}) => {
  const [replyList,setReplyList]=useState([])
  const {boardNum}=useParams();
  //console.log({boardNum})
  const [replyData,setReplyData]=useState({

  });
  const [isShow,setIsShow]=useState(false);
  const clickUpdate=()=>{
    setIsShow(!isShow)
  }
  //const [delState,setDelState]=useState({})


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

  function updateReply(replyNum){

    axios
    .put('/reply/update',replyData)
    .then((res)=>{
      alert('댓수정')
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div>
      {
        replyList.map((re,i)=>{
          return(

          <div className='replyContent' key={i}>
            
            <p>{re.memId} </p> 
            <p className='replyDetail'>{re.replyDate}</p>
            <p onChange={(e)=>{
              
              setReplyData({
                ...replyData,
                replyNum:re.replyNum,
                replyContent:e.target.value
              })
            }}
            onClick={(e)=>{clickUpdate()}}
            >

              {
                isShow?
                <div>
                  <input type='text' name='replyContent'></input>
                </div>
                :
                re.replyContent
              }
              
              </p>
            <p className='replyDetail'>{i+1}번재 댓글임</p>

            {loginInfo.memId==re.memId ? 
            <div>
              <button type='button' onClick={(e)=>{delReply(re.replyNum)}}>삭제</button> 
              <button type='button' onClick={(e)=>{updateReply(re.replyNum)}}>수정</button>
            </div>
            
            
            : null}

          </div>

          );
        })
      }
    </div>
  );
}

export default ReplyContent