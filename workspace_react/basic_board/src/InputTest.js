import { useState } from "react";

const InputTest=()=>{
  

  //input태그에 입력한 내용을 저장하는 변수
  const [inputData,setInputData] = useState('');
  const [inputData2,setInputData2] = useState('');
  //  [변수의 초기값(이게 바껴도 재렌더링 되진않음), inputData값을 변경할 머 그거(근데 이게 바뀌면 재렌더링 됨 ) ]

  const [stu,setStu] =useState({
    stuName:'',
    age:0,
    score:0,
    addr:''
  }); //객체를 초기화 

  function changeStu(e){
    setStu({
      ...stu, // 전개연산자 
      [e.target.name]:e.target.value
    });
  }
  //[key값] : key값에 변수 쓰려면 대괄호를 씌워야 한다~ 암튼 그렇다~ 

  return(

    <div>
      
      <div>
          학생명:<input type='text' name='stuName' onChange={(e)=>{
            changeStu(e);
          }}></input> <br />
  
          나이:<input type='text' name='age' onChange={(e)=>{
            changeStu(e);
          }}></input> <br />
  
          점수:<input type='text' name='score' onChange={(e)=>{
            changeStu(e);
          }}></input> <br />
  
          주소:<input type='text' name='addr' onChange={(e)=>{
            changeStu(e);
          }}></input> <br />
        </div>
  
        <div>
          이름 : {stu.stuName} <br></br>
          나이 : {stu.age} <br></br>
          점수 : {stu.score} <br></br>
          주소 : {stu.addr} <br></br>
        </div>


    </div>

  );


}

export default InputTest;