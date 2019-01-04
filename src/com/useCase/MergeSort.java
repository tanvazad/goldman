package com.useCase;


public class MergeSort {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    public static void mergeSort(int a[],int low, int high) {
            int N = high - low;
            if (N <= 1)
                return;
            int mid = low + N/2;
            // recursively sort
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
            // merge two sorted sub-Arrays
            int[] temp = new int[N];
            int i = low, j = mid;
            for (int k = 0; k < N; k++)
            {
                if (i == mid)
                    temp[k] = a[j++];
                else if (j == high)
                    temp[k] = a[i++];
                else if (a[j]<a[i])
                    temp[k] = a[j++];
                else
                    temp[k] = a[i++];
            }
            for (int k = 0; k < N; k++)
                a[low + k] = temp[k];
        }

    public static void main(String args[]) throws Exception{
        int arr[] = {1,7,3,10,3,6};
        System.out.println("\nElements for sorting ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        mergeSort(arr, 0, arr.length);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        //test
        MergeSort mergeSort = new MergeSort();     

    }   

}
