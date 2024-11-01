import axios from 'axios'
import React, { useEffect, useState } from 'react'
import './itemManage.css'

const ItemManage = () => {
  const [itemList,setItemList]=useState([])

  useEffect(()=>{
    axios
    .post('/item/list')
    .then((res)=>{setItemList(res.data)})
    .catch((error)=>{console.log(error)})
  },[])

  // console.log(itemList)

  const delItem=(itemCode)=>{

    if(window.confirm('해당 상품을 삭제하시겠습니까?')){
      axios.delete(`/item/delItem/${itemCode}`)
      .then((res)=>{
        alert('상품이 삭제되었습니다.')

        itemList.forEach((item,i)=>{
          if(item.itemCode=itemCode){
            itemList.splice(i,1)
          }
          setItemList([...itemList])
        })
      })
      .catch((error)=>{console.log(error)})
    }

  }

  return (
    <div className='container'>
      <h2>상품 관리</h2>
      <div className='item-reg-div'>
        <table className='manage-table'>
          <thead>
            <tr>
              <td>카테고리</td>
              <td>상품명</td>
              <td></td>
            </tr>
          </thead>
          <tbody>
            {
              itemList.map((item,i)=>{
                return(
                  <tr key={i}>
                    <td>{item.categoryVO.cateName}</td>
                    <td>{item.itemName}</td>
                    <td>
                      <button type='button' className='cart-del-btn'
                        onClick={()=>{delItem(item.itemCode)}}>삭제</button></td>
                  </tr>
                  )
                })  
            }
          </tbody>
        </table>
      </div>

    </div>
  )
}

export default ItemManage