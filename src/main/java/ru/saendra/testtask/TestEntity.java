package ru.saendra.testtask;

/**
 * Created by Saendra on 11/23/2015.
 */
public class TestEntity {
    private int id;                                                 // ID сущности
    private int idRef;                                              // ID связанной сущности

    public TestEntity() {                                           // Конструктор по умолчанию
    }

    public TestEntity(int id) {
        setId(id);
    }

    public TestEntity(int id, int idRef) {
        setId(id);
        setIdRef(idRef);
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setIdRef (int idRef) {
        this.idRef = idRef;
    }

    public int getId () {
        return id;
    }

    public int getIdRef () {
        return idRef;
    }
}
