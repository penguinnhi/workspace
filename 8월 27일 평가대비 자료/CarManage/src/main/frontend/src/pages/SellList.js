import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const SellList = () => {
  const [sellerList,setSellerList]=useState([])
  
  

  useEffect(()=>{
    axios
    .get(`/sales/select`)
    .then((res)=>{
      setSellerList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])
  


  return (
    <div>
      <table className='list'>
        <thead>
          <tr>
            <td rowSpan={2}>No.</td>
            <td colSpan={4}>구매자정보</td>
            <td colSpan={2}>차량정보</td>
          </tr>
          <tr>
            <td>구매자명</td>
            <td>연락처</td>
            <td>구매일</td>
            <td>색상</td>
            <td>모델명</td>
            <td>금액</td>
          </tr>
        </thead>
        <tbody>
          {
            sellerList.length==0?
            <tr>
              <td colSpan={7}>등록된 구매자가 없습니다.</td>
            </tr>
            :
            sellerList.map((seller,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td>{seller.sellerName}</td>
                <td>{seller.sellerTel}</td>
                <td>{seller.sellDate}</td>
                <td>{seller.color}</td>
                <td>{seller.carVO.modelName}</td>
                <td>{seller.carVO.price}만원</td>
                <td></td>
              </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default SellList