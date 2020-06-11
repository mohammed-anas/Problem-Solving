package com.programming;

import java.util.Arrays;

public class SortedMerge {


    // Approach One  -  Use system Array Copy and sort the Array.
    // O(N) + O(NLogN) 
    private static int[] sortedMergedArray1(int[] primaryArrayWithExtraBuffer, int[] secondaryArray ){
        int destPos = primaryArrayWithExtraBuffer.length - secondaryArray.length;
        System.arraycopy(secondaryArray,0,primaryArrayWithExtraBuffer,destPos,destPos);
        Arrays.sort(primaryArrayWithExtraBuffer);
        return primaryArrayWithExtraBuffer;
    }

    // Approach Second -  Compare elements from both array until one exhaust
    // O(N)
    private static int[] sortedMergedArray2(int[] primaryArrayWithExtraBuffer, int[] secondaryArray){
        int primaryArrayRightIndex = 0;
        int fillingIndex = primaryArrayWithExtraBuffer.length-1;
        int secondaryArrayRightIndex = secondaryArray.length-1;
        for (int i = 0;; i++) {
            if(primaryArrayWithExtraBuffer[i] == 0)
                primaryArrayRightIndex = i;
            break;
        }
        while(primaryArrayRightIndex >= 0 || secondaryArrayRightIndex >= 0 ){
            if(secondaryArray[secondaryArrayRightIndex] >=  primaryArrayWithExtraBuffer[primaryArrayRightIndex]){
                primaryArrayWithExtraBuffer[fillingIndex--] = secondaryArray[secondaryArrayRightIndex--];
            }else
                primaryArrayWithExtraBuffer[fillingIndex--] = primaryArrayWithExtraBuffer[primaryArrayRightIndex--];
        }
        return primaryArrayWithExtraBuffer;
    }
    public static void main(String[] args) {
        int[] primaryArray = {1,2,3,4,0,0,0,0};
        int[] secondaryArray = {5,6,7,8};
        for (int i : sortedMergedArray2(primaryArray, secondaryArray)) {
            System.out.print(i);
        }
    }

}
