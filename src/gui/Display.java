package gui;

import models.Field;
import models.Tile;

import javax.rmi.CORBA.Tie;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Display{
    private Field field;
    private int width;
    private int height;
    private String title;
    public Display(String title, int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        this.title = title;
        field = new Field();
        showField(field);
    }
    public void showField(Field field) throws IOException {
        JFrame myFrame = new JFrame(title);
        myFrame.setSize(new Dimension(width, height));
        //myFrame.setLayout(new BorderLayout(0, 0));
        //myFrame.setLayout(new GridLayout(10,10, 2, 2));
        myFrame.setTitle("Sleutel Barricade");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel myPanel = new JPanel();
        myFrame.add(myPanel);

        Graph graph = new Graph(field);
        graph.setPreferredSize(new Dimension(800,800));
        myPanel.add(graph);




        myFrame.setVisible(true);
    }

    public void createTile(){

    }
}
