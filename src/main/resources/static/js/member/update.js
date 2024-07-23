console.log('update.js');


// 1. 내정보 호출
doMyInfo();
function doMyInfo(){
    $.ajax({
        method : 'get',
        url : "/member/my/info",
        success : result =>{
            console.log( result );
            if( result == '' ){
                alert('로그인하고 오세요');
            }
            // 1. 어디에
            let myInfoBox = document.querySelector('#myInfoBox')
            // 2. 무엇을
            let html ='';
            document.querySelector('.no').innerHTML=`${ result.no }`;
            document.querySelector('.id').innerHTML=`${ result.id }`; 
            document.querySelector('.name').innerHTML=`${ result.name }`; 
            document.querySelector('.phone').innerHTML=`${ result.phone }`; 
            document.querySelector('.email').innerHTML=`${ result.email }`; 
              

        }
    })
}


function update(){
  console.log('updaate()');

  let name=document.querySelector('.name').value;     console.log(name);
  let pw=document.querySelector('.pw').value;         console.log(pw);
  let phone=document.querySelector('.phone').value;   console.log(phone);

  $.ajax({
    method: "get",
    url: "/member/update" ,
    data : { name : name,
            pw:pw,
            phone : phone
     } , 
     success : (result)=>{       // HTTP 응답받을 DATA
      if( result ){
          alert('수정처리 되었습니다'); location.href="/";
        
      }else{
          alert('수정실패');
          
      }
    }
  
  });

}
