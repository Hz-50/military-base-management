package com.militarybase.model;

public class Unit {
    private String name;
    private String location;
    private String type;

    public Unit(String type, String location, String name) {
        this.type = type;
        this.location = location;
        this.name = name;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
