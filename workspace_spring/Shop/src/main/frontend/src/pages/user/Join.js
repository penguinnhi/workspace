import React from 'react'

const Join = () => {


  return (
    <div className='join-div'>
      <div>
  
        <table className='join-table'>
          <thead></thead>
          <tbody>
            <tr>
              <td>아이디</td>
              <td>
                <div className='inline-input'>
                  <input type='text' className='form-control'></input>
                  <button type='button' className='btn-primary'>중복확인</button>
                </div>
              </td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td><input type='password' className='form-control'></input></td>
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td><input type='password' className='form-control'></input></td>
            </tr>
            <tr>
              <td>이름</td>
              <td><input type='text' className='form-control'></input></td>
            </tr>
            <tr>
              <td>연락처</td>
              <td><input type='text' className='form-control' placeholder='숫자입력'></input></td>
            </tr>
            <tr>
              <td rowSpan={3}>주소</td>
              <td>
                <div className='inline-input'>
                  <input type='text' className='form-control' placeholder='우편번호'></input>
                  <button type='button'>검색</button>
                </div>
              </td>
            </tr>
            <tr>
              <td><input type='text' className='form-control' placeholder='주소'></input></td>
            </tr>
            <tr>
              <td><input type='text' className='form-control' placeholder='상세주소'></input></td>
            </tr>
            <tr>
              <td>이메일</td>
              <td>
                <div className='inline-select'>
                  <input type='text' className='form-control'></input>
                  <select className='form-control'>
                    <option>naver.com</option>
                    <option>gmail.com</option>
                  </select>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
  
        <button type='button'>회원가입</button>
  
      </div>
    </div>
  )
}

export default Join