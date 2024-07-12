import { useNavigate } from "react-router-dom";
import Item from "./Item";
import './List.css';

function List({board_list}){

  const navigate=useNavigate();
  



  return(
    
    <div className="board">

      <h1>게시글 목록 화면</h1> 

      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>

        <tbody>

        {
        board_list.map((board,i)=>{
          return(
              <Item board={board} key={i}></Item>
          );
        })
        }

        </tbody> 

        
       </table>

      <button type="button" onClick={(e)=>{
        navigate(`/writeForm`);
      }}>글쓰기</button>


    </div>
      

  );
}

export default List;