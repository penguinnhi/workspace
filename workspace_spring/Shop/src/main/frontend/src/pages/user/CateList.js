import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const CateList = () => {
  const navigate=useNavigate()
  const {cateCode}=useParams()
  const [cateList,setCateList]=useState([])
  

  useEffect(()=>{
    axios
    .get(`/item/cateList/${cateCode}`)
    .then((res)=>{
      setCateList(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[cateCode])

  //console.log(cateCode)
  //console.log(cateList)

  return (
    <div className='join-div itemList'>
      {
        cateList.map((cate,i)=>{
          return(
            <div key={i} className='item-div'>
              <img onClick={(e)=>{navigate(`/detail/${cate.itemCode}`)}} src={`http://localhost:8080/upload/${cate.imgList[0].attachedFileName}`}/>
              <h4><span onClick={(e)=>{navigate(`/detail/${cate.itemCode}`)}}>{cate.itemName}</span></h4>
              <p>{cate.itemPrice.toLocaleString()}원</p>
            </div>
          )
        })
      }
      
    </div>
  )
}

export default CateList