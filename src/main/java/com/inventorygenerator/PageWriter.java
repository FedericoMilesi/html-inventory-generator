package com.inventorygenerator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class PageWriter {
    private final Company company;
    private final List<Item> items;
    private final BufferedWriter inventory;
    private final String[] itemShapeHTML;
    private final String[] itemShapeImageHTML;
    private final String[] itemF1TextHTML;
    private final String[] itemF2TextHTML;
    private final String[] itemF3TextHTML;
    private final String[] itemF4TextHTML;
    private final String[] itemF5TextHTML;
    private final String[] itemNameShapeHTML;
    private final String[] itemNameShapeImageHTML;
    private final String[] itemNameTextHTML;
    private final String[] itemPreviewImageHTML;
    private final String[] itemPreviewImageSourceHTML;
    private final String[] itemPriceShapeHTML;
    private final String[] itemPriceShapeImageHTML;
    private final String[] itemPriceTextHTML;
    public PageWriter(Company company, List<Item> items, BufferedWriter inventory) {
        this.company = company;
        this.items = items;
        this.inventory = inventory;
        itemShapeHTML = new String[9];
        itemShapeHTML[0] = "<div id=\"wb_Shape2\" style=\"position:absolute;left:10px;top:100px;width:200px;height:250px;z-inventory:3;\">";
        itemShapeHTML[1] = "<div id=\"wb_Shape5\" style=\"position:absolute;left:300px;top:101px;width:200px;height:250px;z-inventory:14;\">";
        itemShapeHTML[2] = "<div id=\"wb_Shape8\" style=\"position:absolute;left:595px;top:102px;width:200px;height:250px;z-inventory:25;\">";
        itemShapeHTML[3] = "<div id=\"wb_Shape11\" style=\"position:absolute;left:10px;top:404px;width:200px;height:250px;z-inventory:36;\">";
        itemShapeHTML[4] = "<div id=\"wb_Shape14\" style=\"position:absolute;left:300px;top:405px;width:200px;height:250px;z-inventory:47;\">";
        itemShapeHTML[5] = "<div id=\"wb_Shape17\" style=\"position:absolute;left:595px;top:405px;width:200px;height:250px;z-inventory:58;\">";
        itemShapeHTML[6] = "<div id=\"wb_Shape20\" style=\"position:absolute;left:10px;top:714px;width:200px;height:250px;z-inventory:91;\">";
        itemShapeHTML[7] = "<div id=\"wb_Shape23\" style=\"position:absolute;left:300px;top:713px;width:200px;height:250px;z-inventory:69;\">";
        itemShapeHTML[8] = "<div id=\"wb_Shape26\" style=\"position:absolute;left:595px;top:714px;width:200px;height:250px;z-inventory:80;\">";
        itemShapeImageHTML = new String[9];
        itemShapeImageHTML[0] = "<img src=\"images/img0002.png\" id=\"Shape2\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[1] = "<img src=\"images/img0002.png\" id=\"Shape5\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[2] = "<img src=\"images/img0002.png\" id=\"Shape8\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[3] = "<img src=\"images/img0002.png\" id=\"Shape11\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[4] = "<img src=\"images/img0002.png\" id=\"Shape14\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[5] = "<img src=\"images/img0002.png\" id=\"Shape17\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[6] = "<img src=\"images/img0002.png\" id=\"Shape20\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[7] = "<img src=\"images/img0002.png\" id=\"Shape23\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemShapeImageHTML[8] = "<img src=\"images/img0002.png\" id=\"Shape26\" alt=\"\" style=\"width:200px;height:250px;\"></div>";
        itemF1TextHTML = new String[9];
        itemF1TextHTML[0] = "<div id=\"wb_Text9\" style=\"position:absolute;left:15px;top:262px;width:190px;height:16px;z-inventory:4;\">";
        itemF1TextHTML[1] = "<div id=\"wb_Text5\" style=\"position:absolute;left:305px;top:263px;width:190px;height:16px;z-inventory:15;\">";
        itemF1TextHTML[2] = "<div id=\"wb_Text15\" style=\"position:absolute;left:600px;top:264px;width:190px;height:16px;z-inventory:26;\">";
        itemF1TextHTML[3] = "<div id=\"wb_Text22\" style=\"position:absolute;left:15px;top:566px;width:190px;height:16px;z-inventory:37;\">";
        itemF1TextHTML[4] = "<div id=\"wb_Text29\" style=\"position:absolute;left:305px;top:567px;width:190px;height:16px;z-inventory:48;\">";
        itemF1TextHTML[5] = "<div id=\"wb_Text36\" style=\"position:absolute;left:600px;top:567px;width:190px;height:16px;z-inventory:59;\">";
        itemF1TextHTML[6] = "<div id=\"wb_Text43\" style=\"position:absolute;left:15px;top:876px;width:190px;height:16px;z-inventory:92;\">";
        itemF1TextHTML[7] = "<div id=\"wb_Text50\" style=\"position:absolute;left:305px;top:875px;width:190px;height:16px;z-inventory:70;\">";
        itemF1TextHTML[8] = "<div id=\"wb_Text57\" style=\"position:absolute;left:600px;top:876px;width:190px;height:16px;z-inventory:81;\">";
        itemF2TextHTML = new String[9];
        itemF2TextHTML[0] = "<div id=\"wb_Text10\" style=\"position:absolute;left:15px;top:278px;width:190px;height:16px;z-inventory:5;\">";
        itemF2TextHTML[1] = "<div id=\"wb_Text7\" style=\"position:absolute;left:305px;top:279px;width:190px;height:16px;z-inventory:16;\">";
        itemF2TextHTML[2] = "<div id=\"wb_Text16\" style=\"position:absolute;left:600px;top:280px;width:190px;height:16px;z-inventory:27;\">";
        itemF2TextHTML[3] = "<div id=\"wb_Text23\" style=\"position:absolute;left:15px;top:582px;width:190px;height:16px;z-inventory:38;\">";
        itemF2TextHTML[4] = "<div id=\"wb_Text30\" style=\"position:absolute;left:305px;top:583px;width:190px;height:16px;z-inventory:49;\">";
        itemF2TextHTML[5] = "<div id=\"wb_Text37\" style=\"position:absolute;left:600px;top:583px;width:190px;height:16px;z-inventory:60;\">";
        itemF2TextHTML[6] = "<div id=\"wb_Text44\" style=\"position:absolute;left:15px;top:892px;width:190px;height:16px;z-inventory:93;\">";
        itemF2TextHTML[7] = "<div id=\"wb_Text51\" style=\"position:absolute;left:305px;top:891px;width:190px;height:16px;z-inventory:71;\">";
        itemF2TextHTML[8] = "<div id=\"wb_Text58\" style=\"position:absolute;left:600px;top:892px;width:190px;height:16px;z-inventory:82;\">";
        itemF3TextHTML = new String[9];
        itemF3TextHTML[0] = "<div id=\"wb_Text1\" style=\"position:absolute;left:15px;top:294px;width:190px;height:16px;z-inventory:6;\">";
        itemF3TextHTML[1] = "<div id=\"wb_Text8\" style=\"position:absolute;left:305px;top:295px;width:190px;height:16px;z-inventory:17;\">";
        itemF3TextHTML[2] = "<div id=\"wb_Text17\" style=\"position:absolute;left:600px;top:296px;width:190px;height:16px;z-inventory:28;\">";
        itemF3TextHTML[3] = "<div id=\"wb_Text24\" style=\"position:absolute;left:15px;top:598px;width:190px;height:16px;z-inventory:39;\">";
        itemF3TextHTML[4] = "<div id=\"wb_Text31\" style=\"position:absolute;left:305px;top:599px;width:190px;height:16px;z-inventory:50;\">";
        itemF3TextHTML[5] = "<div id=\"wb_Text38\" style=\"position:absolute;left:600px;top:599px;width:190px;height:16px;z-inventory:61;\">";
        itemF3TextHTML[6] = "<div id=\"wb_Text45\" style=\"position:absolute;left:15px;top:908px;width:190px;height:16px;z-inventory:94;\">";
        itemF3TextHTML[7] = "<div id=\"wb_Text52\" style=\"position:absolute;left:305px;top:907px;width:190px;height:16px;z-inventory:72;\">";
        itemF3TextHTML[8] = "<div id=\"wb_Text59\" style=\"position:absolute;left:600px;top:908px;width:190px;height:16px;z-inventory:83;\">";
        itemF4TextHTML = new String[9];
        itemF4TextHTML[0] = "<div id=\"wb_Text2\" style=\"position:absolute;left:15px;top:310px;width:190px;height:16px;z-inventory:7;\">";
        itemF4TextHTML[1] = "<div id=\"wb_Text11\" style=\"position:absolute;left:305px;top:311px;width:190px;height:16px;z-inventory:18;\">";
        itemF4TextHTML[2] = "<div id=\"wb_Text18\" style=\"position:absolute;left:600px;top:312px;width:190px;height:16px;z-inventory:29;\">";
        itemF4TextHTML[3] = "<div id=\"wb_Text25\" style=\"position:absolute;left:15px;top:614px;width:190px;height:16px;z-inventory:40;\">";
        itemF4TextHTML[4] = "<div id=\"wb_Text32\" style=\"position:absolute;left:305px;top:615px;width:190px;height:16px;z-inventory:51;\">";
        itemF4TextHTML[5] = "<div id=\"wb_Text39\" style=\"position:absolute;left:600px;top:615px;width:190px;height:16px;z-inventory:62;\">";
        itemF4TextHTML[6] = "<div id=\"wb_Text46\" style=\"position:absolute;left:15px;top:924px;width:190px;height:16px;z-inventory:95;\">";
        itemF4TextHTML[7] = "<div id=\"wb_Text53\" style=\"position:absolute;left:305px;top:923px;width:190px;height:16px;z-inventory:73;\">";
        itemF4TextHTML[8] = "<div id=\"wb_Text60\" style=\"position:absolute;left:600px;top:924px;width:190px;height:16px;z-inventory:84;\">";
        itemF5TextHTML = new String[9];
        itemF5TextHTML[0] = "<div id=\"wb_Text6\" style=\"position:absolute;left:15px;top:326px;width:190px;height:16px;z-inventory:8;\">";
        itemF5TextHTML[1] = "<div id=\"wb_Text12\" style=\"position:absolute;left:305px;top:327px;width:190px;height:16px;z-inventory:19;\">";
        itemF5TextHTML[2] = "<div id=\"wb_Text19\" style=\"position:absolute;left:600px;top:328px;width:190px;height:16px;z-inventory:30;\">";
        itemF5TextHTML[3] = "<div id=\"wb_Text26\" style=\"position:absolute;left:15px;top:630px;width:190px;height:16px;z-inventory:41;\">";
        itemF5TextHTML[4] = "<div id=\"wb_Text33\" style=\"position:absolute;left:305px;top:631px;width:190px;height:16px;z-inventory:52;\">";
        itemF5TextHTML[5] = "<div id=\"wb_Text40\" style=\"position:absolute;left:600px;top:631px;width:190px;height:16px;z-inventory:63;\">";
        itemF5TextHTML[6] = "<div id=\"wb_Text47\" style=\"position:absolute;left:15px;top:940px;width:190px;height:16px;z-inventory:96;\">";
        itemF5TextHTML[7] = "<div id=\"wb_Text54\" style=\"position:absolute;left:305px;top:939px;width:190px;height:16px;z-inventory:74;\">";
        itemF5TextHTML[8] = "<div id=\"wb_Text61\" style=\"position:absolute;left:600px;top:940px;width:190px;height:16px;z-inventory:85;\">";
        itemNameShapeHTML = new String[9];
        itemNameShapeHTML[0] = "<div id=\"wb_Shape3\" style=\"position:absolute;left:15px;top:230px;width:190px;height:27px;z-inventory:9;\">";
        itemNameShapeHTML[1] = "<div id=\"wb_Shape6\" style=\"position:absolute;left:305px;top:231px;width:190px;height:27px;z-inventory:20;\">";
        itemNameShapeHTML[2] = "<div id=\"wb_Shape9\" style=\"position:absolute;left:600px;top:232px;width:190px;height:27px;z-inventory:31;\">";
        itemNameShapeHTML[3] = "<div id=\"wb_Shape12\" style=\"position:absolute;left:15px;top:534px;width:190px;height:27px;z-inventory:42;\">";
        itemNameShapeHTML[4] = "<div id=\"wb_Shape15\" style=\"position:absolute;left:305px;top:535px;width:190px;height:27px;z-inventory:53;\">";
        itemNameShapeHTML[5] = "<div id=\"wb_Shape18\" style=\"position:absolute;left:600px;top:535px;width:190px;height:27px;z-inventory:64;\">";
        itemNameShapeHTML[6] = "<div id=\"wb_Shape21\" style=\"position:absolute;left:15px;top:844px;width:190px;height:27px;z-inventory:97;\">";
        itemNameShapeHTML[7] = "<div id=\"wb_Shape24\" style=\"position:absolute;left:305px;top:843px;width:190px;height:27px;z-inventory:75;\">";
        itemNameShapeHTML[8] = "<div id=\"wb_Shape27\" style=\"position:absolute;left:600px;top:844px;width:190px;height:27px;z-inventory:86;\">";
        itemNameShapeImageHTML = new String[9];
        itemNameShapeImageHTML[0] = "<img src=\"images/img0003.png\" id=\"Shape3\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[1] = "<img src=\"images/img0003.png\" id=\"Shape6\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[2] = "<img src=\"images/img0003.png\" id=\"Shape9\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[3] = "<img src=\"images/img0003.png\" id=\"Shape12\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[4] = "<img src=\"images/img0003.png\" id=\"Shape15\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[5] = "<img src=\"images/img0003.png\" id=\"Shape18\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[6] = "<img src=\"images/img0003.png\" id=\"Shape21\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[7] = "<img src=\"images/img0003.png\" id=\"Shape24\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameShapeImageHTML[8] = "<img src=\"images/img0003.png\" id=\"Shape27\" alt=\"\" style=\"width:190px;height:27px;\"></div>";
        itemNameTextHTML = new String[9];
        itemNameTextHTML[0] = "<div id=\"wb_Text4\" style=\"position:absolute;left:15px;top:234px;width:190px;height:18px;text-align:center;z-inventory:10;\">";
        itemNameTextHTML[1] = "<div id=\"wb_Text13\" style=\"position:absolute;left:305px;top:235px;width:190px;height:18px;text-align:center;z-inventory:21;\">";
        itemNameTextHTML[2] = "<div id=\"wb_Text20\" style=\"position:absolute;left:600px;top:236px;width:190px;height:18px;text-align:center;z-inventory:32;\">";
        itemNameTextHTML[3] = "<div id=\"wb_Text27\" style=\"position:absolute;left:15px;top:538px;width:190px;height:18px;text-align:center;z-inventory:43;\">";
        itemNameTextHTML[4] = "<div id=\"wb_Text34\" style=\"position:absolute;left:305px;top:539px;width:190px;height:18px;text-align:center;z-inventory:54;\">";
        itemNameTextHTML[5] = "<div id=\"wb_Text41\" style=\"position:absolute;left:600px;top:539px;width:190px;height:18px;text-align:center;z-inventory:65;\">";
        itemNameTextHTML[6] = "<div id=\"wb_Text48\" style=\"position:absolute;left:15px;top:848px;width:190px;height:18px;text-align:center;z-inventory:98;\">";
        itemNameTextHTML[7] = "<div id=\"wb_Text55\" style=\"position:absolute;left:305px;top:847px;width:190px;height:18px;text-align:center;z-inventory:76;\">";
        itemNameTextHTML[8] = "<div id=\"wb_Text62\" style=\"position:absolute;left:600px;top:848px;width:190px;height:18px;text-align:center;z-inventory:87;\">";
        itemPreviewImageHTML = new String[9];
        itemPreviewImageHTML[0] = "<div id=\"wb_Image1\" style=\"position:absolute;left:15px;top:110px;width:190px;height:113px;z-inventory:11;\">";
        itemPreviewImageHTML[1] = "<div id=\"wb_Image2\" style=\"position:absolute;left:305px;top:111px;width:190px;height:113px;z-inventory:22;\">";
        itemPreviewImageHTML[2] = "<div id=\"wb_Image3\" style=\"position:absolute;left:600px;top:112px;width:190px;height:113px;z-inventory:33;\">";
        itemPreviewImageHTML[3] = "<div id=\"wb_Image4\" style=\"position:absolute;left:15px;top:414px;width:190px;height:113px;z-inventory:44;\">";
        itemPreviewImageHTML[4] = "<div id=\"wb_Image5\" style=\"position:absolute;left:305px;top:415px;width:190px;height:113px;z-inventory:55;\">";
        itemPreviewImageHTML[5] = "<div id=\"wb_Image6\" style=\"position:absolute;left:600px;top:415px;width:190px;height:113px;z-inventory:66;\">";
        itemPreviewImageHTML[6] = "<div id=\"wb_Image7\" style=\"position:absolute;left:15px;top:724px;width:190px;height:113px;z-inventory:99;\">";
        itemPreviewImageHTML[7] = "<div id=\"wb_Image8\" style=\"position:absolute;left:305px;top:723px;width:190px;height:113px;z-inventory:77;\">";
        itemPreviewImageHTML[8] = "<div id=\"wb_Image9\" style=\"position:absolute;left:600px;top:724px;width:190px;height:113px;z-inventory:88;\">";
        itemPreviewImageSourceHTML = new String[9];
        itemPreviewImageSourceHTML[0] = "\" id=\"Image1\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[1] = "\" id=\"Image2\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[2] = "\" id=\"Image3\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[3] = "\" id=\"Image4\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[4] = "\" id=\"Image5\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[5] = "\" id=\"Image6\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[6] = "\" id=\"Image7\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[7] = "\" id=\"Image8\" alt=\"\"></div>";
        itemPreviewImageSourceHTML[8] = "\" id=\"Image9\" alt=\"\"></div>";
        itemPriceShapeHTML = new String[9];
        itemPriceShapeHTML[0] = "<div id=\"wb_Shape4\" style=\"position:absolute;left:35px;top:360px;width:150px;height:25px;z-inventory:12;\">";
        itemPriceShapeHTML[1] = "<div id=\"wb_Shape7\" style=\"position:absolute;left:325px;top:361px;width:150px;height:25px;z-inventory:23;\">";
        itemPriceShapeHTML[2] = "<div id=\"wb_Shape10\" style=\"position:absolute;left:620px;top:362px;width:150px;height:25px;z-inventory:34;\">";
        itemPriceShapeHTML[3] = "<div id=\"wb_Shape13\" style=\"position:absolute;left:35px;top:664px;width:150px;height:25px;z-inventory:45;\">";
        itemPriceShapeHTML[4] = "<div id=\"wb_Shape16\" style=\"position:absolute;left:325px;top:665px;width:150px;height:25px;z-inventory:56;\">";
        itemPriceShapeHTML[5] = "<div id=\"wb_Shape19\" style=\"position:absolute;left:620px;top:665px;width:150px;height:25px;z-inventory:67;\">";
        itemPriceShapeHTML[6] = "<div id=\"wb_Shape22\" style=\"position:absolute;left:35px;top:974px;width:150px;height:25px;z-inventory:100;\">";
        itemPriceShapeHTML[7] = "<div id=\"wb_Shape25\" style=\"position:absolute;left:325px;top:973px;width:150px;height:25px;z-inventory:78;\">";
        itemPriceShapeHTML[8] = "<div id=\"wb_Shape28\" style=\"position:absolute;left:620px;top:974px;width:150px;height:25px;z-inventory:89;\">";
        itemPriceShapeImageHTML = new String[9];
        itemPriceShapeImageHTML[0] = "<img src=\"images/img0004.png\" id=\"Shape4\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[1] = "<img src=\"images/img0004.png\" id=\"Shape7\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[2] = "<img src=\"images/img0004.png\" id=\"Shape10\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[3] = "<img src=\"images/img0004.png\" id=\"Shape13\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[4] = "<img src=\"images/img0004.png\" id=\"Shape16\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[5] = "<img src=\"images/img0004.png\" id=\"Shape19\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[6] = "<img src=\"images/img0004.png\" id=\"Shape22\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[7] = "<img src=\"images/img0004.png\" id=\"Shape25\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceShapeImageHTML[8] = "<img src=\"images/img0004.png\" id=\"Shape28\" alt=\"\" style=\"width:150px;height:25px;\"></div>";
        itemPriceTextHTML = new String[9];
        itemPriceTextHTML[0] = "<div id=\"wb_Text3\" style=\"position:absolute;left:35px;top:363px;width:150px;height:18px;text-align:center;z-inventory:13;\">";
        itemPriceTextHTML[1] = "<div id=\"wb_Text14\" style=\"position:absolute;left:325px;top:364px;width:150px;height:18px;text-align:center;z-inventory:24;\">";
        itemPriceTextHTML[2] = "<div id=\"wb_Text21\" style=\"position:absolute;left:620px;top:365px;width:150px;height:18px;text-align:center;z-inventory:35;\">";
        itemPriceTextHTML[3] = "<div id=\"wb_Text28\" style=\"position:absolute;left:35px;top:667px;width:150px;height:18px;text-align:center;z-inventory:46;\">";
        itemPriceTextHTML[4] = "<div id=\"wb_Text35\" style=\"position:absolute;left:325px;top:668px;width:150px;height:18px;text-align:center;z-inventory:57;\">";
        itemPriceTextHTML[5] = "<div id=\"wb_Text42\" style=\"position:absolute;left:620px;top:668px;width:150px;height:18px;text-align:center;z-inventory:68;\">";
        itemPriceTextHTML[6] = "<div id=\"wb_Text49\" style=\"position:absolute;left:35px;top:977px;width:150px;height:18px;text-align:center;z-inventory:101;\">";
        itemPriceTextHTML[7] = "<div id=\"wb_Text56\" style=\"position:absolute;left:325px;top:976px;width:150px;height:18px;text-align:center;z-inventory:79;\">";
        itemPriceTextHTML[8] = "<div id=\"wb_Text63\" style=\"position:absolute;left:620px;top:977px;width:150px;height:18px;text-align:center;z-inventory:90;\">";
    }
    
    public void writePage() throws IOException {
        writePageHeader();
        writeInventoryName();
        if(company.getLogo() != null) {
            writeLogo();
        }
        for (int i = 0; i < 9; i++) {
            if(items.get(i) != null) {
                writeItem(i);
            }
        }
        writeCompanyContactInfo();
        writePageFooter();
        inventory.close();
    }
    
    public void writePageHeader() {
        try {
            inventory.write("<!doctype html>");
            inventory.newLine();
            inventory.write("<html>");
            inventory.newLine();
            inventory.write("<head>");
            inventory.newLine();
            inventory.write("<meta charset=\"utf-8\">");
            inventory.newLine();
            inventory.write("<title>" + company.getName() + " - " + company.getInventoryName().toUpperCase() + "</title>");
            inventory.newLine();
            inventory.write("<link href=\"style.css\" rel=\"stylesheet\">");
            inventory.newLine();
            inventory.write("<link href=\"inventory.css\" rel=\"stylesheet\">");
            inventory.newLine();
            inventory.write("</head>");
            inventory.newLine();
            inventory.write("<body>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
        
    public void writeInventoryName() {
        try {
            int position = 700;
            if(company.getInventoryName().length() > 0 && company.getInventoryName().length() <= 10) {
                position = 275;
            }
            if(company.getInventoryName().length() > 10 && company.getInventoryName().length() <= 15) {
                position = 375;
            }
            if(company.getInventoryName().length() > 15 && company.getInventoryName().length() <= 20) {
                position = 475;
            }
            if(company.getInventoryName().length() > 20 && company.getInventoryName().length() <= 25) {
                position = 575;
            }
            inventory.write("<div id=\"wb_Shape1\" style=\"position:absolute;left:10px;top:10px;width:" + position + "px;height:35px;z-inventory:1;\">");
            inventory.newLine();
            inventory.write("<img src=\"images/img0001.png\" id=\"Shape1\" alt=\"\" style=\"width:" + (position + 5) + "px;height:35px;\"></div>");
            inventory.newLine();
            inventory.write("<div id=\"wb_Heading2\" style=\"position:absolute;left:15px;top:10px;width:" + position + "px;height:35px;z-inventory:2;\">");
            inventory.newLine();
            inventory.write("<h1 id=\"Heading2\">");
            inventory.write(company.getInventoryName().toUpperCase());
            inventory.write("</h1></div>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void writeLogo() {
        try {
            inventory.write("<div id=\"wb_Image10\" style=\"position:absolute;left:595px;top:10px;width:200px;height:85px;z-inventory:102;\">");
            inventory.newLine();
            inventory.write("<img src=\"images/" + company.getLogo().getName() + "\" id=\"Image10\" alt=\"\"></div>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void writeItem(int itemNumber) {
        try {
            inventory.write(itemShapeHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemShapeImageHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemF1TextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:13px;\">");
            inventory.write(items.get(itemNumber).getField1());
            inventory.write("</span></div>");
            inventory.newLine();
            inventory.write(itemF2TextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:13px;\">");
            inventory.write(items.get(itemNumber).getField2());
            inventory.write("</span></div>");
            inventory.newLine();
            inventory.write(itemF3TextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:13px;\">");
            inventory.write(items.get(itemNumber).getField3());
            inventory.write("</span></div>");
            inventory.newLine();
            inventory.write(itemF4TextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:13px;\">");
            inventory.write(items.get(itemNumber).getField4());
            inventory.write("</span></div>");
            inventory.newLine();
            inventory.write(itemF5TextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:13px;\">");
            inventory.write(items.get(itemNumber).getField5());
            inventory.write("</span></div>");
            inventory.newLine();
            inventory.write(itemNameShapeHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemNameShapeImageHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemNameTextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#000000;font-family:Tahoma;font-size:15px;\"><strong>");
            inventory.write(items.get(itemNumber).getName());
            inventory.write("</strong></span></div>");
            inventory.newLine();
            inventory.write(itemPreviewImageHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<img src=\"images/");
            inventory.write(items.get(itemNumber).getImage().getName());
            inventory.write(itemPreviewImageSourceHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemPriceShapeHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemPriceShapeImageHTML[itemNumber]);
            inventory.newLine();
            inventory.write(itemPriceTextHTML[itemNumber]);
            inventory.newLine();
            inventory.write("<span style=\"color:#FFFFFF;font-family:Tahoma;font-size:15px;\"><strong><em>$ ");
            inventory.write(items.get(itemNumber).getPrice());
            inventory.write("</em></strong></span></div>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void writeCompanyContactInfo() {
        try {
            if(items.get(6) == null && items.get(7) == null && items.get(8) == null) {
                if(!company.getWsappNumber().equals("")) {
                    inventory.write("<div id=\"wb_Image11\" style=\"position:absolute;left:10px;top:726px;width:100px;height:100px;z-inventory:103;\">");
                    inventory.newLine();
                    inventory.write("<img src=\"images/wsapp.jpg\" id=\"Image11\" alt=\"\"></div>");
                    inventory.newLine();
                    inventory.write("<div id=\"wb_Text64\" style=\"position:absolute;left:125px;top:763px;width:200px;height:24px;z-inventory:104;\">");
                    inventory.newLine();
                    inventory.write("<h4>" + company.getWsappNumber() + "</h4></div>");
                    inventory.newLine();
                }
                inventory.write("<div id=\"wb_Text65\" style=\"position:absolute;left:395px;top:739px;width:400px;height:24px;z-inventory:105;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getEmail() + "</h4></div>");
                inventory.newLine();
                inventory.write("<div id=\"wb_Text66\" style=\"position:absolute;left:395px;top:763px;width:400px;height:24px;z-inventory:106;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getWebPage()+ "</h4></div>");
                inventory.newLine();
                inventory.write("<div id=\"wb_Text67\" style=\"position:absolute;left:395px;top:787px;width:400px;height:24px;z-inventory:107;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getAddress()+ "</h4></div>");
                inventory.newLine();
            }
            else {
                if(!company.getWsappNumber().equals("")) {
                    inventory.write("<div id=\"wb_Image11\" style=\"position:absolute;left:10px;top:1038px;width:100px;height:100px;z-inventory:103;\">");
                    inventory.newLine();
                    inventory.write("<img src=\"images/wsapp.jpg\" id=\"Image11\" alt=\"\"></div>");
                    inventory.newLine();
                    inventory.write("<div id=\"wb_Text64\" style=\"position:absolute;left:125px;top:1075px;width:200px;height:24px;z-inventory:104;\">");
                    inventory.newLine();
                    inventory.write("<h4>" + company.getWsappNumber() + "</h4></div>");
                    inventory.newLine();
                }
                inventory.write("<div id=\"wb_Text65\" style=\"position:absolute;left:395px;top:1051px;width:400px;height:24px;z-inventory:105;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getEmail() + "</h4></div>");
                inventory.newLine();
                inventory.write("<div id=\"wb_Text66\" style=\"position:absolute;left:395px;top:1075px;width:400px;height:24px;z-inventory:106;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getWebPage()+ "</h4></div>");
                inventory.newLine();
                inventory.write("<div id=\"wb_Text67\" style=\"position:absolute;left:395px;top:1099px;width:400px;height:24px;z-inventory:107;\">");
                inventory.newLine();
                inventory.write("<h4>" + company.getAddress()+ "</h4></div>");
                inventory.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void writePageFooter() {
        try {
            inventory.write("</body>");
            inventory.newLine();
            inventory.write("</html>");
            inventory.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
