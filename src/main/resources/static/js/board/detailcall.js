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
      document.querySelector('.bFile').innerHTML = `${ board.bfile } <a href="/file/download?filename=${ board.bfile }">다운로드</a>`;
      document.querySelector('.btnBox').innerHTML =
              `
              <button type="button" onclick="location.href='/board/update?bno=${bno}'">수정</button>
              <button type="button" onclick="doBoardDelete(${bno})">삭제</button>
              `;
          

  }