package com.queue;

import com.list.SingleLinkedList;
import com.node.SingleNode;
public class QueueByList {
	SingleLinkedList list ;

	public QueueByList() {
		list = new SingleLinkedList();
	}

	public void enQueue(int value) {
		SingleNode node = new SingleNode();
		node.setValue(value);
		node.setNext(null);
		if(isEmpty()) {
			list.setHead(node);
			list.setTail(node);
		}else {
			list.getTail().setNext(node);
			list.setTail(node);
		}
		System.out.println("value "+ value + "is queued");

	}

	private Boolean isEmpty() {
		return list.getHead() == null;
	}

	public int  deQueue() {
		if(isEmpty()) {
			System.out.println("no element to dequeue");
			return -1;
		}else {
			SingleNode tempNode = list.getHead(); 
			list.setHead(list.getHead().getNext());
			return tempNode.getValue();
		}
	}

	public int peek() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		}
		else {
			return list.getHead().getValue();
		}
	}



	public void deleteQueue() {
		list.setHead(null);
		list.setTail(null);
		
		System.out.println("queue is deleted sucessfully");
	}


}
