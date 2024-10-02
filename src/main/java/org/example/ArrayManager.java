package org.example;

public class ArrayManager {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }


    private static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = arr[low + (high - low) / 2];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] > middle) {
                i++;
            }
            while (arr[j] < middle) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }
}
