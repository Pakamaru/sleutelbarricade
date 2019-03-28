package gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class TextBox{
    private long time;
    private JTextArea textArea;
    private static int FONTSIZE = 20;
    private static long STARTTIME = System.currentTimeMillis();

    public TextBox(JTextArea textArea){
        this.textArea = textArea;
        this.textArea.setFont(new Font("Arial",Font.PLAIN, FONTSIZE));
        this.textArea.setEditable(false);
    }

    public void writeText(String msg){
        if(textArea.getLineCount() == 10) {
            try {
                textArea.setText(textArea.getText().substring(textArea.getLineStartOffset(1)));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        time = (System.currentTimeMillis() - STARTTIME);
        int minutes = (int) time / (60 * 1000);
        int seconds = (int) (time / 1000) % 60;
        String str = String.format("%d:%02d - ", minutes, seconds);
        textArea.append(str + msg + "\n");

    }
}
