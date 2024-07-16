package example.day09.thread;

public class Step1 {

    //메인 thread 제공받는다
    public static void main(String[] args) {
        Thread thread=Thread.currentThread();
        System.out.println("해당코드를 읽어주는 스레드명:" +thread.getName());//Step2.main()

        //2.여러개의 스레드를 만들어서 스레드 이름 확인
        for (int i=1; i<=5; i++){//자역변수 i는 main스레드의 지역변수

            Thread threadA=new Thread(){//main 스레드 아닌 해당 각 스레드의 스택영역
                @Override
                public void run() { ///작업스레드
                    //System.out.println(i);//안됨
                    Thread thread = Thread.currentThread();
                    thread.setName("내가만든스레드");
                    System.out.println("해당코드를 읽어주는 스레드명:" +thread.getName());//Step2.main()

                }
            }; //익명 구현체
            threadA.start(); //thread start

        }//f e

        //3. 현재 스레드를 주어진 시간동안 일시정지(메인스레드만 10초간정지)
       try {
           System.out.println("====(main Thread)3초간 대기중====");
           Thread.sleep(3000); //thread.sleep(밀리초); //밀리초: 1/1000 //예외처리 해야함
       }catch (Exception e){
           System.out.println(e);
       }
        System.out.println("3초후");
        System.out.println("====(main Thread)실행됨====");

       //4 서로 다른 스레드의 종료를 기다림
        SumThread sumThread=new SumThread();
        sumThread.start();
            //main 스레드가 SumThread스레드 누적합계를 구하기전에 결과를 출력
        System.out.println("JOIN 전 합계결과: "+sumThread.sum);//0
            // --main스레드가 SumThread스레드가 끝나기전에

       try {
           sumThread.join(); //mmain 스레드와 SumThread가 조인(흐름 합치기)
       }catch (Exception e){
           System.out.println(e);
       } System.out.println("JOIN 후 합계결과: "+sumThread.sum);///5050

        //5.
        WorkThread workThreadA =new WorkThread(); //스레드 객체  생성
        workThreadA.setName("작업스레드A");//스레드 이름 정의

        WorkThread workThreadB=new WorkThread();
        workThreadB.setName("작업스레드B");
        workThreadA.start();
        workThreadB.start();

       try {
           Thread.sleep(5000); //5초간 A 정지
       }catch (Exception e){
           System.out.println(e);
       }
        workThreadA.work=false; //a 작업스레드의 필드값 변경

       try {
           Thread.sleep(5000); //main스레드 5초 정지
       }catch (Exception e){
           System.out.println(e);
       }workThreadA.work=true; //작업스레드a의 필드값 변경


    }//m e
}//c e
