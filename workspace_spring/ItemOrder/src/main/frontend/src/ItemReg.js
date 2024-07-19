import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const ItemReg = () => {
  const navigate=useNavigate();
  const [inItem,setInItem]=useState({});

  function insertItem(e){
    setInItem({
      ...inItem,
      [e.target.name] : e.target.value
    })
  }

  function regItem(){
    axios
    .post('/insertItem',inItem)
    .then((res)=>{
      alert('ㅇㅇ')
      navigate('/')
    })
    .catch((error)=>{
      alert('등록오류')
      console.log(error)
    })
  }

  return (
    <div>
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>상품명</td>
            <td><input type='text' name='itemName' onChange={(e)=>{insertItem(e)}}></input></td>
          </tr>
          <tr>
            <td>상품가격</td>
            <td><input type='number' name='itemPrice' onChange={(e)=>{insertItem(e)}}></input></td>
          </tr>
          <tr>
            <td>판매자</td>
            <td><input type='text' name='seller' onChange={(e)=>{insertItem(e)}}></input></td>
          </tr>
          <tr>
            <td>상품설명</td>
            <td><textarea name='itemIntro' onChange={(e)=>{insertItem(e)}}></textarea></td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={(e)=>{regItem()}}>등록</button>
    </div>
  )
}

export default ItemReg