package com.array;

import java.lang.Integer;

public class ArrayBase {
	// name of array init null
	int arr[] = null;
	
	// create a blank array
	public ArrayBase(int sizeOfArray) {
		// create an array of given size
		arr = new int[sizeOfArray];
		for (int i = 0; i< arr.length ; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}
	
	
	public void traverseArray() {
		try {
			for(int i =0;i < arr.length ; i++) {
				System.out.print(arr[i] + " ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("array no longer exists!!");
		}
	}
	
	public void insert(int location, int value_to_add) {
		try {
			if(arr[location] == Integer.MIN_VALUE) {
				arr[location] = value_to_add;
				System.out.println("value "+ value_to_add + " is added to location "+ location);
			}else {
				System.out.println("index " + location + " is already occupied" );
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("invalid index of access array");
		}
	}
	
	public void accessCell(int cellNumber) {
		try {
			System.out.println(arr[cellNumber]);
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("invalid index of access array");
		}
	}
	
	public void searchInArray(int valueToSearch) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i] == valueToSearch) {
				System.out.println(valueToSearch + " is at index " + i);
				return ;
			}			
		}
		System.out.println(valueToSearch+ " is not found");
	}
	
	public void deleteValueInIndex(int cellNumber) {
		try {
			if(arr[cellNumber] == Integer.MIN_VALUE){
				System.out.println("no value present for cell " + cellNumber);
			}else {
				arr[cellNumber] = Integer.MIN_VALUE ;
				System.out.println("value is deleted in cell "+ cellNumber);
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(cellNumber + "is out of index");
		}
	}
	
}
