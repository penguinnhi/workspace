import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { memberActions } from './redux/memberState'

const Member = () => {

  // 회원 정보를 저장하고 있는 변수
  const member = useSelector(state => state.memberState)
  const dispatch = useDispatch()

  useEffect(()=>{

    //DB에서 조회한 데이터
    const selectedMember = {
      memId : 'Dulli',
      memName : 'Go',
      memAge : 43
    }

    // 조회한 정보로 store 저장한 member 객체의 정보를 변경
    dispatch(memberActions.changeMemberInfo(selectedMember))

  },[])

  return (
    <div>

      <h3>회원 정보 페이지</h3>
      <div>
        <div>회원 아이디 : {member.memId}</div>
        <div>회원 이름 : {member.memName}</div>
        <div>회원 나이 : {member.memAge}</div>
      </div>

    </div>
  )
}

export default Member