package test;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
    }
}
