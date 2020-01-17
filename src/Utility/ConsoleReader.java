package Utility;

import java.util.Scanner;

public class ConsoleReader {
    public static int readInt() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        return a;
    }
    public static double readDouble() {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        return a;
    }
    public static String readString() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        return a;
    }
}
