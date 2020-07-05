package com.vertumno.matrix.multiplication;

public class SequentialMultiplication
{
	public void multiply(int[][] A, int[][] B, int[][] C, int dimension)
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
}
