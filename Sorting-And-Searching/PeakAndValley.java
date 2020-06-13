package com.programming;

import java.util.Arrays;

public class PeakAndValley {

    public static int[] peakAndValley(int[] arr) {
        if (arr.length <= 2)
            return arr;
        Arrays.sort(arr);
        int[] second = new int[arr.length];
        second[0] = arr[0];
        int low = 1;
        int high = arr.length-1;
        int i = 1;
        boolean toggle = true;
        while(low <= high){
            if(toggle)
                second[i++] = arr[high--];
            else
                second[i++] = arr[low++];
            toggle = !toggle;
        }

        return second;
    }

    public static void main(String[] args) {

        int[] arr = {5,2,3};
        int[] result = peakAndValley(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
