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
    .catch((error)=>{console.log(error)})
  },[])

  //console.log(cateList)

  function changeBold(e){
    
    let li=document.querySelectorAll('.category li')
    li.forEach((l,i)=>{
      if(e.currentTarget==l){
        l.classList.add('active')
      }
      else{
        l.classList.remove('active')
      }
    })

  }

  return (

    <div>
      <div>👾</div>
      <ul className='category'>
        <li onClick={(e)=>{
          changeBold(e)
          navigate('/itemList')}}>전체상품</li>
        {
          cateList.map((cate,i)=>{
            return(
              <li key={i} onClick={(e)=>{
                changeBold(e) 
                navigate(`/cateList/${cate.cateCode}`)}}>
                {cate.cateName}
              </li>
            )
          })
        }
      </ul>
      
      <div className='home-main'>
        <p>안녕하세요! 감사해요! 잘있어요! 다시 만나요!</p>
      </div>

      <Outlet />
      
    </div>
    

  )
}

export default UserLayout