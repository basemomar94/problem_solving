package com.example.problemsolving;

import static java.sql.DriverManager.println;
import static kotlin.io.ConsoleKt.readLine;

public class Test {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int i;
        double d;
        String s;
        i = Integer.parseInt(readLine());
        d = Double.parseDouble(readLine());
        s = readLine();
        println(String.valueOf((i + d)));
        println(String.valueOf(d*2));
        println(s);

    }
}
