package com.graph;

import java.util.ArrayList;
import java.util.Stack;

import com.node.GraphNode;
public class TopologicalSort {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	Stack<GraphNode> stack = new Stack<GraphNode>();
	
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}
	
	void topologicalSort() {
		for (GraphNode node : nodeList) {
			if(!node.isVisited()) {
				topologicalSort(node);
			}
			}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+ " ");
		}
	}

	private void topologicalSort(GraphNode node) {
		// TODO Auto-generated method stub
		for(GraphNode neighbour: node.getNeighbors()) {
			if(!neighbour.isVisited()) topologicalSort(neighbour);
		}
		
		node.setVisited(true);;
		stack.push(node);
		
	}

	
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	}

}
