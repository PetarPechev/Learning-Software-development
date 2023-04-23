package com.company.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
          // output: [1, 2, 3]

        arr = Arrays.copyOf(arr, 6);
        System.out.println(arr.length);             // output: 6
        System.out.println(Arrays.toString(arr));   // output: [1, 2, 3, 0, 0, 0]



    }
}