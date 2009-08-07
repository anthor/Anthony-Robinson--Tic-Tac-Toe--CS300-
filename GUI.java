/* Copyright (c) 2009, Anthony Robinson
 * All Rights Reserved.
 *
 * GUI.java
 *
 * This is meant to be the GUI for the CS300 Tic-Tac-Toe game project.
 */
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Image;
import java.awt.Graphics;

class JPanel_with_background extends JPanel
    {
        private Image img;

        public JPanel_with_background(Image img)
            {
            this.img = img;
            }

        // We have to override paintComponent to
        // have a somewhat hacked background image
        @Override
        public void paintComponent(Graphics g)
            {
            g.drawImage(img,0,0,null);
            }
    }

public class GUI extends JFrame {

    public GUI()
        {
        setSize(800,600);
        setTitle("Tic Tac Toe v2.0");
        setResizable(false); // May change depending on requirements.

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        menuBar.add(menu);
        setJMenuBar(menuBar);
        Image mainPanelBackground = 
                new ImageIcon("Images/background.png").getImage();

        // Main panel will contain all the other panels.
        JPanel mainPanel = new JPanel_with_background(mainPanelBackground); 
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue());
        add(mainPanel);

        // topPanel just holds the title image and makes the layout cleaner.
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setAlignmentX(.5f);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(800,100));
        ImageIcon title = new ImageIcon("Images/tictactoe.png");
        topPanel.add(new JLabel(title));


        mainPanel.add(topPanel);


        // middlePanel will contain three other JPanels.
        // middleLeftPanel, boardPanel, middleRightPanel
        JPanel middlePanel = new JPanel();
        middlePanel.setOpaque(false);
        middlePanel.setAlignmentX(.5f);
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
        mainPanel.add(middlePanel);

            


        JPanel middleLeftPanel = new JPanel();
        middleLeftPanel.setOpaque(false);
        middleLeftPanel.setAlignmentX(0f);
        middleLeftPanel.setAlignmentY(.5f);
        middleLeftPanel.setLayout(
                new BoxLayout(middleLeftPanel, BoxLayout.Y_AXIS));
        middleLeftPanel.setPreferredSize(new Dimension(100,600));

        // Set up toggle button icons for selecting whose turn it is.
        ImageIcon x_toggle_icon = new ImageIcon("Images/x.png");
        ImageIcon o_toggle_icon = new ImageIcon("Images/o.png");
        ImageIcon erase_toggle_icon = new ImageIcon("Images/erase.png");

        JToggleButton x_toggle = new JToggleButton(x_toggle_icon);
        JToggleButton o_toggle = new JToggleButton(o_toggle_icon);
        JToggleButton erase_toggle = new JToggleButton(erase_toggle_icon);

        middleLeftPanel.add(Box.createRigidArea(new Dimension(50,0)));
            
        middleLeftPanel.add(x_toggle);
        middleLeftPanel.add(o_toggle);
        middleLeftPanel.add(erase_toggle);
            
        middlePanel.add(middleLeftPanel);
        middlePanel.add(Box.createHorizontalGlue());


        ImageIcon boardSquare = new ImageIcon("Images/tl_box.png");
        ImageIcon boardSquareOver = new ImageIcon("Images/tl_box_over.png");

        // Set up the Tic-Tac-Toe panel (boardPanelBackground) with a
        // background image and add the buttons for the individual spaces.
        Image boardPanelBackground =
                new ImageIcon("Images/board_background2.png").getImage();
        JPanel boardPanel = new JPanel_with_background(boardPanelBackground);

        GridLayout boardPanelGridLayout = new GridLayout(3,3,2,2);
        boardPanelGridLayout.preferredLayoutSize(boardPanel);
        boardPanel.setLayout(boardPanelGridLayout);

        boardPanel.setPreferredSize(
                new Dimension(boardSquare.getImage().getWidth(null)*3+12,
                boardSquare.getImage().getHeight(null)*3+8));

        boardPanel.setMaximumSize(
                new Dimension(boardSquare.getImage().getWidth(null)*3+12,
                boardSquare.getImage().getHeight(null)*3+8));

        boardPanel.setAlignmentX(0f);
        boardPanel.setAlignmentY(.5f);
        boardPanel.setOpaque(false);
           
        int i;
        for(i=0;i<9;++i)
            {
            JButton temp = new JButton(boardSquare);
            temp.setRolloverIcon(boardSquareOver);
            temp.setMargin(new Insets(0,0,0,0));
            temp.setBorderPainted(false);
            temp.setIconTextGap(0);
            temp.setContentAreaFilled(false);
            temp.setFocusPainted(false);
            boardPanel.add(temp);
            }

        middlePanel.add(boardPanel);
           
        // middleRightPanel is just a place holder for now to make sure
        // that the board is centered in the window.
        JPanel middleRightPanel = new JPanel();
        middleRightPanel.setOpaque(false);
        middleRightPanel.setAlignmentX(0f);
        middleRightPanel.setLayout(
                new BoxLayout(middleRightPanel, BoxLayout.X_AXIS));
        middleRightPanel.setPreferredSize(new Dimension(100,600));

        middlePanel.add(middleRightPanel);
        middlePanel.add(Box.createHorizontalGlue());

        // Set up the bottom panel which will hold the status text...
        // Most likely whose turn it is, and announcing a winner.
        JPanel bottomPanel = new JPanel();
        bottomPanel.setAlignmentX(.5f);
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(800,100));
        bottomPanel.add(new JLabel("Status Text Goes Down Here"));

        mainPanel.add(bottomPanel);

        }

    public static void main(String[] args)
        {
        GUI test = new GUI();
        test.setVisible(true);
        }
}

