// 게시판 테이블에서 사용하는 axios 모음

import axios from "axios"

// 게시글 목록조회 
export const getBoardList=(pageNo)=>{
  const response = axios.post('/board/list',{'pageNo':pageNo});
  return response;
}


// export const getBoardList=(data)=>{
//   const response = axios.post('/board/list',data);
//   return response;
// } => 검색기능 포함 


//게시글 등록
export const insertBoard=(data)=>{
  const reponse = axios.post('/board/insert',data)
  return reponse
}

//게시글 상세조회
export const getBoardDetail=({boardNum})=>{
  const response=axios.get(`/board/detail/${boardNum}`)
  return response
}


