package com.graph;

import java.util.ArrayList;
import java.util.Stack;

import com.node.GraphNode;
public class DFSIterative {
	
	ArrayList<GraphNode> nodeList ;
	
	public DFSIterative(ArrayList<GraphNode> nodeList ) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList ;
	}
	
	void dfs() {
		for(GraphNode node: nodeList) {
			if(!node.isVisited()) {
				dfsVisit(node);
			}
		}
	}

	private void dfsVisit(GraphNode node) {
		// TODO Auto-generated method stub
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			GraphNode presentNode =stack.pop();
			presentNode.setVisited(true);
			System.out.print(presentNode.getName()+ " ");
			for(GraphNode neighbor : presentNode.getNeighbors()) {
				if(!neighbor.isVisited()) {
					stack.push(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
	
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
}
