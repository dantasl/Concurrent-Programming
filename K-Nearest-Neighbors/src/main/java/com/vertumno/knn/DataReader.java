package com.vertumno.knn;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public final class DataReader
{
    public static void ReadCSV(Vector<IrisFlower> dataset)
    {
        String csvFile = new File("").getAbsolutePath().concat("/data/iris.csv");
        CSVReader reader = null;
        try
        {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line = reader.readNext();
            while ((line = reader.readNext()) != null)
            {
                IrisFlower entry = new IrisFlower(
                        Double.parseDouble(line[0]), Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]), Double.parseDouble(line[3]),
                        line[4]
                );
                dataset.addElement(entry);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
