package gui;

import models.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display{
    private int width;
    private int height;
    private String title;
    private JFrame myFrame;
    private JPanel myPanel;
    private Graph graph;
    private JTextArea textBox;
    private TextBox textBoxText;
    private JButton resetButton;
    public Display(String title, int width, int height){
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
        addResetButton();

        textBoxText = new TextBox(textBox);


        this.width = width;
        this.height = height;
        this.title = title;
        showTextBox("Move around :3");
        myFrame.setVisible(true);
    }
    public void showField(Field field, int x, int y){
        try{
            this.myPanel.remove(graph);
        }catch (Exception e){

        }
        this.graph = new Graph(field, x, y);
        this.graph.setPreferredSize(new Dimension(800,800));
        this.myPanel.add(graph);
        this.myPanel.setComponentZOrder(graph, 0);
        this.myFrame.getContentPane().validate();
        this.myFrame.getContentPane().repaint();
    }

    public void showTextBox(String msg){
        textBoxText.writeText(msg);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    public void addResetButton(){
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset level
            }
        });
        myPanel.add(resetButton);

    }

    public JFrame getMyFrame() {
        return myFrame;
    }

    public void refreshDisplay(){
    }
}
