package com.militarybase.model;

public class BaseCommander extends Personnel{
    public BaseCommander(String id, String role, String name) {
        super(id, role, name);
    }

    @Override
    public String getPermissions() {
        return "";
    }

    @Override
    public String toString() {
        return "BaseCommander{Name: " + this.getName() + " Id: " +this.getId() +   " role: " + this.getRole();
    }
}
