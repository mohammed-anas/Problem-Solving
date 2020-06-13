package com.programming;

public class UnboundedSortedSearch {

    public static int searchNumber(int[] arr,int num){

        if(arr.length == 0)
            return -1;
        if(arr[0] == num)
            return 0;
        int low = 1;
        return binarySearch(arr,1,2,num);
    }

    // Time Complexity - O(LogN) * O(LogN)
    // Space Complexity  - O(LogN)
    private static int binarySearch(int[] arr, int low, int high,int num){

        int index = -1;
        while(low <= high){
            int mid  = low + (high-low)/2;
            if(arr[mid] == num) {
                index = mid;
                break;
            }
            else if(num < arr[mid])
                high = mid-1;
            else if(num > arr[mid])
                low = mid+1;
        }
        if(index >= 0)
            return index;
        else
            return binarySearch(arr,high+1,2*high,num);
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(searchNumber(arr,4));
    }
}
