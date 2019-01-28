package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        File fileFolder = new File(root);
        for (File file : fileFolder.listFiles()){
            if(file.isDirectory()){

            }else {
                fileTree.add(file.getName());
            }
        }
        return fileTree;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("D:\\projects");
        for (String fileName: list) {
            System.out.println(fileName);
        }
    }
}
