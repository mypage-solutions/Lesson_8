package com.mykhailo;

public class HappyTickets {
    public static void main(String[] args) {

        findSumMatches1();
        findSumMatches2();

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

        for (int i = 0; i < 1000; i++) {
            arrayLeft[2] = i % 10;;
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
        System.out.println("The result is: " + count + "\n");
    }

    private static void findSumMatches2() {
        int count = 0;
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
        System.out.println("The result is: " + count);
    }
}

