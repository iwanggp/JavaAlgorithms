package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/07.
 * 将两个有序的数组合并成一个新的有序的数组
 * 这是一个面试时要我写的算法，我平生最烦的就是当着人的面写代码，况且还是手写。真的很是郁闷。我当时的思路基本
 * 是正确的。但是还有一些问题是欠考虑的，当时一紧张做的很差劲的。现在回想起来真是不该，其实这个问题很简单的
 * 这是一种简单的归并算法，已经不需要归并了，直接合并即可
 */
public class OrderArraySort {
   /**
    * 归并并排序算法
    * 主要思想是：先创建一个临时的数组长度为两个数组的和
    * 首先分别定义两个指针分别遍历两个数组，如果一个数组的元素小于另一个数组的则将当前元素插入到新数组中
    * 这里有如下的情况当时我考虑的不好：就是如果一个数组的元素大于其中一个数组的其余元素或全部元素时
    * 这时实际上处理也是很简单。下面会介绍的。
    *
    * @param m 第一个有序的数组
    * @param n 第二个有序的数组
    * @return 返回排序后的数组
    */
   public static int[] orderArraySort(int[] m, int[] n) {
      int len1 = m.length, len2 = n.length;
      int[] temp = new int[len1 + len2];
      int i = 0, j = 0, k = 0;//分别定义三个指针分别操作三个数组
      /**
       * 分别遍历两个数组，并对两个数组的元素进行比较
       * 我当时是判断两个数组那个长度长些，当时考虑的复杂了，实际很简单的
       */
      while (i < len1 && j < len2) {
         if (m[i] <= n[j]) {
            temp[k++] = m[i++];
         } else {
            temp[k++] = n[j++];
         }
      }
      /**
       * 如下的两个方法只有一个执行，我当时考虑的是判断，实际不用这么复杂的。只需考虑
       * 数组是否遍历完即可，如果没有遍历完则证明该数组后的都是较大的数，直接遍历插入即可
       */
      while (i < len1) {
         temp[k++] = m[i++];
      }
      while (j < len2) {
         temp[k++] = n[j++];
      }
      return temp;

   }

   public static void main(String[] args) {
      int[] m = {2, 4, 6, 56, 66, 456};
      int[] n = {1, 20, 22, 24, 345, 3444};
      int[] result = orderArraySort(m, n);
      System.out.println(Arrays.toString(result));
   }
}
