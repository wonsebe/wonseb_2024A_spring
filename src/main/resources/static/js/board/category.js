

console.log('category.js'); 

  category();
  function category(){
  //어디에
  let category= document.querySelector('#category');
  //무엇을
  let html="";

  $.ajax({
          method: "get" ,
          url: "/board/category" ,
          success:(result)=>{      
          console.log(result);

          for(let i=0; i<result.length; i++){
            html += `<option value="${result[i].bcno}">${result[i].bcname}</option>`
          }    
          //출력
             category.innerHTML = html;
      
          
      
  } // success method end


})


}