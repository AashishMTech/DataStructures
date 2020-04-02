package com.list;

import com.node.SingleNode;

public class SingleCircularLinkedList {

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
		SingleNode sn = new SingleNode();
		sn.setValue(nodeValue);
		if(!existsLinkedList()){
			sn = null;
			System.out.println("list does not exists");
		}
		else if(location ==0){
			sn.setNext(head);
			head = sn;	
			tail.setNext(head);
		}
		else if(location >= this.getSize()){
			// adding element to last node
			
			tail.setNext(sn);
			tail = sn;
			sn.setNext(head);
		}else{
			SingleNode temp_node = this.getHead();
			for(int i=0 ; i<location-1; i++){
				temp_node = temp_node.getNext();
			}
			temp_node.setNext(sn); // set sn as next node of temp node
			sn.setNext(temp_node.getNext()); // set sn's next to nextNode
		}
		
		this.setSize(this.getSize()+1);
	}
	
	public void traverseLinkedList(){
		if(!existsLinkedList()){
			System.out.println("list is not present");
		}else{
			SingleNode tempNode = this.getHead();
			for(int i =0; i< this.getSize();i++ ){
				System.out.print(tempNode.getValue());
				if(i != this.getSize() -1){
					System.out.print(" ");
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("\n");
	}
	
	
	public void printHeadUsingTail(){
		if(existsLinkedList()){
			System.out.println("printing tail value");
			System.out.println(getTail().getValue());
			System.out.println("printing head value");
			System.out.println(getHead().getValue());
			System.out.println("printing  head value using tAIL");
			System.out.println(getTail().getNext().getValue());
		}else{
			System.out.println("linked list does not exists");
		}
	}
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		if(tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		}else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}
	
	public Boolean searchNode(int nodeValue){
		if(existsLinkedList()){
			SingleNode tempNode = this.getHead();
			for(int i=0; i<this.getSize();i++){
				if(tempNode.getValue() == nodeValue ){
					System.out.println("value "+ nodeValue+ " found at location "+ i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("value "+nodeValue+" is not found in list");
		return false;
	}
	
	public void deletionOfNode(int location){
		if(!existsLinkedList()){
			System.out.println("list is not present");
		}else if(location > getSize()){
			System.out.println("no value found at this location; size of list "+ getSize());
		}
		else if(location == 0){
			this.setHead(this.getHead().getNext());
			this.setSize(this.getSize()-1);;
			getTail().setNext(getHead());
			if(this.getSize()==0){
				this.setTail(null);
			}
		}else if(location >= this.getSize()){
			SingleNode tempNode = head;
			for(int i=0;i< this.getSize()-1; i++){
				tempNode = tempNode.getNext();		
			}
			if (tempNode == this.getHead()){
				head = null;
				tail = null;
				
				this.setSize(this.getSize()-1);
				return;
			}
			tempNode.setNext(getHead());
			tail= tempNode;
			this.setSize(this.getSize()-1);
		}else{
			SingleNode tempNode = getHead();
			for (int i=0;i < location -1; i++){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			this.setSize(this.getSize()-1);
		}
		
	}
	
	public void getValueByLocation(int location){
		if (!existsLinkedList()){
			System.out.println("linked list is not present");
		}
		else if(location > getSize()){
			System.out.println("value is out of index ; size = "+getSize() );
		}else {
			SingleNode tempNode = getHead();
			for(int i=0; i< getSize(); i++){
				if (i==location){
					System.out.println("value at location "+ location + " is " +tempNode.getValue());
				}
				tempNode= tempNode.getNext();
			}
		}
	}
}
