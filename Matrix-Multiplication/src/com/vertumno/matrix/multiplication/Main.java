package com.vertumno.matrix.multiplication;

public class Main
{
	public static void main(String[] args)
	{
		FileHandler fileHandler = new FileHandler();
		fileHandler.readMatrixFromFile("data/A4x4.txt");
	}
}