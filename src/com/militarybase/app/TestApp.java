package com.militarybase.app;

import com.militarybase.model.BaseCommander;
import com.militarybase.model.SecurityOfficer;
import com.militarybase.service.PersonnelService;

public class TestApp {
    public static void main(String[] args) {
        PersonnelService ps = new PersonnelService();
        BaseCommander bc = new BaseCommander("9022","Commanding Officer","Rab Nawaz");

        ps.addPersonnel(bc);

        SecurityOfficer s1 = new SecurityOfficer("2099","Security","Muhammad Asif");
        ps.addPersonnel(s1);
        System.out.println(s1.toString());
        // Print all personnel
        for (var p : ps.getAllPersonnel()) {
            System.out.println(p.getName());
        }
    }
}