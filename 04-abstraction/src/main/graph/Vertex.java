package main.graph;

public class Vertex {
    private int id;

    public Vertex(int id) {
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
