package com.cascado.lesson5;

import java.util.Arrays;

public class MultithreadingHomework {
    public static void main(String[] args) {
        firstArrayMultithreading();
        secondArrayMultithreading();
    }

    public static void firstArrayMultithreading(){

        final int size = 20000000;
        final int h = size / 2;
        float[] array = new float[size];
        Arrays.fill(array, 1);

        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        int runTime = (int) (end - start);
        System.out.printf("First method run time: %d millis.\n", runTime);

    }

    public static void secondArrayMultithreading(){

        final int size = 20000000;
        final int half = size / 2;
        float[] array = new float[size];
        Arrays.fill(array, 1);

        float[] firstHalfArray = new float[half];
        float[] secondHalfArray = new float[half];

        new Thread(() -> {
            long startFirstArraySplit = System.currentTimeMillis();
            System.arraycopy(array, 0, firstHalfArray, 0, half);

            for (int i = 0; i < firstHalfArray.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            System.arraycopy(firstHalfArray, 0, array, 0, half);
            long endFirstArraySplit = System.currentTimeMillis();
            int firstArrayRunTime = (int) (endFirstArraySplit - startFirstArraySplit);
            System.out.printf("Run time first half array: %d millis.\n", firstArrayRunTime);
        }).start();

        new Thread(() -> {
            long startSecondArraySplit = System.currentTimeMillis();
            System.arraycopy(array, half, secondHalfArray, 0, half);

            for (int i = 0; i < secondHalfArray.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            System.arraycopy(secondHalfArray, 0, array, half, half);
            long endSecondArraySplit = System.currentTimeMillis();
            int secondArrayRunTime = (int) (endSecondArraySplit - startSecondArraySplit);
            System.out.printf("Run time second half array: %d millis.\n", secondArrayRunTime);
        }).start();

    }
}
