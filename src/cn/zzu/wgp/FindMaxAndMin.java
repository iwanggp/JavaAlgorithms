package cn.zzu.wgp;

/**
 * Created by wgp on 2016/11/26.
 * 寻找数组中最大的和最小的值
 */
public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 33, 55, 65, 776, 22, 123, 323};
        findMaxAndMin(arr);
    }

    public static void findMaxAndMin(int[] arr) {
        int max, min;
        max = min = arr[0];//将第一个元素赋值为最大值和最小值
        for (int i = 0, len = arr.length; i < len; i++) {//将len在初始化语句中，这样避免反复的计算，提高效率
            if (min > arr[i])
                min = arr[i];
            if (max < arr[i])
                max = arr[i];
        }
        System.out.println("最大的值为");
        System.out.println(max);
        System.out.println("最小的值为");
        System.out.print(min);
    }


}
