package com.vertumno.matrix.multiplication;

import java.time.Instant;
import java.time.Duration;
import java.util.Vector;

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
	
	public void run()
	{
		Helpers helperClass = new Helpers();
		for (int i = 0; i < 20; i++)
		{
			helperClass.resetMatrix(C, dimension);
			Instant start = Instant.now();
			sequentialMultiplication();
			Instant finish = Instant.now();
			executionTimes.addElement(Duration.between(start, finish).toMillis());
		}
		helperClass.writeMetrics(executionTimes, dimension, mode);
	}
}
