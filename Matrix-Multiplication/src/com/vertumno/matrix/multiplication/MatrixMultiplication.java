package com.vertumno.matrix.multiplication;

import java.time.Instant;
import java.time.Duration;
import java.util.Vector;
import java.util.Collections;

public class MatrixMultiplication
{
	public int[][] A;
	public int[][] B;
	public int[][] C;
	public int dimension;
	public Vector<Long> executionTimes;
	public String mode;
	
	public MatrixMultiplication(int[][] A, int[][] B, int dimension, String mode)
	{
		this.A = A;
		this.B = B;
		this.C = new int[dimension][dimension];
		this.dimension = dimension;
		this.executionTimes = new Vector<Long>(20);
		this.mode = mode;
	}
	
	public void sequentialMultiplication()
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				for (int k = 0; k < dimension; k++)
				{
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
	
	public void resetCMatrix()
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				C[i][j] = 0;
			}
		}
	}
	
	public double getAverageExecutionTime()
	{
		Long sum = (long) 0;
		for (Long time : executionTimes)
			sum += time;
		return sum / 20;
	}
	
	public double getStandardDeviation(double averageTime)
	{
		double distance = 0;
		for (int i = 0; i < 20; i++)
			distance += Math.pow(executionTimes.get(i) - averageTime, 2);
		distance /= 20;
		return Math.sqrt(distance);
	}
	
	public void writeMetrics()
	{
		FileHandler fileHandler = new FileHandler();		
		Collections.sort(executionTimes);
		long minimum = executionTimes.firstElement();
		long maximum = executionTimes.lastElement();
		double average = getAverageExecutionTime();
		double standardDeviation = getStandardDeviation(average);
		fileHandler.writeMetricsIntoFile(minimum, maximum, average, standardDeviation, dimension, mode);
	}
	
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			resetCMatrix();
			Instant start = Instant.now();
			sequentialMultiplication();
			Instant finish = Instant.now();
			executionTimes.addElement(Duration.between(start, finish).toMillis());
		}
		writeMetrics();
	}
}
