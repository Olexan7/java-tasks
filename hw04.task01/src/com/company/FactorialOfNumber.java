package com.company;

import java.math.BigInteger;

class FactorialOfNumber implements  Runnable{
    int number; //элемент массива
    int numberThread; //номер нити

    /**в конструктор получаем число и номер, под которым была запущена нить*/
    public FactorialOfNumber(int number, int numberThread){
        this.number = number;
        this.numberThread = numberThread;
    }

    /**Имплементация метода run - именно он выполняется в рамках потока*/
    @Override
    public void run() {
        /**вывод в консоль*/
        System.out.println("Number of thread " + numberThread + " : Factorial " + number + " equal " + calculate(number));
    }

    /**Метод подсчета факториала числа*/
    private BigInteger calculate(int numberForFactor) {
        BigInteger result = BigInteger.valueOf(1);

        for (long i = 1; i <= numberForFactor; i++) {
            BigInteger factor = BigInteger.valueOf(i);
            result = result.multiply(factor);
        }
        return result;
    }


}
