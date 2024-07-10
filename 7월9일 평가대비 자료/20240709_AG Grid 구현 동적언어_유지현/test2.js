


function setAvgAge(){

  const ageTag=document.querySelectorAll('.ageTd');
const age_arr=[];

  ageTag.forEach(function(e,i){
    //console.log(e.textContent);
    age_arr.push(e.textContent);
  })
const sum=Number(age_arr[0])+Number(age_arr[1])+Number(age_arr[2]);
const avg=sum/3;
  //console.log(sum);
  //console.log(avg);
  
  const str=`${avg}`;
  const btn=document.querySelector('#resultTd');
  btn.innerHTML='';
  btn.insertAdjacentHTML("afterbegin",str);

  

}