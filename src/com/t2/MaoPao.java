package com.t2;

import java.util.Arrays;

public class MaoPao {
 /**
  * @description 冒泡算法
  * @param num
  * @author
  * @date 2021/3/10 20:01
  * @return void
  */
    public static void shorts(int[] num){
        if (num==null || num.length<2){
            return;
        }
        for( int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if (num[j]>num[j+1]){
                    int temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }

    /**
     * @description 插入排序
     * @param b
     * @author
     * @date 2021/3/9 8:05
     * @return void
     */

    public static void chalu(int[] b){
        if (b==null||b.length<2){
            return;
        }
        for (int i=0;i<b.length-1;i++){
            int curr=b[i+1];
            int index=i;
            while (index >=0 && curr<b[index]){
                b[index+1]=b[index];
                index--;
            }
            b[index+1]=curr;
        }
        System.out.println(Arrays.toString(b));
    }
    public static void main(String[] args) {
        int[] a= {24,5,2,1,8,4,3,9,6,2,4,9,0};
        MaoPao.shorts(a);
        MaoPao.chalu(a);
    }
}
