package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by Wgp on 2016/11/07.
 * 简单插入排序该算法的主要思想是：
 * 首先遍历元素将新的元素插入到已经有序的数组中，遍历完已经有序的元素然后插入到合适的位置。
 * 插入排序算法的复杂度为O(n*n),是个稳定的排序算法
 */
public class InsertSort {
    /**
     * 简单插入排序
     *
     * @param m 要排序的数组
     */
    public static void insertSort(int[] m) {
        System.out.println("排序前：");
        System.out.println(Arrays.toString(m));
        int len = m.length;
        int temp = 0;
        for (int i = 1; i < len; i++) {//从第二个元素开始遍历
            temp = m[i];
            int j = i - 1;//当前元素的前一个元素
            for (; j >= 0 && temp < m[j]; j--) {
                m[j + 1] = m[j];//将大的值覆盖掉小的值
            }
            m[j + 1] = temp;
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(m));
    }

    public static void main(String[] args) {
        int[] m = {34, 2, 4, 5, 6, 1, 54};
        insertSort(m);
    }
}
