/* Copyright (c) 2009, Anthony Robinson
 * All Rights Reserved.
 *
 * GUI.java
 *
 * This is meant to be the GUI for the CS300 Tic-Tac-Toe game project.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GUI extends JFrame implements ActionListener{

        // Status variable to let us know whose turn it is.
        private char current_player = 'n';

        // Set up toggle buttons for selecting whose turn it is.
        private ImageIcon x_toggle_icon = new ImageIcon("Images/x.png");
        private ImageIcon o_toggle_icon = new ImageIcon("Images/o.png");
        private ImageIcon erase_toggle_icon = new ImageIcon("Images/erase.png");

        private JToggleButton x_toggle = new JToggleButton(x_toggle_icon);
        private JToggleButton o_toggle = new JToggleButton(o_toggle_icon);
        private JToggleButton erase_toggle = new JToggleButton(erase_toggle_icon);


        // Set up tic-tac-toe board icons for hover, pressing, and selected
        private ImageIcon board_square = new ImageIcon("Images/box.png");
        private ImageIcon board_square_hover =
                new ImageIcon("Images/box_hover.png");


        private ImageIcon board_square_x =
                new ImageIcon("Images/x_box_selected.png");
        private ImageIcon board_square_x_hover =
                new ImageIcon("Images/x_box_hover.png");
        private ImageIcon board_square_x_pressed =
                new ImageIcon("Images/x_box_pressed.png");

        private ImageIcon board_square_o =
                new ImageIcon("Images/o_box_selected.png");
        private ImageIcon board_square_o_hover =
                new ImageIcon("Images/o_box_hover.png");
        private ImageIcon board_square_o_pressed =
                new ImageIcon("Images/o_box_pressed.png");

        private ImageIcon board_square_e_pressed =
                new ImageIcon("Images/e_box_pressed.png");
        private ImageIcon board_square_e_hover =
                new ImageIcon("Images/e_box_hover.png");


        // Set up the array of buttons for the tic-tac-toe board
        private JButton[] boardButtons = {new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square)};

     


    void selectToggle(char button_to_toggle)
    {
    int i;

    if(button_to_toggle=='x')
        {
        x_toggle.setSelected(true);
        o_toggle.setSelected(false);
        erase_toggle.setSelected(false);


        for(i=0;i<9;++i)
            {
            boardButtons[i].setRolloverIcon(board_square_x_hover);
            boardButtons[i].setPressedIcon(board_square_x_pressed);
            }
        }
    else if(button_to_toggle=='o')
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(true);
        erase_toggle.setSelected(false);

        for(i=0;i<9;++i)
            {
            boardButtons[i].setRolloverIcon(board_square_o_hover);
            boardButtons[i].setPressedIcon(board_square_o_pressed);
            }
        }
    else if(button_to_toggle=='e')
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(false);
        erase_toggle.setSelected(true);

        for(i=0;i<9;++i)
            {
            boardButtons[i].setRolloverIcon(board_square_e_hover);
            boardButtons[i].setPressedIcon(board_square_e_pressed);
            }
        }
    else
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(false);

        for(i=0;i<9;++i)
            {
            boardButtons[i].setRolloverIcon(null);
            boardButtons[i].setPressedIcon(null);
            }
        }
    }

    void updateIcons(int selected_toggle)
        {
        if(selected_toggle == 1) // X is being clicked
            {
            // If X is being unselected then select eraser as default
            if(x_toggle.getSelectedObjects()==null) 
                {
                selectToggle('e'); // Select eraser
                current_player='e';
                }
            // If x is being selected unselect other two buttons
            else
                {
                selectToggle('x');
                current_player='x';
                }
            }
        else if(selected_toggle == 2) // O is being clicked
            {
            // If O is being unselected then select eraser as default
            if(o_toggle.getSelectedObjects()==null)
                {
                selectToggle('e');
                current_player='e';
                }
            // If O is being selected unselect other two buttons
            else
                {
                selectToggle('o');
                current_player='o';
                }
            }
        else // Default to eraser being clicked
            {
            // If O is being unselected then select eraser as default
            if(erase_toggle.getSelectedObjects()==null)
                {
                selectToggle('n');
                current_player='n';
                }
            else
                {
                selectToggle('e');
                current_player='e';
                }
            }

        }
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

        JMenu file_menu = new JMenu("File");
        JMenu help_menu = new JMenu("Help");

        menuBar.add(file_menu);
        menuBar.add(help_menu);

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

        

        x_toggle.addActionListener(this);
        x_toggle.setActionCommand("ToggleX");

        o_toggle.addActionListener(this);
        o_toggle.setActionCommand("ToggleO");

        erase_toggle.addActionListener(this);
        erase_toggle.setActionCommand("ToggleE");

        middleLeftPanel.add(Box.createRigidArea(new Dimension(50,0)));
            
        middleLeftPanel.add(x_toggle);
        middleLeftPanel.add(o_toggle);
        middleLeftPanel.add(erase_toggle);
            
        middlePanel.add(middleLeftPanel);
        middlePanel.add(Box.createHorizontalGlue());


        

        // Set up the Tic-Tac-Toe panel (boardPanelBackground) with a
        // background image and add the buttons for the individual spaces.
        Image boardPanelBackground =
                new ImageIcon("Images/board_background2.png").getImage();
        JPanel boardPanel = new JPanel_with_background(boardPanelBackground);

        GridLayout boardPanelGridLayout = new GridLayout(3,3,2,2);
        boardPanelGridLayout.preferredLayoutSize(boardPanel);
        boardPanel.setLayout(boardPanelGridLayout);

        boardPanel.setPreferredSize(
                new Dimension(board_square.getImage().getWidth(null)*3+12,
                board_square.getImage().getHeight(null)*3+8));

        boardPanel.setMaximumSize(
                new Dimension(board_square.getImage().getWidth(null)*3+12,
                board_square.getImage().getHeight(null)*3+8));

        boardPanel.setAlignmentX(0f);
        boardPanel.setAlignmentY(.5f);
        boardPanel.setOpaque(false);

        
        int i;
        for(i=0;i<9;++i)
            {
            boardButtons[i].setMargin(new Insets(0,0,0,0));
            boardButtons[i].setBorderPainted(false);
            boardButtons[i].setIconTextGap(0);
            boardButtons[i].setContentAreaFilled(false);
            boardButtons[i].setFocusPainted(false);
            boardButtons[i].addActionListener(this);
            boardButtons[i].setActionCommand(i+"_clicked");
            boardPanel.add(boardButtons[i]);
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

    // Implements java.awt.event.ActionListener.actionPerformed
    // listens for a toggle button change from x, o, or earse
    // toggle buttons. Then calls the appropriate methods to update
    // the mouseover icons on the board.
    public void actionPerformed(ActionEvent e)
        {
        System.out.println(e.getActionCommand());
        // X Toggle Button has been pressed.
        if(e.getActionCommand().equals("ToggleX"))
            {
            updateIcons(1); // Take care of images throughout
            }
        // O Toggle Button has been pressed.
        else if(e.getActionCommand().equals("ToggleO"))
            {
            updateIcons(2); // Take care of images throughout
            }
        // E Toggle Button has been pressed.
        else if(e.getActionCommand().equals("ToggleE"))
            {
            updateIcons(3); // Take care of images throughout
            }
        else if(e.getActionCommand().contains("clicked"))
            {
            String[] split_command = e.getActionCommand().split("_");
            int board_number = -1;
            board_number = Integer.parseInt(split_command[0]);
            if(board_number>=0 && board_number<=8)
                {
                if(current_player == 'x')
                    {
                    boardButtons[board_number].setIcon(board_square_x);
                    }
                else if(current_player == 'o')
                    {
                    boardButtons[board_number].setIcon(board_square_o);
                    }
                else if(current_player == 'e')
                    {
                    boardButtons[board_number].setIcon(board_square);
                    }
                }
            
            }
        }
    
    public static void main(String[] args)
        {
        GUI test = new GUI();
        test.setVisible(true);
        }
}

