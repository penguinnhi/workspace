import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Modal from '../../common/Modal';
import './ItemReg.css'

const ItemReg = () => {
  //첨부파일을 저장할 State변수 
  const [mainImg,setMainImg]=useState(null)
  const [subImg,setSubImg]=useState(null)

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
    // axios통신으로 자바로 갈 때 첨부파일이 있으면 반드시 아래의 설정코드를 axios에 추가 
    const fileConfig={headers : {'Content-Type':'multipart/form-data'}}

    //위의 설정코드를 axios 통신할 때 추가하면 자바로 넘어가는 데이터를 전달하는 방식이 달라짐
    //첨부파일이 있는 데이터를 자바로 전달하기 위해서는 form태그를 사용해서 전달

    //1.form 객체 생성
    const itemForm=new FormData()

    //2.form 객체에 데이터를 추가 
    // itemForm.append('itemName','상품1')
    // itemForm.append('itemPrice',10000)

    itemForm.append('itemName',itemData.itemName)
    itemForm.append('itemPrice',itemData.itemPrice)
    itemForm.append('itemIntro',itemData.itemIntro)
    itemForm.append('cateCode',itemData.cateCode)
    itemForm.append('mainImg',mainImg)
    itemForm.append('subImg',subImg)

    //3.데이터를 가진 form객체를 axios 통신에서 자바로 전달한다

    axios
    //.put('/admin/insert', itemData, fileConfig)
    .put('/admin/insert', itemForm, fileConfig)
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
        <div>상품 정보를 입력하세요</div>
        :
        <div>상품이 등록되었습니다</div>
        }
      </div>
      
    )
  }


  
  return (

    <div className='container'>
      <h2>상품 등록</h2>
      
      <div className='item-reg-div'>
        <div>
          <p>상품 카테고리</p>
          <select className='reg-input' name='cateCode' onChange={(e)=>{inputData(e)}}>
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
          <input type='text' name='itemName' className='reg-input'
           onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 가격</p>
          <input type='text' name='itemPrice' className='reg-input'
           onChange={(e)=>{inputData(e)}}></input>
        </div>
        <div>
          <p>상품 소개</p>
          <textarea name='itemIntro' className='reg-input'
           onChange={(e)=>{inputData(e)}}/>
        </div>

        <div>
          <p>메인 이미지</p>
          <input type='file' className='reg-input'
          onChange={(e)=>{
            //선택한 파일정보(배열로 가져옴)
            setMainImg(e.target.files[0]) 
            // e.target.files
          }}></input>
        </div>
        <div>
          <p>상세 이미지</p>
          <input type='file' className='reg-input'
          onChange={(e)=>{
            setSubImg(e.target.files[0])
          }}></input>
        </div>
  
        <button type='button' className='reg-btn'
          onClick={(e)=>{regItem()}}>상품 등록</button>
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