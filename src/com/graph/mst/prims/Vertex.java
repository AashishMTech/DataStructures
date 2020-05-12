package com.graph.mst.prims;

import java.util.HashMap;

public class Vertex {
	private String label ;
	private HashMap<Vertex, Edge> edges = new HashMap<Vertex, Edge>();
	private boolean isVisited = false;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public HashMap<Vertex, Edge> getEdges() {
		return edges;
	}
	public void setEdges(HashMap<Vertex, Edge> edges) {
		this.edges = edges;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	
	public HashMap<Vertex, Edge> nextMinimum(){
		Edge nextMinimum =  new Edge();
		nextMinimum.setWeight(Integer.MAX_VALUE);
		Vertex nextVertex = this;
		for(Vertex v : this.edges.keySet()) {
			if(!v.isVisited) {
				if(this.edges.get(v).getWeight() < nextMinimum.getWeight()) {
					nextMinimum = this.edges.get(v);
					nextVertex = v;
				}
			}
		}
		HashMap<Vertex, Edge> newMinMap  = new  HashMap<Vertex, Edge>();
		newMinMap.put(nextVertex, nextMinimum);
		return newMinMap;
	}
	
	
}
