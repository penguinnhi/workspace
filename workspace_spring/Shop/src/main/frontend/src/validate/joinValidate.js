import React from 'react'

  //유효성 검사 결과를 저장할 변수 
  let resultArr=[
    false,  //id
    false,  //pw
    false,  //name
    false //tel
  ];

  let result_pw1=false
  let result_pw2=false
  

export const joinValidate = (newData,valid_tag,tagName) => {


  //test():매개변수로 들어온 데이터가 조건에 부합하면 리턴 true
  
  
  const regex_memName = /^[ㄱ-ㅎ|가-힣]{2,10}$/;
  const regex_memId = /^[a-z|A-Z]{4,12}$/;
  // const regex_memPw = /^[a-z|0-9]{4,12}$/;
  const regex_memPw = /^(?=.*[a-z])(?=.*[0-9]).{4,12}$/g;
  const regex_memTel = /^\d{2,3}-\d{3,4}-\d{4}$/;



  //id값을 변경했으면 id 피드백만 띄운다
  //pw값을 변경했으면 pw 피드백만 띄운다
  //name값을 변경했으면 name 피드백만 띄운다
  //tel값을 변경했으면 tel 피드백만 띄운다

  switch(tagName){
    case 'memId':

        //id가 영문만 포함 + 4~12자리 검사하는 정규식 
        
        //newData.memId.length < 4 || newData.memId.length > 12
        // validation 처리 (유효성 어쩌구.. )
        if(!regex_memId.test(newData.memId)){
          //div에 error클래스 추가
          // memId_valid_tag.current.className='feedback error'
      
          //div 태그 안에 글자 변경 : 4글자 이상 가능
          // memId_valid_tag.current.textContent='아이디는 영문,4~12글자로 입력하세요.'
          // console.log(joinData.memId)
      
          sendFeedbackMsg(valid_tag[0],'아이디는 영문,4~12글자로 입력하세요.','error')
          resultArr[0]=false
        }
      
        else{
          //div에 good 클래스 추가
          // memId_valid_tag.current.className='feedback good'
      
          // //div 태그 안에 글자 변경 : 사용 가능한 아이디임
          // memId_valid_tag.current.textContent='사용 가능한 아이디입니다.'
      
          sendFeedbackMsg(valid_tag[0],'사용 가능한 아이디입니다.','good')
          resultArr[0]=true
        }
        break;



    case 'memPw': 
    case 'confirmPw':


    
      // 비밀번호 및 비밀번호 확인 글자가 같아야함 
      if(newData.memPw!=newData.confirmPw){
        // console.log(newData.memPw)
        // console.log(newData.confirmPw)
        sendFeedbackMsg(valid_tag[3],'비밀번호가 일치하지 않습니다.','error')
        result_pw2=false
      }
      else{
        sendFeedbackMsg(valid_tag[3],'','good')
        result_pw2=true
      }
  


      // 4~12글자 사이 영문소문자+숫자 
      if(regex_memPw.test(newData.memPw)){
        sendFeedbackMsg(valid_tag[2],'사용 가능한 비밀번호입니다.','good')
        result_pw1=true
      }
      else{
        sendFeedbackMsg(valid_tag[2],'비밀번호는 4~12글자 영문소문자+숫자로 입력하세요','error')
        result_pw1=false
      }

      //???????
      resultArr[1]=result_pw1 && result_pw2 ? true : false

      break;
      

        

    case 'memName':
      
      //이름값 유효성 검사 
      if(!regex_memName.test(newData.memName)){

        sendFeedbackMsg(valid_tag[1],'이름은 한글,2~10글자로 입력하세요.','error')
        resultArr[2]=false

      }
      else{
        sendFeedbackMsg(valid_tag[1],'사용 불가능한 이름도 있냐고.','good')
        resultArr[2]=true
      }
      break



    case 'memTel':
      // 
      if(regex_memTel.test(newData.memTel)){
        sendFeedbackMsg(valid_tag[4],'가능한','good')
        resultArr[3]=true
      }
      else{
        sendFeedbackMsg(valid_tag[4],'연락처를 확인하세요.','error')
        resultArr[3]=false
      }
      break


  } 
  
  //resultArr의 모든 데이터가 true일 때만 리턴 true

  //배열에 매개변수로 전달된 데이터가 존재하면 리턴 true 
  // return !resultArr.includes(false)
  
  for(const e of resultArr){
    if(!e){
      return false
    }
  }

  return true;
}

//유효성 결과 메시지를 띄우는 함수 
function sendFeedbackMsg(feedbackTag,msg,type){

  feedbackTag.current.className=`feedback ${type}`
  feedbackTag.current.textContent=msg

}










