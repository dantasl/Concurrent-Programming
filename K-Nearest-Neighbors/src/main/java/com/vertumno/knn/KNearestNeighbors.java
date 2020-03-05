package com.vertumno.knn;

import java.util.*;
import java.util.stream.Collectors;

public final class KNearestNeighbors
{
	private KNearestNeighbors(){}

	private static double euclideanDistance(IrisFlower p1, IrisFlower p2)
	{
		double distance =
				Math.pow( (p2.petal_length - p1.petal_length), 2 ) +
				Math.pow( (p2.petal_width - p1.petal_width), 2 ) +
				Math.pow( (p2.sepal_length - p1.sepal_length), 2 ) +
				Math.pow( (p2.sepal_width - p1.sepal_width), 2 );
		return Math.sqrt(distance);
	}

	public static void loadData(Vector<IrisFlower> dataset)
	{
		DataReader.ReadCSV(dataset);
	}

	// TODO: pass function to calculate distance as a parameter
	public static String run(Vector<IrisFlower> dataset, IrisFlower query, int kNeighbors)
	{
		// [1] Calculate the Euclidean Distance from each point in the dataset with the query
		Map<Integer, Double> flowerDistance = new HashMap<>();
		for (int index = 0; index < dataset.size(); index++)
		{
			double distance = euclideanDistance(dataset.get(index), query);
			flowerDistance.put(index, distance);
		}

		// [2] Sort the record of distances in ascending order
		Map<Integer, Double> sortedDistances = flowerDistance
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		// [3] Get the first K neighbors on ordered distances
		int count = 0;
		Vector<String> kFirstSpecies = new Vector<>();
		for (Map.Entry<Integer, Double> entry : sortedDistances.entrySet())
		{
			if (count == kNeighbors) break;
			kFirstSpecies.addElement(dataset.get(entry.getKey()).species);
			count++;
		}

		// [4] Get the mode of the species
		String mode = kFirstSpecies.stream()
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.get()
				.getKey();

		// [5] Return mode
		return mode;
	}

	public static void printResults(){}
}