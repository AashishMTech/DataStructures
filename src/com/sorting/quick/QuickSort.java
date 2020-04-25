package com.sorting.quick;

public class QuickSort {

	
	public static void QuickSort(int[] arr ,int low, int high) {
		if(low<high) {
			int part = partition(arr, low, high);
			QuickSort(arr, low, part-1);
			QuickSort(arr, part+1, high);
		
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot =  high;
		int i = low -1;
		for (int j = low; j<=high;j ++) {
			if(arr[j] <= arr[pivot]) {
				i++;
				int temp = arr[i] ;
				arr[i] = arr[j];
				arr[j]= temp;
			}
		}
		return i;
		
	}
	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}
}
