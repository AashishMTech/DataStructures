package com.graph;



import com.node.GraphNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSByAdjacencyMatrix {
	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int[][] adjacencyMatrix;
	
	public BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()] ;
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
			
			ArrayList<GraphNode> neighbours = getNeighbors(presentNode);
			for (GraphNode neighbour : neighbours) {
				if(!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setVisited(true);
				}
			}

		}
	}
	
	public ArrayList<GraphNode> getNeighbors(GraphNode node){
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		
		int nodeIndex = node.getIndex(); // row at which node is located
		
		for (int i =0; i< adjacencyMatrix.length ; i++) {
			if(adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}
	
	public void addUndirectedEdge(int i, int j) {
		//decrement i, j for array indexes
		i--;
		j--;
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
		
	}
}
