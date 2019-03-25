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
    private Graphics g;
    private Player player;
    public Display(String title, int width, int height, Field field){
        myFrame = new JFrame(title);
        myFrame.setSize(new Dimension(width, height));
        myFrame.setTitle("Sleutel Barricade");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel = new JPanel();
        myFrame.add(myPanel);
        graph = new Graph(field, 0,0);
        graph.setPreferredSize(new Dimension(800,800));
        myPanel.add(graph);


        this.width = width;
        this.height = height;
        this.title = title;
        this.field = field;
        showField(field, 0, 0);
        myFrame.setVisible(true);
    }
    public void showField(Field field, int x, int y){
        myPanel.remove(graph);
        graph = new Graph(field, x, y);
        graph.setPreferredSize(new Dimension(800,800));
        myPanel.add(graph);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    public JFrame getMyFrame() {
        return myFrame;
    }
}
