package example.day12;

import java.util.*;
import java.util.stream.Collectors;

public class Step2 {

    public static void main(String[] args) {

//        //1. Map 컬렉션 객체
//        Map<String, Integer> map = new HashMap<>();
//        //2.
//        map.put("유재석", 85);
//        map.put("홍길동", 90);
//        map.put("강호동", 100);
//        map.put("신동엽", 90); //value 의 값은 중복이 가능하다.
//        map.put("유재석", 70); //key 값 중복이면 기존 key 가 제거되고 새로운 값이 덮어씌워짐
//
//        System.out.println("map = " + map);
//        //3.
//        int size = map.size();
//        System.out.println("size = " + size);
//        //4.
//        int point = map.get("강호동");
//        System.out.println("point = " + point);
//        //5.
//        map.remove("강호동");
//        System.out.println("map = " + map);
//
//        //6.
//        Set<String> keys = map.keySet();
//        System.out.println("keys = " + keys);
//
//
//        Collection<Integer> values = map.values();
//        System.out.println("values = " + values);
//
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        System.out.println("entries = " + entries);
//        //entries = [홍길동=90, 유재석=70, 신동엽=90]
//
//
//
//        //map 객체내 엔트리 순회
//        //(1)
//        Iterator<String> rs = map.keySet().iterator();
//        String key = rs.next(); //key
//        System.out.println(key);
//        System.out.println(map.get(key)); //값
//        //홍길동
//        //90
//
//        for (Integer value : map.values()) {
//            System.out.println("value = " + value);
//
//        }
//        //value = 90
//        //value = 70
//        //value = 90
//
//        for (String  key1 : map.keySet()){
//            System.out.println(key1);
//            System.out.println(map.get(key1));
//        }
//        //홍길동
//        //90
//        //유재석
//        //70
//        //신동엽
//        //90
//
//        map.keySet().forEach(key2 -> {
//            System.out.println(key2);
//            System.out.println(map.get(key2));
//        });
//        //홍길동
//        //90
//        //유재석
//        //70
//        //신동엽
//        //90
//
//        map.keySet().stream().map(key3 -> {
//            System.out.println(key3);
//            System.out.println(map.get(key3));
//            return key3;
//        }).collect(Collectors.toSet());
////        홍길동
////        90
////        유재석
////        70
////        신동엽
////        90


        //(2)
        //실습

    }




}
