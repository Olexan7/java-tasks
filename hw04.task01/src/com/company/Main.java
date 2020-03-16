/**
 * Лекция 4 Многопоточность. Задание 1: Факторил чисел
 *
 * Класс Main - распараллеливание вычислений для разных чисел. Для вычисления каждого числа создается своя нить
 *      константа N - количество элементов массива (в тестах использовал значение до 1000)
 *      метод getArrayNumber - генерация массива integer значений (в тестах использовал значения до 5000)
 *
 * Класс FactorialOfNumber - наследован от интерфейса Runnable
 *      метод calculate - считает факториала в цикле с созданием объекта BigInteger
 *
 * @autor Кондратьев Александр ВМ-41
 */

package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int N = 100; //длина массива

    public static void main(String[] args) {
	    int [] arrayNumber = getArrayNumber(N); //массив чисел

        ExecutorService executorService = Executors.newFixedThreadPool(N); //пулл нитей
        // В методе newFixedThreadPool указываем количество потоков N

        /**в пулл помещаем тот поток, который хотим запустить*/
	    for(int i = 0; i< N; i++) {
            executorService.submit(new FactorialOfNumber(arrayNumber[i], i));
        }
        executorService.shutdown(); // закрытие пула
    }

    /**генерация массива случайных чисел*/
    public static int[] getArrayNumber(int N){
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = (int) (Math.random() * 500);
        }
        return array;
    }
}
