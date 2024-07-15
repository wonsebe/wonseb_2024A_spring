package example.day03;

public class Step2 {
    public static void main(String[] args) {
        //2개의 문자열객체 생성
        String str1= new String("abc"); //str1=> 302번지(멤버변수 -> 502 번지)
        String str2=new String("abc"); //str->402번지(멤버변수 -> 502번지)
        String str3="abc";                    //str3 -> 502 번지
        int i1=100;
        int i2=100;
        Integer i3=100;

        //래퍼클래스: int 형 기본타입은 메소드를 사용할 수 없으므로 int 형 타입도 메소드를 사용하기 위해 만들어진 참조타입
        //JAVA : Integer.parseInt() : 문자열 타입을 정수타입 반환, "10" vs 10 다르다
        //vs JS : parseInt()

        System.out.println(str1.hashCode() );    //96354,  String 타입의 객체같은 경우 문자열의 저장위치를 참조
        System.out.println(str2.hashCode());    //96354
        System.out.println(str3.hashCode());   //96354 //2개의 객체의 멤버변수와 :"abc"는 동일한 저장위치를 참조한다.
        System.out.println(str1 == str2);       //false
        System.out.println(str1.equals(str2)); //true
        System.out.println(i1 ==i2);//true
       // System.out.println(i1.equlse);//int는 참조타입이 아니므로 Object로부터 상속받지 못했다
        System.out.println(i3.equals(i1)); //Integer 는 참조타입 이므로 Object클래스로부터 상속 받아왔으므로 .equlse 사용가능.
        //true
        //
        // str1.clone(); //기본적으로 clone()메소드는 사용이 불가능 하다.
        Object object =new Object();
        // object.clone();


        /*

       메소드 메모리              스택 메모리                        힙 메모리
            리터럴                 str1(302번지)                new String() : 302번지 주소값을 가지는 객체 생성
                                                               멤버변수 : "abc"   502번지 주소값을 가지는 객체
                                  str2(402번지)              new String(): 402번지 주소값을 가지는 객체 생성
                                                               멤버변수: "abc"    502번지 주소값을 가지는(참조하는) 객체
                                 str3 (502번지)
                                                             -"abc" : 502번지 주소값을 가지느 객체 생성


            1. == : 302 번지와 402번지를 가지는 두 스택변수는 다르다.
            2.equlase() : 302번지와 402번지가 가지는 객체는 같다.


         */




    }
}
