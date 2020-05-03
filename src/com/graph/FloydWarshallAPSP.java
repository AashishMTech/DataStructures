package com.graph;

import java.util.ArrayList;
import com.node.WeightedNode;

public class FloydWarshallAPSP {
	ArrayList<WeightedNode> nodeList;

	public FloydWarshallAPSP(ArrayList<WeightedNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}

	public void addWeightedEdge(int i , int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);
	}

	public void floydwarshall() {
		int n = nodeList.size();
		System.out.println("size " + n);
		int [][] v = new int[n][n];
		//create table from adjacent list, adjacent Metrix

		for (int i =0; i<n; i++) {
			WeightedNode first = nodeList.get(i);
			for(int j=0; j<n; j++) {
				WeightedNode second  = nodeList.get(j);
				if(i==j) {
					v[i][j] = 0;
				}else if(first.getWeightMap().containsKey(second)) {
					v[i][j] = first.getWeightMap().get(second);
				}else {
					v[i][j] = Integer.MAX_VALUE;
				}
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}


		// floydwarshall mehod//

		for (int k = 0;k <n; k++) {
			for(int i = 0;i <n; i++) {
				for (int j= 0;j <n; j++) {
					if(v[i][k]!=Integer.MAX_VALUE && v[k][j]!= Integer.MAX_VALUE &&  v[i][j] > v[i][k]+v[k][j]) {
						//System.out.print(v[i][j] +" "+v[i][k]+ " "+ v[k][j]);
						v[i][j] = v[i][k]+v[k][j];
						//System.out.println(" "+v[i][j] +" "+v[i][k]+ " "+ v[k][j]);
					}
					//System.out.println("for k "+ k +" ("+i+","+j+")"+ " edge is "+  v[i][j]);
				}System.out.println();
			}System.out.println();
		}

		// printing all source shortest path
		for (int i=0; i<n;i++ ) {
			System.out.println("printing shortest path for "+nodeList.get(i)+ " : ");
			for(int j = 0; j< n; j++) {
				System.out.print(nodeList.get(j)+ ": "+ v[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
