package example.day12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Step5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Integer>map=new HashMap<>();

        //HashMap
        while (true){

            System.out.print("1.등록 2. 전체출력 3. 수정 4. 삭제");
            int ch= scan.nextInt();

            if (ch==1){
                System.out.println("이름:"); String name =scan.next();
                System.out.println("나이:"); int age= scan.nextInt();
                User user = new User();
                user.name=name; //담기
                user.age=age;
              map.put(name,age);

            }
            if (ch==2) {
                map.keySet().forEach(key -> {System.out.printf("%s\t%d\n", key, map.get(key)); });

            }
            if (ch==3) {

                System.out.print("수정할 이름"); String  name= scan.next();
                map.keySet().forEach(key ->
                {
                    if (key.equals(name)){
                        System.out.println("수정할나이: ");
                        int age = scan.nextInt();
                        map.put(key, age);
                        //map.replace(key,age); //수정

                    }
                });

            }
            if (ch==4) {
                System.out.print("삭제할 이름 :"); String name = scan.next();
                        map.remove(name);
            }
    }





    }
}
