package com.example.doisoat.demo;

public class InventoryRow {
    private String name;
    private String type;
    private Character availability;
    private String returndate;

    public InventoryRow(String name, String type, Character availability,
                        String returndate) {
        this.name = name;
        this.type = type;
        this.availability = availability;
        this.returndate = returndate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Character getAvailability() {
        return availability;
    }

    public void setAvailability(Character availability) {
        this.availability = availability;
    }

    public String toString() {
        return name + "   " + type + "   " + availability + "   " + returndate;
    }
}
