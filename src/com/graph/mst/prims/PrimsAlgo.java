package com.graph.mst.prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PrimsAlgo {

	private ArrayList<Vertex> graph;
	
	public void run() {
		if(graph.size()>0) {
			graph.get(0).setVisited(true);
		}
		Edge nextMinimum = new Edge();
		nextMinimum.setWeight(Integer.MAX_VALUE);
		Vertex nextVertex = graph.get(0);
		while(isDisconnected()) {
			for(Vertex vertex : graph) {
				if(vertex.isVisited()) {
					HashMap<Vertex, Edge> candidate  = vertex.nextMinimum();
					Iterator<Vertex> it =  candidate.keySet().iterator();
					Vertex key = it.next();
					if(candidate.get(key).getWeight() < nextMinimum.getWeight()) {
						nextMinimum = candidate.get(key);
						nextVertex = key;
					}
							
				}
			}
			nextMinimum.setIncluded(true);
			nextVertex.setVisited(true);
		}
	}
	
	private boolean isDisconnected() {
		for(Vertex vertex : graph) {
			if(!vertex.isVisited()) {
				return true;
			}
		}
		return false;
	}
}
