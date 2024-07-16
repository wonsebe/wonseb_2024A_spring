package example.day09.thread;

public class Calculator {

    int memory;


    public synchronized void setMemory(int memory){//synchronized : 동기화 시킴
        //user1과 user2가 한 번에 나오지않고 우선순위에 의해 한 명이 다 끝날 때까지 다른 한명은 실행되지 못함.

        System.out.println("memory = " + memory);

        this.memory=memory;//매개변수 값을 필드 저장

        try {Thread.sleep(2000);}//2초간 일시정지
        catch (Exception e){System.out.println(e);}
        System.out.println(Thread.currentThread().getName()); ///현재 읽고읽는 스레드의 이름

        System.out.println(this.memory);  //현재 필드값 확인

    }// setMemory e
}//c e
