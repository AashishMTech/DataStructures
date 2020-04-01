package com.mdarray;

public class MDArrayMain {

	public static void main(String[] args) {
		MDArray sda = new MDArray(5,5);
		sda.traverseArray();
		
		
		sda.insertValueInTheArray(0,2,1000000001);
		sda.traverseArray();
				
		sda.insertValueInTheArray(0,2,1000000001);
		sda.traverseArray();
		
		
		sda.accessSingleCell(0,2);
		sda.accessSingleCell(6,2);
		sda.accessSingleCell(2,2);
		
		
		sda.searchingSingleValue(10);
		sda.searchingSingleValue(-2147483648);
		sda.searchingSingleValue(1000000001);
		
		
		sda.deleteValuefromArray(0,2);
		sda.traverseArray();
		
		
		sda.deleteThisArray();
		sda.traverseArray();
	}
}
