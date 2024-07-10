function List(props){
  return(

    <div className='box'>

        <h4>07/08</h4>

        {props.cart.map((item,i)=>{
          return(
            <div key={i} className="item-div">
              <span className="item">{item}</span>
              <button type="button" onClick={(e)=>{
                const copyCart=[...props.cart];
                copyCart.splice(i,1);
                props.setCart(copyCart);

                // props.cart.splice(i,1);
                // props.setCart([...props.cart]);

                //props.cart.splice(i,1);
                //console.log(props.cart);
                //props.setCart(props.cart);

              }}>삭제</button>
            </div>
          )
        //console.log(item);
        })}

       
      </div>

  );
}

export default List;
