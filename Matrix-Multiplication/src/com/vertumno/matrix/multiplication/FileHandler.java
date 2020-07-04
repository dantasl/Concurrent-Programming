package com.vertumno.matrix.multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler
{
	public void readMatrixFromFile(String filename)
	{
		Path path = Paths.get(filename);
		String currentLine;
		try
		{
			BufferedReader reader = Files.newBufferedReader(path);	
			while( (currentLine = reader.readLine()) != null )
			{
				System.out.println(currentLine);				
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
