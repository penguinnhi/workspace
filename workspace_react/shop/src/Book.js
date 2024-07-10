import Item from "./Item";

function Book({item_list}){
  return(
    

    <div className='book'>
        {
          item_list.map((item,i)=>{
            return(
              <Item item={item} key={i}></Item>
            );
          })
        }
    </div>


  );
}

// const Book = ()=>{} 

export default Book;