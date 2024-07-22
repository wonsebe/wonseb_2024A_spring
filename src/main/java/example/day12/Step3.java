package example.day12;

import java.util.*;

public class Step3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <User> list=new LinkedList<>();


        while (true){

            System.out.print("1.등록 2. 전체출력 3. 수정 4. 삭제");
                int ch= scan.nextInt();

                if (ch==1){
                    System.out.println("이름:"); String name =scan.next();
                    System.out.println("나이:"); int age= scan.nextInt();
                    User user = new User();
                    user.name=name; //담기
                    user.age=age;
                    list.add(user); //저장



                }
                else if (ch==2) {
                for (int i=0; i<list.size(); i++){
                    System.out.printf("%d %d %s", i, list.get(i).age, list.get(i).name);
                }

                }
                else if (ch==3) {

                    System.out.print("수정할 인덱스"); int index= scan.nextInt();

                    try {
                        User user=list.get(index);
                        System.out.println("수정할나이:"); int age=scan.nextInt();
                        user.age=age; //수정내용 담기
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("존재하지 않는 인덱스");
                    }

                }
                else if (ch==4) {

                    System.out.print("삭제할인덱스:"); int index=scan.nextInt();
                    try {
                        list.remove(index);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("존재하지 않는 잍덱스");
                    }
                }
                else {
                    System.out.println(">>없는 기능입니다.");
                }

            }

        }
    }
