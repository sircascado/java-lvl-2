package com.cascado.lesson1;

public class Homework {

    public static void main(String[] args) {

        Object[] barriers = new Object[6];
        Human[] members = new Human[3];

        members[0] = new Human("Robert",150, 1400);
        members[1] = new Human("Phil",210, 1800);
        members[2] = new Human("John",270, 2240);

        barriers[0] = new Wall(50);
        barriers[1] = new Wall(150);
        barriers[2] = new Wall(250);
        barriers[3] = new Treadmill(500);
        barriers[4] = new Treadmill(1500);
        barriers[5] = new Treadmill(2000);

        Cat murka = new Cat("Murka");
        Robot bender = new Robot("Bender");

        murka.jump((Wall) (barriers[1]));
        murka.run((Treadmill) (barriers[3]));

        bender.jump((Wall) (barriers[1]));
        bender.run((Treadmill) (barriers[3]));

        System.out.println("---------------------");

        for (Human member : members) {

            for (Object barrier : barriers) {

                if (barrier instanceof Wall) {

                    member.jump((Wall) (barrier));


                } else {

                    member.run((Treadmill) (barrier));

                }

            }

        }


    }

}
