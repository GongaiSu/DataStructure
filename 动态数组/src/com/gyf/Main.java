package com.gyf;

/**
 * 动态数组主函数入口
 * @author 龚燕飞
 * @date 2021/9/22
 */
public class Main {
    public static void main(String[] args) {
        ArrayListTest<Integer> listTest = new ArrayListTest();
        listTest.add(11);
        listTest.add(22);
        System.out.println(listTest.get(1));
        listTest.set(1,33);
        System.out.println(listTest);
        System.out.println(listTest.contains(33));

    }
}
