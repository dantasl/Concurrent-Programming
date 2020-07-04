package com.vertumno.matrix.multiplication;

import java.time.Instant;
import java.time.Duration;

public class MatrixMultiplication
{
	public int[][] A;
	public int[][] B;
	public int[][] C;
	public int dimension;
	private long[] executionTimes;
	
	public MatrixMultiplication(int[][] A, int[][] B, int dimension)
	{
		this.A = A;
		this.B = B;
		this.C = new int[dimension][dimension];
		this.dimension = dimension;
		this.executionTimes = new long[20];
	}
	
	public void sequentialMultiplication()
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				int sum = 0;
				for (int k = 0; k < dimension; k++)
				{
					sum += A[i][k] * B[k][j];
				}
				C[i][j] = sum;
			}
		}
	}
	
	public void run(String method)
	{
		for (int i = 0; i < 20; i++)
		{
			Instant start = Instant.now();
			sequentialMultiplication();
			Instant finish = Instant.now();
			executionTimes[i] = Duration.between(start, finish).toMillis();
		}		
	}	
}
