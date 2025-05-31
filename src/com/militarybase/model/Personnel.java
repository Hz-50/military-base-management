package com.militarybase.model;

public abstract class Personnel {
    private String id;
    private String name;
    private String role;

    public Personnel(String id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }


    // getters
    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }


    // method
    public abstract String getPermissions();

    @Override
    public String toString() {
        return "Personnel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}