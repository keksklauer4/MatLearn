package main.graph;

public class GenericVertex {
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
}
