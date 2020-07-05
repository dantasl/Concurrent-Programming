package com.vertumno.matrix.multiplication;
import java.lang.Math;

public class Helpers
{
	public boolean isLogBaseTwo(int value)
	{
		if (value == 0 | value == 1) return false;
		double log = Math.log(value) / Math.log(2);
		return Math.pow(2, log) == value;
	}
	
	public void checkArguments(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Execution only happens when 2 valid arguments are provided.");
			System.exit(1);
		}
		
		if (!isLogBaseTwo(Integer.parseInt(args[0])))
		{
			System.out.println("Matrix dimension must be a positive integer power of 2.");
			System.exit(1);
		}
		
		if ((!args[1].equals("S")) & (!args[1].contentEquals("C")))
		{
			System.out.println(args[1] + " is not a valid execution option. This code supports C for Concurrent and S for Sequential.");
			System.exit(1);
		}
	}
	
	public void printMatrix(int[][] matrix, int dimension)
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.println("\n");
		}		
	}
}
