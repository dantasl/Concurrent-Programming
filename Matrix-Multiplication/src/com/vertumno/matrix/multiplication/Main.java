package com.vertumno.matrix.multiplication;

public class Main
{
	public static void main(String[] args)
	{
		FileHandler fileHandler = new FileHandler();
		int[][] matrix = new int[1024][1024];
		
		fileHandler.readMatrixFromFile(matrix, 1024, "A");
		
		for (int i = 0; i < 1024; i++) {
			for (int j = 0; j < 1024; j++) {
				System.out.println(matrix[i][j]);
			}
		}
		
	}
}