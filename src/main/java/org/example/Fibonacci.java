package org.example;

import java.util.logging.Logger;
public class Fibonacci {
    private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());

//    Просторова складність: O(1) (використовується постійна кількість пам'яті)
//    Часова складність: O(n) (де n - номер числа Фібоначчі, яке потрібно обчислити)
    public static int iterativeFibonacci(int n) {
        if (n <= 1)
            return n;
        int fib = 1;
        int prevFib = 1;
        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

//    Просторова складність: O(n) (залежить від глибини рекурсії)
//    Часова складність: O(2^n) (експоненціальна, оскільки викликається дві функції рекурсивно)
    public static int recursiveFibonacci(int n) {
        if (n <= 1)
            return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

//    Просторова складність: O(n) (необхідний масив розміром n для зберігання значень)
//    Часова складність: O(n) (необхідно виконати n операцій для обчислення всіх значень)
    public static int dynamicProgrammingFibonacci(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;

        int n = 10;
        startTime = System.currentTimeMillis();
        LOGGER.info("Fibonacci of " + n + " is: " + iterativeFibonacci(n));
        endTime = System.currentTimeMillis();
        LOGGER.info("Time for iterativeFibonacci = " + (endTime - startTime) + "\n");

        startTime = System.currentTimeMillis();
        LOGGER.info("Fibonacci of " + n + " is: " + recursiveFibonacci(n));
        endTime = System.currentTimeMillis();
        LOGGER.info("Time for recursiveFibonacci = " + (endTime - startTime) + "\n");

        startTime = System.currentTimeMillis();
        LOGGER.info("Fibonacci of " + n + " is: " + dynamicProgrammingFibonacci(n));
        endTime = System.currentTimeMillis();
        LOGGER.info("Time for dynamicProgrammingFibonacci = " + (endTime - startTime));
    }
}
