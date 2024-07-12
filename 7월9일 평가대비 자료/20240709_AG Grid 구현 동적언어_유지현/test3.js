t

function create(){

  const input1=document.querySelector('#rowInput');
  const input2=document.querySelector('#colInput');

  const num1=input1.value;//input태그에 입력한 값
  const num2=input2.value;//input태그에 입력한 값

  let str=``;
  
  str+=`<table>`;

  for(let i=0;i<num1;i++){
    
      
    str+=`<tr>` //************** */


    for(let e=0;e<num2;e++){
      // str=`
      //   <table>
      //     <tr>
      //       <td>${num1}행${num2}열</td>
      //     </tr>
      //   </table>
      //   `;

      str+=`<td>${i+1}행${e+1}열</td>`//********************* */

      const hh=document.querySelector('.table-div>span');
      hh.innerHTML='';
      hh.insertAdjacentHTML('afterbegin',str);
      
      
    }
    
    str+=`</tr>`;//************* */

  }
  
  str+=`</table>`; //***** ********/


  //추가할 태그
  
  




}