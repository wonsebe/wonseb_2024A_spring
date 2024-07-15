package example.day04;

public class Step1 {


    public static void main(String[] args) {

        // [1] 문자열 선언하는 두 가지 방법
        String str1 = new String("abc"); //(힙영역) 302번지 --> 상수풀 참조
        String str2 = "test"; //상수풀 (메소드영역) 상수풀 참조
        String str3 = "test"; //상수풀(메소드영역) 상수풀 참조
        String str4 = new String("abc");//(힙영역) 402번지 참조 --> 상수풀 참조
        String str5 ="abc";

        System.out.println(str2 == str3); //true //참조 변수의 참조주소가 같다
        System.out.println(str1 == str4); //false // 참조변수의 참조주소가 다르다
        System.out.println(str1.equals(str4));//true

        //[2]두 문자열을 연결하는 방법
            //[2-1] 문자열1. concat(문자열2): 두 문자열을 연결한 새로운 문자열 반환 함수
        String javaStr=new String("java");
        String androidStr=new String("android");

        //연결하기 전 문자열 주소
            System.out.println(System.identityHashCode(javaStr));
            //918221580

        //문자열과 문자열을 연결하기 (새롭게 생성됨)
        javaStr=javaStr.concat(androidStr); //두 문자열을 연결하는 concat()메소드 호출
        System.out.println(javaStr);

        //연결 후 문자열 주소
            System.out.println(System.identityHashCode(javaStr)); //문자열의 주소를 알려주는 메소드 출력
            //2055281021

        //[2-2]문자열1 += 문자열2              : 문자열변수 += 문자열 , 문자열변수 = 문자열 + 문자열
        String html1= "<div>";
        String html2="하하<div>";
        System.out.println(System.identityHashCode(html1)); //원래 주소값
        html1 += html2; //문자열 합치기
        System.out.println(html1); //합친 문자열 출력
        System.out.println(System.identityHashCode(html1)); //합치고 주소값

        //[2-3] StringBuilder           : 기존 메모리 문자열을 사용하는 연결 클래스, 메모리 효율성
        String javaStr2= new String("java"); //객체 생성
        String androidStr2= new String("android"); //객체 생성
        System.out.println("연결전"+System.identityHashCode(javaStr2));//주소 출력

        StringBuilder buffer= new StringBuilder(javaStr2);//객체 생성
        System.out.println("연결전"+System.identityHashCode(javaStr2));//주소 출력
        buffer.append(androidStr2);
        System.out.println("연결후"+System.identityHashCode(javaStr2));//주소 출력
        //주소 동일

        javaStr2=buffer.toString();

        System.out.println(javaStr2);//합친 문자열 출력
        System.out.println("연결후"+System.identityHashCode(javaStr2));//주소 출력

    }
}