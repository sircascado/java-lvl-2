package com.cascado.lesson3;

import java.util.*;

public class PhoneBook {

    Map<String, Set<String>> book = new TreeMap<>();

    public void add(String name, String number){

        book.put(name, Collections.singleton(number));

    }

    public Set<String> get(String name){
            return book.get(name);
    }

}
