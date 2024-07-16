package example.day09.thread;

public class SumThread extends  Thread {

    public int sum;


    //1~100 까지 누적합계 구하기
    @Override
    public void run() {
        for (int i=1; i<=100; i++){

            sum+=i; //누적합계
        }//f e
    }//r e
}//c e
