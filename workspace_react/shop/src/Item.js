import { Link, useNavigate } from "react-router-dom";

function Item({item}){
  //navigate는 함수 
  //navicate('이동할 url');
  //navicate(-1); 한페이지 뒤로가기 
  const navicate = useNavigate();
  // console.log(item);

  let itemNum=item.itemNum;

  return(
    <div className="item">
      
      <img onClick={(e)=>{
        navicate(`/detail/${itemNum}`);
        
      }} src={process.env.PUBLIC_URL + '/'+ item.imgName }/>
      <div>상품명 : {item.itemName}</div>
      <div>가격 : {item.price}</div>
      
    </div>

  );
}

export default Item;