import React from 'react'
import { Outlet } from 'react-router-dom'

const AdminLayout = () => {
  return (
    <div>
      <div>관리자 🦄</div>
      <Outlet />
    </div>
  )
}

export default AdminLayout