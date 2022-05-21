package com.cascado.lesson1;

public class Robot implements Running, Jumping{

    private String name;

    public Robot(String name){
        this.name = name;
    }

    @Override
    public void jump(Wall wall) {
        System.out.printf("Robot %s jumps.\n", name);
    }

    @Override
    public void run(Treadmill treadmill) {
        System.out.printf("Robot %s runs.\n", name);
    }

}
