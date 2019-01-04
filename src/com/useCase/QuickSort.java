package com.useCase;

public class QuickSort {

    public static void main(String args[]){

        QuickSort q = new QuickSort();
        int[] arr ={16,3,6,1,5,8,19};
        System.out.println("given array");
        printArray(arr);

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        q.sort(arr , 0,arr.length-1);
        System.out.println("");
        System.out.println("sorted array");
        printArray(arr);
    }

    private  void sort(int[] arr, int low, int high) {

        if(low<high){
            //pi - partition index
            int pi=partition(arr,low,high);
            //recursive call to sort for left and right partition
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }

    static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+ arr[i]);
            System.out.print("");
        }
    }

     int  partition(int[] arr, int low, int high) {

        int i=low-1;
        int pivot = arr[high];
        for(int j=0;j<high;j++) {
            //if current is <= pivot
            if (arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

            int temp=arr[i+1];
            arr[i+1]=arr[high];
            arr[high]=temp;

            return i+1;
    }
}

