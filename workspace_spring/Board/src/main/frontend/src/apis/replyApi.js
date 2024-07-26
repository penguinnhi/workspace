import axios from "axios"

export const getReplyList=(boardNum)=>{
  const response = axios.get(`/reply/list/${boardNum}`)
  return response
}