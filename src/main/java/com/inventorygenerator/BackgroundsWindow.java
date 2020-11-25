package com.inventorygenerator;

public class BackgroundsWindow extends javax.swing.JFrame {
    private int backgroundNumber;
    private final MainWindow mainWindow;
    public BackgroundsWindow(MainWindow mainWindow, boolean visibility) {
        initComponents();
        this.mainWindow = mainWindow;
        backgroundNumber = mainWindow.getBackgroundNumber();
        changeBackground();
        pack();
        setLocationRelativeTo(mainWindow);
        setVisible(visibility);
    }
    
    public void displayNextBackground() {
        if(backgroundNumber == 12) {
            backgroundNumber = 1;
        }
        else {
            backgroundNumber++;
        }
        changeBackground();
    }
    
    public void displayPreviousBackground() {
        if(backgroundNumber == 1) {
            backgroundNumber = 12;
        }
        else {
            backgroundNumber--;
        }
        changeBackground();
    }
    
    public void closeWindow() {
        mainWindow.requestFocus();
        mainWindow.setEnabled(true);
        setVisible(false);
    }
    
    public final void changeBackground() {
        switch(backgroundNumber) {
            case 1:  CurrentBackgroundText.setText("BACKGROUND #1");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background1-thumbnail.png")));
                     break;
            case 2:  CurrentBackgroundText.setText("BACKGROUND #2");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background2-thumbnail.png")));
                     break;
            case 3:  CurrentBackgroundText.setText("BACKGROUND #3");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background3-thumbnail.png")));
                     break;
            case 4:  CurrentBackgroundText.setText("BACKGROUND #4");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background4-thumbnail.png")));
                     break;
            case 5:  CurrentBackgroundText.setText("BACKGROUND #5");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background5-thumbnail.png")));
                     break;
            case 6:  CurrentBackgroundText.setText("BACKGROUND #6");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background6-thumbnail.png")));
                     break;
            case 7:  CurrentBackgroundText.setText("BACKGROUND #7");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background7-thumbnail.png")));
                     break;
            case 8:  CurrentBackgroundText.setText("BACKGROUND #8");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background8-thumbnail.png")));
                     break;
            case 9:  CurrentBackgroundText.setText("BACKGROUND #9");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background9-thumbnail.png")));
                     break;
            case 10: CurrentBackgroundText.setText("BACKGROUND #10");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background10-thumbnail.png")));
                     break;
            case 11: CurrentBackgroundText.setText("BACKGROUND #11");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background11-thumbnail.png")));
                     break;
            case 12: CurrentBackgroundText.setText("BACKGROUND #12");
                     CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background12-thumbnail.png")));
                     break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CurrentBackgroundText = new javax.swing.JLabel();
        NextButton = new javax.swing.JButton();
        CurrentBackgroundThumbnail = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        SelectButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose the page background");
        setResizable(false);

        CurrentBackgroundText.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        CurrentBackgroundText.setText("BACKGROUND #1");

        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right-arrow.png"))); // NOI18N
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        CurrentBackgroundThumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background1-thumbnail.png"))); // NOI18N

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentBackgroundText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CurrentBackgroundThumbnail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NextButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CurrentBackgroundText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentBackgroundThumbnail, javax.swing.GroupLayout.Alignment.TRAILING)
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
        mainWindow.setBackgroundNumber(backgroundNumber);
    }//GEN-LAST:event_SelectButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        displayPreviousBackground();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        displayNextBackground();
    }//GEN-LAST:event_NextButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel CurrentBackgroundText;
    private javax.swing.JLabel CurrentBackgroundThumbnail;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton SelectButton;
    // End of variables declaration//GEN-END:variables
}
