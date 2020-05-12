package com.graph.mst.prims;

public class Edge {
	private int weight ;
	private boolean isIncluded = false ;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isIncluded() {
		return isIncluded;
	}
	public void setIncluded(boolean isIncluded) {
		this.isIncluded = isIncluded;
	}
	
	
}
