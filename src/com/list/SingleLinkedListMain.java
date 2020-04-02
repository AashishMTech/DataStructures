package com.list;

import com.node.SingleNode;

public class SingleLinkedListMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNode sn = new SingleNode();
		System.out.println(sn.getNext()+ " "+  sn.getValue());
		SingleNode head = sn;
		sn.setValue(123);
		
		System.out.println(sn+ " "+ head);
	}

}
