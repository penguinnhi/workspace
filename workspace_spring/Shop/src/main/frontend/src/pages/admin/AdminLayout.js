import React, { useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'

const AdminLayout = () => {
  //사이드메뉴 정보를 관리하는 state 변수
  const [sideMenu,setSideMenu]=useState('itemManage')

  //사이드메뉴를 화면에 그리는 함수
  function drawSideMenu(){
    if(sideMenu=='itemManage'){
      return(
        <>
          <li>
            <span onClick={(e)=>{navigate('/admin/itemManage')}}>상품 관리</span>
            <span><i className="bi bi-chevron-right"></i></span>
          </li>
          <li>
            <span onClick={(e)=>{navigate('/admin/itemReg')}}>상품 등록</span>
            <span><i className="bi bi-chevron-right"></i></span>
          </li>
          <li>
            <span onClick={(e)=>{navigate('/admin/cateManage')}}>카테고리 관리</span>
            <span><i className="bi bi-chevron-right"></i></span>
          </li>
        </>
      );
    }
    else if(sideMenu=='buyManage'){
      return(
        <>
          <li><span onClick={(e)=>{navigate('/admin/saleHistoryOfMonth')}}>이 달의 구매내역</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
          <li><span>구매 정보 검색</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
        </>
      )
    }
    else if(sideMenu=='memberManage'){
      return(
        <>
          <li><span onClick={(e)=>{navigate('/admin/adminBoard')}}>공지사항</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
          <li><span>유저 정보 변경</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
          <li><span>탈퇴 유저 관리</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
        </>
      )
    }
    else if(sideMenu=='saleManage'){
      return(
        <>
          <li><span onClick={(e)=>{navigate('/admin/recordOfMonth')}}>이 달의 매출</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
          <li><span>월별 매출</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
          <li><span>카테고리별 매출</span>
          <span><i className="bi bi-chevron-right"></i></span></li>
        </>
      )
    }

    return(
      <>
      
      </>
    )
  }
  
  const navigate=useNavigate();

  


  return (
    <div className='layout-div'>
      <div>🦄</div>
      <div>
        <ul className='category'>
          <li><span onClick={(e)=>{navigate('/admin/itemManage'); setSideMenu('itemManage')}}>상품 관리</span></li>
          <li><span onClick={(e)=>{navigate('/admin/saleHistoryOfMonth'); setSideMenu('buyManage')}}>구매 관리</span></li>
          <li><span onClick={(e)=>{navigate('/admin/adminBoard'); setSideMenu('memberManage')}}>유저관리</span></li>
          <li><span onClick={(e)=>{navigate('/admin/recordOfMonth'); setSideMenu('saleManage')}}>매출 관리</span></li>
        </ul>
      </div>

      <div className='sidebar'>
        <div>        
          <ul className='category side'>
            {
              drawSideMenu()
            }
          </ul>
        </div>

        <Outlet />
      </div>

      

    </div>
  )
}

export default AdminLayout



{/*  */}