import axios from 'axios'
import React, { useEffect, useState } from 'react'

const CarManage = () => {
  const [carList,setCarList]=useState([])
  const [carData,setCarData]=useState({
    modelName:'',
    price:0,
    make:'현대'
  })

  useEffect(()=>{
    axios
    .get('/car/list')
    .then((res)=>{
      //console.log(res.data)
      setCarList(res.data)

    })
    .catch((error)=>{
      alert('조회오류')
      console.log(error)
    })
  },[carData])

  function inputCar(e){
    setCarData({
      ...carData,
      [e.target.name]:e.target.value
    })
    
  }

  function insertCar(){
    axios
    .post('/car/insert',carData)
    .then((res)=>{
      setCarData({
        ...carData,
        modelName:'',
        price:0,
        make:'현대'
      })
    })
    .catch((error)=>{
      alert('등록오류')
      console.log(error)
    })
  }


  return (
    <div>
      
      <div className='insert'>
        <p>- 차량등록</p>
        <span>제조사</span>
        <select name='make' onChange={(e)=>{inputCar(e)}}>
          <option value='현대'>현대</option>
          <option value='기아'>기아</option>
          <option value='쌍용'>쌍용</option>
        </select>

        <span>모델명</span>
        <input type='text' name='modelName' onChange={(e)=>{inputCar(e)}}></input>

        <span>차량가격</span>
        <input type='text' name='price' onChange={(e)=>{inputCar(e)}}></input>

        <div className='btn'>
          <button type='button' onClick={(e)=>{insertCar()}}>등록</button>
        </div>

      </div>
     

      <div className='carList'>
        <p>- 차량목록</p>
        <table className='list'>
          <thead>
            <tr>
              <td>모델번호</td>
              <td>모델명</td>
              <td>제조사</td>
            </tr>
          </thead>
          <tbody>
            {
              carList.map((car,i)=>{
                return(
                  <tr key={i}>
                    <td>{i+1}</td>
                    <td>{car.modelName}</td>
                    <td>{car.make}</td>
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

export default CarManage