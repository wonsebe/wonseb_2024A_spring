package example.day03;

class Book{//직접 extends Object 를 하지 않아도 자동으로 Object 클래스로부터 상속받는다.
    //멤버변수
    int bookNumber;
    String bookTitle;

    //생성자
    public Book(int bookNumber, String bookTitle) {
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
    }//생성자 end

    //메소드
    public String toString(){
        return "Object Info : " + bookTitle+ "," +bookNumber;

    }




}//class end


public class Step1 {
    public static void main(String[] args) {
        ///1. 객체생성
        Book book1=new Book(200,"개미");           //스택 메모리: book1 = 힙메모리: 예) 302 번지 객체 생성
        //2. Book 클래스의 메소드가 아닌 Object 클래스의 메소드 호출
        System.out.println(book1); ///참조변수를 출력하면 자동으로 toString() 가 자동으로 호출 example.day03.Book@5ca881b5
        //객체내 정보가 들어갔는지 확인하기 위해 콘솔확인출력
        System.out.println(book1.toString()); //example.day03.Book@5ca881b5
        //3.객체2 생성
        Book book2 = new Book(300,"Tiger");     //스택메모리: book2 =힙 메모리: 402번지 객체 생성
        //4객체3 생성
        Book book3= new Book(200,"Ant");       //스택메모리 : book3=힙메모리 : 502번지 객체ㅔ 생성
        //객체 1 멤버변수 동일하게
        //5.객체4는  객체 생성이 아닌 객체1의 참조값 대입
        Book book4=book1;                                       //스택 메모리: book4= book1(302번지 참조)

        System.out.println(book1 ==book2 ); //false                                      //302번지 == 402번지
        System.out.println(book1 == book3); //false                                     //302번지==502번지
        System.out.println(book1 == book4); //true: 객체 생성 아닌 대입을 했기 때문에 같다.  //302번지 ==302번지


        System.out.println(book1.equals(book2)); //false    302번지.equlse(402번지)
        System.out.println(book1.equals(book3)); //false    302번지.equlase(502번지)
        System.out.println(book1.equals(book4)); //true     302번지.equlse(302번지)

    }



}
