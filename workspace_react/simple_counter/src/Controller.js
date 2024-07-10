
function Controller(props){
  //console.log(2);
  return(
    <div className='controller'>

      <div className='box'>

          {/* <button type='button' onClick={()=>{
            props.setCount(props.count-10)
          }}>-10</button> */}
          
          <button type='button' value='-10' onClick={(e)=>{
            props.changeCount(e.target.value);
          }}>-10</button>

          <button type='button' value='-1' onClick={(e)=>{
            props.changeCount(e.target.value);
          }}>-1</button>

          <button type='button' value='+1' onClick={(e)=>{
            //console.log(e.target.value);
            props.changeCount(e.target.value);
          }}>+1</button>
          {/* e.target : 현재 이벤트가 발생하고 있는 태그  */}

          <button type='button' value='+10' onClick={(e)=>{
            props.changeCount(e.target.value);
          }}>+10</button>




          {/* <input type='button' value={-10} onClick={()=>{
            setCount(count-10)
          }}
          ></input>
          <input type='button' value={-1} onClick={()=>{
            setCount(count-1)
          }}></input>
          <input type='button' value={'+1'} onClick={()=>{
            setCount(count+1)
          }}></input>
          <input type='button' value={'+10'} onClick={()=>{
            setCount(count+10)
          }}></input> */}
      </div>

    </div>
  );
}

export default Controller;