
console.log("all.js");
    //1.page : 보고자 하는 현재 페이지번호 , 초기값 : 1 , 첫페이지를 1페이지로 
    //2. bcno : 보고자 하는 카테고리 번호 , 초기값 : 0 ,전체보기를 0으로 설정
allPrint(1, 0 );
function allPrint(page ,bcno){
    let boardPageDto ={}
    
    $.ajax({
        async :false ,
        method : 'get',
        url : "/board/call",
        data:{page:page ,
              bcno : bcno
        } ,
        success : r => {console.log(r)

            boardPageDto =r;
        }        
        
    })
    let board = document.querySelector(".board");
    let html = '';
    let list =boardPageDto.data;

    list.forEach(b => {
        html += `
        <tr> <th> ${b.bno}  </th> 
        <th><a href="/board/tail?bno=${b.bno}">${b.btitle}</a>  </th> 
        <th> ${b.id}  </th> <th> ${b.bdate}  </th> 
        <th> ${b.bview}  </th>  </tr>
        `;
    });
    board.innerHTML = html;
      // 4. 페이지네이션( 페이지버튼 ) 구성
        // 4-1 어디에
        let pagination = document.querySelector('.pagination')

        // 4-2 무엇을
        let pageHTML = ``;
            // 이전버튼 , page : 현재 함수의 매개변수이면서 현재페이지번호 의미 , 현재페이지 - 1 , 만약에 현재페이지-1 했을때 1보다 작으면 1 고정 하고 아니면 -1차감
                //current == page ? 'active' : current 번째 값이 현재 페이지면 active 넣고 아니면 아님
            pageHTML += `<li class="page-item">
                            <a class="page-link" onclick="allPrint( ${ page-1 < 1 ? 1 : page-1 } )">이전</a></li>`;
            // 페이지버튼
                // 페이지 마다 시작 버튼 번호 :
                let startBtn = boardPageDto.startBtn;
                // 페이지 마다 끝 버튼 번호 :
                let endBtn= boardPageDto.endBtn;
                // 최대 페이지수 : totalPage
            let totalPage = boardPageDto.totalPage;

            for( let current = startBtn ; current <= endBtn ; current++ ){
                pageHTML += `<li class="page-item"><a class="page-link ${current == page ? 'active' : ''}" onclick="allPrint(${current})">${current}</a></li>`;
            }
            // 다음버튼 , page : 현재 함수의 매개변수 이면서 현재페이지번호 의미 , 현재페이지 + 1 , 만약에 현재페이지+1 했을때 최대페이지수 보다 커지면 최대페이지수 고정 아니면 +1 증가
            pageHTML += `<li class="page-item">
                            <a class="page-link" onclick="allPrint( ${ page+1 > totalPage ? totalPage : page+1 } )">다음</a>
                        </li>`;

        // 4-3 출력
        pagination.innerHTML = pageHTML;


}



















