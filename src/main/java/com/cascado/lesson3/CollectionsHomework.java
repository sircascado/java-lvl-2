package com.cascado.lesson3;

import java.util.*;

public class CollectionsHomework {

    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();
        book.add("Harrison", "2657674");
        book.add("Truman", "4546543");
        book.add("Jackson", "2556746");
        book.add("Nixon", "1232154");
        book.add("Harrison", "5746362");
        book.add("Johnson", "3563573");

        System.out.println(book.get("Johnson"));
        System.out.println(book.get("Harrison"));

    }

    private static void count(){

        List<String> list = new ArrayList<>
                (Arrays.asList("Java", "Python", "C#", "Java", "Java", "Java",
                        "C#", "C#", "Python", "C++", "C#"));

        int java, cs, cpp, python;
        java = cs = cpp = python = 0;

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("Java")) java++;
            else if (str.equals("Python")) python++;
            else if (str.equals("C#")) cs++;
            else if (str.equals("C++")) cpp++;
        }

        System.out.printf("Java - %d times.\n" +
                        "Python - %d times.\n" +
                        "C# - %d times.\n" +
                        "C++ - %d times.\n",
                java, python, cs, cpp);
    }
}
