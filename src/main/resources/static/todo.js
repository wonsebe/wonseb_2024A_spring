console.log('todo.js');

//let todoList=["밥먹기, x"];
//1달에는 JS 에서 메모리 관리 했지만 //3달에는 웹서버(->DB서버) 관리하기 때문에 필요없다.
//할일 등록 함수
function todocreate(){console.log('todocreate() load')
    //HTML 입력받은 값 가져오기
    let todoInput=document.querySelector('#todoInput');
    console.log(todoInput);
    
    let tcontent=todoInput.value;
    console.log(tcontent);


    let ajaxoption= {
        method: 'post', //HTTP 메소드 선택(GET, POST,PUT,DELETE)
        url:'/todo/create?tcontent='+tcontent ,//HTTP 통신할 경로 작성(),다른건 생략
        success: function response(result){ //HTTP 성공시 응답값을 함수의 매개변수로 받는다
        console.log(result); //응답 결과 확인
        if(result == true){alert('할일등록성공'); //성공안내
            todoInput.value=''; //입력상자에 입력된 값 없애기.

            todoreadall(); // 등록 성공시 할일 목록 전체 출력 함수 호출
        }
        else{alert('할일등록실패');} //실패안내
        }//success e
    }//옵션 e

    //Ajax는 JQUERY 라이브러리 포함된 함수이다. $는 JQUERY의 문법이다.
    $.ajax(ajaxoption);
}
//할일 목록 전체 출력, 실행조건: 1. JS 열렸을 때  2. 등록/삭제/수정 성공시
//출력함수
todoreadall();
function todoreadall(){
    $.ajax({
        method: 'get',
        url: '/todo/readall' , 
        //data는 매개변수가 있을 때 만 하기
        success: function response(result){ 
            console.log(result); //결과받은 데이터의 타입은 Arraylist
            let todoBox = document.querySelector(`#todoBox`);   console.log( todoBox );
            // [2] 무엇을 
           let html = ``;
            //for(let i=0; i<result.length; i++){}
            //2 리스트명.forEach{반복변수명 => {실행문}}
            result.forEach(todoDto=>{
                html += `<div id=${todoDto.tstate == 0? 'whiteBox':'blackBox'}>
                        <span> ${todoDto.tcontent} </span>
                        <div>
                            <button type="button" onclick="todoupdate(${todoDto.tno})">변경</button>
                            <button type="button" onclick="tododelete(${todoDto.tno})">삭제</button>
                        </div>
                    </div>`      

                    console.log(html);
            });
             //출력
             todoBox.innerHTML=html;
           
        }

    }); //ajax e
}//f e
//수정함수
function todoupdate(tno){
$.ajax({
    method: 'put' ,
    url:`/todo/update?tno=${tno}` ,
    //data:  ,
    success: function response(result){ console.log(result);
        if(result){
            todoreadall(); //새로고침
            }
        else{alert('오류발생.관리자에게문의');}
        
    }

})//ajax e

}
//삭제함수
function tododelete(tno){
    $.ajax({
        method: 'delete' ,
        url:`/todo/delete` ,
        data: {'tno' : tno} ,
        success : result =>{
            if(result){
                todoreadall(); //새로고침
                }
            else{alert('오류발생.관리자에게문의');}
            
        //success:function(result){}
        //success: function response(result){ console.log(result);
       
        }
    
    })//ajax e

}
