package com.cascado.lesson1;

public class Human implements Jumping, Running {

    private String name;
    private int maxHeight;
    private int maxDistance;

    Human(String name, int maxHeight, int maxDistance) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxDistance = maxDistance;
    }


    @Override
    public void jump(Wall wall) {
        if (maxHeight >= wall.getHeight()) {
            System.out.printf("Human %s jumps over the wall.\n", name);
        } else {
            System.out.printf("Human %s can't jump over the wall.\n", name);
        }
    }

    @Override
    public void run(Treadmill treadmill) {
        if (maxDistance >= treadmill.getDistance()) {
            System.out.printf("Human %s runs %d meters.\n", name, treadmill.getDistance());
        } else {
            System.out.printf("Human %s can't run %d meters.\n", name, treadmill.getDistance());
        }
    }

}
