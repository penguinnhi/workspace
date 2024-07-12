import { useParams } from 'react-router-dom';
import './Detail.css';

function Detail({item_list}){
  //url로 전달되는 데이터 받기 

  //1
   //const params = useParams();
   //console.log(params.itemNum);

  //2
  let {id} = useParams(); 
  //id라는 키값을 가진 거만 뽑겠다

  let findItem=null;
  item_list.forEach((item,i)=>{
    if(item.itemNum==id){
      findItem=item;
    }
  });

  console.log(findItem);


  // let detail=[];
  // item_list.map((item,i)=>{
  //   if(item.itemNum=={id}){
  //     return(

  //       detail.push(item)
        
  
  //     );
  //   }
  //   console.log(item)
  // })
  

  return(
    <div className="detail">
      
      {/* {
      item_list.map((item,i)=>{
         //console.log(item.itemNum);
         //console.log({id});
          if(item.itemNum=={id}){
            console.log(item);

            return( */}
              {/* // detail.push(item) */}
              
              <div>

                <div className='d1'>
          
                  <img src={process.env.PUBLIC_URL + '/'+ findItem.imgName }></img>
            
                  <div className='d2'>
                    <div>상품명 : {findItem.itemName}</div>
                    <div>가격 : {findItem.price}</div>
                    <button type="button">주문하기</button>
                  </div>
          
          
                </div>
          
                <div className='intro'>소개 <br></br>
                {findItem.intro}</div>

              </div>

        
            {/* );

          } */}
          {/* // console.log(item) */}
        {/* })


      } */}

      {/* <div>
        <div className='d1'>
  
          <img src={process.env.PUBLIC_URL + '/'+ detail.imgName }></img>
    
          <div className='d2'>
            <div>상품명 : {detail.itemName}</div>
            <div>가격 : {detail.price}</div>
            <button type="button">주문하기</button>
          </div>
  
  
        </div>
  
        <div className='intro'>소개 <br></br>
        {detail.intro}</div>
      </div> */}


      


    </div>
  );

}

export default Detail;