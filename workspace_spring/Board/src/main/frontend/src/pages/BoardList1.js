import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { getBoardList } from '../apis/boardApi';

// . : 현재폴더 / .. : 상위폴더 

const BoardList1 = ({loginInfo}) => {
  const navigate=useNavigate();
  const [boardList,setBoardList]=useState([]);
  const [page,setPage]=useState({});


  //검색 조건 저장 변수
  const [searchBox,setSearchBox]=useState({
    searchType:'TITLE',
    searchValue:''
  });



  useEffect(()=>{
    getBoardList()
    .then((res)=>{
      
      console.log(res.data)
      setBoardList(res.data.boardList)
      setPage(res.data.pageInfo)


      
    })
    .catch((error)=>{
      // alert('ㄴㄴ')
      console.log(error)
    })
  },[]);

  function inputSearch(e){
    setSearchBox({
      ...searchBox,
      [e.target.name]:e.target.value
    })
  }

  function clickSearch(){
    getBoardList()
    .then((res)=>{
      setBoardList(res.data)

    })
    .catch((error)=>{
      console.log(error)
    })
    
  }

  //for문을 이용한 그림그리기 예제 아니면 map쓰거나 
  //페이징 그리기 
  function test(){
    const arr=[];
    for(let i =1;i<6;i++){
      arr.push(<span>{i}</span>)
      
    }
    return arr
  }

  function drawPagination(){
    const pagesArr=[];
    if(page.prev){
      pagesArr.push(<span className='page-span' onClick={(e)=>{getList(page.beginPage-1)}}>이전</span>)
    }

    //페이징 처리한 곳에서 숫자(페이지 번호)를 클릭하면 다시 게시글 조회 
    function getList(pageNo){
      getBoardList(pageNo)
      .then((res)=>{
        setBoardList(res.data.boardList)
        setPage(res.data.pageInfo)
      })
      .catch((error)=>{
        console.log(error)
      })
    }

    for(let i= page.beginPage;i<=page.endPage;i++){
      pagesArr.push(<span key={i} className='page-span' onClick={(e)=>{getList(i)}}>{i}</span>)
      
    }
    if(page.next){
      pagesArr.push(<span className='page-span' onClick={(e)=>{getList(page.endPage+1)}}>다음</span>)
    }
    
    
    return pagesArr
  }

  // //그림 그릴 페이지 숫자를 담을 배열 
  // const [pageA,setPageA]=useState([])
  
  // for(let i= page.beginPage;i<=page.endPage;i++){
  //   pageA.push(<span key={i}>{i}</span>)
  // }


  return (
    <div>

      <div className='searchBox'>

        <select name='searchType' onChange={(e)=>{inputSearch(e)}}>
          <option value='TITLE'>제목</option> 
          {/* 대문자인 이유는 ${searchType}에 들어갈 거라서 ..그.. 암튼 그럼  */}
          <option value='MEM_ID'>작성자</option>
        </select>

        <input type='text' name='searchValue' onChange={(e)=>{inputSearch(e)}}></input>
        <button type='button' onClick={(e)=>{clickSearch()}}>검색</button>

      </div>

      <div className='board'>
        <table>
          <colgroup>
            <col width='5%'></col>
            <col width='10%'></col>
            <col width='*'></col>
            <col width='10%'></col>
            <col width='30%'></col>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>글번호</td>
              <td>제목</td>
              <td>작성자</td>
              <td>작성일</td>
            </tr>
          </thead>
          <tbody>
            {
              boardList.map((board,i)=>{
                return(
                <tr key={i}>
                  <td>{boardList.length-i}</td>
                  <td>{board.boardNum}</td>
                  <td><span className='title' onClick={(e)=>{navigate(`/bDetail/${board.boardNum}`)}}>{board.title}</span></td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
                );
              })
            }
          </tbody>
        </table>


          

        {

          loginInfo.memId!=null ? 
          <button type='button' onClick={(e)=>{navigate('/boardWrite')}}>글쓰기</button> 
          : null 

        }

        <div>
          {/* {
            page.prev?<button type='button'>prev</button>:null
          } */}

          {
            drawPagination()
          }

          {/* {
            pageA.map((p,i)=>{
              return(
              <span key={i}>{p}</span>
              )
            })
          } */}
          

          {/* {
            page.next?<button type='button'>next</button>:null
          } */}
          
        </div>
        

      </div>

      

    </div>
  )
}

export default BoardList1