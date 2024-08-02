package com.java.components.lang;

public class Null {
    public static final Null NULL = null;

    public Null() {
        
    }

    public boolean isNull() {
        return true;
    }

    public Null getNull() {
        return NULL;
    }

    @Override
    public String toString() {
        return null;
    }
}
