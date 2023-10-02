package com.example.homework1;
public class number1 {
    public static void main(String[] args) {
        int sum1 = calculate(1000);
        System.out.println(sum1);
    }
    public static int calculate(int limit) {
        int sum2 = 0;
        for (int i = 0; i <= limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum2 += i;
            }
        }
        return sum2;
    }
}
