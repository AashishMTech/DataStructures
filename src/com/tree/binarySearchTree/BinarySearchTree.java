package com.tree.binarySearchTree;

import com.node.BinaryNode;
import java.util.*;
public class BinarySearchTree {
	public BinaryNode root ;

	public BinarySearchTree() {
		root = null;
	}

	void searchForValue(int value) {
		searchForValue(root, value);
	}
	
	
	// Search a node in BST
	BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeftNode(), value);
		} else {
			return searchForValue(node.getRightNode(), value);
		}
	}// end of method

	public void LevelOrder() {
		if(root == null) {
			System.out.println("BST is not present");
			return;
		}
		else {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode node =  queue.remove();
				System.out.print(node.getValue() + " ");
				if(node.getLeftNode()!=null) queue.add(node.getLeftNode());
				if(node.getRightNode()!=null) queue.add(node.getRightNode());
			}
		}
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
	
	// Insert values in BST
	void insert(int value) {
		root = insert(root, value);
	}

	// Helper Method
	BinaryNode insert(BinaryNode currentNode, int value) {
		if (currentNode == null) { // if root node is blank then insert new node there
			System.out.println("Successfully inserted " + value + " in BST");
			return createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeftNode(insert(currentNode.getLeftNode(), value));
			return currentNode;
		} else {
			currentNode.setRightNode(insert(currentNode.getRightNode(), value));
			return currentNode;
		}
	}

	

	// creates a new blank new node
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}
	
	

	// Get minimum element in binary search tree
	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeftNode() == null)
			return root;
		else {
			return minimumElement(root.getLeftNode());
		}
	}// end of method


	// Deleting a node from BST
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		deleteNodeOfBST(root,value);
	}
	
	
	public BinaryNode deleteNodeOfBST(BinaryNode node, int value) {
		if(node == null) return null;
		else if(value < node.getValue()) {
			return deleteNodeOfBST(node.getLeftNode(), value);
		}else if(value > node.getValue()) return deleteNodeOfBST(node.getRightNode(), value);
		else {
			if(node.getLeftNode() == null & node.getRightNode()!=null) {
				node = node.getRightNode();
			}
			else if (node.getRightNode() == null & node.getLeftNode() !=null) {
				node = node.getLeftNode();
			}if (node.getLeftNode() != null & node.getRightNode() != null) {
				BinaryNode temp  = node;
				BinaryNode minRightNode = minimumElement(temp.getRightNode());
				node.setValue(minRightNode.getValue());
				node.setRightNode(deleteNodeOfBST(node.getRightNode(), minRightNode.getValue()));
			}else {
				node = null;
			}
			
		}
		return node;
	}

	// Delete entire BST
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}// end of method
	
	
	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeftNode());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRightNode());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method
}
