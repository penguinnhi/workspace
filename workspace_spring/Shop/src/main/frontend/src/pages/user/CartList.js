import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './CartList.css'

const CartList = ({loginInfo}) => {
  const navigate=useNavigate()
  const [cartList,setCartList]=useState([])

  // 제목줄 체크박스의 체크여부를 저장하고 있는 state 변수
  // 체크 true 
  const [chkAll,setChkAll]=useState(true)

  // 내용줄 체크박스의 체크여부를 저장하고 있는 state 변수
  const [chks,setChks]=useState([])

  //const [memId,setMemId]=useState({})
  
  //console.log(memId)

  useEffect(()=>{

    axios
    .get(`/cart/cartList/${loginInfo.memId}`)
    .then((res)=>{
      //console.log(res.data)
      setCartList(res.data)

      //조회된 장바구니 목록만큼 체크박스의 값을 설정
      // res.data.length
      let checkArr=new Array(res.data.length)
      checkArr.fill(true)
      setChks(checkArr)

    })
    .catch((error)=>{console.log(error)})
  },[loginInfo])

  //console.log(cartList)

  function insertCnt(e){
    // setCartList([
    //   ...cartList
    // ])
  }

  function goDelete(cartCode){

    axios
    .delete(`/cart/del/${cartCode}`)
    .then((res)=>{
      cartList.forEach((cart,i)=>{
        if(cart.cartCode==cartCode){
          cartList.splice(i,1)
        }
      })
      setCartList([...cartList])
    })
    .catch((error)=>{console.log(error)})

  }

  useEffect(()=>{
    //마운트 됐을 때는 실행 x 
    if(chks.length!=0){
      //제목줄이 체크되면 전체 체크박스 체크 
      const copyChks=[...chks]
      
      if(chkAll){
        copyChks.fill(true)
      }
      else{
        copyChks.fill(false)
      }

      setChks(copyChks)
    }

  },[chkAll])



  //제목줄의 체크박스 변경 시 실행되는 함수
  function changeChkAll(){
    setChkAll(!chkAll)

  }

  // 합계 구하기
  function getTotalPrice(){
    let result=0
    cartList.forEach((cart,i)=>{
      return(
        result+=(cart.itemVO.itemPrice * cart.cartCnt)
      )
    })
    return result
  }


  return (
    <div>
      <div className='cart-div'>
        <h2>장바구니</h2>
        <table className='cart-table'>
          <colgroup>
            <col width='20px'/>
            <col width='20px'/>
            <col width='*'/>
            <col width='100px'/>
            <col width='40px'/>
            <col width='100px'/>
            <col width='100px'/>
            <col width='40px'/>
          </colgroup>

          <thead className='cart-header'>
            <tr>
              <td>No</td>
              <td><input type='checkbox' checked={chkAll} 
                onChange={(e)=>{changeChkAll()}}></input></td>
              <td>상품 정보</td>
              <td>가격</td>
              <td>수량</td>
              <td>구매 가격</td>
              <td>구매 일시</td>
              <td>  </td>
            </tr>
          </thead>

          <tbody className='cart-body'>
            {
              cartList.length==0?
              <tr>
                <td colSpan={8} className='blank'>
                  <p>👻 장바구니에 담긴 상품이 없습니다 </p>
                  <button type='button' onClick={(e)=>{navigate('/itemList')}}>상품 목록</button>
                  </td>
              </tr>
              :
              cartList.map((cart,i)=>{
                return(
                  <tr key={i} className='cart-table-tr'>
                    <td><span>{cartList.length-i}</span></td>
                    <td><input type='checkbox' checked={chks[i]}
                    onChange={(e)=>{ // 몰루겟는디 ********************
                      const copyChks=[...chks]
                      copyChks[i]=!copyChks[i]; 
                      setChks(copyChks)}}
                    /></td>
                    <td className='itemTitle'>
                      <div className='item-title' onClick={(e)=>{navigate(`/detail/${cart.itemVO.itemCode}`)}}>
                        <img src={`http://localhost:8080/upload/${cart.itemVO.imgList[0].attachedFileName}`}/>
                        <span>{cart.itemVO.itemName}</span>
                      </div>
                    </td>
                    <td>{cart.itemVO.itemPrice.toLocaleString()}원</td>
                    <td>
                      <input type='number' onChange={(e)=>{insertCnt(e)}} className='cartCnt' defaultValue={cart.cartCnt}></input>
                    </td>
                    <td>{(cart.itemVO.itemPrice * cart.cartCnt).toLocaleString()}원</td>
                    <td>{cart.cartDate}</td>
                    <td>
                      <button type='button' className='cart-del-btn' 
                        onClick={(e)=>{goDelete(cart.cartCode)}}>삭제</button>
                    </td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
        
        
        {
          cartList.length==0?
          null
          :
          <div className='totalPrice'>
          <span>총 구매 금액 : </span>
          <span>
            {getTotalPrice().toLocaleString()} 원
          </span>
        </div>
        }

      </div>
        
      <div>
        <button type='button' className='cart-btn'>선택 삭제</button>
        <button type='button' className='cart-btn'>선택 구매</button>
      </div>
    </div>
  )
}

export default CartList