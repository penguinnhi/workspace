//item_list는 현재 쇼핑몰에서 판매하고 있는 상품들의 목록 정보이다.
//아래 데이터를 참고하여 요구사항을 해결하시오.
const item_list = [
  {
    item_name : '여름 셔츠',
    price : 25000,
    brand : 'java마켓',
    size : [90, 100, 110]
  },
  {
    item_name : '라운드 티',
    price : 20000,
    brand : 'java마켓',
    size : [90, 95, 100, 105, 110]
  },
  {
    item_name : '데님 청바지',
    price : 30000,
    brand : 'python마켓',
    size : [90, 100, 110, 120]
  },
  {
    item_name : '슬림 면바지',
    price : 35000,
    brand : 'python마켓',
    size : [90, 95, 100]
  }
];

//key값은 중복 불가 
//마지막으로 들어간 key값으로 나옴 

const obj={
  //key : value
};


//1. 'java마켓'에서 팔고 있는 상품들의 상품명과 가격을 각각 콘솔창에 출력하여라.
item_list.forEach(function(e,i){
  if(e.brand=='java마켓'){
    console.log(`상품명 : ${e.item_name} / 가격 : ${e.price}`);
    //console.log(e.price);
  }
})


//2. 95사이즈를 구매할 수 있는 상품들의 상품명을 콘솔창에 출력하시오.
item_list.forEach((item,i)=>{
  //item.size// 사이즈들
  item.size.forEach((e,a)=>{
    if(e==95){
      console.log(item.item_name);
    }
  })
  })



//3. '등록 및 출력' 버튼을 클릭하면 입력 내용 저장 후 콘솔창에 데이터를 출력하시오.  ************************************ㅁㄹ
//
// const arr1=[{},{}];
// const add_data={ ddd : 'ddd' , sss : 'sss'};
// arr1.push(add_data); // 배열에 객체 추가 


function addItem(){

  //체크박스
  const chks = document.querySelectorAll('.size:checked'); 
  // 데이터가 많아서 배열임
  // .size라는 체크박스 중에서 체크 된 것만 들고 오겟다~ 
  const size = []; // size를 넣을 배열을 만듦 

  chks.forEach((chk,i)=>{
    // if(chk.checked){ // ㅎㅎ? 
        //console.log(chk.value); // 체크한 값만 출력 
    // }
    size.push(chk.value); //size라는 배열에 넣기 
    
  })

  const itemName=document.querySelector('#itemName').value;

  if(itemName==''){
    alert('상품명을 입력하세요');
  }
  else{

    //추가할 객체
    const add_data = {
      item_name : document.querySelector('#itemName').value ,
      price : Number(document.querySelector('#price').value) ,
      brand : document.querySelector('#brand').value ,
     size : size
    };



   item_list.push(add_data);
   console.log(item_list);

  }
  

  


  

  // if(itemName==null){
    

  // }
  // else{
  //   const text = document.querySelectorAll('input[type="text"]');
    
  //   const arr1=[{}];
  //   text.forEach((item,i)=>{
  //     //console.log(item.value);
  //     //item_list.push(item.value);
  //     // arr1=[{
  //     //   item_name : item.value[0],
  //     //   price : item.value[1],
  //     //   brand : item.value[2]
  //     // }];
      
  //   })


  //   //item_list.push(...arr1);
  //   console.log(...item_list);

    
  //   const check = document.querySelectorAll('.size');
    
  //   const isChecked=check.checked;
  //   if(isChecked){
  //     check.forEach((size,b)=>{
        
  //       console.log(size);
  //       })
  //   }
    


  //   //item_list.push(text);
  // }

  

  
  
}


