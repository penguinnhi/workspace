import { useParams } from 'react-router-dom';
import './Detail.css';
import { useEffect, useState } from 'react';

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

  // console.log(findItem);


  // let detail=[];
  // item_list.map((item,i)=>{
  //   if(item.itemNum=={id}){
  //     return(

  //       detail.push(item)
        
  
  //     );
  //   }
  //   console.log(item)
  // })

  const [num,setNum]=useState(0);
  const [num1,setNum1]=useState(0);

  
  //해당 컴포넌트가 랜더링되면 마지막에 실행 = mount되면 실행(생성이 되면 실행한다~ )
  //mount(컴포넌트를 새로 읽을 때) + update(재랜더링)
  //useEffect의 두번째 매개변수가 없으면 mount+update될 때 실행 -> 매개변수가 없으면! 없음 
  useEffect(()=>{// 컴포넌트의 라이프싸이클 사이에 필요한 기능 추가
    console.log('매개변수 없음1');
  });

  //mount될 때 실행 (새로고침)
  // 두번째 매개변수가 빈배열이기 때문에 state값이 변경되어도 재랜더링 안할꺼임 이라는 뜻이래 
  //여기는 두번째 매개변수가 없는게 아니고 빈 배열일 때 
  //두번째 매개변수로 빈 배열을 전달하면 mount 될 때만 실행 
  useEffect(()=>{
    console.log('매개변수 빈 배열2');
  }, []);

  //두번째 매개변수에 배열 형태로 state변수를 넣으면 
  //해당 useEffect는 mount+배열에 넣은 state값이 변경되어 재랜더링 될 때 실행됨   ? ? ? ? ? ? ? ? ? ?아뇨 
  //그럼 변경안되면? 안나오겠지 
  useEffect(()=>{
    console.log('매개변수 num 3');
  }, [num]);

  useEffect(()=>{
    console.log('매개변수 num,num1 4');
  }, [num,num1]);


  
  useEffect(()=>{
    console.log('매개변수 num 5');
    
    return()=>{ //mount될 때 보이지 않음 실행안됨 / unmount될 때도 실행 
      // ? 재랜더링 될 때 가장 먼저 실행된대 왜 ?  
      // 변수를 ,, 변수를... 초기화? 암튼 청소한다는데 ? ? ? ? 
      console.log('리턴 안, 매개변수 num 6');
    };

  },[num]);

  //unmount 될 때만 7을 출력하고싶음 
  useEffect(()=>{
    return()=>{
      console.log(7);
    };
  },[]); //두번재가 빈 배열이여야 state가 변경되어도 재랜더링 안되니까 


  // console.log(2);
   
  //라이프싸이클? 밑의 상태들을 라이프사이클이라고 함 
  //mount 응애 : 최초의 컴포넌트가 생성
  //update 변화 : 컴포넌트가 재랜더링 되는 상태 ? 
  //unmount 죽음 : 컴포넌트가 사라질 때 

  return(

    <div className="detail">

      <button type='button' onClick={(e)=>{
        setNum(num+1);//우왕
      }}>num값 변경</button>
      <div>num={num}</div>


      <button type='button' onClick={(e)=>{
        setNum1(num1+1);//우왕
      }}>num1값 변경</button>
      <div>num1={num1}</div>

      
      
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