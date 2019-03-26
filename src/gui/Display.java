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
    private Canvas canvas;
    private Graph graph;
    private TextBox textBox;
    private Graphics g;
    private Player player;
    public Display(String title, int width, int height, Field field){
        myFrame = new JFrame(title);
        myFrame.setSize(new Dimension(width, height));
        myFrame.setTitle("Sleutel Barricade");
        myFrame.setSize(new Dimension(1600, 1080));
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel = new JPanel();
        myFrame.add(myPanel);


        this.width = width;
        this.height = height;
        this.title = title;
        this.field = field;
        showField(field, 0, 0);
        showHint("Move around :3");
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
        try{
            myPanel.remove(textBox);
        }catch (Exception e){

        }
        textBox = new TextBox(msg);
        textBox.setPreferredSize(new Dimension(450, 600));
        myPanel.add(textBox);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    public JFrame getMyFrame() {
        return myFrame;
    }
}
