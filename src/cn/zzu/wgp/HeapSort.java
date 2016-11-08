package cn.zzu.wgp;

import java.util.Arrays;

/**
 * Created by wgp on 16/11/8.
 * <p>
 * 堆排序算法：
 * 该算法的主要思想是：建堆，先将初始文件建成一个大根堆为初始的无序堆
 */
public class HeapSort {


    /**
     * 交换两个数组元素的值
     *
     * @param data 原始数组
     * @param i    第一个数组的角标
     * @param j    第二个数组的角标
     */
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void createHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;//首先记录当前节点
            //判断当前节点的子节点是否存在
            while (2 * k + 1 <= lastIndex) {
                //biggerindex记录总是记录最大节点的值，首先赋值给当前节点的子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    //若右节点存在
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //若右节点的值比左节点的值大则最大索引应该是右节点的
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void heapSort(int[] data) {
        for (int i = 0, len = data.length; i < len; i++) {
            createHeap(data, len - 1 - i);
            swap(data, 0, len - 1 - i);
        }
    }

    public static void main(String[] args) {
        int[] m = {2, 3, 1, 55, 66, 334, 9};
        System.out.println("排序前");
        System.out.println(Arrays.toString(m));
        heapSort(m);
        System.out.println("排序后");
        System.out.println(Arrays.toString(m));

    }
}
