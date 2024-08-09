import React from 'react'

const ItemList = () => {
  return (
    <div>
            <table>
        <thead>
          <tr className='item-header'>
            <td>카테고리</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>상품상태</td>
          </tr>
        </thead>
        <tbody>
          {
            itemList.map((item,i)=>{
              return(
              <tr key={i}>
                <td>{item.categoryVO.cateName}</td>
                <td><span onClick={(e)=>{goDetail(item.itemCode)}}>{item.itemName}</span></td>
                <td>{item.itemPrice}</td>
                <td>{item.itemStatus}</td>
              </tr>
              )
            })
          }
        </tbody>
      </table>

      {
        loginInfo.memRole=='ADMIN'
        ?
        <div>
          <button type='button' onClick={()=>{navigate('/admin/itemReg')}}>상품 등록</button>
        </div>
        :
        null
      }
    </div>
  )
}

export default ItemList