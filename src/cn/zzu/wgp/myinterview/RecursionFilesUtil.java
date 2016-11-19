package cn.zzu.wgp.myinterview;//package cn.zzu.myinterview;
//
//import java.io.File;
//
///**
// * Created by wgp on 2016/11/19.
// * 一个递归遍历文件下的所有文件
// */
//public class RecursionFilesUtil {
//    private static String fileAbPath;
//
//    public static String showAllFiles(File dis) throws Exception {
//        File[] filesList = dis.listFiles();
//        for (int i = 0, len = filesList.length; i < len; i++) {
//            fileAbPath = filesList[i].getAbsolutePath();
//            return fileAbPath;
//            if (filesList[i].isDirectory()) {
//                try {
//                    String s = showAllFiles(filesList[i]);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return fileAbPath;
//    }
//}
