package com.vertumno.knn;

public class Main
{
	public static void main(String[] args)
	{
		// A quick look at the structure
		KNearestNeighbors.loadData();
		KNearestNeighbors.run();
		KNearestNeighbors.printResults();
	}
}