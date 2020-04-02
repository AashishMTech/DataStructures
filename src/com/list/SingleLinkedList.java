package com.list;

import com.node.SingleNode;

public class SingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size; //denotes size of  list
	
	public SingleNode createSingleLinkedList(int nodeValue){
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		head = node;
		tail = node;
		size = 1; //size=1
		return node;
	}

	public SingleNode getHead() {
		return head;
	}

	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
	
	public void insertInLinkedList(int nodeValue, int location){
		
	}
}
