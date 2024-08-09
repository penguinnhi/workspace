import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const ItemDetail = () => {
  const [itemData,setItemData]=useState({})
  const {itemCode}=useParams

  useEffect(()=>{
    axios
    .get(`/detail/${itemCode}`)
    .then((res)=>{
      setItemData(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])



  return (
    <div>
      
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td rowSpan={5}>이미지</td>
          </tr>
          <tr>
            <td colSpan={2}>{itemData.itemName}</td>
          </tr>
          <tr>
            <td>가격</td>
            <td>{itemData.itemPrice}</td>
          </tr>
          <tr>
            <td>수량</td>
            <td><input type='number' /></td>
          </tr>
          <tr>
            <td>총 가격</td>
            <td>{itemData.itemPrice}</td>
          </tr>
          <tr>
            <td colSpan={2}>
              <button type='button'>구매하기</button>
              <button type='button'>장바구니에 담기</button>
              </td>
          </tr>
          <tr>
            <td></td>
          </tr> 
        </tbody>
      </table>

    </div>
  )
}

export default ItemDetail