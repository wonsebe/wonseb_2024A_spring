package example.day12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Step4 {

    //HashSet

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<User>set=new HashSet<>();
        while (true){

            System.out.print("1.등록 2. 전체출력 3. 수정 4. 삭제");
            int ch= scan.nextInt();

            if (ch==1){
                System.out.println("이름:"); String name =scan.next();
                System.out.println("나이:"); int age= scan.nextInt();
                User user = new User();
                user.name=name; //담기
                user.age=age;
               set.add(user);



            }
            if (ch==2) {
               set.forEach(user -> {System.out.printf("%s\t%d\n",user.name, user.age); });

            }
            if (ch==3) {

                System.out.print("수정할 이름"); String  name= scan.next();
                set.forEach(user ->
                {
                    if (user.name.equals(name)){
                    System.out.println("수정할나이: ");
                    int age = scan.nextInt();
                    user.age = age;
                }
                });

            }
            if (ch==4) {
                System.out.print("삭제할 이름 :"); String name = scan.next();
                set.forEach(user ->
                {
                    if (user.name.equals(name)){
                       set.remove(user);
                    }
                });
            }

        }
    }
}
