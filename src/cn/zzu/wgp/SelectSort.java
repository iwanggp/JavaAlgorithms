package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/07.
 * 选择排序算法：
 * 该算法的主要思想就是将数组的第一元素依次与数组的其它元素进行比较，然后循环遍历即可
 * 该算法是不稳定的算法 时间复杂度为O(n*n)
 */
public class SelectSort {
   /**
    * 选择排序算法，该算法主要关注两个循环即可，外循环和内循环
    *
    * @param m
    */
   public static void selectSort(int[] m) {
      System.out.println("排序前");
      System.out.println(Arrays.toString(m));
      for (int i = 0, len = m.length; i < len - 1; i++) {//注意：因为最后一个元素每次都要比较一次，故最后一个元素无需再比较了，故为len-1
         for (int j = i + 1; j < len; j++) {
            if (m[i] > m[j]) {
               int temp = m[i];
               m[i] = m[j];
               m[j] = temp;
            }
         }
      }
      System.out.println("排序后");
      System.out.println(Arrays.toString(m));
   }

   public static void main(String[] args) {
      int[] m = {2, 23, 232, 3, 5, 52, 33, 232};
      selectSort(m);
   }
}
