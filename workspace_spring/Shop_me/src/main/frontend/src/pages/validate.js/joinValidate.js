
const result_arr=[
  false, //id
  false //pw
]




export function joinValidate({valid_tag,newData,tagName}){

  const regex_memId= /^[a-z|A-Z]{4,12}$/;
  const regex_memPw = /^(?=.*[a-z])(?=.*[0-9]).{4,12}$/g;



  switch(tagName){
    case memId : 
      if(!regex_memId.test(newData.memId)){
        setFeedbackMsg(valid_tag[0],error,'아이디는 영문 4~12글자로 입력하세요.')
      }
      else{
        setFeedbackMsg(valid_tag[0],good,'사용가능한 아이디입니다.')
      }
      break

    case memPw:
    case confirmPw:
      if(regex_memPw.test(newData.memPw)){
        setFeedbackMsg(valid_tag[1],error,'비밀번호는 영문+숫자 조합으로 입력하세요.')
      }
      else{
        setFeedbackMsg(valid_tag[1],good,'사용가능한 비밀번호입니다.')
      }

      // 비밀번호 확인
      if(newData.memPw!=newData.confirmPw){
        setFeedbackMsg(valid_tag[2],error,'비밀번호가 다릅니다.')
      }
      break


  }




}

function setFeedbackMsg(feedbackTag,type,msg){
  feedbackTag.current.className=`feedback ${type}`
  feedbackTag.current.textContent=msg
}