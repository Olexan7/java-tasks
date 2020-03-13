package com.company;

public class Main {
    static int N = 100; //количество элементов

    public static void main(String[] args) {

        /**
         * Массив уникальных элементов длинной N
         * @param N количесто элементов;
         * @param arrayNumber массив
         */

        int iteration = 0;
        double[] arrayNumber = new double[N];
        double newUniqueElem;
        boolean checkUnique;
        while (iteration != N) {
            checkUnique = true;
            newUniqueElem = (int) (Math.random() * 1000);
            for (Double arrayElem : arrayNumber) {
                if (arrayElem == newUniqueElem) {
                    checkUnique = false;
                }
            }
            if (checkUnique) {
                arrayNumber[iteration] = newUniqueElem;
                iteration++;
            }
        }

        /*Задание 1*/
        MathBox mathBox = new MathBox(arrayNumber); //вход получает массив Number
        mathBox.summator();
        mathBox.console();
        mathBox.splitter(2);
        mathBox.console();


        /*Задание 2*/
        /*создаем примеры объектов*/
        ExampleObjectClass first = new ExampleObjectClass(1, true, "first");
        ExampleObjectClass second = new ExampleObjectClass(2, false, "second");
        ExampleObjectClass third = new ExampleObjectClass(3, true, "third");
        ExampleObjectClass fourth = new ExampleObjectClass(4, false, "fourth");
        ExampleObjectClass fifth = new ExampleObjectClass(5, true, "fifth");

        ObjectBox objectBox = new ObjectBox();//объект класса ObjectBox
        /*Добавляем объекты*/
        objectBox.addObject(first); //вызов метода добавления
        objectBox.addObject(second);
        objectBox.addObject(third);
        objectBox.addObject(fourth);

        //objectBox.deleteObject(first); //вызов метода удаления. Удаляем объект first
        objectBox.deleteObject(fifth); // вызов методы удаления. Попытка удалить несуществующий объект коллекции
        objectBox.dump(); //

        /*try{

        }catch (Exception e)*/
    }
}

class ExampleObjectClass{ //класс для создания объектов (взят для примера)
    /*свойства*/
    int propertyInt;
    boolean propertyBool;
    String propertyString;

    /*консруктор*/
    public ExampleObjectClass(int propertyInt, boolean propertyBool, String propertyString){
        this.propertyInt = propertyInt;
        this.propertyBool = propertyBool;
        this.propertyString = propertyString;
    }
}
