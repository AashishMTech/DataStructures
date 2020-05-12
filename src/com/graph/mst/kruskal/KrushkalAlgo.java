package com.graph.mst.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.graph.mst.DisjointSet;
import com.graph.util.UndirectedEdge;
import com.node.WeightedNode;

public class KrushkalAlgo{
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();
	
	public KrushkalAlgo(ArrayList<WeightedNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}
	
	public void kruskal() {
		DisjointSet.makeSet(nodeList);
		
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
		
			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		}; 
		Collections.sort(edgeList, comparator);
		
		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			WeightedNode first = edge.getFirst();
			WeightedNode second = edge.getSecond();
			if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
				DisjointSet.union(first, second);
				cost += edge.getWeight();
				System.out.println("Taken : " + edge);
			}
			System.out.println("\n Total cost of MST: " + cost);

		}
	}
	
	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge();
		edge.setFirst(nodeList.get(firstIndex -1));
		edge.setSecond(nodeList.get(secondIndex-1));
		edge.setWeight(weight);
		WeightedNode first = edge.getFirst();
		WeightedNode second = edge.getSecond();
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
		
	}
}