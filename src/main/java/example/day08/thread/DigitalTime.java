package example.day08.thread;

import java.time.LocalDateTime;

public class DigitalTime extends Thread {

    @Override
    public void run() {
        // === 멀티 스레드가 처리할 코드들 ===//
        while (true){
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }//w r
    }//r e
}//c e
