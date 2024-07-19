import axios from "axios";
import { useEffect } from "react";

const AxiosTest=()=>{

  //spring 서버와 데이터 통신을 위해 react에서는 axios 기술 사용
  //axios 설치 : npm install axios 

  //axios는 데이터베이스의 작업 종류에 따라 함수를 제공
  //get('url' [, config]) : 데이터 조회 SELECT 
  //post('url',data [, config]) : 데이터 삽입 INSERT
  //put('url',data [, config]) : 데이터 수정 UPDATE
  //delete('url' [, config]) : 데이터 삭제 DELETE
  //사용 예제
  //axios
  //.get()
  //.then(데이터 통신 성공 후 실행 내용)
  //.catch(데이터 통신 중 오류 발생 시 실행 내용);
  

  //쿼리에 빈 값이 없는 데이터 조회 1
  function get1(){
    axios
    .get('/getList')
    .then((res)=>{
      console.log(...res.data)
    })
    .catch((error)=>{
      console.log('오류');
      console.log(error);
    })
  }

  function get2(){
    axios
    .get('/detail/1')
    .then((res)=>{})
    .catch((error)=>{})
  }

  //post로 데이터 전달하기
  function post1(){
    axios
    .post('/insertBoard',{name:'kin',age:20})
    .then((res)=>{
      
    })
    .catch((error)=>{})
  }


  function put1(){
    axios
    .put('/updateBoard',{boardNum : 1, boardTitle : 'java', boardWriter : 'hihi'})
    .then((res)=>{
      // alert('내용 수정함')
      alert(...res.data)
    })
    .catch((error)=>{})
  }

  return(

    <div>

      <h2>axios 통신 예제</h2>

      <div className="btn-div">
        <button type="button" onClick={()=>{get1()}}>get으로 데이터 조회하기 1</button>
      </div>

      <div className="btn-div">
        <button type="button" onClick={()=>{get2()}}>get으로 데이터 조회하기 2</button>
      </div>

      <div className="btn-div">
      <button type="button" onClick={()=>{post1()}}>post으로 데이터 삽입하기 1</button>
      </div>

      <div className="btn-div">
      <button type="button" onClick={()=>{put1()}}>put으로 데이터 수정하기 1</button>
      </div>


    </div>


  );

}

export default AxiosTest;