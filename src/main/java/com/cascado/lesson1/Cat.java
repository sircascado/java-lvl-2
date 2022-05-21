package com.cascado.lesson1;

public class Cat implements Jumping, Running{

    private String name;

    public Cat(String name){
        this.name = name;
    }

    @Override
    public void jump(Wall wall) {
        System.out.printf("Cat %s jumps.\n", name);
    }

    @Override
    public void run(Treadmill treadmill) {
        System.out.printf("Cat %s runs.\n", name);
    }
}
