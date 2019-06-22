package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки

В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.

Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        String fileName1 = "D:\\projects\\JavaRushTasks\\forTest\\file_win1251.txt";
 //       String fileName2 = "D:\\projects\\JavaRushTasks\\forTest\\file_utf8.txt";

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
//        byte[] buffer = new byte[1000];

        //Создаем поток-чтения-байт-из-файла
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        byte[] bytesInp = new byte[fileInputStream.available()]; //метод  available возвращает количество непрочитанных (доступных) байт
        fileInputStream.read(bytesInp);
        String s = new String(bytesInp, windows1251);
        byte[] bytesOut = s.getBytes("UTF-8");
        fileOutputStream.write(bytesOut); // и записать его во второй поток

        //закрываем оба потока. Они больше не нужны.
        fileInputStream.close();
        fileOutputStream.close();
    }

}
