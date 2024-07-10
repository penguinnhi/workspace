function Item({item}){
  return(
    <div className="item">
      
      <img src={process.env.PUBLIC_URL + '/'+ item.imgName }/>
      <div>상품명 : {item.itemName}</div>
      <div>가격 : {item.price}</div>
      
    </div>

  );
}

export default Item;