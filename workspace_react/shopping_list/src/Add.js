import { useState } from "react";

function Add(props){
  //input 태그의 데이터를 저장할 변수
  let [text, setText]=useState('');


  return (
    
    <div className='box'>
        <input type="text" onChange={(e)=>{
          //console.log(e.target.value);
          setText(e.target.value); //input태그에 적힌 값을 저장 
        }}></input>

        <button type="button" value='추가' onClick={(e)=> { //input태그에 입력한 내용을 가져온다
        // 가져온 내용을 list에 추가 
          props.cart.push(text);
          console.log(props.cart);
            
        // 변경된 list의 내용으로 setCart 함수를 호출 
          props.setCart([...props.cart]);

            
          }} >추가</button>
      </div>

  );
}

export default Add;