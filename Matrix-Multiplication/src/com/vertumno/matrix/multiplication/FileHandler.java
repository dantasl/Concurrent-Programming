package com.vertumno.matrix.multiplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler
{
	public void readMatrixFromFile(int[][] matrix, int lines, String matrixAOrB)
	{
		Path path = Paths.get("data/"+ matrixAOrB + lines + "x" + lines + ".txt");
		System.out.println("Attempting to read file data/" + matrixAOrB + lines + "x" + lines + ".txt");
		String currentLine;
		try
		{
			int lineCounter = 0;
			BufferedReader reader = Files.newBufferedReader(path);
			currentLine = reader.readLine();
			while( (currentLine = reader.readLine()) != null )
			{
				String[] lineNumbers = currentLine.split("\\s+");
				if (lineNumbers.length != lines)
				{
					System.out.println("Invalid matrix file.");
					return;
				}
				for (int column = 0; column < lineNumbers.length; column++)
				{
					matrix[lineCounter][column] = Integer.parseInt(lineNumbers[column]);					
				}
				lineCounter++;
			}
			System.out.println("File read and converted to matrix with success.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeMatrixIntoFile(int[][] matrix, int dimension)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output/C" + dimension + "x" + dimension + ".txt"));
			writer.write(dimension + " " + dimension + "\n");
			for (int line = 0; line < dimension; line++)
			{
				for (int column = 0; column < dimension; column++)
				{
					writer.write(matrix[line][column] + " ");
				}
				writer.write("\n");
			}			
			writer.close();
			System.out.println("Saved resulting matrix C at output/C" + dimension + "x" + dimension + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeMetricsIntoFile(long minimum, long maximum, double average, double standardDeviation, int dimension, String mode)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output/metrics.txt", true));
			String metrics = "Metrics (in nanoseconds) for " + dimension + "x" + dimension + " in mode " + mode + ": " +
							 minimum + " minimum, " + maximum + " maximum, " + average + " average and " + standardDeviation + " standard deviation. \n";
			writer.write(metrics);
			writer.close();
			System.out.println("Appended metrics for this execution at output/metrics.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
