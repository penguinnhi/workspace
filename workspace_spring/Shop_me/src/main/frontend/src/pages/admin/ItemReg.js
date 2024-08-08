import axios from 'axios'
import React, { useEffect, useState } from 'react'

const ItemReg = () => {
  const [cateList,setCateList]=useState([])
  const [itemData,setItemData]=useState({})


  useEffect(()=>{
    axios
    .get('/admin/list')
    .then((res)=>{
      setCateList(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  function inputData(e){
    setItemData({
      ...itemData,
      [e.target.name]:e.target.value
    })
  }

  function regItem(){
    axios
    .put('/admin/insert',itemData)
    .then((res)=>{
      alert('ㅇㅇ')
    })
    .catch((error)=>{console.log(error)})
  }


  return (
    <div>

      <div>
        <div>
          <p>상품 카테고리</p>
          <select name='cateNum' 
          onChange={(e)=>{inputData(e)}}>
            {
              cateList.map((cate,i)=>{
                return(
                  <option value={cate.cateNum} key={i}>{cate.cateName}</option>
                )
              })
            }
          </select>
        </div>
        <div>
         <p>상품명</p>
         <input type='text' name='itemName' 
         onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 가격</p>
          <input type='text' name='itmePrice' 
          onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 소개</p>
          <textarea name='itemIntro' 
          onChange={(e)=>{inputData(e)}}></textarea>
        </div>

        <button type='button' onClick={(e)=>{regItem()}}>상품 등록</button>
      </div>
      
    </div>
  )
}

export default ItemReg