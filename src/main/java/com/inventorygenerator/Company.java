package com.inventorygenerator;

import java.io.File;

public class Company {
    private String name;
    private String address;
    private String webPage;
    private String email;
    private String wsappNumber;
    private String inventoryName;
    private final File logo;
    public Company(String name, String address, String webPage, String email, 
            String wsappNumber, String inventoryName, File logo) {
        this.name = name;
        this.address = address;
        this.webPage = webPage;
        this.email = email;
        this.wsappNumber = wsappNumber;
        this.inventoryName = inventoryName;
        this.logo = logo;
    }
        
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getWebPage() {
        return this.webPage;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getWsappNumber() {
        return this.wsappNumber;
    }
    
    public String getInventoryName() {
        return this.inventoryName;
    }
    
    public File getLogo() {
        return this.logo;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setWsappNumber(String wsappNumber) {
        this.wsappNumber = wsappNumber;
    }
    
    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }
}
