import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  // 게시글 목록은 반복문 (map())
  // 상세보기는 처음에는 화면에 나타나지 않음-> 게시글 제목을 클릭하면 나타남 
  // 상세보기 컴포넌트로 만들 것
  const board_list=[
    { //board_list[0]
      boardNum:1,
      title:'첫번째 게시글',
      content:'첫번째 내용',
      writer:'무말랭이'
  },{
      boardNum:2,
      title:'두번째 게시글',
      content:'두번째 내용',
      writer:'김자반'
  },{
      boardNum:3,
      title:'세번째 게시글',
      content:'세번째 내용',
      writer:'깻잎조림'
  }];

  const [isShow,setIsShow]=useState(false);
  const [index,setIndex]=useState(0); //바뀔 boardNum



  return (
    <div className="App">
      <div className='container'>
        <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
          </tr>
        </thead>
        <tbody>
          {
            board_list.map((board,i)=>{
              return (
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td>
                    <span onClick={()=>{
                    setIsShow(true);
                    setIndex(i); //어이없음
                  }}>{board.title}
                  </span>
                  </td>
                  <td>{board.writer}</td>
                </tr>
              );
            })
          }
        </tbody>
        </table>

      
      {
        isShow ? <Detail board={board_list[index]}/> : null
      }
      
      
    </div>
    </div>

  );
}

function Detail(props){
  return (

    <div className='detail'>
        글번호 : {props.board.boardNum}<br></br>
        글제목 : {props.board.title}<br></br>
        글내용 : {props.board.content}<br></br>
        작성자 : {props.board.writer}<br></br>
    </div>

  );
}





export default App;
