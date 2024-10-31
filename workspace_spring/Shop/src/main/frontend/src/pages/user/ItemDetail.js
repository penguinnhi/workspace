import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const ItemDetail = ({loginInfo}) => {
  const navigate=useNavigate()
  const {itemCode}=useParams()
  const [itemData,setItemData]=useState({
    itemCode : itemCode,
    itemPrice:0,
    imgList:[{
      imgCode:0,
      attachedFileName:'',
      isMain:'',
      itemCode:0
    },{
      imgCode:0,
      attachedFileName:'',
      isMain:'',
      itemCode:0
    }]

  })
  
  const [totalPrice,setTotalPrice]=useState(0)
  const [itemCnt,setItemCnt]=useState(1)

  const [cartList,setCartList]=useState({
    itemCode:itemData.itemCode,
    cartCnt:1,
    memId:JSON.parse(window.sessionStorage.getItem('loginInfo')).memId
  })

  //console.log(loginInfo.memId)

  const [mainImgName,setMainImgName]=useState('')
  const [subImgName,setSubImgName]=useState('')

  
  
  //let price=Number(itemData.itemPrice)
  function getPrice(e){
    setItemCnt(e.target.value)
    let price=itemData.itemPrice*Number(e.target.value)

    // 수량이 0이하이거나 10개를 초과하면 수량을 1로 고정
    const cnt= Number(e.target.value)
    if(cnt<1||cnt>10){
      setItemCnt(1)
      setTotalPrice(itemData.itemPrice)
    }
    else{
      setItemCnt(cnt)
      setTotalPrice(price)
    }
  
  }

  useEffect(()=>{
    axios
    .get(`/item/detail/${itemCode}`)
    .then((res)=>{

      let img1=''
      let img2=''
      res.data.imgList.forEach((img,i)=>{
        if(img.isMain == 'Y'){
          img1=img.attachedFileName
        }
        else{
          img2=img.attachedFileName
        }
      })
      
      setMainImgName(img1)
      setSubImgName(img2)
      setItemData(res.data)
      setTotalPrice(res.data.itemPrice)
    })
    .catch((error)=>{console.log(error)})
  },[])

  //console.log(itemData)

  function inCart(e){
    setCartList({
      ...cartList,
      [e.target.name]:e.target.value,
      
    })
  }

  //console.log(cartList)
  //console.log(loginInfo.memId)

  function goCart(){

    axios
    .put('/cart/putInCart',cartList)
    .then((res)=>{
      if(window.confirm(' 장바구니에 상품을 담았습니다. \n 계속 쇼핑하겠습니까? ')){
        

      }
      else{
        //취소선택 : 장바구니 목록
        navigate(`/cart/${loginInfo.memId}`)
      }
    })
    .catch((error)=>{console.log(error)})

  }


  return (
    <div className='container'>
      
      <div className='join-div'>
        <div className='detail-div'>

          <div className='detail-div top'>
            <div>
              <img src={`http://localhost:8080/upload/${itemData.imgList[0].attachedFileName}`}/>
            </div>
            <div>
              <div className='item-name'>
                <div className='detail-title' value={itemData.itemName}>{itemData.itemName}</div>
                <div>
                  <span>가격 </span>
                  <span>{itemData.itemPrice.toLocaleString()}원</span>
                </div>
                <div>
                  <span>수량 </span>
                  <input type='number' value={itemCnt} name='cartCnt' 
                  onChange={(e)=>{
                    inCart(e); getPrice(e)}} />
                </div>
                <div>
                  <span>총액 </span>
                  <span>{totalPrice.toLocaleString()}원</span>
                </div>
                <div className='detail-button'>
                  <button type='button' className='cart-btn'>구매하기</button>
                  <button type='button' className='cart-btn' 
                    onClick={(e)=>{goCart()}}>장바구니</button>
                </div>
              </div>
            </div>
          </div>

          <div className='detail-intro'>{itemData.itemIntro}</div>

          <div className='detail-img'><img src={`http://localhost:8080/upload/${itemData.imgList[1].attachedFileName}`}/></div>

        
        </div>
      </div>

    </div>
  )
}

export default ItemDetail