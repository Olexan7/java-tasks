/**
 * Лекция 2. Задание 3: Массив объектов
 * + Генерация массива объектов длинной N в классе GetPeople default N = 10000
 * + Свойства объектов age name sex
 * + Единый интерфейс Sort
 * -- Методы сортировки (не разобрался как реализовать условие для сортировки с несколькими правилами)
 * интерфейс Sort
 *  класс GetPeople - получаем массив объектов
 * класс MySort - создаёт два массива мужчин и женщин. Сортируются по возрасту с помощью метода 'Сортировка выбором'
 *
 * @autor Кондратьев Адександр ВМ-41
 * @version 1.0
 */
package com.company;

import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GetPeople getPeople = new GetPeople(); //создаем объект класса GetPeople
        Person[] person = getPeople.GetPeople(); // получаем массив объектов в person

        //SortBubble sortBubble = new SortBubble();
        //sortBubble.Sort(person); //Выволняем соритровку пузырьком

        SortMy sortMy = new SortMy(); //('все, на что хватило ума')
        sortMy.Sort(person);
    }

}

class SortBubble implements Sort{

    @Override
    public void Sort(Person[] person) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < person.length - 1; i++) {
                if (person[i].age < person[i + 1].age) {
                    temp = person[i].age;
                    person[i].age = person[i + 1].age;
                    person[i + 1].age = temp;
                    sorted = false;
                }
            }
        }
    }
}

class SortMy implements Sort{

    @Override
    public void Sort(Person[] person) {
        long startTime = System.currentTimeMillis(); // время начала сортировки

        ArrayList<Person> personSortMan = new ArrayList<>();
        ArrayList<Person> personSortWoman = new ArrayList<>();

        for(int i = 0; i< person.length; i++){ //делим массив: мужчины и женщины
            if(person[i].sex.equals("man")){
                personSortMan.add(person[i]);
            }
            else{
                personSortWoman.add(person[i]);
            }
        }

       for (int i = 0; i < personSortMan.size(); i++) { //Сортировка выбором по возрасту мужчин
            int min = personSortMan.get(i).age;
            int minId = i;
            for (int j = i + 1; j < personSortMan.size(); j++) {
                if (personSortMan.get(j).age > min) {
                    min = personSortMan.get(j).age;
                    minId = j;
                }
            }
            // замена
            int temp = personSortMan.get(i).age;
            personSortMan.get(i).age = min;
            personSortMan.get(minId).age = temp;
       }

       for (int i = 0; i < personSortWoman.size(); i++) { //Сортировка выбором по возрасту женщин
            int minWoman = personSortWoman.get(i).age;
            int minIdWoman = i;
            for (int j = i + 1; j < personSortWoman.size(); j++) {
                if (personSortWoman.get(j).age > minWoman) {
                    minIdWoman = j;
                    minWoman = personSortWoman.get(j).age;
                }
            }
            // замена
            int tempWoman = personSortWoman.get(i).age;
            personSortWoman.get(i).age = minWoman;
            personSortWoman.get(minIdWoman).age = tempWoman;
       }

        ArrayList<Person> people = new ArrayList<>(); //объединяем отсортированные массивы в один
        people.addAll(personSortMan);
        people.addAll(personSortWoman);

        for(int i = 0; i<people.size(); i++){ //цикл вывода
            for(int j = 0; j<people.size(); j++){
                if(people.get(i).name.equals(people.get(j).name) && people.get(i).age == people.get(j).age && i!=j){ //исключение если данные совпадают
                    try {
                        throw new IdenticalValueException("Such data is available" + " : " + people.get(j).name + " : " + people.get(j).age);
                    } catch (IdenticalValueException e) {
                        e.printStackTrace();
                    }
                    people.remove(j); //удалить объект из массива
                }
            }
            System.out.println("Person № " + i + ": Name: " + people.get(i).name + " Age: " + people.get(i).age + " Sex: " + people.get(i).sex);
        }
        long timeSpent = System.currentTimeMillis(); //время конда сортировки
        System.out.println("Sorting time :" + (timeSpent - startTime) + "ms");
    }

    class IdenticalValueException extends Exception { //класс исключения
        public IdenticalValueException(String message){
            System.out.println(message);
        }
    }
}


class GetPeople{ // получаем объектов класса Person
    static int N = 10000; //количество объектов
    static Random rand = new Random();

    public Person[] GetPeople(){ //метод возвращает массив объектов
        Person[] person = new Person[N]; //массив объектов длинной N

        for(int i = 0; i < N; i++){
            person[i] = new Person();
            person[i].age =  rand.nextInt(100); //свойство: возраст до 100
            person[i].name = getAlphaNumericString(10); //свойство: рандомное имя
            Sex sex = new Sex(); //(""не разобрался как сделать объект класса свойством другого класса"")
            person[i].sex = sex.Sex((int) (Math.random()*10)%2); //свойство: случайный пол
        }
        return person;
    }

    class Sex  {
        final String MAN = "man"; //константы пола
        final String WOMAN = "woman";

        public String Sex(int index){ //переменная 1 возвращаем man 0 - woman
            if(index == 1) return MAN;
            else if(index == 0) return WOMAN;
            else return WOMAN;
        }
    }

    // функция для генерации случайной строки длиной n
    static String getAlphaNumericString(int n){
        // выбрал символ случайный из этой строки
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        // создаем StringBuffer размером AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // генерируем случайное число между
            // 0 переменной длины AlphaNumericString
            int index = (int)(AlphaNumericString.length() * Math.random());
            // добавляем символ один за другим в конец sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
