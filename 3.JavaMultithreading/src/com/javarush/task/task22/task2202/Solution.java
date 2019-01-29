package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
//        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        try {
            if (string == null) throw new TooShortStringException();
            if(string.split(" ").length - 1  < 4) throw new TooShortStringException();
            int lastIndex = 0;
            for (int i = 0; i < 5; i++) {
                lastIndex = string.indexOf(" ", lastIndex);
                if (lastIndex == -1) {
                    if (i < 4) {
                        throw new TooShortStringException();
                    }else {lastIndex = string.length();}
                }else {lastIndex++;}
            }
            return string.substring(string.indexOf(" "), lastIndex).trim();
        }catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
