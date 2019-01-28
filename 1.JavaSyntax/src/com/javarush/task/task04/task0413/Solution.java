package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> daysOfWeek = new HashMap<Integer, String>();
        daysOfWeek.put(1, "понедельник");
        daysOfWeek.put(2, "вторник");
        daysOfWeek.put(3, "среда");
        daysOfWeek.put(4, "четверг");
        daysOfWeek.put(5, "пятница");
        daysOfWeek.put(6, "суббота");
        daysOfWeek.put(7, "воскресенье");

        int number = Integer.parseInt(bufferedReader.readLine());

        if(daysOfWeek.get(number) != null){
            System.out.println(daysOfWeek.get(number));
        }else  {
            System.out.println("такого дня недели не существует");
        }
    }
}