package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class AnimalCardIndex {
    List<Animal> listAnimal = new ArrayList<>();

    /** метод - добавление нового животного*/
    public void addNewAnimal(String nickName, double weight, Person owner){
        Animal animal = new Animal();
        animal.nickName = nickName;
        animal.weight = weight;
        animal.owner = owner;

        /**проверка на уникальность и добавление нового животного*/
        boolean unique = true;
        for(Animal elem : listAnimal){
            if(elem.weight == animal.weight && elem.nickName.equals(animal.nickName)){
                unique = false;
                try {
                    throw new IllegalArgumentException(); // исключении при добавлении дубликата
                }
                catch (IllegalArgumentException e){
                    System.out.println(e + ": " + animal.nickName + ": This Animal has already been added");
                }
            }
        }
        if(unique){
            listAnimal.add(animal);
        }
    }

    /**метод поиска животного по нику*/
    public void searchByNick(String nick){
        for(Animal element : listAnimal){
            if (element.nickName.equals(nick)){
                System.out.println("Nicname: " + element.nickName + "; Weight: " + element.weight + "; Owner: " + element.owner.toString());
            }
        }
    }
    /**метод изменения данных*/
    public void editAnimal(int id, String newNick, double newWeight, Person newOwner){
        Animal animal = new Animal();
        animal.nickName = newNick;
        animal.weight = newWeight;
        animal.owner = newOwner;
        listAnimal.set(id, animal);
    }

    /**метод сортировки. Поля: хозяин, кличка животного, вес*/
    public void sortConsole(){
        Collections.sort(listAnimal,new CompAnimal());
        for(Animal e : listAnimal){
            System.out.println(e.toString());
        }
    }
}

/**Класс Comparator для сортировки*/
class CompAnimal implements Comparator<Animal>{
    @Override
    public int compare(Animal o1, Animal o2) {
        int flag = o1.owner.getName().compareTo(o2.owner.getName()); //сортировка по имени хозяина
        if (flag == 0) flag = o1.getNick().compareTo(o2.getNick()); //если имена равны - сортировка по кличке
        if (flag == 0) flag = (int) (o1.weight - o2.weight); // если одинаковая кличка - сортировка по весу
        return flag;
    }
}

/**Класс Animals - хранит для хранения объектов животных*/
class Animal{
    String nickName; //кличка животного
    Person owner; // хозяин - объект класса Person
    double weight; // вес животного

    public String getNick (){ //получить кличку
        return nickName;
    }

    /**Переопределение метода toString*/
    @Override
    public String toString() {
        return "Nicname: " + nickName + "; Weight: " + weight + "; Owner: " + owner.toString();
    }
}