
console.log('write.js');

// function _write(){ //첨부파일을 전송하지 않는 일반 JSON  타입의 통신

//     let title = document.querySelector('#title').value;
//     let content = document.querySelector('#content').value;
//     let category = document.querySelector('#category').value;
//    // let bfile=document.querySelector('.bfile').value;
//     let info ={
//       btitle : title, bcontent : content,  bcno: category , bfile: bfile
//     }; console.log(info);

        
//         //ajax 처리
//         $.ajax({
//             method: "post" ,
//             url: "/board/post" ,
//             data : JSON.stringify(info) ,
//             contentType : "application/json",
//             success:(result)=>{      
//                  console.log(result);
                
//                  if(result){alert('글쓰기 성공')
//                     location.href="/board/all";
//                  }else{alert('글쓰기 실패')}
            
//             } // success method end
//     })
// }

    //2. 게시물 쓰기(첨부파일을 전송하는 대용량 form 타입의 통신)
    function doBoardWrite(){
            //1. form 가져오기 ,form 안에 있는 html 모두 한번에 가져오기
            let boardWriteForm = document.querySelector('.boardWriteForm')
            console.log(boardWriteForm);
            //2.form  HTML 를 바이트로 변환해주는 객체 = new FormData
            let boardWriteFormData= new FormData(boardWriteForm) ;
            console.log(boardWriteFormData);
            //3. ajax 통신
            $.ajax({
                method: "post",
                url: "/board/write",
                data: boardWriteFormData ,
                contentType: false , processData : false,
                success: r => {console.log(r);},
                error: e => {console.log(e);}
            });

    }

