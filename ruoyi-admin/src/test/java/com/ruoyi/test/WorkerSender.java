package com.ruoyi.test;

import java.util.*;

public class WorkerSender {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next(); // 每次调用 next() 才会获取下一个元素
            System.out.println(element);
        }
    }
}
