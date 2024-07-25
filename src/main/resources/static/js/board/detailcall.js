// console.log("detailcall.js");

// let urlParams = new URL(location.href).searchParams;
// let Bno = urlParams.get("bno") //글번호

// detailcall();
// function detailcall(){
// let detailBox=document.querySelector(".detailBox");
// let html='안녕 여기다가 상세하게 출력할거야';
// console.log(html);

//      $.ajax({
//         method : 'get',
//         url : "/board/detail",
//         data:{bno:Bno},
//         success : function response (result){console.log(result)
//             result.forEach(r => {
//                 html += `


//                 <div  class="detailBox">
//                   <ul class="detail">
//                     <li class="god">
//                         ${r.bcname} 
//                       </li>
//                       <li>
//                       ${r.bno}
//                       </li>
//                       <li class="god">
//                       ${r.btitle}
//                       </li>
//                       <li class="god">
//                       ${r.bcontent}
//                       </li>
//                       <li class="god">
//                       ${r.id}
//                       </li>
//                       <li class="god">
//                       ${r.bdate}
//                     </li>
//                     <li class="god">
//                       ${r.bview} 
//                     </li>
//                   </ul>
//               </div>
//               <button type="button" onclick="location.href='/board/update?bno=3'">수정하러가기</button>`
              
//             });
//             detailBox.innerHTML = html;
//         }
//     });
// }