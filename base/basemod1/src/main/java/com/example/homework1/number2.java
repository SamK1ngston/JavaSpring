package com.example.homework1;
public class number2 {
    public static void main(String[] args) {
        int[][] a = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };
        int min1 = search(a);
        System.out.println("Min element is: " + min1);
    }
    public static int search(int[][] arr) {
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min2) {
                    min2 = arr[i][j];
                }
            }
        }
        return min2;
    }
}

