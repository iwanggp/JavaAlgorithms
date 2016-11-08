package cn.zzu.wgp;

/**
 * Created by wgp on 16/11/7.
 * 折半查找算法，该算法的前提是必须是有序的数组
 */
public class BinFind {

    public static int binFind(int[] m, int key) {
        int len = m.length;
        int left = 0, mid, right = len - 1;//定义三个指针分别代表左指针，右指针和中间指针
        mid = len >> 1;//右移一位
        while (left <= right) {
            if (m[mid] < key) {
                mid = mid + 1;
            } else {
                mid = mid - 1;
            }
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] m = {1, 3, 4, 5};
        System.out.println(binFind(m, 5));
    }
}
