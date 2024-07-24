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
  console.log('update()');

  let name=document.querySelector('.name').value;     console.log(name);
  let pw=document.querySelector('.pw').value;         console.log(pw);
  let Newpw=document.querySelector('.Newpw').value;         console.log(Newpw);
  let phone=document.querySelector('.phone').value;   console.log(phone);

  let info = {  name : name ,
                pw: pw ,
                Newpw : Newpw,
                phone : phone
  }

  $.ajax({
    async: false ,
    method: "put",
    url: "/member/update" ,
    data:  JSON.stringify(info)  ,
    contentType : "application/json" ,
    success : r => {
        
        console.log(r);
        if(r){alert('수정성공'); location.href="/member/mypage";}
        else{alert('입력한 정보가 일치하지 않습니다.');}



    } ,
    error: e => {console.log(e);}
  })

}
