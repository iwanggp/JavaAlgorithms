package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/07.
 * 最基础的冒泡排序算法：
 * 该算法的主要思想就是两两比较每次选择一个最大或者最小的
 * 该算法是稳定的，时间复杂度为O(n*n)
 */
public class BuddleSort {
   public static void buddleSort(int[] m) {
      System.out.println("排序前");
      System.out.println(Arrays.toString(m));
      for (int i = 0, len = m.length; i < len - 1; i++) {//因为最后一个每次都要比较所以最后一个无需再比较了
         for (int j = 0; j < len - i - 1; j++) {
            if (m[j] > m[j + 1]) {
               int temp = m[j];
               m[j] = m[j + 1];
               m[j + 1] = temp;
            }
         }
      }
      System.out.println("排序后：");
      System.out.println(Arrays.toString(m));
   }

   public static void main(String[] args) {
      int[] m = {2, 44, 33, 2, 232, 21, 67, 678};
      buddleSort(m);
   }
}
