package com.vertumno.matrix.multiplication;

public class Main
{
	public static void main(String[] args)
	{
		// Defining objects instances to be used
		Helpers classHelpers = new Helpers();
		FileHandler fileHandler = new FileHandler();
		MatrixMultiplication multiplicator = new MatrixMultiplication();
		
		// Checking if arguments passed to code execution are right
		classHelpers.checkArguments(args);
		
		// Creating A, B and C matrices with the proper dimensions
		int dimension = Integer.parseInt(args[0]);
		int[][] A = new int[dimension][dimension];
		int[][] B = new int[dimension][dimension];
		int[][] C = new int[dimension][dimension];
		
		// Reading values from files into matrices A and B		
		fileHandler.readMatrixFromFile(A, dimension, "A");
		fileHandler.readMatrixFromFile(B, dimension, "B");
		
		// Running matrix multiplication
		run(multiplicator, A, B, C, dimension, args[1]);
		
		// Output C into a file
		fileHandler.writeMatrixIntoFile(C, dimension);
	}
	
	public static void run(MatrixMultiplication multiplicator, int[][] A, int[][] B, int[][] C, int dimension, String method)
	{
		if (method.equals("S"))
		{
			System.out.println("Now performing multiplication between A and B, sequential mode.");
			multiplicator.sequentialMultiplication(A, B, C, dimension);				
		}
		if (method.equals("C"))
		{
			System.out.println("Now performing multiplication between A and B, concurrent mode.");
			//multiplicator.sequentialMultiplication(A, B, C, dimension);
		}
	}
}