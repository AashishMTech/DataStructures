package com.tree.AVL;

import java.util.LinkedList;
import java.util.Queue;

import com.node.BinaryNode;

public class AVLTreeBYLinkedList {
	BinaryNode root;

	public AVLTreeBYLinkedList() {
		System.out.println("initializing AVL Tree");
		root  = null;
	}

	public void searchInAVLTree(int value) {
		searchInAVLTree(root, value);
	}

	public BinaryNode searchInAVLTree(BinaryNode node, int value) {
		if(node == null) {
			System.out.println("value "+ value + "is not present");
			return null;
		}
		else if(node.getValue() == value) {
			System.out.println("value "+ value + " is found binary tree");
			return node;
		}
		else if(value < node.getValue()) {
			return searchInAVLTree(node.getLeftNode(), value);
		}
		else return searchInAVLTree(node.getRightNode(), value);
	}

	public void inOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		else {
			inOrder(node.getLeftNode());
			System.out.print(node.getValue()+" ");
			inOrder(node.getRightNode());
		}
	}

	public void preOrder(BinaryNode node) {
		if(node == null) return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
	}


	public void postOrder(BinaryNode node) {
		if(node == null) return ; 
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getValue() + " ");
	}

	public void levelOrder() {
		if(root == null) {
			System.out.println("tree is not present");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode node = queue.remove();
			System.out.print(node.getValue()+ " ");
			if(node.getLeftNode()!= null) queue.add(node.getLeftNode());
			if(node.getRightNode()!=null) queue.add(node.getRightNode());
		}
		
		
		
	}
	
	
	

}
