import React, { useState } from 'react'

const BoardWrite = () => {
  const [board,setBoard] = useState({});

  function writeBoard(){

  }

  function upBoard(){

  }

  return (
    <div>
      <table>
        <thead></thead>
        <tbody>
          <tr>
            <td>제목</td>
            <td>내용</td>
          </tr>
          <tr>
            <td><input type='text' name='title'></input></td>
            <td><textarea name='content'></textarea></td>
          </tr>
        </tbody>
      </table>

      <button type='button' onClick={upBoard()}>글등록</button>
    </div>
  )
}

export default BoardWrite