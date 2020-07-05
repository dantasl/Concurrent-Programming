package com.vertumno.matrix.multiplication;

public class ConcurrentMultiplication implements Runnable
{
	public int[][] A;
	public int[][] B;
	public int[][] C;
	public int row;
	
	public ConcurrentMultiplication(int[][] A, int[][] B, int[][] C, int row)
	{
		this.A = A;
		this.B = B;
		this.C = C;
		this.row = row;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < B[0].length; i++)
		{
			C[row][i] = 0;
			for (int j = 0; j < A[row].length; j++)
			{
				C[row][i] += A[row][j] * B[j][i];
			}
		}
	}
}
