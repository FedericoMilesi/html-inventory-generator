package com.inventorygenerator;

public class ColorsWindow extends javax.swing.JFrame {
    private int colorsNumber;
    private final MainWindow mainWindow;
    public ColorsWindow(MainWindow mainWindow, boolean visibility) {
        initComponents();
        this.mainWindow = mainWindow;
        colorsNumber = mainWindow.getColorsNumber();
        changeColors();
        pack();
        setLocationRelativeTo(mainWindow);
        setVisible(visibility);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CurrentColorsText = new javax.swing.JLabel();
        NextButton = new javax.swing.JButton();
        CurrentColorsThumbnail = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        SelectButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose the item colors");
        setResizable(false);

        CurrentColorsText.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        CurrentColorsText.setText("COLORS #1");

        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right-arrow.png"))); // NOI18N
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        CurrentColorsThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colors1.png"))); // NOI18N

        PreviousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        SelectButton.setText("SELECT");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        BackButton.setText("BACK");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PreviousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CurrentColorsThumbnail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NextButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CurrentColorsText)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CurrentColorsText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentColorsThumbnail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PreviousButton)
                                .addGap(121, 121, 121)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NextButton)
                        .addGap(169, 169, 169)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        closeWindow();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
        mainWindow.setColorsNumber(colorsNumber);
    }//GEN-LAST:event_SelectButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        displayPreviousColors();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        displayNextColors();
    }//GEN-LAST:event_NextButtonActionPerformed

    public void displayNextColors() {
        if(colorsNumber == 3) {
            colorsNumber = 1;
        }
        else {
            colorsNumber++;
        }
        changeColors();
    }
    
    public void displayPreviousColors() {
        if(colorsNumber == 1) {
            colorsNumber = 3;
        }
        else {
            colorsNumber--;
        }
        changeColors();
    }
    
    public void closeWindow() {
        mainWindow.requestFocus();
        mainWindow.setEnabled(true);
        setVisible(false);
    }
    
    public final void changeColors() {
        switch(colorsNumber) {
            case 1:  CurrentColorsText.setText("COLORS #1");
                     CurrentColorsThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colors1.png")));
                     break;
            case 2:  CurrentColorsText.setText("COLORS #2");
                     CurrentColorsThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colors2.png")));
                     break;
            case 3:  CurrentColorsText.setText("COLORS #3");
                     CurrentColorsThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colors3.png")));
                     break;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel CurrentColorsText;
    private javax.swing.JLabel CurrentColorsThumbnail;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton SelectButton;
    // End of variables declaration//GEN-END:variables
}
