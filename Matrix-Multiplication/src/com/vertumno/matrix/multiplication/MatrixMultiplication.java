package com.vertumno.matrix.multiplication;

public class MatrixMultiplication
{
	public int[][] A;
	public int[][] B;
	public int[][] C;
	public int dimension;
	
	public MatrixMultiplication(int[][] A, int[][] B, int dimension)
	{
		this.A = A;
		this.B = B;
		this.C = new int[dimension][dimension];
		this.dimension = dimension;
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
			sequentialMultiplication();			
		}		
	}	
}
