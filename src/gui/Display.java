package gui;

import models.Field;
import models.Tile;

import javax.rmi.CORBA.Tie;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Display{
    public void showField(Field field) throws IOException {
        JFrame myFrame = new JFrame();
        myFrame.setSize(new Dimension(800, 800));
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
