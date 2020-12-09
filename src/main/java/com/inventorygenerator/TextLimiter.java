package com.inventorygenerator;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextLimiter extends PlainDocument {
    private final int wordLimit;
    TextLimiter(int wordLimit) {
        super();
        this.wordLimit = wordLimit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= wordLimit) {
            super.insertString(offs, str, attr);
        }
    }
}
