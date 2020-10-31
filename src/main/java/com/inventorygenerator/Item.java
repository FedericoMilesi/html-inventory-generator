package com.inventorygenerator;

import java.io.File;

public class Item {
    private String name;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String price;
    private File image;
    public Item(String name, String field1, String field2, String field3, 
            String field4, String field5, String price, File image) {
        this.name = name;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.price = price;
        this.image = image;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getField1() {
        return this.field1;
    }
    
    public String getField2() {
        return this.field2;
    }
    
    public String getField3() {
        return this.field3;
    }
    
    public String getField4() {
        return this.field4;
    }
    
    public String getField5() {
        return this.field5;
    }
    
    public String getPrice() {
        return this.price;
    }
    
    public File getImage() {
        return this.image;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setField1(String field1) {
        this.field1 = field1;
    }
    
    public void setField2(String field2) {
        this.field2 = field2;
    }
    
    public void setField3(String field3) {
        this.field3 = field3;
    }
    
    public void setField4(String field4) {
        this.field4 = field4;
    }
    
    public void setField5(String field5) {
        this.field5 = field5;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setImage(File image) {
        this.image = image;
    }
}
