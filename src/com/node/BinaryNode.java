package com.node;

public class BinaryNode {
	private int value;
	private BinaryNode leftNode;
	private BinaryNode rightNode;
	private int height ;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryNode leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryNode rightNode) {
		this.rightNode = rightNode;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
