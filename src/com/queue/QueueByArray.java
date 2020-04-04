package com.queue;

public class QueueByArray {
	private int arr[];
	private int topOfQueue ;
	private int beginningOfQueue;

	public QueueByArray(int size) {
		arr = new int[size];
		topOfQueue = -1;
		beginningOfQueue = -1;

	}

	public Boolean isFull(){
		return topOfQueue == arr.length-1;
	}

	public void enQueue(int value) {
		if(isFull()) {
			System.out.println("queue is full");
		}
		else {
			arr[topOfQueue+1] = value;
			topOfQueue++;
		}
	}

	public Boolean isEmpty() {
		return beginningOfQueue == topOfQueue;
	}

	public void deQueue() {
		if(isEmpty()) {
			System.out.println("queue is empty");
		}else {
			System.out.println(arr[beginningOfQueue+1]);
			beginningOfQueue ++; 
			if(beginningOfQueue == topOfQueue) {
				beginningOfQueue = topOfQueue = -1;
			}
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("queue is empty");
		}else {
			System.out.println(arr[beginningOfQueue+1]);
		}
	}
	
	
	public void deleteQueue() {
		arr = null;
		System.out.println("queue is deleted");
	}
	

}

