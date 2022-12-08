package com.inventorygenerator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class PageWriter {
    private final BufferedWriter inventory;
    private final Company company;
    private final List<Item> items;
    public PageWriter(Company company, List<Item> items, BufferedWriter inventory) {
        this.inventory = inventory;
        this.company = company;
        this.items = items;
    }
    
    public void writePage() throws IOException {
        writePageHeader();
        for (int i = 0; i < 9; i++) {
            if(items.get(i) != null) {
                writeItem(i);
            }
        }
        writePageFooter();
        inventory.close();
    }
    
    public void writePageHeader() {
        try {
            inventory.write("<!DOCTYPE html>");
            inventory.newLine();
            inventory.write("<html lang=\"en\">");
            inventory.newLine();
            inventory.write("<head>");
            inventory.newLine();
            inventory.write("<meta charset=\"UTF-8\" />");
            inventory.newLine();
            inventory.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
            inventory.newLine();
            inventory.write("<title>" + company.getName() + " - " + company.getInventoryName().toUpperCase() + "</title>");
            inventory.newLine();
            inventory.write("<link href=\"https://fonts.googleapis.com/css2?family=Fira+Sans:ital@1&display=swap\" rel=\"stylesheet\" />");
            inventory.newLine();
            inventory.write("<link href=\"https://fonts.googleapis.com/css2?family=Oswald:wght@500&display=swap\" rel=\"stylesheet\" />");
            inventory.newLine();
            inventory.write("<link rel=\"stylesheet\" href=\"main.css\" />");
            inventory.newLine();
            inventory.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"/>");
            inventory.newLine();
            inventory.write("</head>");
            inventory.newLine();
            inventory.write("<body>");
            inventory.newLine();
            inventory.write("<div class=\"grid header\">");
            inventory.newLine();
            inventory.write("<div>");
            inventory.newLine();
            inventory.write("<h1 class=\"title\">" + company.getInventoryName() + "</h1>");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
            if(company.getLogo() != null) {
                inventory.write("<div class=\"logo\">");
                inventory.newLine();
                inventory.write("<img src=\"img/images.png\" alt=\"\" height=\"100px\" width=\"150px\" />");
                inventory.newLine();
                inventory.write("</div>");
                inventory.newLine();
            }
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("<div class=\"container\">");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
        
    public void writeItem(int itemNumber) {
        try {
            inventory.write("<div class=\"container-card\">");
            inventory.newLine();
            inventory.write("<div class=\"card\">");
            inventory.newLine();
            inventory.write("<div class=\"card-img\">");
            inventory.newLine();
            inventory.write("<img src=\"images/" + items.get(itemNumber).getImage().getName() + "\" alt=\"\" class=\"item-img\" />");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("<div class=\"card-title\">");
            inventory.newLine();
            inventory.write("<h4 class=\"item-title\">" + items.get(itemNumber).getName() + "</h4>");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("<p class=\"item-text\">");
            inventory.write(items.get(itemNumber).getField1() + items.get(itemNumber).getField2() + items.get(itemNumber).getField3() + items.get(itemNumber).getField4() + items.get(itemNumber).getField5());
            inventory.write("</p>");
            inventory.newLine();
            inventory.write("<div class=\"card-price\">");
            inventory.newLine();
            inventory.write("<strong class=\"item-price\"><em>$ " + items.get(itemNumber).getPrice() + "</em></strong>");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("</div>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
     
    public void writePageFooter() {
        try {
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("<div class=\"footer\">");
            inventory.newLine();
            inventory.write("<div>");
            inventory.newLine();
            inventory.write("<div class=\"div\">");
            inventory.newLine();
            if(!company.getWsappNumber().equals("")) {
                inventory.write("<img src=\"images/wsapp.png\" height=\"30\" width=\"30\" alt=\"\" class=\"ico-wsap\"/>");
                inventory.newLine();
                inventory.write("</div>");
                inventory.newLine();
                inventory.write("<div class=\"div\">");
                inventory.newLine();
                inventory.write("<span class=\"number\">" + company.getWsappNumber() + "</span>");
                inventory.newLine();
                inventory.write("</div>");
                inventory.newLine();
            }
            inventory.write("</div>");
            inventory.newLine();
            if(!company.getWebPage().equals("")) {
                inventory.write("<div>");
                inventory.newLine();
                inventory.write("<span class=\"url\">" + company.getWebPage() + "</span>");
                inventory.newLine();
                inventory.write("</div>");
                inventory.newLine();
            }
            inventory.write("</div>");
            inventory.newLine();
            inventory.write("</body>");
            inventory.newLine();
            inventory.write("</html>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
