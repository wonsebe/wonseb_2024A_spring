package example.day08.thread;

import ch.qos.logback.core.joran.conditional.ThenAction;

import javax.tools.Tool;
import java.awt.*;

public class Step1 {

    public static void main(String[] args) {
        //싱글스레드=========================//
        //1.'띵 ' 5회 출력
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        //Tolkit : java.awt 자바의 UI(화면,소리, 등등) 라이브러리
//        for (int i = 1; i <= 5; i++) {
//            toolkit.beep(); // '띵' 비프음 소리 출력
//        }//5회 반복
//        //비프음 소리 1회 출력 속도보다 for문의 5회 반복 속도가 더 빠르다
//        //for문을 처리하는 흐름[스레드.txt]을 잠시 일시정지
//        try {//Thread.sleep() : (밀리초) : 밀리초 만큼 스레드가 일시정지
//            //밀리초: 1/1000 초
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            System.out.println("e = " + e);
//        }
//        //2. '띵' ; 5회 console 출력
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("띵");
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println("e = " + e);
//            }
//        }//f e
//            //---------------------------------------//
//            //---------------------멀티스레드 1-------------------//
//            //1. 작업스레드 A 의 객체 생성
//            작업스레드A threadA = new 작업스레드A();
//            //2. 작업스레드A 의 스레드 실행 (run 메소드 실행)
//            //2. '띵' ; 5회 console 출력
//            for (int i = 0; i <= 5; i++) {
//                System.out.println("띵");
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    System.out.println("e = " + e);
//                }
//
//            }//f e
//        //------------멀티스레드2---------------------------------//
//        //1. 구현(객)체 생성
//        Runnable runnable1=new 작업스레드B();
//        //2. Thread 객체
//        Thread threadB=new Thread(runnable1);
//        //3. 실행
//        threadB.start();
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("띵");
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println("e = " + e);
//            }
//        }//f e
//        //=================멀티스레드 3=====================//
//        //익명 객체 /구현체 : 이름없는 객체
//            //new 생성자(){익명구현체 정의}
//        Thread threadC = new Thread(){
//            @Override
//            public void run() {
//                Toolkit toolkit=Toolkit.getDefaultToolkit();
//                for (int i = 0; i <= 5; i++) {
//                    System.out.println("띵");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                        System.out.println("e = " + e);
//
//                    }
//                }//for e
//            }//f e
//        };//생성자 e 익명구현객체 정의 e
//        threadC.start();
//
//        //[2]
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("띵");
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println("e = " + e);
//
//            }
//        }//for e
        //==========멀티스레드 3-2================//

        Thread threadD=new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit=Toolkit.getDefaultToolkit();
                for (int i = 0; i <= 5; i++) {
                    System.out.println("띵");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("e = " + e);

                    }
                }//for e
            }
        });
        //2.스레드 실행
        threadD.start();
        //[2]
        for (int i = 0; i <= 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("e = " + e);
            }
        }
    }// m e
}// c e


