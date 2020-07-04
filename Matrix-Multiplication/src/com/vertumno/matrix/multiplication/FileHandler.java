package com.vertumno.matrix.multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler
{
	public void readMatrixFromFile(int[][] matrix, int lines, String matrixAOrB)
	{
		Path path = Paths.get("data/"+ matrixAOrB + lines + "x" + lines + ".txt");
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
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeMatrixIntoFile()
	{
		
	}
}
