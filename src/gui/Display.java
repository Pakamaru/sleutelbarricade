package gui;

import models.Field;
import models.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Paints the display of the game. It creates the field using commands like Jframe and Jpanel
 */

public class Display{
    private int width;
    private int height;
    private String title;
    private JFrame myFrame;
    private JPanel myPanel;
    private JPanel buttonPanel;
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
        //myFrame.setSize(new Dimension(1600, 1080));
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding stuff
        myPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1));
        addResetButton();
        addHelpButton();
        addTextBox();
        myFrame.add(myPanel);
        myFrame.add(buttonPanel, BorderLayout.LINE_END);
        //make everything visible
        myFrame.setVisible(true);
    }

    /**
     * Creates the inner layer of the display
     * @param field gives a value to graph that lets it draw the field
     * @param x is the value of the horizontal coordinate in the game
     * @param y is the value of the vertical coordinate in the game
     */
    public void showField(Field field, int x, int y){
        try{
            this.myPanel.remove(graph);
        }catch (Exception e){

        }
        this.graph = new Graph(field, x, y);
        this.graph.setPreferredSize(new Dimension(800,800));
        this.myPanel.add(graph, BorderLayout.LINE_START);
        this.myPanel.setComponentZOrder(graph, 0);
        this.myFrame.getContentPane().validate();
        this.myFrame.getContentPane().repaint();
    }

    /**
     * Shows a TextBox
     * @param msg is the message that is shown in the textbox
     */
    public void showTextBox(String msg){
        textBoxText.writeText(msg);
        myFrame.getContentPane().validate();
        myFrame.getContentPane().repaint();
    }

    /**
     * Adds a textbox
     */
    private void addTextBox(){
        textBox = new JTextArea();
        textBox.setFocusable(false);
        textBox.setPreferredSize(new Dimension(300, 300));
        buttonPanel.add(textBox, BorderLayout.LINE_START);
        textBoxText = new TextBox(textBox);

        showTextBox("Move around :3");
    }

    /**
     * Adds the reset button that lets the player restart a level
     */
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
        buttonPanel.add(resetButton);

    }

    /**
     * Adds the help button that explains to the player what the goal of the game is
     */
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
        buttonPanel.add(helpButton);
    }

    /**
     * This is a popup that will tell you, you won the game
     */
    public void showWinScreen(){
        JOptionPane.showMessageDialog(myPanel, "You won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * A getter for myFrame
     * @return returns the myFrame
     */
    public JFrame getMyFrame() {
        return myFrame;
    }

}
