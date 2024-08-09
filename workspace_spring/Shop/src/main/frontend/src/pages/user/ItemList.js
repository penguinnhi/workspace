import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

const ItemList = ({loginInfo}) => {
  const navigate=useNavigate();
  const [itemList,setItemList]=useState([])

  useEffect(()=>{

    axios
    .get('/item/list')
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{console.log(error)})
    
  },[])

  // console.log(itemList)


  return (
    <div className='join-div itemList'>
      
      {
        itemList.map((item,i)=>{
          return(
            <div key={i} className='item-div' >
              <img src={`http://localhost:8080/upload/${item.imgList[0].attachedFileName}`}/>
              <h4><span onClick={(e)=>{navigate(`/detail/${item.itemCode}`)}}>{item.itemName}</span></h4>
              <p>{item.itemPrice.toLocaleString()+' 원'}</p>
            </div>
          )
        })
      }

    </div>
  )
}

export default ItemList