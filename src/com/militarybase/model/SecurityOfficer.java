package com.militarybase.model;

public class SecurityOfficer extends Personnel{
    public SecurityOfficer(String id, String role, String name) {
        super(id, role, name);
    }

    @Override
    public String getPermissions() {
        return "";
    }


}
