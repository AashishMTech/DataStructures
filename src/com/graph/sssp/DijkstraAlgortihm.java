package com.graph.sssp;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.node.WeightedNode;
public class DijkstraAlgortihm {
	ArrayList<WeightedNode> nodeList  ;

	public DijkstraAlgortihm(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}


	public void printPath(WeightedNode node) {
		if(node.getParent() != null) {
			printPath(node.getParent());
			System.out.print(" -> "+ node);
		}else 
			System.out.print(node);
	}

	

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first  =  nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);

	}
	
	
	public void djikstraSSSP(WeightedNode sourceNode) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		sourceNode.setDistance(0);
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove();
			for(WeightedNode neighbor : presentNode.getNeighbors()) {
				if(queue.contains(neighbor)) {
					if(neighbor.getDistance() > presentNode.getDistance() +
												presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getDistance() +
								presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}
		for (WeightedNode node : nodeList) {
			System.out.print("Node "+node+", distance: "+node.getDistance()+", Path: ");
			printPath(node);
			System.out.println();
		}
		
	}
		
	
}
