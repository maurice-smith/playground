package com.kingmo.recursiontest;

public class RecursionChallenge {
    private static int sumNumbers(int maxNumber) {
        if (maxNumber >= 0) {
            return maxNumber + sumNumbers(maxNumber - 1);
        } else {
            return 0;
        }
    }

    private static String reverserString(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int m = s.length() - 1; m >= 0; m--) {
            stringBuilder.append(s.charAt(m));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("sum: " + sumNumbers(5));

        System.out.println("reverse: " + reverserString("kenny man"));
    }
}
