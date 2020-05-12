package com.graph.mst;

import java.util.ArrayList;

import com.node.WeightedNode;

public class DisjointSet {

	ArrayList<WeightedNode> nodes = new ArrayList<WeightedNode>();

	public ArrayList<WeightedNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<WeightedNode> nodes) {
		this.nodes = nodes;
	}
	
	
	public static void makeSet(ArrayList<WeightedNode> nodeList) {
		for(WeightedNode node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);
		}
	}
	
	public static DisjointSet  findSet(WeightedNode node) {
		return node.getSet();
	}
	
	public static DisjointSet getSet(WeightedNode node) {
		return node.getSet();
	}
	
	
	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for(WeightedNode node: nodes) {
			System.out.print(node + "  ");
		}
		System.out.println();
	}
	
	public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
		
		// if node 1 and 2 belongs to same set then return null
		
		if(node1.getSet().equals(node2.getSet())) {
			System.out.println("both nodes belong to same set");
			return null;
		}
		else {
			DisjointSet set_node1 = node1.getSet();
			DisjointSet set_node2 = node2.getSet();
			if(set_node1.getNodes().size() > set_node2.getNodes().size()) {
				ArrayList<WeightedNode> nodeset2 = set_node2.getNodes();
				for (WeightedNode node : nodeset2) {
					set_node1.getNodes().add(node);
					node.setSet(set_node1);
				}
				return set_node1;
				
			}else {
				ArrayList<WeightedNode> nodeset1 = set_node1.getNodes();
				for(WeightedNode node : nodeset1) {
					set_node2.getNodes().add(node);
					node.setSet(set_node2);
				}
				return set_node2;
				
			}
			
		}
	}
	
	public static void driver(ArrayList<WeightedNode> nodeList) {
		makeSet(nodeList);
		for (int i =0;i<nodeList.size()-1; i++) {
			WeightedNode firstNode = nodeList.get(i);
			WeightedNode secondNode = nodeList.get(i+1);
			System.out.println("Checking if node "+firstNode.getName()+" and "+secondNode.getName() +" belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if(!firstNode.getSet().equals(secondNode.getSet())) {
				System.out.println("\nMaking union "+firstNode+" and "+secondNode );
				DisjointSet unionSet = union(firstNode, secondNode);
				unionSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
					
		}
	}
}
