package com.example.code;

import static com.java.components.Prints.println;
import com.java.components.lang.Boolean;

public class App {
    public static void main(String[] args) {
        Boolean test = new Boolean(false);
        println(test.equals(false, false, false));
    }
}