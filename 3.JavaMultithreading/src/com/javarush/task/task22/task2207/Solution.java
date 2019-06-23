package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова

В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять эти методы нельзя.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            //String fileName = "D:\\projects\\JavaRushTasks\\forTest\\task2207.txt";

            File file = new File(fileName);
            if(file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);

                byte[] bytesInp = new byte[fileInputStream.available()]; //метод  available возвращает количество непрочитанных (доступных) байт
                fileInputStream.read(bytesInp);
                str = new String(bytesInp, "UTF-8");

/*                while (fileInputStream.available() > 0){
                    char a = (char) fileInputStream.read();
                    str += a;
                }
*/
                //закрываем потоки после использования
                fileInputStream.close();

                String []  strList = str.replaceAll(System.lineSeparator(), " ").split(" ");

                for (int i = 0; i < strList.length; i++) {
                    StringBuilder stringBuilder = new StringBuilder(strList[i]);
                    stringBuilder.reverse();
                    for (int j = i + 1; j < strList.length; j++) {
                        if(strList[j].equals(stringBuilder.toString())) {
                            Pair pair = new Pair();
                            pair.first = strList[i];
                            pair.second = strList[j];
                            if (!result.contains(pair) && !result.contains(Pair.reversePlace(pair))){
                                result.add(pair);
                            }
                            //result.add(pair);
                        }
                    }
                }

                for (Pair p : result) {
                    System.out.println(p.first + " " + p.second);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        public static Pair reversePlace(Pair pair) {
            String s = pair.first;
            pair.first = pair.second;
            pair.second = s;
            return pair;
        }
    }

}
