package com.inventorygenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;

public class MainWindow extends javax.swing.JFrame {
    private final boolean[] itemAdded;
    private Company company;
    private int positionOfRegisterText;
    private int colorsNumber;
    private int backgroundNumber;
    private File logo;
    private final List<Item> items;
    private final List<ItemWindow> itemWindows;
    private final String directory;
    private final File directory1;
    private final File directory2;
    private final File[] dest;
    private final InputStream[] background;
    private final InputStream[] pageFiles;
    private final ImageLoader imageLoader;
    public MainWindow() {
        initComponents();
        itemAdded = new boolean[9];
        items = new ArrayList<>();
        itemWindows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            itemAdded[i] = false;
            items.add(null);
            itemWindows.add(null);
        }
        positionOfRegisterText = 0;
        backgroundNumber = 1;
        colorsNumber = 1;
        directory = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/HTML Inventory Generator";
        directory1 = new File(directory);
	directory2 = new File(directory + "/images");
        if(!directory1.isDirectory()) {
            directory1.mkdir();
            directory2.mkdir();
            writeTextToRegister("\"HTML Inventory Generator\" folder succesfully created in " + directory.replace("/HTML Inventory Generator", "") + " directory.");
        }
	dest = new File[3];
	background = new InputStream[12];
        pageFiles = new InputStream[2];
	this.imageLoader = new ImageLoader(this);
    }
	
    public void addItem(int index, Item item) {
        items.add(index, item);
    }
    
    public int getColorsNumber() {
        return colorsNumber;
    }
    
    public int getBackgroundNumber() {
        return backgroundNumber;
    }
	
    public void setLogo(File logo) {
        this.logo = logo;
    }
    
    public Item getItem(int index) {
        return items.get(index);
    }
	
    public String getDirectory() {
        return directory;
    }
    
    public void setItemAdded(boolean itemAdded, int index) {
        this.itemAdded[index] = itemAdded;
    }
    
    public void setPositionOfRegisterText(int position) {
        this.positionOfRegisterText = position;
    }
    
    public void setColorsNumber(int index) {
        colorsNumber = index;
    }
    
    public void setBackgroundNumber(int index) {
        backgroundNumber = index;
    }
    
    public void setItem(int index, Item item) {
        items.set(index, item);
    }
    
    public void openItemWindow(int index) {
        setEnabled(false);
        itemWindows.set(index, new ItemWindow(this, true, itemAdded[index], index));
    }
    
    public ColorsWindow openColorsWindow() {
        setEnabled(false);
        return new ColorsWindow(this, true);
    }
    
    public BackgroundsWindow openBackgroundsWindow() {
        setEnabled(false);
        return new BackgroundsWindow(this, true);
    }
	
    public ErrorWindow1 openErrorWindow() {
        setEnabled(false);
        return new ErrorWindow1(this, true);
    }
    
    public void changeItemButtonState(int index, boolean state) {
        switch(index) {
            case 1: Item2Button.setEnabled(state);
                    break;
            case 2: Item3Button.setEnabled(state);
                    break;
            case 3: Item4Button.setEnabled(state);
                    break;
            case 4: Item5Button.setEnabled(state);
                    break;
            case 5: Item6Button.setEnabled(state);
                    break;
            case 6: Item7Button.setEnabled(state);
                    break;
            case 7: Item8Button.setEnabled(state);
                    break;
            case 8: Item9Button.setEnabled(state);
                    break;
        }
    }
    
    public void changeItemStateText(String text, int index) {
        switch(index) {
            case 0: Item1Button.setText(text);
                    break;
            case 1: Item2Button.setText(text);
                    break;
            case 2: Item3Button.setText(text);
                    break;
            case 3: Item4Button.setText(text);
                    break;
            case 4: Item5Button.setText(text);
                    break;
            case 5: Item6Button.setText(text);
                    break;
            case 6: Item7Button.setText(text);
                    break;
            case 7: Item8Button.setText(text);
                    break;
            case 8: Item9Button.setText(text);
                    break;
            default: break;
        }
    }
        
    public boolean checkCompanyData() {
        boolean condition1 = true, condition2 = true, condition3 = true; 
        if(InventoryNameField.getText().equals("")) {
            condition1 = false;
        }
        int emptyItems = 0;
        for(Item item : items) {
            if(item == null) {
                emptyItems++;
            }
        }
        if(emptyItems == 9) {
            condition2 = false;
        }
        if(CompanyField.getText().equals("")) {
            condition3 = false;
        }
        return !(!condition1 || !condition2 || !condition3);
    }
    
    public void createPage() {
        company = new Company(CompanyField.getText(), AdressField.getText(), WebPageField.getText(), EmailField.getText(), WANumberField.getText(), InventoryNameField.getText(), logo);
            try {
                File pagina = new File(directory + "/inventory.html");
                FileWriter fstream = new FileWriter(pagina);
                PageWriter pageWriter = new PageWriter(company, items, new BufferedWriter(fstream));
                pageWriter.writePage();
		background[0] = getClass().getResourceAsStream("/background1.jpg");
		background[1] = getClass().getResourceAsStream("/background2.jpg");
		background[2] = getClass().getResourceAsStream("/background3.jpg");
		background[3] = getClass().getResourceAsStream("/background4.jpg");
		background[4] = getClass().getResourceAsStream("/background5.jpg");
		background[5] = getClass().getResourceAsStream("/background6.jpg");
		background[6] = getClass().getResourceAsStream("/background7.jpg");
		background[7] = getClass().getResourceAsStream("/background8.jpg");
		background[8] = getClass().getResourceAsStream("/background9.jpg");
		background[9] = getClass().getResourceAsStream("/background10.jpg");
		background[10] = getClass().getResourceAsStream("/background11.jpg");
		background[11] = getClass().getResourceAsStream("/background12.jpg");
                pageFiles[0] = getClass().getResourceAsStream("/main.css");
		pageFiles[1] = getClass().getResourceAsStream("/wsapp.png");
                dest[0] = new File(directory + "/main.css");
		dest[1] = new File(directory + "/images/background.jpg");
		dest[2] = new File(directory + "/images/wsapp.png");
                try {
                    FileUtils.copyToFile(pageFiles[0], dest[0]);
                    FileUtils.copyToFile(background[backgroundNumber - 1], dest[1]);
                    FileUtils.copyToFile(pageFiles[1], dest[2]);
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
                writeTextToRegister("Page file (inventory.html) succesfully "
                        + "generated.");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
    }
    
    public final void writeTextToRegister(String text) {
        if(positionOfRegisterText == 0) {
            Register.insert(text, positionOfRegisterText);
            int position = positionOfRegisterText + text.length();
            setPositionOfRegisterText(position);
        }
        else {
            Register.insert("\n" + text, positionOfRegisterText);
            int position = positionOfRegisterText + text.length() + 1;
            setPositionOfRegisterText(position);
        } 
    }
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Item1Text = new javax.swing.JLabel();
        Item1Button = new javax.swing.JButton();
        Item2Text = new javax.swing.JLabel();
        Item2Button = new javax.swing.JButton();
        Item3Text = new javax.swing.JLabel();
        Item3Button = new javax.swing.JButton();
        Item4Text = new javax.swing.JLabel();
        Item4Button = new javax.swing.JButton();
        Item5Text = new javax.swing.JLabel();
        Item5Button = new javax.swing.JButton();
        Item6Text = new javax.swing.JLabel();
        Item6Button = new javax.swing.JButton();
        Item7Text = new javax.swing.JLabel();
        Item7Button = new javax.swing.JButton();
        Item8Text = new javax.swing.JLabel();
        Item8Button = new javax.swing.JButton();
        Item9Text = new javax.swing.JLabel();
        Item9Button = new javax.swing.JButton();
        InventoryNameField = new javax.swing.JTextField();
        InventoryNameText = new javax.swing.JLabel();
        CompanyField = new javax.swing.JTextField();
        CompanyText = new javax.swing.JLabel();
        AdressField = new javax.swing.JTextField();
        AdressText = new javax.swing.JLabel();
        LoadLogoButton = new javax.swing.JButton();
        WebPageField = new javax.swing.JTextField();
        WebPageText = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        EmailText = new javax.swing.JLabel();
        WANumberField = new javax.swing.JTextField();
        WANumberText = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        Scrollbar = new javax.swing.JScrollPane();
        Register = new javax.swing.JTextArea();
        CreatePageButton = new javax.swing.JButton();
        ChangeBackgroundButton = new javax.swing.JButton();
        ChangeColorsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HTML Inventory Generator");
        setResizable(false);

        Item1Text.setText("Item #1");
        Item1Text.setToolTipText("");

        Item1Button.setText("Add");
        Item1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item1ButtonActionPerformed(evt);
            }
        });

        Item2Text.setText("Item #2");

        Item2Button.setText("Add");
        Item2Button.setToolTipText("");
        Item2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item2ButtonActionPerformed(evt);
            }
        });

        Item3Text.setText("Item #3");

        Item3Button.setText("Add");
        Item3Button.setToolTipText("");
        Item3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item3ButtonActionPerformed(evt);
            }
        });

        Item4Text.setText("Item #4");

        Item4Button.setText("Add");
        Item4Button.setToolTipText("");
        Item4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item4ButtonActionPerformed(evt);
            }
        });

        Item5Text.setText("Item #5");

        Item5Button.setText("Add");
        Item5Button.setToolTipText("");
        Item5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item5ButtonActionPerformed(evt);
            }
        });

        Item6Text.setText("Item #6");

        Item6Button.setText("Add");
        Item6Button.setToolTipText("");
        Item6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item6ButtonActionPerformed(evt);
            }
        });

        Item7Text.setText("Item #7");

        Item7Button.setText("Add");
        Item7Button.setToolTipText("");
        Item7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item7ButtonActionPerformed(evt);
            }
        });

        Item8Text.setText("Item #8");

        Item8Button.setText("Add");
        Item8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item8ButtonActionPerformed(evt);
            }
        });

        Item9Text.setText("Item #9");

        Item9Button.setText("Add");
        Item9Button.setToolTipText("");
        Item9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item9ButtonActionPerformed(evt);
            }
        });

        InventoryNameText.setText("Inventory Name");

        CompanyText.setText("Company");

        AdressText.setText("Address");

        LoadLogoButton.setText("Load Logo Picture");
        LoadLogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadLogoButtonActionPerformed(evt);
            }
        });

        WebPageText.setText("Web Page");

        EmailText.setText("E-Mail");

        WANumberText.setText("WhatsApp Number");

        Register.setColumns(20);
        Register.setRows(5);
        Register.setFocusable(false);
        Scrollbar.setViewportView(Register);

        CreatePageButton.setText("Create Page");
        CreatePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePageButtonActionPerformed(evt);
            }
        });

        ChangeBackgroundButton.setText("Change Background");
        ChangeBackgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeBackgroundButtonActionPerformed(evt);
            }
        });

        ChangeColorsButton.setText("Change Colors");
        ChangeColorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeColorsButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Scrollbar, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(Separator))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ExitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(ChangeColorsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChangeBackgroundButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CreatePageButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(EmailText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(WANumberText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WANumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(WebPageText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WebPageField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(AdressText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AdressField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CompanyText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CompanyField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LoadLogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(InventoryNameText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(InventoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item3Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item3Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item1Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item2Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item4Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item5Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item6Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item7Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item7Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item8Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item8Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Item9Text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Item9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item1Text)
                            .addComponent(Item1Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item2Text)
                            .addComponent(Item2Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item3Text)
                            .addComponent(Item3Button)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item4Text)
                            .addComponent(Item4Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item5Text)
                            .addComponent(Item5Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item6Text)
                            .addComponent(Item6Button)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item7Text)
                            .addComponent(Item7Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item8Text)
                            .addComponent(Item8Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Item9Text)
                            .addComponent(Item9Button))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CompanyText)
                    .addComponent(CompanyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryNameText)
                    .addComponent(InventoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdressText)
                            .addComponent(AdressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WebPageText)
                            .addComponent(WebPageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailText)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WANumberText)
                            .addComponent(WANumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LoadLogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Scrollbar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(CreatePageButton)
                    .addComponent(ChangeBackgroundButton)
                    .addComponent(ChangeColorsButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void Item1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item1ButtonActionPerformed
        openItemWindow(0);       
    }//GEN-LAST:event_Item1ButtonActionPerformed

    private void LoadLogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadLogoButtonActionPerformed
        imageLoader.uploadImage();
    }//GEN-LAST:event_LoadLogoButtonActionPerformed

    private void ChangeBackgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeBackgroundButtonActionPerformed
        openBackgroundsWindow();
    }//GEN-LAST:event_ChangeBackgroundButtonActionPerformed

    private void CreatePageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePageButtonActionPerformed
        if(!checkCompanyData()) {
            openErrorWindow();
        }
        else {
            createPage();
        }  
    }//GEN-LAST:event_CreatePageButtonActionPerformed

    private void Item2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item2ButtonActionPerformed
        openItemWindow(1);
    }//GEN-LAST:event_Item2ButtonActionPerformed

    private void Item3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item3ButtonActionPerformed
        openItemWindow(2);
    }//GEN-LAST:event_Item3ButtonActionPerformed

    private void Item4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item4ButtonActionPerformed
        openItemWindow(3);
    }//GEN-LAST:event_Item4ButtonActionPerformed

    private void Item5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item5ButtonActionPerformed
        openItemWindow(4);
    }//GEN-LAST:event_Item5ButtonActionPerformed

    private void Item6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item6ButtonActionPerformed
        openItemWindow(5);
    }//GEN-LAST:event_Item6ButtonActionPerformed

    private void Item7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item7ButtonActionPerformed
        openItemWindow(6);
    }//GEN-LAST:event_Item7ButtonActionPerformed

    private void Item8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item8ButtonActionPerformed
        openItemWindow(7);
    }//GEN-LAST:event_Item8ButtonActionPerformed

    private void Item9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item9ButtonActionPerformed
        openItemWindow(8);
    }//GEN-LAST:event_Item9ButtonActionPerformed

    private void ChangeColorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeColorsButtonActionPerformed
        openColorsWindow();
    }//GEN-LAST:event_ChangeColorsButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdressField;
    private javax.swing.JLabel AdressText;
    private javax.swing.JButton ChangeBackgroundButton;
    private javax.swing.JButton ChangeColorsButton;
    private javax.swing.JTextField CompanyField;
    private javax.swing.JLabel CompanyText;
    private javax.swing.JButton CreatePageButton;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailText;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField InventoryNameField;
    private javax.swing.JLabel InventoryNameText;
    private javax.swing.JButton Item1Button;
    private javax.swing.JLabel Item1Text;
    private javax.swing.JButton Item2Button;
    private javax.swing.JLabel Item2Text;
    private javax.swing.JButton Item3Button;
    private javax.swing.JLabel Item3Text;
    private javax.swing.JButton Item4Button;
    private javax.swing.JLabel Item4Text;
    private javax.swing.JButton Item5Button;
    private javax.swing.JLabel Item5Text;
    private javax.swing.JButton Item6Button;
    private javax.swing.JLabel Item6Text;
    private javax.swing.JButton Item7Button;
    private javax.swing.JLabel Item7Text;
    private javax.swing.JButton Item8Button;
    private javax.swing.JLabel Item8Text;
    private javax.swing.JButton Item9Button;
    private javax.swing.JLabel Item9Text;
    private javax.swing.JButton LoadLogoButton;
    private javax.swing.JTextArea Register;
    private javax.swing.JScrollPane Scrollbar;
    private javax.swing.JSeparator Separator;
    private javax.swing.JTextField WANumberField;
    private javax.swing.JLabel WANumberText;
    private javax.swing.JTextField WebPageField;
    private javax.swing.JLabel WebPageText;
    // End of variables declaration//GEN-END:variables
}
