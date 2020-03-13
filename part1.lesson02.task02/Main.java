/**
 * Лекция 2. Задание 2
 * Генерация исключений корня от отрицательного числа
 * @autor Кондратьев Александр ВМ-41
 * @version 1.0
 */

package com.company;

import java.util.Random;

public class Main {
    static int N = 100;

    public static void main(String[] args) {

        byte [] arrayNumber = new byte [N]; // массив для хранения чисел длинной N
        Random rand = new Random ();
        rand.nextBytes(arrayNumber); //запоняем масссив значениями

        for(int j = 0; j < N; j++){ // перебираем все числа
            try{
                int k = (int) arrayNumber[j]; // присваиваем значение переменной k
                if(k < 0){
                    throw new ArithmeticException("Элемент № " + j + ": " + " Error " + k + " <0"); //выбрасываем исключенее если k отрицательное
                }

                int q = (int) Math.sqrt(k);
                if(q*q == k){
                    System.out.println("Элемент № " + j + ": k = " + k); //вывести если q^2 равняется k
                }
            }
            catch (ArithmeticException e){
                System.out.println(e); // выводим исключение, созданное в блоке try
            }
        }
    }
}

