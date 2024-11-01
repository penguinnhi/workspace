import React, { useState } from 'react'

const Origin = () => {
  const [num,setNum]=useState(0)
  
  //+1 하는 함수 == Reducer
  const addNum=()=>{
    setNum(num+1)
  }

  //-1 하는 함수 == Reducer
  const subNum=()=>{
    setNum(num-1)
  }

  //0으로 초기화하는 함수 == Reducer
  const resetNum=()=>{
    setNum(0)
  }

  return (
    <div>
      <h3>카운터 앱 (기존 방식)</h3>
      <h3>{num}</h3>
      <div>
        <button type='button' onClick={addNum}>+1</button>
        <button type='button' onClick={subNum}>-1</button>
        <button type='button' onClick={resetNum}>RESET</button>
      </div>
    </div>
  )
}

export default Origin