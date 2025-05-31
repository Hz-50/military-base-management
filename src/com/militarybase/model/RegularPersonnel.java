package com.militarybase.model;

public class RegularPersonnel extends Personnel{


    public RegularPersonnel(String id, String role, String name) {
        super(id, role, name);
    }

    @Override
    public String getPermissions() {
        return "";
    }
}
