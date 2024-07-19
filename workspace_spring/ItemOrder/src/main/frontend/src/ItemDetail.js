import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';

const ItemDetail = (props) => {
  // const {itemNum}=useParams();
  const [itemDetail,setItemDetail]=useState({
    // itemNum:0,
    // itemName:'',
    // itemPrice:'',
    // seller:'',
    // regDate:'',
    // itemIntro:''
  });
  //console.log(itemDetail)

  const [changeDetail,setChangeDetail]=useState({});

  useEffect(()=>{
    axios
    .get(`/getItemDetail/${props.itemNum.itemNum}`)
    .then((res)=>{
      setItemDetail(res.data)
      
      //console.log(res.data)
    })
    .catch((error)=>{
      alert('ㄴㄴ')
      console.log(error)
    })
  },[]);

  function changeData(e){
    setItemDetail({
      ...itemDetail,
      [e.target.name] : e.target.value
    })
  }
  
  function updateData(){
    axios
    .put(`/updateItem/${props.itemNum.itemNum}`,itemDetail)
    .then((res)=>{
      alert('ㅇㅇ')
    })
    .catch((error)=>{
      alert('수정오류')
      console.log(error)
    })
  }


  return (

    <div>
  
    <p>상품 상세 정보</p>

    <table>
      <thead></thead>
      <tbody>
        <tr>
          <td>상품번호</td>
          <td><input type='text' name='itemNum' readOnly defaultValue={itemDetail.itemNum}></input></td>
        </tr>
        <tr>
          <td>상품명</td>
          <td><input type='text' name='itemName' onChange={(e)=>{changeData(e)}} defaultValue={itemDetail.itemName}></input></td>
        </tr>
        <tr>
          <td>상품가격</td>
          <td><input type='number' name='itemPrice' onChange={(e)=>{changeData(e)}} defaultValue={itemDetail.itemPrice}></input></td>
        </tr>
        <tr>
          <td>판매자</td>
          <td><input type='text' name='seller' readOnly defaultValue={itemDetail.seller} ></input></td>
        </tr>
        <tr>
          <td>판매시작일</td>
          <td><input type='text' name='regDate' readOnly defaultValue={itemDetail.regDate}></input></td>
        </tr>
        <tr>
          <td>상품설명</td>
          <td><textarea name='itemIntro' onChange={(e)=>{changeData(e)}} defaultValue={itemDetail.itemIntro}></textarea></td>
        </tr>
      </tbody>
    </table>

    <button type='button' onClick={(e)=>{updateData()}}>수정</button>
    </div>
  

  )
}

export default ItemDetail