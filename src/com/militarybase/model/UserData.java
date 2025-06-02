package com.militarybase.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
This class store all user-specific info, it gets data from each gui
 */
public class UserData implements Serializable {

    private List<Object[]> personnelRows = new ArrayList<>();
    private List<Object[]> inventoryRows = new ArrayList<>();
    private List<Object[]> unitRows = new ArrayList<>();
    private List<Object[]> accessLogRows = new ArrayList<>();

    public List<Object[]> getPersonnelRows() { return personnelRows; }
    public List<Object[]> getInventoryRows() { return inventoryRows; }
    public List<Object[]> getUnitRows() { return unitRows; }
    public List<Object[]> getAccessLogRows() { return accessLogRows; }

}