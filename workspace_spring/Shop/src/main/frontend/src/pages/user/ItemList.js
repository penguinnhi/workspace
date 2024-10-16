import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './itemList.css'

const ItemList = ({loginInfo}) => {
  const navigate=useNavigate();
  const [itemList,setItemList]=useState([])

  // 검색 조건 저장 변수
  const [searchBox,setSearchBox]=useState({
    searchValue:''
  })

  // 검색 창
  function insertSearch(e){
    setSearchBox({
      ...searchBox,
      [e.target.name]:e.target.value
    })
  }



  // 검색하기
  function clickSearch(){

    axios
    .post('/item/list',searchBox)
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{console.log(error)})
  }

  console.log(searchBox)


  useEffect(()=>{

    axios
    .post('/item/list',searchBox)
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{console.log(error)})
    
  },[])



  return (
    <div>
      <div className='searchBox'>
        <input type='text' name='searchValue'
          onClick={(e)=>{insertSearch(e)}}></input>
        <i className="bi bi-search" 
          onClick={()=>{clickSearch()}}></i>
      </div>
      <div className='join-div itemList'>
      
        {
          itemList.map((item,i)=>{
            return(
              <div key={i} className='item-div' >
                <img 
                  onClick={(e)=>{navigate(`/detail/${item.itemCode}`)}} 
                  src={`http://localhost:8080/upload/${item.imgList[0].attachedFileName}`}/>
                <p>{item.categoryVO.cateName}</p>
                <h3><span onClick={(e)=>{navigate(`/detail/${item.itemCode}`)}}>{item.itemName}</span></h3>
                <p>{item.itemPrice.toLocaleString()+' 원'}</p>
              </div>
            )
          })
        }
  
      </div>
    </div>


  )
}

export default ItemList