package com.inventorygenerator;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.maven.shared.utils.io.FileUtils;

public class ImageLoader extends FileSelector {
    private final ItemWindow itemWindow;
    private final MainWindow mainWindow;
    public ImageLoader(MainWindow mainWindow) {
        super("Choose a logo image");
        this.mainWindow = mainWindow;
        this.itemWindow = null;
    }
    
    public ImageLoader(MainWindow mainWindow, ItemWindow itemWindow) {
        super("Choose an item image");
        this.mainWindow = mainWindow;
        this.itemWindow = itemWindow;
    }
    
    public void uploadImage() {
        int returnValue = getJfc().showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = getJfc().getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            File dest = new File(mainWindow.getDirectory() + "/images/" + selectedFile.getName());
            try {
                FileUtils.copyFile(selectedFile, dest);
                if(itemWindow == null) {
                    mainWindow.setLogo(dest);
		    mainWindow.writeTextToRegister("Logo picture (" + selectedFile.getName() + ") succesfully loaded.");
                }
                else {
                    itemWindow.setImage(dest);
                }
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
	}
    }
}
