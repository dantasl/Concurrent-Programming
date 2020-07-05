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
	
	public void run()
	{
		Helpers helperClass = new Helpers();
		SequentialMultiplication sequentialMultiplication = new SequentialMultiplication();
		ConcurrentMultiplication concurrentMultiplication = new ConcurrentMultiplication();
		for (int i = 0; i < 20; i++)
		{
			helperClass.resetMatrix(C, dimension);
			Instant start = null, finish = null;
			// I know this bit breaks the DRY principle, but since I'm not sure how the comparing affects time...
			if (mode.equals("S"))
			{
				start = Instant.now();
				sequentialMultiplication.multiply(A, B, C, dimension);
				finish = Instant.now();
			}
			if (mode.equals("C"))
			{
				start = Instant.now();
				concurrentMultiplication.multiply(A, B, C, dimension);
				finish = Instant.now();
			}
			executionTimes.addElement(Duration.between(start, finish).toMillis());
		}
		helperClass.writeMetrics(executionTimes, dimension, mode);
	}
}
