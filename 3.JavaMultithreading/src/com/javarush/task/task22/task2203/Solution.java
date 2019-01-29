package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            if(string == null) throw new TooShortStringException();
            return string.substring(string.indexOf("\t")+1, string.indexOf("\t", string.indexOf("\t")+1));
        }catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
//        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java."));
//        System.out.println(getPartOfString("JavaRush \t- лучший сервис обучения Java.\t"));
        System.out.println(getPartOfString("JavaRush \t- лучший сервис обучения Java."));
//        System.out.println(getPartOfString("JavaRush"));
//        System.out.println(getPartOfString(null));
    }
}
