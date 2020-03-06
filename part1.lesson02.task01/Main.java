/**
 * Лекция 2. Задание 1: Генерация ошибок & Hello, World
 * @autor Кондратьев Александр ВМ-41
 * @version 1.0
 */

package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!"); //привет мир

        String unknownString = new String(); //пустая строка
        unknownString = null;

        try{
            if(unknownString == null) {
                throw new NullPointerException(); // обрабатываем исключение
            }
        }
        catch (NullPointerException e){
            System.out.println(e  + ": string is null"); //ввывод исключения
        }

       int[] falseArray = new int[5]; // массив длинной 5
        try{
            throw new ArrayIndexOutOfBoundsException(falseArray[5]); //обращаемся к несуществующему элементу
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e +  ": element does not exist");  // сообщение об ошибке
            throw e; // ошибка
        }
    }
}
