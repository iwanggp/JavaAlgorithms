package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by Wgp on 2016/11/07.
 * 归并算法：
 * 首先将一个数组进行递归归并，常见的就是一分为二然后递归调用，最终则是两两一组。最后再将分组后的进行排序即可
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * 归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，算法不是自适应的，不需要对数据的随机读取。
 */
public class MergeSort {
   /**
    * 分治算法就是递归调用这个算法然后进行排序的
    *
    * @param m     要排序的数组
    * @param left  最左边的指针
    * @param right 最右边的指针
    */
   public static void sort(int[] m, int left, int right) {
      if (left >= right) {
         return;//如果左指针大于右指针则直接返回，不执行下面的语句，这一行代码比较好
      }
      int mid = (left + right) >> 1;//采用右移的方式快速的折半
      //递归调用下面的两个方法
      sort(m, left, mid);
      sort(m, mid + 1, right);
      merge(m, left, mid, right);//排序
   }

   public static void merge(int[] m, int left, int mid, int right) {
      int[] temp = new int[right - left + 1];//定义一个零时数组，记住这时不能是m因为m此时已经被划分了
      int i = left, j = mid + 1, k = 0;//分别定义三个指针操作数组
      while (i <= mid && j <= right) {
         if (m[i] <= m[j]) {
            temp[k++] = m[i++];
         } else {
            temp[k++] = m[j++];
         }
      }
      while (i <= mid) {
         temp[k++] = m[i++];
      }
      while (j <= right) {
         temp[k++] = m[j++];
      }
      //将排序好的数组重新赋值给m,这样起到节省空间的作用
      for (int k2 = 0, len = temp.length; k2 < len; k2++) {
         m[k2 + left] = temp[k2];
      }
   }

   public static void main(String[] args) {
      int[] m = {23, 232, 2, 1, 323, 222, 5454, 65, 22, 2, 4};
      sort(m, 0, m.length - 1);
      System.out.println(Arrays.toString(m));
   }
}
