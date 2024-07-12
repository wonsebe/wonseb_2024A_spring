console.log('phonebook.js 열림')
//배열 선언
//let PhonebookDB=[]

//1 등록함수: 등록버튼을 출력했을 때
function postPhone(){

    //1.입력받고
    let name =document.querySelector('#name').value; //html에서 입력받은 내용을 name을 가져온다
    let phone =document.querySelector('#phone').value;//html에서 입력받은 내용을 phone을 가져온다
    //2 객체화
    let phoneDto={name:name, phone:phone} //js 표현 객체화
    //3 배열 push 저장
  // PhonebookDB.push(phoneDto) //3.컨트롤에게 통신
    //4 안내 / 새로고침
   //alert('save'); getPhone();//안내/새로고침

   //2.html 에 jquery라이브러리 가져왔으면 ajax 함수  사용 가능.
    //2-1 ajax 들어갈 옵션 객체 정의
   let option ={
    url: "http://localhost:8080/phone/create",//통신할 경로  --> spring 의 controller
    method: "post", //HTTP가 지원하는 함수중 사용할 함수명(post, get, put, delete 등)
    data:JSON.stringify(phoneDto), //통신할 경로에 보낼 데이터 --> spring의 controller 에게 보낼 데이터
    contentType: "application/json", //data 옵션에 있는 타입
    success: function response(result){//통신을 성공했을 때 응답받을 함수
    console.log(result);
    if(result){alert('save'); getPhone();}
    else{alert('fail');}
    }//success respons e
    }///option end

   //2-2 ajax 함수 호출      , &: jquery 문법
   $.ajax(option);
}
//2 출력함수: 등록처리가 되었을 때, js 열렸을 때 최초1번
getPhone();

function getPhone(){

    //1 어디에
    let phoneListBox=document.querySelector('#phoneListBox') //어디에
    let html='' ;

    let option = {
    url : "http://localhost:8080/phone/read" ,       //누구에게
    method: "get" ,   //어떠한 방식으로
   // data:      //무엇을 보내고
    success:function respons(result){
    console.log(result);//무엇을 받을지
       result.forEach(  phone =>{
        html+= `<div>
                    <span>${phone.name}</span>
                     <span> ${phone.phone} </span>
                </div>`
        })
         phoneListBox.innerHTML=html //출력
    }
    }//ajax 통신 option 설정 end
    //ajax 실행
    $.ajax(option);




}