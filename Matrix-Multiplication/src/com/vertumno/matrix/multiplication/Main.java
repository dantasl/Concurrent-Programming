package com.vertumno.matrix.multiplication;

public class Main
{
	public static void main(String[] args)
	{
		FileHandler fileHandler = new FileHandler();
		MatrixMultiplication multiplicator = new MatrixMultiplication();
		
		int[][] A = new int[4][4];
		int[][] B = new int[4][4];
		int[][] C = new int[4][4];
		
		fileHandler.readMatrixFromFile(A, 4, "A");
		fileHandler.readMatrixFromFile(B, 4, "B");
		
		multiplicator.sequentialMultiplication(A, B, C, 4, 4, 4);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(C[i][j]);
			}
		}
	}
}

/*for (int i = 0; i < 1024; i++) {
	for (int j = 0; j < 1024; j++) {
		System.out.println(matrix[i][j]);
	}
}*/