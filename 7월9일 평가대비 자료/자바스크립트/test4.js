function checkAllMenu(){
  const allCheck=document.querySelector('#chk_all');
  const isChecked=allCheck.checked;
  const checkBox=document.querySelectorAll('input');

  checkBox.forEach(function(e,i){
    if(isChecked){
      e.checked=true;
    }
    else{
      e.checked=false;
    }
  })
  
}


function checkAllOption(three){

  //const menuCheck=document.querySelector('li>input');
  const isChecked=three.checked;
  
  const chkBox1=three.nextElementSibling.querySelectorAll('input');
  

  chkBox1.forEach(function(e,i){
    if(isChecked){
      e.checked=true;
    }
    else{
      e.checked=false;
    }

  });

}

