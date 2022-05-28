package de.matlearn.abstraction.graph;

import java.io.Serializable;

public class GenericVertex implements Serializable {
    private int id;

    public GenericVertex(){
        id = -1;
    }

    public GenericVertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericVertex that = (GenericVertex) o;
        return id == that.id;
    }
}
