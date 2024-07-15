console.log('Board.js');
// 1. 등록함수 실행조건 : 1.등록버튼을 클릭했을때 
function bcreate(){
  console.log('create()load');
  let titleInput=document.querySelector('#titleInput').value;
  console.log(titleInput);
  let contentInput=document.querySelector('#contentInput').value;
  console.log(contentInput);
  let passwordInput=document.querySelector('#passwordInput').value;
  console.log(passwordInput);

  let ajaxoption={
      method: 'post' ,
      url: '/board/create' ,
      data: { 'btitle':titleInput ,
              'bcontent':contentInput ,
              'bpw':passwordInput 
      },
      success: function response(result){
        if(result == true){alert('게시판등록성공'); //성공안내
          titleInput.value=''; //입력상자에 입력된 값 없애기.
          contentInput.value='';
          passwordInput.value='';
          printAll();
          //todoreadall(); // 등록 성공시 할일 목록 전체 출력 함수 호출
      }
      else{alert('할일등록실패');} //실패안내

      }

  }
  $.ajax(ajaxoption);

}
//전체출력
printAll();
function printAll(){
$.ajax({
  method: 'get' ,
  url:'/board/printall' ,
  success: function response(result){
    console.log(result); //결과받은 데이터의 타입은 Arraylist
      // 1. 어디에 
  let tableBody = document.querySelector('#tableBody');
  // 2. 무엇을 
  let html = '';
  result.forEach(boardDto=>{
    
    // 각 정보를 HTML 문자열로 구성 
    html += `<tr> 
              <td> ${ boardDto.bno } </td> 
              <td onclick="print( ${ boardDto.bno } )"> ${ boardDto.btitle } </td> 
              <td> ${ boardDto.bdate } </td>
              <td> ${ boardDto.bview } </td>
            </tr>`
  });
  // 3. 출력/대입 
  tableBody.innerHTML = html;
  }


});
}
//개별출력
function print(bno){
console.log(bno);
  $.ajax({
    method: 'get' ,
    url:'/board/print' ,
    data:{'bno':bno},
    success: function response(result){
      let boardDto=result;
      console.log(result); //결과받은 데이터의 타입은 Arraylist
    // 1. 어디에 
  let viewPage = document.querySelector('#viewPage');
  // 2. 무엇을 
  let html = `<h3> 상세 페이지 </h3>
              <div> ${ boardDto.btitle } </div>
              <div> 
                <span> 조회수 : ${ boardDto.bview } </span> 
                <span> 작성일 : ${ boardDto.bdate } </span>
              </div>
              <div> ${ boardDto.bcontent } </div>
              <button onclick="update( ${ bno } )">수정</button>
              <button onclick="_delete( ${ bno } )">삭제</button>`;
  // 3. 출력/대입 
  viewPage.innerHTML = html;
    }
  });
  }

  function update(bno){
    let bpw = prompt('비밀번호 입력');
    let bcontent = prompt('수정할내용');
    $.ajax({
      method: 'put' ,
      url:`/board/update?bno=${bno}` ,
      data: {'bpw':bpw ,
            'bcontent':bcontent
      },
      success: function response(result){ console.log(result);

        // 패스워드 검증 함수를 호출후 반환값이 false 이면 수정함수 강제종료 
        // if( _pwConfirm(bno) == false ) return;

        // 배열내 특정 데이터 수정 
        //let board = boardList[index].split(',');   // 1. 해당 게시물 분류 
          // 새로운 제목과 내용 입력받는다.
       
        //   // 수정할 정보로 구성 : 새로운 제목과 내용만 수정 변수로 구성 하고 나머지는 기존 데이터 사용
        // let uboard = `${ utitle },${ ucontent },${ board[2]},${ board[3]},${ board[4]}`;
        //   // 선택된 인덱스의 수정할 정보 대입 
        // boardList[index] = uboard;
        //   // 화면 새로고침( 재 출력: 데이터 변화가 있기 때문에  )
    
          if(result){
            printAll();
            print( bno );
              }
          else{alert('오류발생.관리자에게문의');}
          
      }
  
  })//ajax e

  }

  function _delete(bno){
    let bpw = prompt('비밀번호 입력');
    $.ajax({
      method: 'delete' ,
      url:`/board/delete` ,
      data: {'bno' : bno,
              'bpw':bpw 

      } ,
      success : result =>{
          if(result){
             printAll(); //새로고침
            viewPage.innerHTML='';
              }
          else{alert('오류발생.관리자에게문의');}
          
      //success:function(result){}
      //success: function response(result){ console.log(result);
     
      }
  
  })//ajax e

  }








































// function _create(){ 
// // 1-1 
// let title = document.querySelector('#titleInput').value;
// let content = document.querySelector('#contentInput').value;
// let password = document.querySelector('#passwordInput').value;
// // 2-1 입력받지 않은 데이터를 초기화 

// // 원하는 날짜 추출 해서 가공 
// let currentYear = date.getFullYear(); 
// let currentMonth = date.getMonth()+1 < 10 ? "0"+(date.getMonth()+1) : date.getMonth()+1 ;
// let currentDay =  date.getDate() < 10 ? "0"+date.getDate() : date.getDate();
// date = `${ currentYear }-${ currentMonth }-${ currentDay }` // 날짜 구성 



