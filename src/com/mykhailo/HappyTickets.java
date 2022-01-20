package com.mykhailo;

import java.util.Arrays;

public class HappyTickets {
    public static void main(String[] args) {

        findSumMatches1();
        findSumMatches2();
        findSumMatches3(100000000);
        findSumMatches4(100000000);
        findSumMatches5();

    }

    /*
    2) Найти количество счастливых билетиков на трамвай от 000001 до
       999999 - те у которых сумма первых 3 цифр равна сумме последних 3.
    */
    private static void findSumMatches1() {
        int count = 0;
        int[] arrayLeft = new int[3];
        int[] arrayRight = new int[3];
        int sumLeft;
        int sumRight;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            arrayLeft[2] = i % 10;
            arrayLeft[1] = (i - arrayLeft[2]) / 10 % 10;
            arrayLeft[0] = ((i - arrayLeft[2]) / 10 - arrayLeft[1]) / 10 % 10;
            sumLeft = arrayLeft[0] + arrayLeft[1] + arrayLeft[2];

            for (int j = 0; j < 1000; j++) {
                arrayRight[2] = j % 10;
                arrayRight[1] = (j - arrayRight[2]) / 10 % 10;
                arrayRight[0] = ((j - arrayRight[2]) / 10 - arrayRight[1]) / 10 % 10;
                sumRight = arrayRight[0] + arrayRight[1] + arrayRight[2];
                if (sumRight == sumLeft) {
                    count++;
                }
            }
        }
        double timeDifferenceSeconds = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println("The result is: " + count);
        System.out.printf("The execution time: %.3f s\n", timeDifferenceSeconds);
    }

    private static void findSumMatches2() {
        int count = 0;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int value1 = i / 100000 % 10;
            int value2 = i / 10000 % 10;
            int value3 = i / 1000 % 10;
            int value4 = i / 100 % 10;
            int value5 = i / 10 % 10;
            int value6 = i % 10;
            if ((value1 + value2 + value3) == (value4 + value5 + value6)) {
                count++;
            }
        }
        double timeDifferenceSeconds = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println("The result is: " + count);
        System.out.printf("The execution time: %.3f s\n", timeDifferenceSeconds);
    }

    /*
    If bus tickets numbers from 00000001 to 99999999
    */
    private static void findSumMatches3(int value) {
        int arrayCount = (int) Math.sqrt(value);
        int count = 0;
        char[] arrayLeft;
        char[] arrayRight;
        int sumLeft;
        int sumRight;

        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayCount; i++) {
            arrayLeft = ("" + i).toCharArray();
            sumLeft = 0;
            for (int j = 0; j < arrayLeft.length; j++) {
                sumLeft += arrayLeft[j] - 48;
            }

            for (int k = 0; k < arrayCount; k++) {
                arrayRight = ("" + k).toCharArray();
                sumRight = 0;
                for (int n = 0; n < arrayRight.length; n++) {
                    sumRight += arrayRight[n] - 48;
                }
                if (sumRight == sumLeft) {
                    count++;
                }
            }
        }
        double timeDifferenceSeconds = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println("The result is: " + count);
        System.out.printf("The execution time: %.3f s\n", timeDifferenceSeconds);
    }

    private static void findSumMatches4(int value) {
        int arrayCount = (int) Math.sqrt(value);
        int lengthOfArray = (String.valueOf(value).length() - 1) / 2;
        int count = 0;
        int[] arrayLeft = new int[lengthOfArray];
        int[] arrayRight = new int[lengthOfArray];
        int sumLeft = 0;
        int sumRight = 0;

        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayCount; i++) {
            int tempLeft;
            int tempLeft1;
            int tempLeft2;
            tempLeft = i;
            for (int n = 0; n < arrayLeft.length; n++) {
                tempLeft1 = tempLeft % 10;
                tempLeft2 = tempLeft - tempLeft1;
                arrayLeft[arrayLeft.length - n - 1] = tempLeft1;
                tempLeft = tempLeft2 / 10;
            }
            sumLeft = Arrays.stream(arrayLeft).sum();

            for (int j = 0; j < arrayCount; j++) {
                int tempRight;
                int tempRight1;
                int tempRight2;
                tempRight = j;
                for (int n = 0; n < arrayRight.length; n++) {
                    tempRight1 = tempRight % 10;
                    tempRight2 = tempRight - tempRight1;
                    arrayRight[arrayRight.length - n - 1] = tempRight1;
                    tempRight = tempRight2 / 10;
                }
                sumRight = Arrays.stream(arrayRight).sum();
                if (sumRight == sumLeft) {
                    count++;
                }
            }
        }
        double timeDifferenceSeconds = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println("The result is: " + count);
        System.out.printf("The execution time: %.3f s\n", timeDifferenceSeconds);
    }

    private static void findSumMatches5() {
        int count = 0;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            int value8 = i / 10000000 % 10;
            int value7 = i / 1000000 % 10;
            int value6 = i / 100000 % 10;
            int value5 = i / 10000 % 10;
            int value4 = i / 1000 % 10;
            int value3 = i / 100 % 10;
            int value2 = i / 10 % 10;
            int value1 = i % 10;
            if ((value1 + value2 + value3 + value4) == (value5 + value6 + value7 + value8)) {
                count++;
            }
        }
        double timeDifferenceSeconds = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println("The result is: " + count);
        System.out.printf("The execution time: %.3f s\n", timeDifferenceSeconds);
    }
}

