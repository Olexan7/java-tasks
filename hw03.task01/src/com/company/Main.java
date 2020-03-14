/**
 * Лекция Коллекции, Задание 1: Картотека животных
 * Класс AnimalCardIndex - класс картотеки животных
 *      метод addNewAnimal - добавление нового животного
 *      метод searchByNick - поиск по кличке
 *      метод editAnimal - изменить данные по идентификатору
 *      метод sortConsole - сортировка и вывод: Хозяин > Кличка > Вес
 *  Класс Animal - класс животных
 *  Классн CompAnimal - отдельны класс, который реализует интерфейс Comparator и сравнирает объекты по различным полям
 * @autor Кондратьев Александр ВМ-41
 */

package com.company;

public class Main {

    public static void main(String[] args) {

        /**Объекты класса Person - хозяева животных*/
        Person charles = new Person("Charles", 25,"man");
        Person gloria = new Person("Gloria",40, "woman");
        Person diego = new Person("Diego", 56, "man");
        Person fred = new Person("Fred",15, "man");
        Person sofia = new Person("Sofia",31,"woman");
        Person neil = new Person("Neil", 17,"man");
        Person ada = new Person("Ada",60, "woman");


        /**Картотека животных*/
        AnimalCardIndex animalCardIndex = new AnimalCardIndex(); //объект класса CardIndex - картотека живатных
        animalCardIndex.addNewAnimal("Barsik", 5, charles);
        animalCardIndex.addNewAnimal("Sharik",12, fred);
        animalCardIndex.addNewAnimal("Ryzhik",7, diego);
        animalCardIndex.addNewAnimal("Pesik", 1, gloria);
        animalCardIndex.addNewAnimal("Maks", 2, sofia);
        animalCardIndex.addNewAnimal("Masha",4, fred);
        animalCardIndex.addNewAnimal("Murka", 6, ada);
        //animalCardIndex.addNewAnimal("Barsik", 5, charles); // попытка добавить дубликат

        //animalCardIndex.searchByNick("Murka"); //вызов метода поиска по нику

        animalCardIndex.editAnimal(2, "Reks", 10, neil); //вызов метода изменения данных по индексу
        animalCardIndex.sortConsole(); // вызов метода вывода отсортированной коллекции
    }
}

class Person{
    String name; //имя хозяина
    int age; // возраст хозяина
    String sex; //пол хозяина

    public Person(String name, int age, String sex){ //конструктор для добаления объекта Person - хозяин
         this.name = name;
         this.age = age;
         this.sex = sex;
    }

    @Override
    public String toString() {
        return "[name: " + name + "; age: " + age + "; sex: " + sex + "]";
    }

    public String getName(){
        return name;
    }
}
