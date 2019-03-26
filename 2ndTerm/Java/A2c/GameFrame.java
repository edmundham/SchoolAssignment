package ca.bcit.comp2526.a2c;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * GameFrame.java
 * GameFrame that extends JFrame and contains all components
 * that are needed to be for the game.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class GameFrame extends JFrame {
    
    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private static final int WORLD_SIZE = 25;
    private World world;
    private ButtonPanel buttonPanel;
    private GamePanel gamePanel;
    private JButton saveButton;
    private JButton loadButton;
    private JFileChooser saveDialog;
    private JFileChooser loadDialog;
    private JTextField saveTextField = new JTextField();
    private JTextField saveDir = new JTextField();
    private JTextField loadTextField = new JTextField();
    private JTextField loadDir = new JTextField();
    private FileNameExtensionFilter fileFilter;

    /**
     * GameFrame constructor that accepts World parameter.
     */
    public GameFrame() {
        world = new World(WORLD_SIZE, WORLD_SIZE);
        gamePanel = new GamePanel(world);
        gamePanel.init();
        buttonPanel = new ButtonPanel(this, world);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        
        fileFilter = new FileNameExtensionFilter("*.ser", "ser");
        
        saveTextField.setEditable(false);
        saveDir.setEditable(false);
        loadTextField.setEditable(false);
        loadDir.setEditable(false);
        
        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());
    }

    /**
     * sets the world object.
     * @param world is the base of the cells
     */
    public void setWorld(World world) {
        this.world = world;
    }
    
    /**
     * initializes GameFrame.
     */
    public void init() {
        setTitle("Assignment 2a");
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
//        addMouseListener(new TurnListener(this));
    }
    
    /**
     * gets the gamePanel object.
     * @return gamePanel that contains all cells
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }
    
    /**
     * adds gamePanel to the gameFrame. Also, removes gamePanel.
     */
    public void addGamePanel() {
        remove(gamePanel);
        world.resetWorld();
        gamePanel = new GamePanel(world);
        gamePanel.init();
        add(gamePanel, BorderLayout.CENTER);
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        repaint();
    }
    
    /**
     * loads gamePanel to the gameFrame which is used in serialization.
     */
    public void loadGamePanel() {
        remove(gamePanel);
        gamePanel = new GamePanel(world);
        gamePanel.init();
        add(gamePanel, BorderLayout.CENTER);
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        repaint();
    }

    /**
     * calls takeTurn method in world class and repaints the JFrame.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
    
    private class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            buttonPanel.setTimeToRun(false);
            saveDialog = new JFileChooser();
            saveDialog.setFileFilter(fileFilter);
            int rVal = saveDialog.showSaveDialog(GameFrame.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                saveTextField.setText(saveDialog.getSelectedFile().getName());
                saveDir.setText(saveDialog.getCurrentDirectory().toString());
                FileOutputStream fileOut = null;
                ObjectOutputStream out = null;
                
                try {
                    fileOut = new FileOutputStream(
                            saveDir.getText() + "\\" + saveTextField.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                
                try {
                    out = new ObjectOutputStream(fileOut);
                    out.writeObject(world);
                    out.close();
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                                
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                saveTextField.setText("You Pressed Cancel");
                saveDir.setText("");
            }
        }
        
    }
    
    private class LoadButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            buttonPanel.setTimeToRun(false);
            loadDialog = new JFileChooser();
            loadDialog.setFileFilter(fileFilter);
            int rVal = loadDialog.showOpenDialog(GameFrame.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                loadTextField.setText(loadDialog.getSelectedFile().getName());
                loadDir.setText(loadDialog.getCurrentDirectory().toString());
                FileInputStream fileIn = null;
                ObjectInputStream in = null;
                
                try {
                    fileIn = new FileInputStream(
                            loadDir.getText() + "\\" + loadTextField.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                
                try {
                    in = new ObjectInputStream(fileIn);
                    GameFrame.this.setWorld((World) in.readObject());
                    in.close();
                    fileIn.close();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
                GameFrame.this.loadGamePanel();
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                saveTextField.setText("You Pressed Cancel");
                saveDir.setText("");
            }
        }
        
    }
}
