import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const SellInfo = () => {
  const navigate=useNavigate();
  const [carList,setCarList]=useState([]);
  const [sellerData,setSellerData]=useState({
    sellerName:'',
    color:'블랙',
    sellerTel:'',
    modelNum:0
  });
  const [blankInput,setBlankInput]=useState('')

  useEffect(()=>{
    axios
    .get('/car/list')
    .then((res)=>{
      setCarList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])


  function inputSeller(e){
    setSellerData({
      ...sellerData,
      [e.target.name]:e.target.value
    })
  }

  function insertSeller(){
    axios
    .post('/sales/insert',sellerData)
    .then((res)=>{
      alert('구매자 등록됨')
      navigate('/')
    })
    .catch((error)=>{
      console.log(error)
    })
  }



  return (
    <div>

      <div>
        <span>구매자명</span>
        <input type='text' name='sellerName' onChange={(e)=>{inputSeller(e)}}></input>
      </div>

      <div>
        <span>색상</span>
        <select name='color' onChange={(e)=>{inputSeller(e)}}>
          <option value='블랙'>블랙</option>
          <option value='화이트'>화이트</option>
          <option value='실버'>실버</option>
          <option value='레드'>레드</option>
        </select>

        <span>모델</span>
        <select name='modelNum' onChange={(e)=>{inputSeller(e)}} >
          {
            carList.map((car,i)=>{
              return(
                <option key={i} value={car.modelNum}>{car.modelName}</option>
              )
            })
          }
        </select>
      </div>

      <div>
        <span>연락처</span>
        <input type='text' name='sellerTel' onChange={(e)=>{inputSeller(e)}}></input>
      </div>

      <button type='button' onClick={(e)=>{insertSeller()}}>등록</button>

    </div>
  )
}

export default SellInfo