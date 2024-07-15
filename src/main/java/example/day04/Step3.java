package example.day04;

public class Step3 {

    public static void main(String[] args) {


        String money = "123123123";
        //문제: money 변수의 존재하는 문자열 금액의 천단위 쉼표를 넣기
            //천단위 쉼표 가 포함된 형식으로 반환하는 함수 구현 하시오.

         String newMoney =money.replace("123123123" , "123,123,123"); //자바 --> JAVA 치환
         System.out.println("money = " + money);
         System.out.println("newMoney = " + newMoney);


//
//        String newMoney =money.replace(" ",","); //  String money = "123 123 123"; 이렇게 했을 때 가능
//        System.out.println("newMoney = " + newMoney);



    }
}
