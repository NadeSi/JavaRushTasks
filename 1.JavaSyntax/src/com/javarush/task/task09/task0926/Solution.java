package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        int[] arraysLength = {5, 2, 4, 7, 0};
        for(int listL : arraysLength){
            int[] newList = new int [listL];
            for(int j=0;j<listL;j++){
                newList[j]=j;
            }
            arrayList.add(newList);
        }

        return arrayList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
