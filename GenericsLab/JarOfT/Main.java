package Generics.Lab.JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Jar<Integer> jar = new Jar();
        jar.add(12);
        jar.add(13);
        jar.add(14);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

        Jar<String> secondJar = new Jar<>();
    }
}
