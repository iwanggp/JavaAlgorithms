package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by wgp on 16/11/7.
 * 快速排序算法：
 * 该算法的主要思想是首先定义两个指针分别从两边遍历数组如果右边的数字比左边的大则右边的左移
 * 否则左边的指针右移，这样最终形成了左边一部分都比基准值小，右边都比基准值大然后递归调用即可
 * 快速排序的时间复杂度为O(logn)是不稳定的排序算法
 */
public class QuickSort {

    /**
     * 快速排序算法实现
     *
     * @param m    待排序的数组
     * @param left 左指针
     * @param high 右指针
     */
    public static void quickSort(int[] m, int left, int high) {
        if (left > high) {//如果左指针大于右指针则直接退出,这样也就不必下文中的判断了
            return;
        }
        int i = left, j = high;
        int temp = m[left];
        while (i < j && m[j] >= temp) {
            j--;
        }
        if (i < j) {
            m[i++] = m[j];
        }
        while (i < j && m[i] <= temp) {
            i++;
        }
        if (i < j) {
            m[j--] = m[i];
        }
        m[i] = temp;
        quickSort(m, 0, i - 1);//递归调用
        quickSort(m, i + 1, high);//递归调用
    }

    public static void main(String[] args) {
        int[] m = {12, 3, 9, 8, 76, 5, 42, 37, 34, 333, 90};
        System.out.println("排序前");
        System.out.println(Arrays.toString(m));
        quickSort(m, 0, m.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(m));
    }
}
