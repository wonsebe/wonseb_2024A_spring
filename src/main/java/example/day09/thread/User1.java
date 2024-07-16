package example.day09.thread;

public class User1 extends Thread {
    //멤버변수 선언
    Calculator calculator;
    int value;

    @Override
    public void run() {
      calculator.setMemory(value);
    }//r e
}//c e
