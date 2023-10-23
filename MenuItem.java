package com.example.datepicker;

public class MenuItem {
    private final String menuCategory;
    private final String itemName;
    private final String itemDescription;
    private final double itemPrice;
    private int itemQty;
    private String modification;
    public MenuItem(String menuCategory, String itemName, String itemDescription, double itemPrice,
                    int itemQty, String modification) {
        this.menuCategory = menuCategory;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.modification = modification;
    }

    //accessors

    public String getMenuCategory() {
        return menuCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public String getModification() {
        return modification;
    }

    //mutators (unnecessary for cuisine, category, itemName,)
    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }
}
