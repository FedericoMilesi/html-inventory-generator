package com.inventorygenerator;

import java.io.File;

public class ItemWindow extends javax.swing.JFrame {
    private boolean itemAdded;
    private final int itemNumber;
    private File image;
    private final MainWindow mainWindow;
    private final ImageLoader imageLoader;
    public ItemWindow(MainWindow mainWindow, boolean visibility, boolean itemAdded, int itemNumber) {
        initComponents();
        this.mainWindow = mainWindow;
        pack();
        setLocationRelativeTo(mainWindow);
        setVisible(visibility);
        this.itemAdded = itemAdded;
        this.itemNumber = itemNumber;
        setTitle("Item N° " + (itemNumber + 1));
	NameField.setDocument(new TextLimiter(24));
        Field1.setDocument(new TextLimiter(30));
        Field2.setDocument(new TextLimiter(30));
        Field3.setDocument(new TextLimiter(30));
        Field4.setDocument(new TextLimiter(30));
        Field5.setDocument(new TextLimiter(30));
        PriceField.setDocument(new TextLimiter(12));
        if(itemAdded) {
            NameField.setText(mainWindow.getItem(itemNumber).getName());
            Field1.setText(mainWindow.getItem(itemNumber).getField1());
            Field2.setText(mainWindow.getItem(itemNumber).getField2());
            Field3.setText(mainWindow.getItem(itemNumber).getField3());
            Field4.setText(mainWindow.getItem(itemNumber).getField4());
            Field5.setText(mainWindow.getItem(itemNumber).getField5());
            PriceField.setText(mainWindow.getItem(itemNumber).getPrice());
            this.image = mainWindow.getItem(itemNumber).getImage();
        }
	this.imageLoader = new ImageLoader(mainWindow, this);
    }

    public void setImage(File image) {
        this.image = image;
    }
	
    public void closeWindow() {
        mainWindow.requestFocus();
        setVisible(false);
    }
        
    public void deleteItem() {
        if(mainWindow.getItem(itemNumber) == null) {
            setEnabled(false);
            openErrorWindow3();
        }
        else {
            mainWindow.writeTextToRegister("Item N° " + (itemNumber + 1) 
                    + " deleted.");
            mainWindow.changeItemStateText("Add", itemNumber);
            itemAdded = false;
            mainWindow.setItemAdded(false, itemNumber);
            NameField.setText("");
            Field1.setText("");
            Field2.setText("");
            Field3.setText("");
            Field4.setText("");
            Field5.setText("");
            PriceField.setText("");
            this.image = null;
            mainWindow.setItem(itemNumber, null);
        }
    }
    
    public void addItem() {
        if(itemAdded == false) {
            mainWindow.writeTextToRegister("Item N° " + (itemNumber + 1) 
                    + " added.");
            mainWindow.changeItemStateText("Change", itemNumber);
            itemAdded = true;
            mainWindow.setItemAdded(true, itemNumber);
        }
        else {
            mainWindow.writeTextToRegister("Item N° " + (itemNumber + 1) 
                    + " changed.");
        }
        mainWindow.setItem(itemNumber, new Item(NameField.getText(), 
                Field1.getText(), Field2.getText(), Field3.getText(), 
                Field4.getText(), Field5.getText(), PriceField.getText(), image));
    }
	
    public ErrorWindow2 openErrorWindow2() {
        setEnabled(false);
        return new ErrorWindow2(mainWindow, this, true);
    }
    
    public ErrorWindow3 openErrorWindow3() {
        setEnabled(false);
        return new ErrorWindow3(mainWindow, this, true);
    }
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameField = new javax.swing.JTextField();
        NameText = new javax.swing.JLabel();
        Field1 = new javax.swing.JTextField();
        Field1Text = new javax.swing.JLabel();
        Field2 = new javax.swing.JTextField();
        Field2Text = new javax.swing.JLabel();
        Field3 = new javax.swing.JTextField();
        Field3Text = new javax.swing.JLabel();
        Field4 = new javax.swing.JTextField();
        Field4Text = new javax.swing.JLabel();
        Field5 = new javax.swing.JTextField();
        Field5Text = new javax.swing.JLabel();
        LoadImageButton = new javax.swing.JButton();
        ImageText = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        PriceText = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);

        NameText.setText("Name");

        Field1Text.setText("Field #1");

        Field2Text.setText("Field #2");

        Field3Text.setText("Field #3");

        Field4Text.setText("Field #4");

        Field5Text.setText("Field #5");

        LoadImageButton.setText("Load");
        LoadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadImageButtonActionPerformed(evt);
            }
        });

        ImageText.setText("Image");

        PriceText.setText("Price");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Field3Text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(Field4Text)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Field5Text)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PriceText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImageText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Field1Text)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Field2Text)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameText)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field1Text)
                    .addComponent(Field1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field2Text)
                    .addComponent(Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field3Text)
                    .addComponent(Field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field4Text)
                    .addComponent(Field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field5Text)
                    .addComponent(Field5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PriceText)
                        .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LoadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ImageText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(BackButton)
                    .addComponent(DeleteButton))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        closeWindow();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(NameField.getText().equals("") || PriceField.getText().equals("") || image == null) 
        {
            setEnabled(false);
            openErrorWindow2();
        }
        else {
            addItem();
        }    
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        deleteItem();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void LoadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadImageButtonActionPerformed
        imageLoader.uploadImage();
    }//GEN-LAST:event_LoadImageButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField Field1;
    private javax.swing.JLabel Field1Text;
    private javax.swing.JTextField Field2;
    private javax.swing.JLabel Field2Text;
    private javax.swing.JTextField Field3;
    private javax.swing.JLabel Field3Text;
    private javax.swing.JTextField Field4;
    private javax.swing.JLabel Field4Text;
    private javax.swing.JTextField Field5;
    private javax.swing.JLabel Field5Text;
    private javax.swing.JLabel ImageText;
    private javax.swing.JButton LoadImageButton;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameText;
    private javax.swing.JTextField PriceField;
    private javax.swing.JLabel PriceText;
    private javax.swing.JButton SaveButton;
    // End of variables declaration//GEN-END:variables
}
