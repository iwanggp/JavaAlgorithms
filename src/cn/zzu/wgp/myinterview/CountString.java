package cn.zzu.wgp.myinterview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by wgp on 2016/11/19.
 * 一家公司的面试题统计所有文件夹下单词出现的频率
 * 当时考虑不周，想的有点复杂我当时没有想到递归遍历文件夹，而是循环遍历
 */
public class CountString {
    private static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();//定义一个成员变量hashMap

    /**
     * 主函数
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File distin = new File("D:\\StringFiles");//要遍历的文件夹
        recursionFiles(distin);//调用递归遍历文件夹函数
        sortHashMap(hashMap);//将结果按照值排序这里按照从大到小进行排序
    }

    /**
     * 将结果存进hashMap中
     *
     * @param path 文件的绝对路径
     * @throws Exception
     */
    public static void getResult(String path) throws Exception {

        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            line.toLowerCase();//将结果转换为小写
            String[] strs = line.split("\\b");//区分单词
            for (String str : strs) {
                if (!hashMap.containsKey(str)) {//如果hashMap不包括该单词，则记为1
                    hashMap.put(str, 1);
                } else {
                    hashMap.put(str, hashMap.get(str) + 1);//如果hashMap中已经有该值了，则加一
                }
            }
        }
    }

    /**
     * 递归遍历文件夹
     * 注意： 递归也有缺点一定要慎重的，递归就是自己调用自己的方法。首先方法入栈，但是如果调用过多的话则会StackOverflow，栈溢出的风险，这一点一定要注意
     *
     * @param dir 传一个文件对象
     * @throws Exception 操作文件跑出异常
     */
    public static void recursionFiles(File dir) throws Exception {
        File[] filesList = dir.listFiles();//显示文件列表
        //开始遍历文件
        for (int i = 0, len = filesList.length; i < len; i++) {
            //如果是文件夹的则，递归调用
            if (filesList[i].isDirectory()) {
                recursionFiles(filesList[i]);
            } else {
                //否则调用函数向hashMap中存值
                String fileAbPath = filesList[i].getAbsolutePath();
                getResult(fileAbPath);
            }
        }

    }

    /**
     * 将hashMap按照值进行排序
     *
     * @param hashMap 要排序的hashMap
     * @throws UnsupportedEncodingException
     */
    public static void sortHashMap(HashMap<String, Integer> hashMap) throws UnsupportedEncodingException {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());//定义一个列表
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {//进行排序
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());//比较两个的值
            }
        });
        for (Map.Entry<String, Integer> _map : list) {
            if (!(_map.getKey().equals(" ") || _map.getKey().equals(",") || _map.getKey().equals("."))) {//先去掉空格和逗号和句号，以后考虑用正则表达式先这样写
                System.out.println(new String(_map.getKey().getBytes(), "utf-8") + "::" + _map.getValue());
            }
        }
    }
}
