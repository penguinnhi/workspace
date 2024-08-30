import React, { useState } from 'react'
import Calendar from 'react-calendar'
import './RecordOfMonth.css';


const RecordOfMonth = () => {
  const [value,onChange]=useState(new Date())//초기값은 현재날짜

  return (
    <div className='cal'>
      <Calendar onChange={onChange} value={value}/>
    </div>

  )
}

export default RecordOfMonth