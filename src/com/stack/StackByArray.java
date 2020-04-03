package com.stack;

public class StackByArray {
	private int arr[];
	private int topOfStack;
	
	public StackByArray(int size ) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("stack of size "+size+" is created");
	}
	
	public Boolean isFull() {
		return topOfStack==arr.length-1;
	}
	
	public Boolean isEmpty() {
		return topOfStack==-1;
	}
	
	public void push(int value) {
		if(!isFull()) {
			
			try {
				arr[topOfStack+1] = value;
				System.out.println("value "+ value+ " is inserted in stack");
				topOfStack++;
			}catch(ArrayIndexOutOfBoundsException ae) {
				System.out.println("stack length is exceeded, stack size: "+ arr.length);
				
			}
			
		}else {
			System.out.println("stack is full");
		}	
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("stack is empty");
		}else {
			try {
				System.out.println(arr[topOfStack]);
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("stack is empty, no value left");
			}
			topOfStack--;
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("stack is empty");
		}else {
			System.out.println(arr[topOfStack]);
		}
	}
	
	public void deleteStack() {
		this.arr = null;
		System.out.println("stack is deleted");
	}
	
}
