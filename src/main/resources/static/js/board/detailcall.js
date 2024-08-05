console.log("detailcall.js");
//URL 상의 쿼리스트링 매개변수를 JS 에서 꺼내는 방법
  // JAVA STRING  에서 HTML URL 상의 쿼리스트링 매

let bno=new URL(location.href).searchParams.get('bno');
console.log(bno);

detailcall(bno);
function detailcall(bno){
    let board={}

     $.ajax({
        async:false, //false 동기화 vs true 동기화 (innerHTML 후 에 응답 온다.)
        method : "get",
        url : "/board/detail",
        data: {bno : bno} ,
        success : r => { console.log(r); board = r} // 응답 받은 데이터을 ajax 밖 변수에 대입
      }) // AJAX END
      document.querySelector('.bcName').innerHTML = `${ board.bcname }`;
      document.querySelector('.etcBox').innerHTML = `${ board.id } / ${ board.bview } / ${ board.bdate }`;
      document.querySelector('.bTitle').innerHTML = `${ board.btitle }`;
      document.querySelector('.bContent').innerHTML = `${ board.bcontent }`;
     
    
        if(board.bfile == null){
          document.querySelector('.bFile').innerHTML = '';
        }else{
          document.querySelector('.bFile').innerHTML =`${board.bfile.split('_')[1]}<a href="/file/download?filename=${ board.bfile }"> 다운로드 </a>`;
         
        }

        document.querySelector('.btnBox').innerHTML =
        `
        <button type="button" onclick="location.href='/board/update?bno=${bno}'">수정</button>
        <button type="button" onclick="doBoardDelete(${bno})">삭제</button>
        `;
          

  }


  //2. 댓글 쓰기
  function onReplyWrite(){
    console.log('onReplyWrite()');
    let brcontent= document.querySelector('.brcontent').value;
    // let bno= bno; //현재 보고있는 게시물 번호 
    // console.log(bno);
    let info ={brindex : 0 ,
                brcontent:brcontent,
                bno: bno //현재 보고 있는 게시물 번호

}
    // let html ='';
    console.log('html');
    $.ajax({
      async: false ,
      method: 'post' , 
      url: "/board/reply/write" ,
      data: JSON.stringify(info) ,
      contentType: "application/json",
      success: r =>{ console.log(r);
        if(r == true){
          alert('댓글 쓰기 성공');
          replyPrint();
        }else{
          alert('댓글 쓰기 실패');
        }


      }//s e





    })//a e

  }//f e

  //댓글출력
  replyPrint()
  function replyPrint(){
    let replyPrintBox = document.querySelector('.replyPrintBox')
    let html ='';
    console.log('html');    
    $.ajax({
      method: 'get' ,
      url: "/board/reply/print" ,
      data: {bno: bno} ,
      success: r => {console.log('나왔지?'); console.log(r);
        r.forEach(r =>{
             html += ` <div>${r.name} </div>
                      <div>${r.brdate}</div>
                      <div>${r.brcontent}</div>`
                      
        })
        replyPrintBox.innerHTML=html;
      }









    })
    

  }