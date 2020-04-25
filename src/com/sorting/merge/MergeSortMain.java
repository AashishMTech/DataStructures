package com.sorting.merge;

public class MergeSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {10, 3, 2,12,24,56, 5, 8, 4, 3, 1, 2, 9,11, 7, 8};

		System.out.println("User entered Array: ");
		MergeSort.printArray(array);

		long start = System.nanoTime();
		MergeSort.mergeSort(array, 0, array.length-1);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end-start));

		System.out.println("\nAfter sorting: ");
		MergeSort.printArray(array);
	}

}
