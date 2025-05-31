package com.militarybase.model;

public class InventoryItem {
    private String itemName;
    private int itemNumber;
    private String itemCategory;

    public InventoryItem(int itemNumber, String itemName, String itemCategory) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
    }

    // getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
}
