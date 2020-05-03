package com.graph;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;

import com.node.WeightedNode;

public class BellmanFordAlgorithm {

	ArrayList<WeightedNode> nodeList ;

	public BellmanFordAlgorithm(ArrayList<WeightedNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
		for(WeightedNode node : nodeList) {
			node.setDistance(Integer.MAX_VALUE);
		}
	}

	public void printPath(WeightedNode node) {
		if(node.getParent() !=null) {
			System.out.print(" = "+ node);
			printPath(node.getParent());
			System.out.print(" -> "+ node);
		}
		else System.out.print(node);
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);
	}


	public void bellmanFordMethod(WeightedNode startNode) {
		// iterating n-1 times
		/*
		startNode.setDistance(0);
		for (int i=0; i< nodeList.size() ; i++) {
			for(WeightedNode presentNode : nodeList){
				for (WeightedNode neighbor : presentNode.getNeighbors()) {
					if(neighbor.getDistance() > presentNode.getDistance() +
							presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getDistance() +
								presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
					}
				}
			}

		}



		// checking nth time !
		System.out.println("checkign for negative cycle");
		for(WeightedNode presentNode : nodeList){
			for (WeightedNode neighbor : presentNode.getNeighbors()) {
				if(neighbor.getDistance() > presentNode.getDistance() +
						presentNode.getWeightMap().get(neighbor)) {
					System.out.println("negative cycle found!!");
					System.out.println("vertex is > "+ neighbor.getName());
					System.out .println("old distance = "+ neighbor.getDistance());
					System.out.println("new distance = " + presentNode.getDistance() +
							presentNode.getWeightMap().get(neighbor));
					return; 
				}
			}

		}

		System.out.println("no negative cycle found");
		System.out.println("printing path now!!");
		for (WeightedNode node : nodeList) {
			if (node.getDistance() != Integer.MAX_VALUE) {
				System.out.print("Node : "+ node + " distance "+ node.getDistance()
				+ " path : ");
				//printPath(node);
			}else {
				System.out.print("No path for node : "  +node);
			}
			System.out.println();
		}
		 */
		System.out.println(startNode);
		startNode.setDistance(0); // set source distance to zero
		int indexofstartNode = nodeList.indexOf(startNode);
		System.out.println(indexofstartNode);
		Collections.swap(nodeList, 0, indexofstartNode);
		System.out.println("after swap " + nodeList.indexOf(startNode));
		for (int i = 1; i < nodeList.size(); i++) { // repeat n-1 times
			for (WeightedNode presentNode : nodeList) { // for each Vertex
				if(presentNode.getName().toString().equals(startNode.getName().toString()) ) {
					//System.out.println( presentNode.getName()+" "+startNode.getName());
					presentNode.setDistance(0);
					//System.out.println(nodeList.indexOf(presentNode));
				}
				System.out.print("PN :"+ presentNode+ " ");
				for (WeightedNode neighbor : presentNode.getNeighbors()) { // for each Neighbor
					// if distance of neighbor is greater than tentative new path then
					// update distance of neighbor with new parent as presentNode
					if ( 	
							(neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)))) {
						System.out.println("neighbor dist : " + neighbor.getDistance());
						System.out.println("present node dist : "+ presentNode.getDistance()+ " " + presentNode.getWeightMap().get(neighbor));
						System.out.println("calculations : "+ (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
						neighbor.setDistance((presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(presentNode);
						System.out.print(neighbor.getName() + " distance : " +  neighbor.getDistance());
					}
				} // end of inner loop
				
				System.out.println();
			} // end of mid loop
		} // end of loop

		System.out.println("Checking for Negative Cycle ...");
		//for each edge check if update possible, if true then negative cycle is there report error
		for(WeightedNode presentNode: nodeList) {
			for(WeightedNode neighbor: presentNode.getNeighbors()) {
				// if distance of neighbor is greater than tentative new path then we have a negative cycle, return from here.. 
				if(neighbor.getDistance() > (presentNode.getDistance()+presentNode.getWeightMap().get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getName());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance()+presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}//end of loop
		System.out.println("Negative cycle not found !");


		//Print table of node with minimum distance and shortest path from source
		System.out.println("\n\nPrinting Paths now: ");
		for (WeightedNode nodeToCheck : nodeList) {
			if (nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
				System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				//printPath(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck);
			}
			System.out.println();
		}//end of loop
	}



}
