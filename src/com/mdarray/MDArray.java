package com.mdarray;

import java.lang.Integer;

public class MDArray {
	int arr[][] ;
	
	public MDArray(int numberOfRows, int numberOfColumns) {
		this.arr = new int[numberOfRows][numberOfColumns];
		for(int row =0; row<arr.length; row++ ){
			for(int col=0;col<arr[0].length; col++){
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}
	
	
	public void traverseArray() {
		try {
		for(int row =0; row<arr.length; row++ ){
			for(int col=0;col<arr[0].length; col++){
				System.out.print(arr[row][col] + "  ");
			}
			System.out.println();
		}
		System.out.println("\n");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("array not found");
		}
	}
	
	
	public void insertValueInTheArray(int row, int col, int value) {
		try{
			if( this.arr[row][col] == Integer.MIN_VALUE){
				this.arr[row][col] = value;
			}
			else{
				System.out.println("value is alreay present in postiion "+ row + " "+ col);
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Invalid index to access array !!");
		}
	}
	
	public void accessSingleCell(int row, int col) {
		try{
			System.out.println("value in given indexes is : " + this.arr[row][col]);
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Invalid index to access array!");
		}
	}
	
	public void searchingSingleValue(int value) {
		for(int row =0; row<arr.length; row++ ){
			for(int col=0;col<arr[0].length; col++){
				if(arr[row][col] == value){
					System.out.println("value " + value+ " found under indexes"+ row + " & "+ col);
					return;
				}
			}
		}
		System.out.println("value " + value + " is not found in array");
	}
	
	
	// Deleting a value from Array
	public void deleteValuefromArray(int deleteValueFromThisRow, int deleteValueFromThisCol) {
		System.out.println(
				"Deleting value from Row#" + deleteValueFromThisRow + " & Col#" + deleteValueFromThisCol + "...");
		try {
			System.out.println("Successfully deleted: " + arr[deleteValueFromThisRow][deleteValueFromThisCol]);
			arr[deleteValueFromThisRow][deleteValueFromThisCol] = Integer.MIN_VALUE;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Cant delete the value as cell# provided is not in the range of array !");
			// e.printStackTrace();
		}
	}
	
	
	// Delete the entire Array
	public void deleteThisArray() {
			arr = null;
			System.out.println("Array has been succefully deleted");
	}
	
	
}
