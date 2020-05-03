package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.node.GraphNode;

public class BFSByLinkedList {

	
	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public BFSByLinkedList(ArrayList<GraphNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}
	
	void bfs() {
		for (GraphNode node : nodeList) {
			if(!node.isVisited()) {
				bfsVisit(node);
			}
		}
	}
	
	void bfsVisit(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove();
			presentNode.setVisited(true);
			System.out.print(presentNode.getName()+ " ");
			ArrayList<GraphNode> neighbours = presentNode.getNeighbors();
			
			for (GraphNode neighbour : neighbours) {
				if(!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setVisited(true);
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
