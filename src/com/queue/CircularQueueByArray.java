package com.queue;

public class CircularQueueByArray {
	private int arr[];
	private int start ;
	private int top;
	private int size;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	
	public CircularQueueByArray(int size) {
		// TODO Auto-generated constructor stub
		arr = new int[size];
		start = top = -1;
		size =0; 
	}
	public Boolean isfull() {
		if(start==0 && top ==arr.length-1 ) {
			return true;
		}else if(top+1== start ){
			return  true;
		}else return false;
	}
	
	public Boolean isEmpty(){
		return top==-1;
	}
	
	public void enQueue(int value){
		if(isfull()) { 
			System.out.println("queue is full");
		}else {
			initializeQueue();
			if(top==arr.length-1){
				top=0;
			}else{
				top++;	 
			}
			arr[top] = value;
		}
		
	}
	
	public void initializeQueue() {
		if(start == -1) {
			start =0;
		}
	}
	
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("queue is empty");
		}
		else {
			//init
			arr[start] = 0;
			if (top == start) {
				top=start=-1;
			}
			else if(start == arr.length -1){
				start = 0;
			}else start++;
		}
	}
	
	public void printArray() {
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i] + "->");
		}
		System.out.println("\n");
	}
	
	public void deleteQueue() {
		arr = null;
		System.out.println("queue is deleted sucessfully!!");
	}
}
