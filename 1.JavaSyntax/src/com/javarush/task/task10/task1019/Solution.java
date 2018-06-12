package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String idSt = reader.readLine();
                if (idSt.isEmpty()) {
                    break;
                }
                String name = reader.readLine();
                int id = Integer.parseInt(idSt);
                hashMap.put(name, id);
                if (name.isEmpty()) {
                    break;
                }
            }
        }catch (Exception e){}


        for(HashMap.Entry<String, Integer> pair : hashMap.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
//        System.out.println("Id=" + id + " Name=" + name);
    }
}
