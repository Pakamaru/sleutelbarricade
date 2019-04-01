package gui;

import models.Field;
import models.Game;

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
    private Game game;
    private JTextArea textBox;
    private TextBox textBoxText;
    private JButton resetButton;
    private JButton helpButton;
    public Display(String title, int width, int height, Game game){
        this.game = game;
        this.width = width;
        this.height = height;
        this.title = title;
        //frame settings
        myFrame = new JFrame(title);
        myFrame.setSize(new Dimension(width, height));
        myFrame.setTitle("Sleutel Barricade");
        myFrame.setSize(new Dimension(1600, 1080));
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding stuff
        myPanel = new JPanel();
        myFrame.add(myPanel);
        addResetButton();
        addHelpButton();
        addTextBox();
        //make everything visible
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

    private void addTextBox(){
        textBox = new JTextArea();
        textBox.setFocusable(false);
        textBox.setPreferredSize(new Dimension(300, 450));
        myPanel.add(textBox);
        textBoxText = new TextBox(textBox);

        showTextBox("Move around :3");
    }

    private void addResetButton(){
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset level
                game.restartLevel();

            }
        });
        resetButton.setFocusable(false);
        myPanel.add(resetButton);

    }
    private void addHelpButton(){
        helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instructions
                JOptionPane.showMessageDialog(myPanel, "Try to reach the portal.\n " +
                        "Use the arrow keys to move. \n"+
                        "Open doors by picking up keys with the same code.\n " +
                        "You can only have one key at a time.\n" +
                        "You can open multiple doors with one key.\n " +
                        "If you get stuck use the reset button to try again", "Instructions", JOptionPane.INFORMATION_MESSAGE);


            }
        });
        helpButton.setFocusable(false);
        myPanel.add(helpButton);

    }


    public JFrame getMyFrame() {
        return myFrame;
    }

    public void refreshDisplay(){
    }
}
