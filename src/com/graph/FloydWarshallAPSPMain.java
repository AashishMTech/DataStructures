package com.graph;
import com.node.WeightedNode;
import com.graph.FloydWarshallAPSP;
import java.util.ArrayList;
public class FloydWarshallAPSPMain {
	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		//Create 4 Vertices: A,B,C,D
		for (int i = 0; i < 4; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		FloydWarshallAPSP graph = new FloydWarshallAPSP(nodeList);
		graph.addWeightedEdge(1, 4, 1);// Add A-> D , weight 1
		graph.addWeightedEdge(1, 2, 8);// Add A-> B , weight 8
		graph.addWeightedEdge(2, 3, 1);// Add B-> C , weight 1
		graph.addWeightedEdge(3, 1, 4);// Add C-> A , weight 4
		graph.addWeightedEdge(4, 2, 2);// Add D-> B , weight 2
		graph.addWeightedEdge(4, 3, 9);// Add D-> C , weight 9

		System.out.println("Printing Floyd-Warshall from each source:");
		graph.floydwarshall();
		
	}
}
