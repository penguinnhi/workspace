import axios from "axios"

//아이디중복체크
export const checkId=(inputId)=>{
  const response = axios
  .get(`/member/isDup/${inputId}`)
  return response
}

//회원가입
export const join=(mem)=>{
  const response = axios.post('/member/getReg',mem)
  return response
}

export const login=(data)=>{
  const response = axios
  .post('/member/logIn',data)
  return response
}

