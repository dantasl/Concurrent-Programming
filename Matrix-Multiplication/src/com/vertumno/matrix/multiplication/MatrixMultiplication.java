package com.vertumno.matrix.multiplication;

public class MatrixMultiplication
{
	public void sequentialMultiplication(int[][] A, int[][] B, int[][] C, int dimension)
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				int soma = 0;
				for (int k = 0; k < dimension; k++)
				{
					soma += A[i][k] * B[k][j];
				}
				C[i][j] = soma;
			}
		}
	}
}
