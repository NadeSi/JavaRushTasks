package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent);

        ArrayList<File> fileArray = new ArrayList();
        fillFileArray(path, fileArray);
        fileArray.sort(Comparator.comparing(File::getName));

        for(File file: fileArray){
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read());
            }
            fileOutputStream.write(System.lineSeparator().getBytes());
            fileOutputStream.flush();
            fileInputStream.close();
        }
        fileOutputStream.close();

    }

    private static void fillFileArray(File fileFolder, ArrayList<File> fileArray) {
//        long minFileLength = 50;
        if(!fileFolder.isDirectory()){return;}

        for (File file : fileFolder.listFiles()) {
            if (file.isDirectory()) {
                fillFileArray(file, fileArray);
            } else {
                if (file.length() <= 50) {
                    fileArray.add(file);
                }else {
                    FileUtils.deleteFile(file);
                }
            }
        }

    }
}
