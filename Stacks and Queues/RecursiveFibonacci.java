package StacksAndQueues.Exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long [] memoryForFib;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long[n+1];
        System.out.println(fib(n));
    }
    public static  long fib (int n){
        if(n <= 1){
            return 1;
        }
        if(memoryForFib[n] != 0){
            //имаме го изчислено на индекс n запазваме стойността
            return memoryForFib[n];
        }else{
            //нямаме го в паметта
            return memoryForFib[n] = fib(n-1)+fib(n-2);
        }
    }
}
