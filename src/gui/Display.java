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
        //canvas = new Canvas();
        //canvas.setSize(new Dimension(width, height));


        this.width = width;
        this.height = height;
        this.title = title;
        this.field = field;
        showField(field);
        myFrame.setVisible(true);
        //drawPlayer(0,0);
    }
    public void showField(Field field){
        graph = new Graph(field);
        graph.setPreferredSize(new Dimension(800,800));
        myPanel.add(graph);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();

    }

    /*public void drawPlayer(int x, int y){
        player = new Player(this, field);
        //player.paint(g);
        myFrame.add(myPanel);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }*/

    public void createTile(){

    }

    public JFrame getMyFrame() {
        return myFrame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
