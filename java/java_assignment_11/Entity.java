package org.example;

public class Entity {

    private String name;
    private String description;
    private String response;
    private boolean takeable;


    public Entity(String name, String description, String response){
        this.name = name;
        this.description = description;
        this.response = response;
        this.takeable = false;

    }

    public Entity(String name, String description, String response, boolean takeable){
        this.name = name;
        this.description = description;
        this.response = response;
        this.takeable = takeable;

    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String interact() {
        return response;
    }
    public boolean isTakeable() {
        return takeable;
    }

}