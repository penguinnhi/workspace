import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { numActions } from './redux/numState'

const UseRedux = () => {
  // store에 저장된 state 변수 num 가져오기 

  // useSelector() : store에 저장한 state변수값 가져오기
  // 매개변수 state : store에 저장된 모든 state 변수
  const num = useSelector(state => state.numState.value)

  // useDispatch() : staet변수의 값을 변경시키는 함수 호출에 사용
  // store에 저장된 함수 호출을 위한 dispatch 생성 
  const dispatch = useDispatch()

  // +1 함수 
  const add = ()=>{
    dispatch(numActions.addNum())
  }




  return (
    <div>
      <h3>카운터 앱 (Redux 방식)</h3>
      <h3>{num}</h3>
      <div>
        <button type='button' onClick={()=>add()}>+1</button>
        <button type='button' onClick={()=>dispatch(numActions.subNum())}>-1</button>
        <button type='button' onClick={()=>dispatch(numActions.resetNum())}>RESET</button>
        <button type='button' onClick={()=>dispatch(numActions.changeNum(10))}>ChangeNum</button>
      </div>
    </div>
  )
}

export default UseRedux