package com.heap;



public class HeapByArray {

	public int[] arr ;
	private int sizeOfHeap ;
	public Boolean heapify;
	private int sizeofsortedheap;

	public HeapByArray(int size) {
		// TODO Auto-generated constructor stub
		arr = new int[size+1];
		sizeOfHeap = 0;
		heapify = false;
		sizeofsortedheap = size;
		System.out.println("heap is initialized without any elements");

	}

	private Boolean isFull() {
		if(arr.length == sizeOfHeap) return true;
		else return false;

	}

	private Boolean isEmpty() {
		if(sizeOfHeap <= 0) return true;
		else return false;
	} 


	public void insert(int value) {
		// insert value in last available position 
		// of array and do botton up heaapify
		if(isFull()){
			System.out.println("heap is full !!");
			return;
		}else {
			System.out.println("Inserting " + value + " in Heap...");
			arr[sizeOfHeap+1] = value;
			if(!heapify) {
				heapifyBottomToTop(sizeOfHeap+1);
			}
			sizeOfHeap++;
			System.out.println("Inserted " + value + " successfully in Heap !");
			levelOrder();
		}

	}

	private void heapifyBottomToTop(int index) {
		// compare current node with parent not if 
		//  it is greater then exchange the position 

		
		if(index <= 1){
			System.out.println("heapify from top to bottom is done");
			return;
		}else if(arr[index] > arr[getParent(index)]){
			swap(index, getParent(index));
			heapifyBottomToTop(getParent(index));
		}

	} 

	private void swap(int first, int second) {
		
		int temp = arr[second];
		arr[second] = arr[first];
		arr[first] = temp;
	}
	private int getParent(int index) {
		return index / 2;
	}

	private int getLeftChild(int index) {
		return index*2;
	}
	private int getRightChild(int index) {
		return (index*2)+1;
	}

	public void heapifyTopToBottom(int index) {
		// compare that element #root with its child and if its 
		// smaller then swap it with the greater element
		//***imp condition check if there are both child 
		// no child or only one child (left) since complete tree
		if(sizeOfHeap < getLeftChild(index)) {
			System.out.println("heapify from top to bottom is done");
			return;
		}else if(sizeOfHeap == getLeftChild(index)) {
			swap(index, getLeftChild(index));
			return;
		}else {
			if(arr[getLeftChild(index)] > arr[getRightChild(index)]) {
				if(arr[index] < arr[getLeftChild(index)]) {
					swap(index, getLeftChild(index));
					heapifyTopToBottom(getLeftChild(index));
				}					
			}
			else if(arr[index] < arr[getRightChild(index)]) {
				swap(index, getRightChild(index));
				heapifyTopToBottom(getRightChild(index));
			}
		}


	}


	public void delete() {
		// can only delte root element
		// enter last element in aaray to the top and 
		// and do top to bottom approach for heapify
		if(isEmpty()) {
			System.out.println("heap is empty");
		}
		else {
			System.out.println("Head of the Heap is: " + arr[1]);
			System.out.println("Extracting it now...");
			int temp = arr[1];
			arr[1] = arr[sizeOfHeap];
			sizeOfHeap--;
			heapifyTopToBottom(1);				
			System.out.println("Successfully extracted value from Heap. >>" + temp);
			levelOrder();
			arr[sizeofsortedheap] = temp;
			sizeofsortedheap--;
		}

	}

	public void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}//end of method
	
	public void deleteall() {
		System.out.println("deleting all remaining records");
		while(sizeOfHeap>0) {
			delete();}
		
	}
	
	public void sorted_elements() {
		System.out.println("printing all soreted records");
		for(int i = 1; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println("\n");
	}
	
	public 	void heapify() {
		System.out.println("heapyfing all sequencially added inputs   ");
		for(int i=sizeOfHeap; i>=1; i-- ) {
			heapifyTopToBottom(i);
		}
	}
}
