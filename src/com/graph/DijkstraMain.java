package com.graph;

import com.graph.sssp.DijkstraAlgortihm;
import java.util.ArrayList;
import com.node.WeightedNode;

public class DijkstraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		//create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		
		//Constructor
		DijkstraAlgortihm graph = new DijkstraAlgortihm(nodeList);
		
		graph.addWeightedEdge(1,3,6); //Add A-> C , weight 6
		graph.addWeightedEdge(1,4,3); //Add A-> D , weight 3
		graph.addWeightedEdge(2,1,3); //Add B-> A , weight 3
		graph.addWeightedEdge(3,4,2); //Add C-> D , weight 2
		graph.addWeightedEdge(4,3,1); //Add D-> C , weight 1
		graph.addWeightedEdge(4,2,1); //Add D-> B , weight 1
		graph.addWeightedEdge(5,2,4); //Add E-> B , weight 4
		graph.addWeightedEdge(5,4,2); //Add E-> D , weight 2
		
		System.out.println("Printing Dijkstra from source: E");
		graph.djikstraSSSP(nodeList.get(4));
	}

}
