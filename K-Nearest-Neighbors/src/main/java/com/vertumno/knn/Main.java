package com.vertumno.knn;

import java.util.Vector;

public class Main
{
	public static void main(String[] args)
	{
		// Step [1] - Load data from CSV file
		Vector<IrisFlower> dataset = new Vector<>();
		KNearestNeighbors.loadData(dataset);

		// Step [2] - Run the algorithm
		IrisFlower query = new IrisFlower(5.8f, 2.7f, 5.1f, 2.3f, "virginica");
		int kNeighbors = 3;
		KNearestNeighbors.run(dataset, query, kNeighbors);

		// Step [3] - See the results
		KNearestNeighbors.printResults();
	}
}