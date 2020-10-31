package com.inventorygenerator;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFileChooser;

public class FileSelector {
    private final FileNameExtensionFilter[] filter;
    private final JFileChooser jfc;
    public FileSelector(String dialogTitle) {
        filter = new FileNameExtensionFilter[5];
        filter[0] = new FileNameExtensionFilter("Bitmap image file (*.bmp)", "bmp");
        filter[1] = new FileNameExtensionFilter("JPEG (*.jpg,*.jpeg)", "jpg", "jpeg");
        filter[2] = new FileNameExtensionFilter("GIF (*.gif)", "gif");
        filter[3] = new FileNameExtensionFilter("PNG (*.png)", "png");
        filter[4] = new FileNameExtensionFilter("All supported image file formats", "bmp", "jpg", "jpeg", "gif", "png");
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle(dialogTitle);
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(filter[4]);
        jfc.addChoosableFileFilter(filter[0]);
        jfc.addChoosableFileFilter(filter[1]);
        jfc.addChoosableFileFilter(filter[2]);
        jfc.addChoosableFileFilter(filter[3]);
    }
    
    public JFileChooser getJfc() {
        return this.jfc;
    } 
}
