package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {

    private static int COUNT_V = 366;
    private static int COUNT_NV = 365;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int yeaar = Integer.parseInt(bufferedReader.readLine());
        int countDaysOfYear;

        if(yeaar%400 == 0){
            countDaysOfYear = COUNT_V;
        }else if(yeaar%100 == 0){
            countDaysOfYear = COUNT_NV;
        }else if(yeaar%4 == 0) {
            countDaysOfYear = COUNT_V;
        }else {
            countDaysOfYear = COUNT_NV;
        }

        System.out.println("количество дней в году: " + countDaysOfYear);
    }
}