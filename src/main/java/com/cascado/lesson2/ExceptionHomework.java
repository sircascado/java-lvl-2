package com.cascado.lesson2;

import java.util.Arrays;

public class ExceptionHomework {

    private static int sum = 0;

    public static void main(String[] args) {

        String[][] array2 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "s", "1", "1"}
        };

        try {
            arraySizeExc(array2);
        } catch (MyArraySizeException e) {
            System.out.println("Array isn't [4][4]");
        } catch (MyArrayDataException e) {
            System.out.println(sum);
        }
    }

    public static void arraySizeExc(String[][] array) throws MyArrayDataException {

        // 1
        if (array.length == 4) {
            for (int i = 0; i < array.length; i++) {

                if (array[i].length != 4) {
                    throw new MyArraySizeException("Array isn't 4x4.");
                }

            }
        } else {
            throw new MyArraySizeException("Array isn't 4x4.");
        }

        // 2
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                try {
                        sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Array [%d][%d] can't be convert to int.", i, j));
                }

            }

        }

        System.out.println(sum);

    }
}