// // 3. ,쉼표 구분해서 하나의 문자열로 만들자. 
// let board = `${title},${content},${password},${date},${view}`; console.log( board );
// // 4. 배열 등록 
// boardList.push( board ); console.log( boardList ); 
// alert('등록성공') // 5. 등록 성공 
// _allRead(); // 등록성공시 전체출력 함수 호출 
// }
// // 2. 전체출력 실행조건 : 1. 페이지가 열렸을때(HTML실행->JS실행) 2.데이터가 변화(수정/삭제/등록)가 있을때
// _allRead(); // js에서 해당 함수 1번 실행 
// function _allRead(){ 
// // 1. 어디에 
// let tableBody = document.querySelector('#tableBody');
// // 2. 무엇을 
// let html = '';
// for( let i = 0 ; i<boardList.length ; i++ ){ // 배열 순회 : 0번 인덱스부터 마지막인덱스 까지
//   // i번째 게시물 반환 
//   let board = boardList[i]; console.log( board );
//   // 게시물의 정보 분류 : 특정 문자 기준으로 분류 .split( 기준문자 ) : 기준문자 기준으로 자른후 배열 반환
//   let boardArray = board.split(',') ; console.log( boardArray );
//   // ,쉼표 기준으로 각 분류된 배열의 정보 
//   console.log( boardArray[0] ); console.log( boardArray[3] ); console.log( boardArray[4] );  
//   // 각 정보를 HTML 문자열로 구성 
//   html += `<tr> 
//             <td> ${ i } </td> 
//             <td onclick="_read( ${ i } )"> ${ boardArray[0] } </td> 
//             <td> ${ boardArray[3] } </td>
//             <td> ${ boardArray[4] } </td>
//           </tr>`
// }
// // 3. 출력/대입 
// tableBody.innerHTML = html;
// }
// // 3. 개별출력 실행조건 : (누구를) 1.제목 클릭했을때
// function _read( index ){
// // 선택/클릭 했을때 클릭된 해당 인덱스를 매개변수를 받아서 
// let boardArray = boardList[ index ].split(','); // 해당 인덱스의 게시물 정보를 ,쉼표 기준으로 분류된 배열 반환 
// // 1. 어디에 
// let viewPage = document.querySelector('#viewPage');
// // 2. 무엇을 
// let html = `<h3> 상세 페이지 </h3>
//             <div> ${ boardArray[0] } </div>
//             <div> 
//               <span> 조회수 : ${ boardArray[4] } </span> 
//               <span> 작성일 : ${ boardArray[3] } </span>
//             </div>
//             <div> ${ boardArray[1] } </div>
//             <button onclick="_update( ${ index } )">수정</button>
//             <button onclick="_delete( ${ index } )">삭제</button>`;
// // 3. 출력/대입 
// viewPage.innerHTML = html;
// }
// // 4. 수정함수 실행조건 : (누구를)1. 수정버튼 클릭할떄  
// function _update( index ){ 
// // 패스워드 검증 함수를 호출후 반환값이 false 이면 수정함수 강제종료 
// if( _pwConfirm(index) == false ) return;

// // 배열내 특정 데이터 수정 
// let board = boardList[index].split(',');   // 1. 해당 게시물 분류 
//   // 새로운 제목과 내용 입력받는다.
// let utitle = prompt('수정할제목');
// let ucontent = prompt('수정할내용');
//   // 수정할 정보로 구성 : 새로운 제목과 내용만 수정 변수로 구성 하고 나머지는 기존 데이터 사용
// let uboard = `${ utitle },${ ucontent },${ board[2]},${ board[3]},${ board[4]}`;
//   // 선택된 인덱스의 수정할 정보 대입 
// boardList[index] = uboard;
//   // 화면 새로고침( 재 출력: 데이터 변화가 있기 때문에  )
// _allRead();
// _read( index );
// } // for end 

// // 5. 삭제함수 실행조건 : (누구를)1. 삭제버튼 클릭할때 
// function _delete( index ){
// // 패스워드 검증 함수를 호출후 반환값이 false 이면 삭제함수 강제종료 
// if( _pwConfirm(index) == false ) return;

// // 배열내 특정 인덱스 삭제 
// boardList.splice( index , 1 );
// // 화면 새로고침( 재 출력: 데이터 변화가 있기 때문에  )
// _allRead();
// document.querySelector('#viewPage').innerHTML = ``;

// }

// // 6. 패스워드 체크 함수 
// function _pwConfirm( index ){
// // - 패스워드 검증 
// // 1. 검증받을 패스워드 입력받는다.
// let confirmPw = prompt('비밀번호:');
// // 2. 해당 인덱스의 비밀번호 와 입력받은 비밀번호가 다르면 함수를 중간에 종료한다.
// if( confirmPw != boardList[index].split(',')[2] ){
//   alert('패스워드가 다릅니다. ');
//   return false ; // 패스워드 일치 실패 뜻 , 함수 종료 , 이하 아래 코드는 실행이 안됨.
// }
// return true; // 패스워드 일치 성공 뜻 
