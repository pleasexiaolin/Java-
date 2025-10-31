package com.xiaolin.reinforcement.quote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lzh
 * @description: 方法引用demo
 * @date 2025/10/31 9:21
 */
public class QuoteDemo {

    public static void main(String[] args) {
        // 排序
        Integer[] arr = {3, 2, 1, 5, 4};

        // 匿名内部类
        //Arrays.sort(arr, new Comparator<Integer>() {
        //    @Override
        //    public int compare(Integer o1, Integer o2) {
        //        return o1 - o2;
        //    }
        //});

        // lambda表达式
        //Arrays.sort(arr, (Integer o1, Integer o2)->{
        //    return o1 - o2;
        //});

        //简化lambda表达式
        //Arrays.sort(arr, (o1, o2) -> o1 - o2);

        // 方法引用 标识应用quoteDemo类里的compare方法
        // 把这个方法当作抽象方法的方法体
        //Arrays.sort(arr, QuoteDemo::compare);

        //for (Integer i : arr) {
        //    System.out.println(i);
        //}

        List<String> list = new ArrayList<>();

        Collections.addAll(list,"2", "1", "3", "5", "4");

        //List<Integer> list1 = list.stream().map(Integer::parseInt).toList();
        //System.out.println(list1);

    }

    private int compare(Integer a, Integer b) {
        return a - b;
    }
}
