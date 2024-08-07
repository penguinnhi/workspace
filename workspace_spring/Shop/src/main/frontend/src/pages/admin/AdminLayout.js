import React from 'react'
import { Outlet, useNavigate } from 'react-router-dom'

const AdminLayout = () => {
  const navigate=useNavigate();

  return (
    <div>
      <div>관리자 🦄</div>
      <div>
        <ul className='category'>
          <li>상품 관리</li>
          <li>구매 관리</li>
          <li><span onClick={(e)=>{navigate('/admin/itemReg')}}>상품 등록</span></li>
          <li>카테고리 관리</li>
        </ul>
      </div>
      <Outlet />
    </div>
  )
}

export default AdminLayout