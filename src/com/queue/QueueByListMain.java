package com.queue;


public class QueueByListMain {

	public static void main(String[] args) {


		QueueByList queue = new QueueByList();
		for (int i = 0;i<=5;i++) {
			queue.enQueue((i+1)*10);
		}
		
		System.out.println("dequeued value "+queue.deQueue());
		System.out.println("peek : "+ queue.peek());
		System.out.println("dequeued value "+queue.deQueue());
		System.out.println("peek : "+ queue.peek());
		System.out.println("dequeued value "+queue.deQueue());
		System.out.println("dequeued value "+queue.deQueue());
		System.out.println("peek : "+ queue.peek());
		System.out.println("dequeued value "+queue.deQueue());
		System.out.println("peek : "+ queue.peek());
		
		queue.deleteQueue();
	} 
}
