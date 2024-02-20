import java.util.logging.Logger;
public class Fibonacci {
    private static Logger log = Logger.getLogger(Fibonacci.class.getName());

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

    public static int recursiveFibonacci(int n) {
        if (n <= 1)
            return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

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

        int n = 40;
        startTime = System.currentTimeMillis();
        System.out.println("Fibonacci of " + n + " is: " + iterativeFibonacci(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time for iterativeFibonacci = " + (endTime - startTime) + "\n");

        startTime = System.currentTimeMillis();
        System.out.println("Fibonacci of " + n + " is: " + recursiveFibonacci(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time for recursiveFibonacci = " + (endTime - startTime) + "\n");

        startTime = System.currentTimeMillis();
        System.out.println("Fibonacci of " + n + " is: " + dynamicProgrammingFibonacci(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time for dynamicProgrammingFibonacci = " + (endTime - startTime));
    }


}
