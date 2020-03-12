/**
 * Лекция 3 - Дженерики; Задание 2 - Создать класс ObjectBox, который будет хранить коллекцию Object
 *Класс ObjectBox - для хранения объектов используется множество Set с коллекцией(экземпляром) object
 * метод addObject - добавляет объект; deleteObject - удаляет объект; dump - добавляет объект в коллецию
 * @autor Кондратьев Александр ВМ-41
 * @version 1.0
 */

package com.company;

public class Main {

    public static void main(String[] args){
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
        objectBox.deleteObject(fifth); // вызов методы удаления. Попытка удалить несуществующий объект
        objectBox.dump(); //
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
