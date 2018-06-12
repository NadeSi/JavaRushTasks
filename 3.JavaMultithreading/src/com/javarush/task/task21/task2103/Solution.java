package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!

Упростить. Переменные не переименовывать, комментарии не оставлять.


Требования:
1. Метод calculate должен быть статическим.
2. Метод calculate должен возвращать значение типа boolean.
3. Метод calculate должен принимать четыре параметра типа boolean.
4. Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (c && (!a || !b || d));
        return c;
    }

    public static void main(String[] args) {
/*
        System.out.println(calculate(false,false,false,true));       //0001
        System.out.println(calculate(false,false,true,false));       //0010
        System.out.println(calculate(false,false,true,true));        //0011
        System.out.println(calculate(false,true,false,false));       //0100
        System.out.println(calculate(false,true,false,true));        //0101
        System.out.println(calculate(false,true,true,false));        //0110
        System.out.println(calculate(false,true,true,true));         //0111
        System.out.println(calculate(true,false,false,false));       //1000
        System.out.println(calculate(true,false,false,true));        //1001
        System.out.println(calculate(true,false,true,false));        //1010
        System.out.println(calculate(true,false,true,true));         //1011
        System.out.println(calculate(true,true,false,false));        //1100
        System.out.println(calculate(true,true,false,true));         //1101
        System.out.println(calculate(true,true,true,false));         //1110
        System.out.println(calculate(true,true,true,true));          //1111
*/
    }
}
