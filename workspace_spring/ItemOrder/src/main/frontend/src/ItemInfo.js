import React, { useEffect, useState } from 'react'
import ItemDetail from './ItemDetail';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ItemInfo = () => {
  //상세정보 보이는지안보이는지
  let [isShow,setIsShow]=useState(false);
  const toggleShow = () => {
    setIsShow(!isShow);
  };

  let [index,setIndex]=useState(0);
  const [itemList,setItemList]=useState([]);
  const navigate=useNavigate();

  useEffect(()=>{
    axios
    .get('/getItemInfo')
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);




  return (
    <div>
      
      <p>총 {itemList.length}개의 상품이 등록되었습니다</p>

      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>판매자</td>
          </tr>
        </thead>

        <tbody>
          {
            itemList.map((item,i)=>{
              return(
              <tr key={i}>
                <td>{i+1}</td>
                <td><span onClick={(e)=>{
                  toggleShow()
                  
                  setIndex(i)
                  }}>{item.itemName}</span></td>
                <td>{item.itemPrice}</td>
                <td>{item.seller}</td>
              </tr>
              )
            })
          }
        </tbody>

      </table>

      {
        isShow ? <ItemDetail itemNum={itemList[index]}/> : null
      }


    

    </div>
  )
}

export default ItemInfo