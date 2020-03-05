package com.vertumno.knn;

public class IrisFlower
{
	public double sepal_length;
	public double sepal_width;
	public double petal_length;
	public double petal_width;
	public String species;

	public IrisFlower(double sp_len, double sp_wd, double pt_len, double pt_wd, String spe)
	{
		sepal_length = sp_len;
		sepal_width = sp_wd;
		petal_length = pt_len;
		petal_width = pt_wd;
		species = spe;
	}

	@Override
	public String toString()
	{
		return "Sepal Length: " + sepal_length + " - Sepal Width: " + sepal_width
				+ " - Petal Length: " + petal_length + " - Petal Width: " + petal_width
				+ " - Species: " + species;
	}
}