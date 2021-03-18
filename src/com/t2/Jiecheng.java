package com.t2;

import java.util.Arrays;

public class Jiecheng {
    /**
     * @descripton 求n以内的阶乘
     * @param num
     * @author
     * @date 2021/3/15 18:30
     * @return void
     */
    public static  void getCount(int num){
        int strap=1;
        for (int i=num;i>1;i--){
                strap=strap*i;
                System.out.println("strap"+i+"："+strap);
            }
        System.out.println(strap);
    }
    /**
     * @description 求n以内的累加和
     * @param start 起始值
     * @param end 末尾值
     * @author
     * @date 2021/3/16 17:59
     * @return void
     */
    public static void getAdd(int start ,int end){
        int count;
        if (start ==0 ){
            start+=1;
        }
            count=(start+end)*end/2;
            System.out.println(count);
    }

    /**
     * @description 求输入字符串的单词个数
     * @param a
     */
    public static void getCode(String a){
        String[] b=a.split(" ");
    System.out.println("总长度："+b.length+"，值"+Arrays.toString(b));
}
    public static void main(String[] args) {
//        Jiecheng.getCount(20);
//        Jiecheng.getCode("hello word");
        Jiecheng.getAdd(1,100);
    }
}
