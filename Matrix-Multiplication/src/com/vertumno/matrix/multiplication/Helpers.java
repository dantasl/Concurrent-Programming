package com.vertumno.matrix.multiplication;
import java.lang.Math;
import java.util.Collections;
import java.util.Vector;

public class Helpers
{
	public boolean isLogBaseTwo(int value)
	{
		if (value == 0 | value == 1) return false;
		double log = Math.log(value) / Math.log(2);
		return Math.pow(2, log) == value;
	}
	
	public void checkArguments(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Execution only happens when 2 valid arguments are provided.");
			System.exit(1);
		}
		
		if (!isLogBaseTwo(Integer.parseInt(args[0])))
		{
			System.out.println("Matrix dimension must be a positive integer power of 2.");
			System.exit(1);
		}
		
		if ((!args[1].equals("S")) & (!args[1].contentEquals("C")))
		{
			System.out.println(args[1] + " is not a valid execution option. This code supports C for Concurrent and S for Sequential.");
			System.exit(1);
		}
	}
	
	public void printMatrix(int[][] matrix, int dimension)
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.println("\n");
		}		
	}
	
	public void resetMatrix(int[][] C, int dimension)
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				C[i][j] = 0;
			}
		}
	}
	
	public double getAverageExecutionTime(Vector<Long> executionTimes)
	{
		Long sum = (long) 0;
		for (Long time : executionTimes)
			sum += time;
		return sum / 20;
	}
	
	public double getStandardDeviation(Vector<Long> executionTimes, double averageTime)
	{
		double distance = 0;
		for (int i = 0; i < 20; i++)
			distance += Math.pow(executionTimes.get(i) - averageTime, 2);
		distance /= 20;
		return Math.sqrt(distance);
	}
	
	public void writeMetrics(Vector<Long> executionTimes, int dimension, String mode)
	{
		FileHandler fileHandler = new FileHandler();		
		Collections.sort(executionTimes);
		long minimum = executionTimes.firstElement();
		long maximum = executionTimes.lastElement();
		double average = getAverageExecutionTime(executionTimes);
		double standardDeviation = getStandardDeviation(executionTimes, average);
		fileHandler.writeMetricsIntoFile(minimum, maximum, average, standardDeviation, dimension, mode);
	}
}
