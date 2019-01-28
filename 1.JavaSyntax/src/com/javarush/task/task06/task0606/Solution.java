package com.javarush.task.task06.task0606;

import java.io.*;
import java.lang.reflect.Array;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bis.readLine());

        Body.count(number);

    }

    public static class Body {
        public static void count(int number) {
            for (char ch: String.valueOf(number).toCharArray()) {
                if(Character.getNumericValue(ch)%2 == 0){
                    even++;
                }else{
                    odd++;
                }
            }
            System.out.printf("Even: " + even + " Odd: " + odd);

        }
    }
}
