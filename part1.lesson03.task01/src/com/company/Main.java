/**
 * Лекция 3(Дженерики) Задание 1
 * Генерируем уникальные значения (массив)
 *  Класс MathBox: конструктор принимает коллекцию
 *  метод console - вывод в консоль всех элементов
 *  метод splitter - поочередное деление элементов
 *  метод removeElement - удаление элемента коллекции. В качестве аргумента принимает делитель. default 2
 *
 * @autor Кондратьев Александр ВМ-41
 */

package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N = 100; //количество элементов

    public static void main(String[] args) {

        Set<Double> numberSet = new HashSet<>();
        for(int i = 0; i < N; i++){
            numberSet.add(Math.random()*1000);
        }

        MathBox mathBox = new MathBox(numberSet);
        mathBox.summator();
        mathBox.console();
        mathBox.splitter(2);
    }
}
