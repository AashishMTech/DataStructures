package com.graph.mst;
import java.util.ArrayList;
import com.node.WeightedNode;

public class DisjointSetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		// Calling DisjointSet
		DisjointSet.driver(nodeList);

	}
}


