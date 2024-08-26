import axios from 'axios'
import React, { useEffect, useState } from 'react'

const ItemManage = () => {
  const [itemList,setItemList]=useState([])

  useEffect(()=>{
    axios
    .get('/item/list')
    .then((res)=>{setItemList(res.data)})
    .catch((error)=>{console.log(error)})
  },[])

  // console.log(itemList)

  return (
    <div>
      상품관리
      {
        itemList.map((item,i)=>{
          return(
            <div key={i}>{item.itemName}</div>
          )
        })  
      }
    </div>
  )
}

export default ItemManage