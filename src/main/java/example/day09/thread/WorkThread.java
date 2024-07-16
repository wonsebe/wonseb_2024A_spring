package example.day09.thread;

public class WorkThread extends Thread {

    public boolean work =true;

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            if (work){
                System.out.println(getName()); //현재 스레드의 이름을 호출
            }else {
                Thread.yield(); ///다른 스레드에게 순서양보
            }//else e
        }//w e
    }//r e
}//c e
