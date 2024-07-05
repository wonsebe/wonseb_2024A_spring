console.log('phonebook.js 열림')
//배열 선언
let PhonebookDB=[]

//1 등록함수: 등록버튼을 출력했을 때
function postPhone(){

    //1.입력받고
    let name =document.querySelector('#name').value;
    let phone =document.querySelector('#phone').value;
    //2 객체화
    let phoneDto={name:name, phone:phone}
    //3 배열 push 저장
   PhonebookDB.push(phoneDto)
    //4 안내 / 새로고침
    alert('save'); getPhone();//안내/새로고침
}
getPhone() 
//2 출력함수: 등록처리가 되었을 때, js 열렸을 때 최초1번
function getPhone(){

    //1 어디에
    let phoneListBox=document.querySelector('#phoneListBox') //어디에
    //2 무엇을
    let html='' ;     //JAVA : ->  , JS: =>
    PhonebookDB.forEach(  phone =>{
    html+= `<div><span>${phone.name}</span>  <span> ${phone.phone} </span></div>`
    })
    //3 출력
    phoneListBox.innerHTML=html //출력

}