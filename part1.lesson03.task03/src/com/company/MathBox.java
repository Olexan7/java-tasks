package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathBox  extends ObjectBox{
    public Set<Double> number = new HashSet<>();
    public double[] arrayNumber;


    public MathBox(double[] arrayNumber){
        this.arrayNumber = arrayNumber;

        for(int i = 0; i < arrayNumber.length; i++){
            number.add(arrayNumber[i]);
        }
    }

    public void console(){ //метод вывода в консоль
        System.out.print("Elements Collection: ");
        for(Double index: number){
            System.out.print(index + " : ");
        }
        System.out.println();
    }

    public Double summator(){ //(сумматор) сумма всех элементов коллекции
        double sum = 0;
        Iterator<Double> iterator = number.iterator();
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        System.out.println("Sum elements: " + sum);
        return sum;
    }

    public void splitter(Integer divider){ //поочередное деление
        Set <Double> numberEdit = new HashSet<>(); //промежуточный Set
        double dividNumber; //результат деления

        for(Double set: number){ //делим элементы
            dividNumber = set / divider;
            numberEdit.add(dividNumber);//
        }

        number.clear(); //удаляем все элементы
        number.addAll(numberEdit);//добавляем новые значения
    }


    public void removeElement (Integer element){ //метод удаления значеия из коллекции
        if(number.contains(element)) { // проверка на тоБ есть ли элемент в коллекции
            number.remove(element); //если есть - удаляем
            System.out.println("Element: " + element + "deleted from Collection");
        }
        else { //если нет - ничего не делаем
            System.out.println("Element: " + element + " not found");
        }
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
