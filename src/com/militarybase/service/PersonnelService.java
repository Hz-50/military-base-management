package com.militarybase.service;

import com.militarybase.model.Personnel;
import java.util.ArrayList;
import java.util.List;

public class PersonnelService {
    private List<Personnel> personnelList = new ArrayList<>();

    public void addPersonnel(Personnel p) { personnelList.add(p); }
    public void removePersonnel(Personnel p) { personnelList.remove(p); }
    public List<Personnel> getAllPersonnel() { return personnelList; }
}
