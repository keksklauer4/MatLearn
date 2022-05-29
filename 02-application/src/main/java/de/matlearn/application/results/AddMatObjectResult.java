package de.matlearn.application.results;

public class AddMatObjectResult implements UseCaseResult {
    private final int id;

    public AddMatObjectResult(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
