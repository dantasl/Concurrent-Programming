package com.vertumno.matrix.multiplication;

public class MatrixMultiplication
{
	public void sequentialMultiplication(int[][] A, int[][] B, int[][] C, int m, int n, int p)
	{
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int soma = 0;
				for (int k = 0; k < p; k++)
				{
					soma += A[i][k] * B[k][j];
				}
				C[i][j] = soma;
			}
		}
	}
}
