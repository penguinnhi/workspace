import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Modal from '../../common/Modal';

const ItemReg = () => {
  const navigate=useNavigate();
  //상품 등록 버튼 클릭 시 모달창
  const [isModalShow,setIsModalShow]=useState(false)
  //?
  const [closeModal,setCloseModal]=useState(false);

  const [successInput,setSuccessInput]=useState(false)

  const [cateList,setCateList]=useState([])
  const [itemData,setItemData]=useState({
    cateCode:1,
    itemName:'',
    itemPrice:'',
    itemIntro:''
  })

  useEffect(()=>{
    axios
    .get('/admin/list')
    .then((res)=>{
      setCateList(res.data)
      // console.log(res.data)
    })
    .catch((error)=>{console.log(error)})
  },[])

  function inputData(e){
    setItemData({
      ...itemData,
      [e.target.name]:e.target.value
    })
  }
  // console.log(itemData)

  function regItem(){
    axios
    .put('/admin/insert',itemData)
    .then((res)=>{

      setCloseModal(true)
      setIsModalShow(true)

      if(res.data!=''){
        setSuccessInput(true)
      }
      else{
        setSuccessInput(false)
      }

    })
    .catch((error)=>{console.log(error)})
    
  }

  function drawModalContent(){
    return(
      
      <div>
        {
        successInput
        ?
        <div>상품이 등록되었습니다</div>
        :
        <div>상품 정보를 입력하세요</div>
        }
      </div>
      
    )
  }


  
  return (

    <div>
      
      <div className='join-div'>
        <div>
          <p>상품 카테고리</p>
          <select className='form-control' name='cateCode' onChange={(e)=>{inputData(e)}}>
            {
              cateList.map((cate,i)=>{
                  return(
                    <option key={i} value={cate.cateCode}>{cate.cateName}</option>
                  )
              })
            }
          </select>
        </div>
        <div>
          <p>상품명</p>
          <input type='text' name='itemName' className='form-control'
           onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 가격</p>
          <input type='text' name='itemPrice' className='form-control'
           onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 소개</p>
          <textarea name='itemIntro' className='form-control'
           onChange={(e)=>{inputData(e)}}/>
        </div>
  
        <button type='button' onClick={(e)=>{regItem()}}>상품 등록</button>
      </div>

      {
      isModalShow
      ?
      <Modal content={drawModalContent}
      setIsShow={setCloseModal}
      clickCloseBtn={()=>{navigate('/itemList')}}/>
      :
      null
    }

    </div>

  )
}

export default ItemReg