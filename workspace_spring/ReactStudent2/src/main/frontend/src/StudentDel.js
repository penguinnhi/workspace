import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { getList } from './apis';

const StudentDel = () => {
  const [stuList,setStuList]=useState([]);
  const params=useParams();

  useEffect(()=>{
    getList()
    .then((res)=>{
      setStuList(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);

  function delStu(stuNum){
    axios
    .delete(`/delStu/${stuNum}`)
    .then((res)=>{

      alert('ㅇㅇ')
      // 삭제 후 새로고침
      //stuList라는 state변수의 값을 변경해서
      //재랜더링 되면서 알아서 그림 새롭게 그린대
      //데이터베이스에서 삭제한 학생정보를 stuList에서도 삭제
      // stuList.forEach((stu,i)=>{
      //   if(stu.stuNum==stuNum){
      //     stuList.splice(i,1);
      //   }
      // })
      
      // setStuList([...stuList]);


      // const arr1=[1,2,3,4,5,6,7,8];
       // (배열에 있는 데이터 하나하나)=>{}
      // const result=arr1.filter( (num)=> num>5 );
      // console.log(result);

      // 중괄호,리턴 둘 다 없애든가 둘 다 넣든가 해야함 

      const re=stuList.filter((stu)=>{
        return(
          stu.stuNum!=stuNum
        )})
        // 삭제한 학번을 제외하고 걸러내기 

      setStuList([...re]);


    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  }

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
          {
            stuList.map((stu,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td>{stu.stuName}</td>
                <td><button type='button' onClick={(e)=>{delStu(stu.stuNum)}}>삭제</button></td>
              </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default StudentDel