package epn.edu.ec.controller;

import java.io.InputStream;
import java.util.Scanner;

public final class Scaner {

    private static Scanner scanner;

    public static void open(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public static void close() {
        scanner.close();
    }

    public static String leerEntrada() {
        return scanner.nextLine();
    }
}


