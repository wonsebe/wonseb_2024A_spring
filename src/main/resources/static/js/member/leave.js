console.log('leave.js');


function doLeave(){console.log('doLeave()')


//1.

let pwConfirm =document.querySelector('.pwConfirm').value;

console.log(pwConfirm);


//2. ajax 이용한 서버에게 탈퇴 통신

$.ajax({
  method: "delete",
  url: "/member/leave" ,
  data : { pwConfirm : pwConfirm } , 
   success : (result)=>{       // HTTP 응답받을 DATA
    if( result ){
        alert('탈퇴처리 되었습니다'); location.href="/";
      
    }else{
        alert('탈퇴실패');
        
    }
    
  }

});


}