package com.queue;

public class CircularQueueByArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating an empty queue...");
		CircularQueueByArray queue = new CircularQueueByArray(5);
		//CircularQueueByArrayOriginal queue = new  CircularQueueByArrayOriginal(5);

		System.out.println("\nEnqueuing 5 values in the queue...");
		for (int i = 1; i <= 5; i++) {
			queue.enQueue(i * 10);
		}
		queue.enQueue(60);
		queue.printArray();
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.deQueue();
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.deQueue();
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.enQueue(60);
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.printArray();
		queue.deQueue();
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.enQueue(123);
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.enQueue(43);
		System.out.println(queue.getTop() + " "+ queue.getStart());
		queue.printArray();
		queue.deleteQueue();
	}

}
