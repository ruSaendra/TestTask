package ru.saendra.testtask;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Saendra on 11/25/2015.
 */
public class PrintResults {
    private String path = new File("").getAbsolutePath();

    public void PrintResults(ArrayList<int[]> references) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-SSS");
        String path = getPath() + "\\results_" + sdf.format(new Date()) + ".txt";
        PrintWriter results = null;
        try {
            results = new PrintWriter(new BufferedWriter(new FileWriter(path,true)));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int[] reference : references)
        {
            for(int i=0; i<reference.length; i++)
            {
                results.print(reference[i]+" ");
            }
            results.println("");
        }
        results.close();
    }

    public String getPath() {
        return path;
    }
}
