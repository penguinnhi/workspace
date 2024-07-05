import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

//App() 함수의 리턴문 안에 작성하는 코드가 화면에 나타남. 
//html 코드처럼 보이는 것은 실은 jsx라는 문법이다.
//그렇기 때문에 html과 조금 다른 부분이 있다. 
function App() {
  //const titles=['dd','xx','bb','ee'];

  //제목 정보를 저장하고 있는 변수
  const [titles, setTitles]=useState(['늑대','코끼리','토끼','사슴']);
  //titles가 초기값 , setTitles가 변경값인데 
  //setTitles=titles인거임 암튼 그럼 

  //const [titleChange, setTitleChang]=useState([titles[0],titles[1])
  
  
  //좋아요 개수
  //대괄호의 첫번째 : 변수 (useState()←소괄호안에 있는 값을 갖는 변수)
  //대괄호의 두번째 : 변수의 값을 변경해주는 함수
  //ex) setLikeCnt(5); -> likeCnt 변수의 값을 5로 변경
  //useState로 만들어서 변수는 값을 변경하면 html화면을 재랜더링 한다./ ? 
  // ㄴ중요하다는데 잘 모르겠ㄷ음 
  let [likeCnt, setLikeCnt]=useState(0);
  let [likeCnt2, setLikeCnt2]=useState(0);
  let [likeCnt3, setLikeCnt3]=useState(0);
  //let [titleChange, setTitleChange]=

  let [likeCnt4,setLikeCnt4]=useState([0,0,0]);

  //detail 컴포넌트가 보일지 안보일지 결정하는 변수
  let [isShow, setIsShow]=useState(false);


  //[1,2,3].forEach(function(){});


  // [1,2,3].map((e,i) => {
  //   return 123;
  // });


  return (
    <div className="App">

      <div className="blog-nav">
        <h3>My  Blog</h3>
      </div>

      {/* {
        [1,2,3].map((e,i)=>{
          return (
            <div>1</div>
          );
        })
      } */}


      <button type="button" onClick={()=>{
        setTitles(['로보','파올로','미첼','넬슨']);
      }}>제목변경</button>

      {/* 블로그 글 목록 */}

      {
        titles.map((title,i)=>{
          return (
            <Board title={title} key={i} />
          );
        })
      }


      {/* <button type="button" onClick={()=>{
        const copyTitles=[...titles]; //원래있는 값을 새로만들어서 복사하는 거 
        copyTitles[0]=('로보');
        setTitles(copyTitles); // ?? 
      }}>제목변경</button> */}

      {/* <button type='button' onClick={()=>{
        setTitleChang(['dddddd','aaa'])
      }}>변경
      </button> */}

      {/* 'java'라는 문자 데이터를 title이라는 이름으로 전달하겠다  */}
      



      {/* <div className='list'> */}
      {/* <h4>{titles[0]} */}
        {/* <span onClick={()=>{
          setLikeCnt(likeCnt+1);
        }}>🐺</span>
        {likeCnt}
        </h4> */}
        {/* <span onClick={()=>{ //배열의 값을 변경할 때는 주의 
          let copyLike=[...likeCnt4];
          copyLike[0]=(likeCnt4[0]+1); 
          setLikeCnt4(copyLike);
        }}>🐺</span>
        {likeCnt4[0]} */}
        {/* </h4> */}
      {/* <p>날짜</p> */}
      {/* </div> */}



      {/* <div className='list'> */}
      {/* <h4>{titles[1]} */}
      {/* <span onClick={()=>{
          setLikeCnt2(likeCnt2+1);
        }}>🐘</span>
        {likeCnt2}
      </h4> */}
      {/* <span onClick={()=>{
          let copyLike=[...likeCnt4];
          copyLike[1]=(likeCnt4[1]+1);
          setLikeCnt4(copyLike);
        }}>🐘</span>
        {likeCnt4[1]} */}
      {/* </h4> */}
      {/* <p>날짜</p> */}
      {/* </div> */}



      {/* <div className='list'> */}
      {/* <h4 onClick={()=>{  */}
          {/* // setIsShow(true); */}
        {/* // }}> */}
        {/* {titles[2]} */}
      {/* <span onClick={()=>{
          setLikeCnt3(likeCnt3+1);
        }}>🐰</span>
        {likeCnt3}
      </h4> */}
      {/* <span onClick={()=>{
          let copyLike=[...likeCnt4];
          copyLike[2]=(likeCnt4[2]+1);
          setLikeCnt4(copyLike);
        }}>🐰</span>
        {likeCnt4[2]} */}
      {/* </h4> */}
      {/* <p>날짜</p> */}
      {/* </div> */}



      {/* 상세보기 */}
      {
        isShow ? <Detail /> : null
        // isShow가 참이면 디테일컴포넌트를 보여주고 아니면 null
      }
      


    </div>
  );
}

//블로그 글 하나에 대한 컴포넌트 
//함수명의 첫글자가 대문자면 컴포넌트를 의미함 
//전달되는 데이터는 컴포넌트의 매개변수 props라는 변수를 통해 전달 받음 

//상세보기 컴포넌트
//컴포넌트의 리턴문에 html을 작성
//모든 html 태그는 하나의 최상위 태그에 포함되게 작성
function Detail(){
  return(

  
    <div className='detail'>
    <h4>제목</h4>
    <p>날짜</p>
    <p>상세내용</p>
    </div>

  );
}

// const Detail = ()=>{

// }


//블로그 글 하나에 대한 컴포넌트
//전달되는 데이터는 매개변수에 props를 사용해서 전달받음
function Board(props){
  <div className='list'>
    <h4>{props.title}
    <span>🤮</span>
    </h4>
    <p>작성</p>
  </div>
}


export default App;

