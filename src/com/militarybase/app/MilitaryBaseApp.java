package com.militarybase.app;

import com.militarybase.gui.PersonnelManagement;
import com.militarybase.model.BaseCommander;
import com.militarybase.model.RegularPersonnel;
import com.militarybase.model.SecurityOfficer;
import com.militarybase.service.PersonnelService;

public class MilitaryBaseApp {
    public static void main(String[] args) {
        BaseCommander b1 = new BaseCommander("8099","Commanding Officer","Rab Nawaz");
        RegularPersonnel r1 = new RegularPersonnel("9876","Sentry","Asad");
        SecurityOfficer s1 = new SecurityOfficer("7982","Security","Taha");



        PersonnelService ps = new PersonnelService();
        ps.addPersonnel(b1);
        ps.addPersonnel(r1);
        ps.addPersonnel(s1);
        System.out.println( ps.getAllPersonnel());;


    }
}
