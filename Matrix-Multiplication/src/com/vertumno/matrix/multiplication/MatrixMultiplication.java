package com.vertumno.matrix.multiplication;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MatrixMultiplication
{
	public int[][] A;
	public int[][] B;
	public int[][] C;
	public int dimension;
	public Vector<Long> executionTimes;
	public String mode;
	public Helpers helperClass;
	
	public MatrixMultiplication(int[][] A, int[][] B, int dimension, String mode)
	{
		this.A = A;
		this.B = B;
		this.C = new int[dimension][dimension];
		this.dimension = dimension;
		this.executionTimes = new Vector<Long>(20);
		this.mode = mode;
		helperClass = new Helpers();
	}
	
	public void runSequential()
	{
		SequentialMultiplication sequentialMultiplication = new SequentialMultiplication();
		for (int i = 0; i < 20; i++)
		{
			helperClass.resetMatrix(C, dimension);
			Instant start = Instant.now();
			sequentialMultiplication.multiply(A, B, C, dimension);
			Instant finish = Instant.now();
			executionTimes.addElement(Duration.between(start, finish).toMillis());
		}
	}
	
	public void runConcurrent()
	{
		List<Thread> threadList = new ArrayList<>();
		for (int execution = 0; execution < 20; execution++)
		{
			helperClass.resetMatrix(C, dimension);
			Instant start = Instant.now();
			for (int i = 0; i < dimension; i++)
			{
				ConcurrentMultiplication task = new ConcurrentMultiplication(A, B, C, i);
				Thread thread = new Thread(task);
				thread.start();
				threadList.add(thread);
				if (threadList.size() % 4 == 0)
				{
					waitForThreads(threadList);
				}
			}
			Instant finish = Instant.now();
			executionTimes.addElement(Duration.between(start, finish).toMillis());
		}
	}
	
	/* 
	 * This method was adapted from:
	 * https://www.javaprogramto.com/2020/01/java-matrix-multiplication-threads.html
	 * Huge thanks!
	 * */	
	private static void waitForThreads(List<Thread> threadList)
	{
		for (Thread thread : threadList)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
			    e.printStackTrace();
			}
		}
		threadList.clear();
	}
	
	
	public void run()
	{
		if (mode.equals("S"))
		{
			runSequential();
		}
		if (mode.equals("C"))
		{
			runConcurrent();
		}
		helperClass.writeMetrics(executionTimes, dimension, mode);
	}
}
