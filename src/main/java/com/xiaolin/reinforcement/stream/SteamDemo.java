package com.xiaolin.reinforcement.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lzh
 * @description:  Stream流操作
 * @date 2025/10/29 16:17
 */
public class SteamDemo {

    public static void main(String[] args) {
        List<String> maleList = new ArrayList<>();
        List<String> femaleList = new ArrayList<>();

        Collections.addAll(maleList,"张飞,21","关羽,24","刘备啊,26","曹操,28","夏侯惇,20","司马懿,21");
        Collections.addAll(femaleList,"小乔,18","大乔,19","孙尚香,20","杨貂蝉,21","杨玉环,21","杨琪拉,22");


        // 男演员只要名字3个字前两人
        List<String> filterMale = maleList.stream().filter(male -> 3 == (male.split(",")[0].length())).limit(2).toList();
        // 女演员只要名字性杨的，且不要第一个
        List<String> filterFemale = femaleList.stream().filter(female -> "杨".equals(female.split(",")[0].substring(0,1))).skip(1).toList();

        // 过滤的男女演员合并
        List<String> allPeople = new ArrayList<>(filterMale);
        allPeople.addAll(filterFemale);

        // 男演员只要名字3个字前两人
        Stream<String> maleStream = maleList.stream().filter(male -> 3 == (male.split(",")[0].length())).limit(2);
        // 女演员只要名字性杨的，且不要第一个
        Stream<String> femaleStream = femaleList.stream().filter(female -> "杨".equals(female.split(",")[0].substring(0, 1))).skip(1);

        // 合并流
        Stream<String> peopleStream = Stream.concat(maleStream, femaleStream);

        // 封装为Actor对象 并且保存到list
//        List<Actor> collect = allPeople.stream().map(new Function<String, Actor>() {
//            @Override
//            public Actor apply(String people) {
//                Actor actor = new Actor();
//
//                String[] split = people.split(",");
//                actor.setName(split[0]);
//                actor.setAge(Integer.parseInt(split[1]));
//
//                return actor;
//            }
//        }).toList();

        // 封装为Actor对象 并且保存到list
        List<Actor> collect = allPeople.stream().map(people -> {
                Actor actor = new Actor();
                String[] split = people.split(",");
                actor.setName(split[0]);
                actor.setAge(Integer.parseInt(split[1]));
                return actor;
        }).toList();
        System.out.println(collect);

        List<Actor> collect2 = peopleStream.map(people -> {
            Actor actor = new Actor();
            String[] split = people.split(",");
            actor.setName(split[0]);
            actor.setAge(Integer.parseInt(split[1]));
            return actor;
        }).toList();
        System.out.println(collect2);
    }

}
