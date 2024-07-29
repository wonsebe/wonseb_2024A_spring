console.log('update.js');

function update(){
let newTitle= document.querySelector('#newTitle').value; console.log(newTitle);
let newContent= document.querySelector('#newContent').value; console.log(newContent);
let category= document.querySelector('#category').value; console.log(category);
    $.ajax({
        method:'put' ,
        url: "/board/load" ,
        data: {
            btitle : newTitle ,
            bcontent : newContent,
            bcno : category ,

        } ,
        success: r => {console.log(r);
            if(r){
                alert('수정 성공');
            }else{
                alert('수정 실패');
            }


        }
    });

}