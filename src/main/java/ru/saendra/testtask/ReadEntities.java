package ru.saendra.testtask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by Saendra on 11/23/2015.
 */
public class ReadEntities {
    private String filePath = new File("").getAbsolutePath() + "\\input.txt";     // Путь к файлу со списком сущностей.
    private HashMap<Integer,TestEntity> testEntities = new HashMap();                           // Список сущностей, ключ - ID сущности.

    public void setFilePath (String filePath) {                                 // Задача пути к списку сущностей.
        this.filePath = filePath;
    }

    public String getFilePath () {                                              // Получение пути к списку сущностей.
        return filePath;
    }

    public void ReadFromFile () {                                               // Чтение из файла со списком сущностей.
        BufferedReader br = null;
        System.out.print(filePath);
        try {
            String currentLine;
            String[] parts;
            try {
                br = new BufferedReader(new FileReader(filePath));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            while((currentLine = br.readLine()) != null)
            {
                parts = currentLine.split(" ");
                testEntities.put(Integer.valueOf(parts[0]), new TestEntity(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally{
            try{
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public HashMap<Integer,TestEntity> getTestEntities() {
        return testEntities;
    }
}
