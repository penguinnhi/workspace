import axios from 'axios'
import React from 'react'

export const getList=axios.get('/getList')

const apis = () => {
  return (
    <div>apis</div>
  )
}

export default apis