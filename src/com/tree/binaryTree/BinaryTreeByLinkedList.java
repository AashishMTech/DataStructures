package com.tree.binaryTree;

import com.node.BinaryNode;
import java.util.*;
public class BinaryTreeByLinkedList {

	public BinaryNode root ; 

	public BinaryTreeByLinkedList() {
		this.root = null;
	}

	public void  preOrder(BinaryNode node) {
		if(node==null) {
			return;
		}
		System.out.print(node.getValue()+ " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());

	}

	public void inOrder(BinaryNode node) {
		if(node==null) return;
		inOrder(node.getLeftNode());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRightNode());
	}

	public void postOrder(BinaryNode node) {
		if(node==null) return ;
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getValue()+ " ");
	}

	public void levelOrder(){
		if(root == null) {
			System.out.println("tree is not present");
			return; 
		} 
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue()+" ");
			if(presentNode.getLeftNode() != null) {
				queue.add(presentNode.getLeftNode());
			}
			if(presentNode.getRightNode() != null) {
				queue.add(presentNode.getRightNode());
			}
		}

	}

	public void search(int value) {
		if(root == null) {
			System.out.println("tree is not present");
			return;
		}
		else {
			Queue<BinaryNode> queue  = new LinkedList<BinaryNode>();
			queue.add(root);

			while(!queue.isEmpty()) {
				BinaryNode presentnode = queue.remove();
				if(presentnode.getValue()==value) {
					System.out.println("value " + value+  " is found in Tree");
					return;
				}
				if(presentnode.getLeftNode() != null) queue.add(presentnode.getLeftNode());
				if(presentnode.getRightNode() != null) queue.add(presentnode.getRightNode());

			}
			System.out.println("value "+ value + " is not found in Tree!!");

		}
	}
	
	public void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if(root == null) {
			root = node;
			System.out.println("sucessfully added new node in tree as root");
			return;
		}
		else {
			Queue<BinaryNode> queue  = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				if(presentNode.getLeftNode() == null) {
					presentNode.setLeftNode(node);
					System.out.println("sucessfully inserted new left node");
					break;
				}else if(presentNode.getRightNode() == null) {
					presentNode.setRightNode(node);
					System.out.println("sucessfully inserted new right node");
					break;
				}
				else{
					queue.add(presentNode.getLeftNode());
					queue.add(presentNode.getRightNode());
				}
			}
		}
		
		
	}
	
	public void deleteNodeOfBinaryTree(int value) {
		if(root == null) {
			System.out.println("tree is not present");
			return;
		}else {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				if(presentNode.getValue() == value) {
					BinaryNode deepestNode = getDeepestNode();
					presentNode.setValue(deepestNode.getValue());
					deleteDeepestNode();
					System.out.println("value "+ value + " is deleted from tree!!");
					return;
				}
				if(presentNode.getLeftNode() != null) queue.add(presentNode.getLeftNode());
				if(presentNode.getRightNode() != null) queue.add(presentNode.getRightNode());
			}
			System.out.println("node with value "+ value + " is not present");
		}
	}
	
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue  = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeftNode()!=null) queue.add(presentNode.getLeftNode());
			if(presentNode.getRightNode()!=null) queue.add(presentNode.getRightNode());	
		}
		return presentNode;
	}
	
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.getLeftNode()==null) {
				previousNode.setRightNode(null);
				return;
			}
			else if(presentNode.getRightNode() == null) {
				presentNode.setLeftNode(null);
				return;
			}
			queue.add(presentNode.getLeftNode());
			queue.add(presentNode.getRightNode());
		}
	}
	
	public void deleteTree() {
		root = null;
		System.out.println("tree is sucsessufully deleted");
	}
	
	
}
