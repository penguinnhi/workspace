import axios from 'axios'
import React, { useEffect, useState } from 'react'

const CateList = ({cateCode}) => {
  const [cateList,setCateList]=useState([])

  useEffect(()=>{
    axios
    .get(`/item/cateList/${cateCode}`)
    .then((res)=>{
      setCateList(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  return (
    <div>
      {
        cateList.map((cate,i)=>{
          return(
            <div>{cate.Name}</div>
          )
        })
      }
    </div>
  )
}

export default CateList