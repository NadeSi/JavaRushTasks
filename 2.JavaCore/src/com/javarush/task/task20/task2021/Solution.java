package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
//Класс Solution должен поддерживать интерфейс Serializable
public class Solution implements Serializable {
    //Класс SubSolution должен быть создан внутри класса Solution
    //Класс SubSolution должен быть потомком класса Solution.
    public static class SubSolution extends Solution {
    }

    public static void main(String[] args) {

    }
}
