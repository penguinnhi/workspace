import { useNavigate } from "react-router-dom";
import './Item.css';

function Item({board}){

  const navigate= useNavigate();
  //함수임 ()붙여야함 


  return(

    
      <tr>
        <td>{board.boardNum}</td>
        <td className="title"><span onClick={(e)=>{
          navigate(`/detail/${board.boardNum}`);
        }}>{board.title}</span></td>
        <td>{board.writer}</td>
        <td>{board.createDate}</td>
      </tr>
  

  );
}

export default Item;