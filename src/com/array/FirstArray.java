package com.array;

public class FirstArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBase sda = new ArrayBase(10);
		sda.traverseArray();
		sda.insert(2, 12);
		sda.insert(0,0);
		sda.insert(1,10);
		sda.insert(2,20);
		sda.insert(3,30);
		sda.insert(4,40);
		sda.insert(5,50);
		sda.insert(6,60);
		sda.insert(7,70);
		sda.insert(8,80);
		sda.insert(1,100);
		sda.insert(12,120);
		sda.traverseArray();
		System.out.println();
		sda.accessCell(10);
		sda.accessCell(7);
		System.out.println();
		sda.searchInArray(45);
		sda.searchInArray(70);
		System.out.println("\n");
		System.out.println("before deleting value");
		sda.traverseArray();
		System.out.println("after deleting value");
		sda.deleteValueInIndex(3);
		sda.traverseArray();
		
		sda.deleteValueInIndex(9);
	}
	
	
}
