package ru.saendra.testtask;

import ru.saendra.testtask.ReadEntities.*;
import ru.saendra.testtask.ProcessData.*;
import ru.saendra.testtask.PrintResults.*;
/**
 * Created by Saendra on 11/23/2015.
 */
public class TestTask {
    public static void main(String[] args) {
        ReadEntities _readEntitiesInstance = new ReadEntities();
        ProcessData _processDataInstance = new ProcessData();
        PrintResults _printResultInstance = new PrintResults();

        _readEntitiesInstance.ReadFromFile();
        _processDataInstance.FindReferences(_readEntitiesInstance.getTestEntities());
        _printResultInstance.PrintResults(_processDataInstance.getReferences());
    }
}
