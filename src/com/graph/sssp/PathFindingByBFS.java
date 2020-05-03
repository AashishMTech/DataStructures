package com.graph.sssp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import com.node.GraphNode;

public class PathFindingByBFS {
	ArrayList<GraphNode> nodeList ;
	
	public PathFindingByBFS(ArrayList<GraphNode> nodeList ) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}
	
	public void pathPrint(GraphNode node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
		}
		System.out.print(node + " ");
	}
	
	public void BFSForSSSP(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		System.out.println();
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove();
			presentNode.setVisited(true);
			System.out.print("Printing path for node "+presentNode.getName()+": ");
			pathPrint(presentNode);
			System.out.println();
			for(GraphNode neighbor : presentNode.getNeighbors()) {
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
					neighbor.setParent(presentNode);			
				}
			}
		}
	}
	
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
	
}
