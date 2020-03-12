package com.company;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox {
    Set<Object> object = new HashSet<>(); //интерфейс Set

    public void addObject(Object objectNew){ //метод добавления нового объекта
        if(!object.contains(objectNew)) { //проверка на наличие объекта
            object.add(objectNew); // add - метод коллекции
            System.out.println("Object: " + objectNew + " added");
        }
        else{
            System.out.println("Object: " + objectNew + " exists");
        }
    }

    public void deleteObject(Object objectDelete){ //метод удаления
        if(object.contains(objectDelete)){ // проверем, есть ли объект
            object.remove(objectDelete);
            System.out.println("Object: " + objectDelete + " deleted");
        }
        else{
            System.out.println("Object: " + objectDelete + " not found");
        }
    }

    public void dump(){ //метод - вывод объектов в строку
        System.out.print("All Objects: ");
        for (Object elem : object){
            System.out.print(elem + " | ");
        }
    }
}
