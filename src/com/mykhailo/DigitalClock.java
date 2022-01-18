package com.mykhailo;

public class DigitalClock {
    public static void main(String[] args) {

        findNumberOfMatches1();
        findNumberOfMatches2();

    }

    /*
    1) Электронные часы показывают время в формате от 00:00 до 23:59.
       Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается
       симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
    */
    private static void findNumberOfMatches1() {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            if (i % 10 < 6) {
                count++;
            }
        }
        System.out.println("The result is: " + count + "\n");
    }

    private static void findNumberOfMatches2() {
        StringBuilder minutes = new StringBuilder();
        StringBuilder hours = new StringBuilder();
        int count = 0;

        for (int i = 0; i < 24; i++) {
            hours.replace(0, 2, "");
            hours.append(i);
            if (hours.toString().length() == 1) {
                hours.insert(0, "0");
            }
            hours.reverse();

            for (int j = 0; j < 60; j++) {
                minutes.replace(0, 2, "");
                minutes.append(j);
                if (minutes.toString().length() == 1) {
                    minutes.insert(0, "0");
                }
                if (hours.toString().equals(minutes.toString())) {
                    hours.reverse();
                    System.out.println(hours.toString() + ":" + minutes.toString());
                    count++;
                    break;
                }
            }
        }
        System.out.println("\nThe result is: " + count);
    }
}