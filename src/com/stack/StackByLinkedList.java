package com.stack;

import com.list.SingleLinkedList;
import com.node.SingleNode;
public class StackByLinkedList {
	private int topOfStack =  -1;
	private SingleNode head ;
	private SingleLinkedList list;
	
	public StackByLinkedList() {
		list = new SingleLinkedList();
		head = list.getHead(); 
		System.out.println("stack is created");
	}
	
	public void push(int value) {
		SingleNode node = new SingleNode();
		node.setValue(value);
		node.setNext(head);
		head = node;
		System.out.println("value "+ value + "is inserted in stack");
	}
	
	public Boolean isEmpty() {
		return head==null;
	}
	
	public int pop() {
		int value = -1;
		if(isEmpty()) {
			System.out.println("stack is empty !! ");
		}
		else {
			SingleNode tempNode = head;
			head = head.getNext();
			value = tempNode.getValue();
		}
		return value;
	}
	
	public int peek() {
		if (isEmpty()) {
			return -1;
		}else {
		return head.getValue();
		}
	}
	
	public void deleteStack() {
		list.setHead(null);
		System.out.println("stack is deleted");
	}
	
}
