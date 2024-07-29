console.log( 'header.js' )

// 1. 로그인상태 요청
doLoginCheck();
function doLoginCheck(){
    $.ajax({
        async: false ,//동기화
        method:'get' , url:"/member/login/check" ,
        success : (result)=>{ console.log( result );
            let html= '';
            if( result != '' ){
              
                //로그인 일때   
                html+= ` <li class="nav-item"> ${result.id}님  </li>
                   <li class="nav-item"> <a class="nav-link" href="/member/mypage"> 내정보 </a> </li>
                   <li class="nav-item"> <a class="nav-link" href="#" onclick="doLogout() "> 로그아웃 </a></li>`;

                
            }
            else{
                //비로그인 일 때
                html+=`<li class="nav-item"> <a class="nav-link" href="/member/signup"> 회원가입</a> </li>
                   <li class="nav-item"> <a class="nav-link" href="/member/login"> 로그인 </a></li>`;
                
              }
              document.querySelector('#loginMenu').innerHTML=html;      
        }//s e
        
    })//ajax end
}//f e
// 2. 로그아웃
function doLogout(){
    $.ajax({
        method : 'get' , url :"/member/logout" ,
        success : ( result ) => {  console.log( result);
            location.href="/";
        }
    })
}