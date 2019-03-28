package gui;

import models.Field;
import models.Player;

import javax.swing.*;
import java.awt.*;

public class Display{
    private Field field;
    private int width;
    private int height;
    private String title;
    private JFrame myFrame;
    private JPanel myPanel;
    private Graph graph;
    private JTextArea textBox;
    private TextBox textBoxText;
    public Display(String title, int width, int height, Field field){
        myFrame = new JFrame(title);
        myFrame.setSize(new Dimension(width, height));
        myFrame.setTitle("Sleutel Barricade");
        myFrame.setSize(new Dimension(1600, 1080));
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel = new JPanel();
        myFrame.add(myPanel);
        textBox = new JTextArea();
        textBox.setFocusable(false);
        textBox.setPreferredSize(new Dimension(300, 450));
        myPanel.add(textBox);

        textBoxText = new TextBox(textBox);


        this.width = width;
        this.height = height;
        this.title = title;
        this.field = field;
        showField(field, 0, 0);
        showTextBox("Move around :3");
        myFrame.setVisible(true);
    }
    public void showField(Field field, int x, int y){
        try{
            myPanel.remove(graph);
        }catch (Exception e){

        }
        graph = new Graph(field, x, y);
        graph.setPreferredSize(new Dimension(800,800));
        myPanel.add(graph);
        myPanel.setComponentZOrder(graph, 0);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    public void showTextBox(String msg){
        textBoxText.writeText(msg);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    public JFrame getMyFrame() {
        return myFrame;
    }
}
