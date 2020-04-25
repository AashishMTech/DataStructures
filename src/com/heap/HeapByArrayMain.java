package com.heap;

import java.awt.HeadlessException;

public class HeapByArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating a blank Heap");
		HeapByArray heap = new HeapByArray(10);
		heap.heapify  = true;
		heap.insert(15);
		heap.insert(134);
		heap.insert(80);
		heap.insert(70);
		heap.insert(10);
		heap.insert(50);
		heap.insert(40);
		heap.insert(25);
		heap.insert(20);
		heap.insert(110);
		heap.heapify();
		heap.levelOrder();
		heap.delete();
		
		
		heap.delete();
		
		
		heap.deleteall();
		heap.sorted_elements();
	}

}
