import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'

const UserLayout = () => {
  const navigate=useNavigate();
  const [cateList,setCateList]=useState([])

  useEffect(()=>{
    axios
    .get('/admin/list')
    .then((res)=>{
      setCateList(res.data)
    })
    .catch((error)=>{})
  },[])

  function goCateDetail(cateNum){
    navigate(`/`)
  }

  return (

    <div>
      <div>유저 전용 페이지입니다 👾</div>
      <ul className='category'>
        <li onClick={(e)=>{navigate('/itemList')}}>전체상품</li>
        {
          cateList.map((cate,i)=>{
            return(
              <li key={i}><span onClick={(e)=>{goCateDetail(cate.cateNum)}}>{cate.cateName}</span></li>
            )
          })
        }
      </ul>
      <Outlet />
      
    </div>
    

  )
}

export default UserLayout