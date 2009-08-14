/* Copyright (c) 2009,
 * All Rights Reserved.
 *
 * Anthony Robinson
 * anthor@pdx.edu
 *
 *
 * FILE: GUI.java
 *
 * Originally my plan was to create just a single class for the GUI,
 * a single class for the logic, and combine them with a class called
 * combine. That is pretty much what ended up happening except GUI.java
 * ended up doing part of the logic as well, because Logic.java couldn't
 * make calls to GUI.java and vice versa.
 *
 * Pretty much, GUI.java sets up the GUI (quite horrendous code because
 * I coded the GUI by hand instead of using a visual GUI builder, and it
 * was my first time using Java Swing / 3rd time coding in Java). Anyways,
 * GUI.java sets up the GUI, creates an board from Logic.java to keep
 * track of wins losses and draws effectively, and coordinates the exchange
 * of data between the two classes / allows interaction with the user.
 *
 */

// So we can create an instance of the Logic class
package tttpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

// Win_draw_dialog creates a dialog
// window if a player has just won,
// lost, or drew the game.
// After the user hits the close button
// a new game will start automatically.
class Win_draw_dialog extends JDialog
    {
    // Same declaration as in GUI Class but we need the images for the
    // Dialog as well...
    ImageIcon x_toggle_icon = new ImageIcon("Images/x.png");
    ImageIcon o_toggle_icon = new ImageIcon("Images/o.png");

    // felixwhis.png from http://www.i-love-cats.com/catgraphics.html
    ImageIcon draw_icon = new ImageIcon("Images/felixwhis.png");

    public Win_draw_dialog(char winner)
        {

        if(winner=='d') // Game is drawn.
            {
            setTitle("Draw Game!");
            getContentPane().setBackground(Color.black);
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

            // Add label for the felix the cat icon from
            // http://www.i-love-cats.com/catgraphics.html
            JLabel draw_label = new JLabel(draw_icon);
            draw_label.setAlignmentY(0.5f);
            draw_label.setAlignmentX(0.5f);

            
            add(draw_label);

            // Add text that says "Cats Game!" white, 32pt bold
            JLabel winner_label = new JLabel("Cats Game!");
            winner_label.setFont(new Font("Arial", Font.BOLD, 32));
            winner_label.setForeground(Color.white);
            winner_label.setAlignmentX(.5f);
            winner_label.setAlignmentY(.5f);


            add(winner_label);


            // clear_and_close is the dialog button that just
            // closes the dialog box.
            JButton clear_and_close = new JButton("Clear Board and Close");
            clear_and_close.setAlignmentX(.5f);
            clear_and_close.setAlignmentY(.5f);

            // Bad formatting but it is strange creating
            // a new method inside a method call.
            clear_and_close.addActionListener(
                new ActionListener()
                {
                public void actionPerformed(ActionEvent event)
                    {
                    dispose();
                    }
                });

            // Separate the text and icon from the button
            // so the button is on the bottom of the dialog.
            add(Box.createRigidArea(new Dimension(0,20)));
            add(Box.createVerticalGlue());


            add(clear_and_close);


            setModalityType(ModalityType.APPLICATION_MODAL);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);
            }

        else // Either X or O has won the game.
            {
            setTitle(winner +" has won!");
            getContentPane().setBackground(Color.black);
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


            // Need to create the label before the x_icon
            // or o_icon so we can change the text color
            // according to who won (x = red, o = blue).
            JLabel winner_label = new JLabel("Has Won!");
            winner_label.setFont(new Font("Arial", Font.BOLD, 32));
            winner_label.setAlignmentY(0.5f);
            winner_label.setAlignmentX(0.5f);


            // Set icon to x_toggle_icon and change
            // the color of winner_label to red.
            if(winner == 'x')
                {
                JLabel x_label = new JLabel(x_toggle_icon);
                x_label.setAlignmentY(0.5f);
                x_label.setAlignmentX(0.5f);
                add(x_label);

                winner_label.setForeground(Color.red);
                }

            // Set icon to o_toggle_icon and change
            // the color of winner_label to blue.
            if(winner == 'o')
                {
                JLabel o_label = new JLabel(o_toggle_icon);
                o_label.setAlignmentY(0.5f);
                o_label.setAlignmentX(0.5f);
                add(o_label);

                winner_label.setForeground(Color.blue);
                }


            add(winner_label);
            

            // Create separation between the button and the text/icon
            // so that the button is at the bottom of the dialog box.
            add(Box.createRigidArea(new Dimension(0,20)));
            add(Box.createVerticalGlue());

            // clear_and_close just closes the dialog box
            JButton clear_and_close = new JButton("Clear Board and Close");
            clear_and_close.setAlignmentX(0.5f);
            clear_and_close.setAlignmentY(0.5f);

            // Bad formatting but it is strange creating
            // a new method inside a method call.
            clear_and_close.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent event)
                    {
                    dispose();
                    }
                });


            add(clear_and_close);


            setModalityType(ModalityType.APPLICATION_MODAL);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(300, 250);
            setLocationRelativeTo(null);
            }
        }
    }

class About_dialog extends JDialog
    {

    // felixwhis.png from http://www.i-love-cats.com/catgraphics.html
    ImageIcon draw_icon = new ImageIcon("Images/felixwhis.gif");

    public About_dialog()
        {
        setTitle("About Tic-Tac-Toe V3.14159!");
        getContentPane().setBackground(Color.white);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add label for the felix the cat icon from
        // http://www.i-love-cats.com/catgraphics.html
        JLabel draw_label = new JLabel(draw_icon);
        draw_label.setAlignmentY(0.5f);
        draw_label.setAlignmentX(0.5f);


        add(draw_label);

        String about_html = "<html><i><center>Tic-Tac-Toe V3.14159 was " +
                    "designed<br>by Anthony Robinson, Copyright 2009.<br><br>" +
                    "For more info please contact: <br><br><br> Anthony " +
                    "Robinson<br> anthor@pdx.edu<br><br></center></i></html>";
        // Add text that says "Cats Game!" white, 32pt bold
        JLabel about_label =
                    new JLabel(about_html,JLabel.CENTER);
        about_label.setFont(new Font("Arial", Font.BOLD, 12));
        about_label.setForeground(Color.black);
        about_label.setAlignmentX(0.5f);
        about_label.setAlignmentY(0.5f);


        add(about_label);


        // clear_and_close is the dialog button that just
        // closes the dialog box.
        JButton clear_and_close = new JButton("OK");
        clear_and_close.setAlignmentX(0.5f);
        clear_and_close.setAlignmentY(0.5f);

        // Bad formatting but it is strange creating
        // a new method inside a method call.
        clear_and_close.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                    {
                    dispose();
                    }
                });

        // Separate the text and icon from the button
        // so the button is on the bottom of the dialog.
        add(Box.createRigidArea(new Dimension(0,20)));
        add(Box.createVerticalGlue());


        add(clear_and_close);


        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 375);
        setLocationRelativeTo(null);
        

    }
}
// JPanel_with_background is the only way I could
// figure out to add a background to a panel... had
// to override the paintComponent method of JPanel
// and draw the image.
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


// GUI Class that pretty much handles all of the tic-tac-toe
// Game. If I had developed this better I am sure this class
// would contain much much less code and methods, but as it is
// this is how I planned to make it when I did my planning.
public class GUI extends JFrame implements ActionListener{


        // Set up all the variables needed throughout the class.

        // Set up a new board from Logic.java
        tttpackage.Logic new_board = new tttpackage.Logic();


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


        // Set up the array of buttons for the tic-tac-toe board sqaures.
        private JButton[] boardButtons = {new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square),
            new JButton(board_square),new JButton(board_square)};

     

    // Logic to make sure only one toggle button is selected
    // and to change it to eraser automatically when x or o
    // is unselected.
    void selectToggle(char button_to_toggle)
    {
    int i;

    // If user hit the X toggle button set O and Erase to unselected
    // and set the tic-tac-toe board rollover icons to board_square_x_hover
    // and their pressed icons to board_square_x_pressed.
    if(button_to_toggle=='x')
        {
        x_toggle.setSelected(true);
        o_toggle.setSelected(false);
        erase_toggle.setSelected(false);

        for(i=0;i<9;++i) // Change board button icons
            {
            boardButtons[i].setRolloverIcon(board_square_x_hover);
            boardButtons[i].setPressedIcon(board_square_x_pressed);
            }
        }

    // If user hit the O toggle button set X and Erase to unselected
    // and set the tic-tac-toe board rollover icons to board_square_o_hover
    // and their pressed icons to board_square_o_pressed.
    else if(button_to_toggle=='o')
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(true);
        erase_toggle.setSelected(false);

        for(i=0;i<9;++i) // Change board button icons
            {
            boardButtons[i].setRolloverIcon(board_square_o_hover);
            boardButtons[i].setPressedIcon(board_square_o_pressed);
            }
        }

    // If user hit the Erase toggle button set X and O to unselected
    // and set the tic-tac-toe board rollover icons to board_square_e_hover
    // and their pressed icons to board_square_e_pressed.
    else if(button_to_toggle=='e')
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(false);
        erase_toggle.setSelected(true);

        for(i=0;i<9;++i) // Change board button icons
            {
            boardButtons[i].setRolloverIcon(board_square_e_hover);
            boardButtons[i].setPressedIcon(board_square_e_pressed);
            }
        }

    // This is the case where user unselected the Erase toggle
    // so we set x and o toggle buttons to unselected and let Erase
    // be unselected.
    else
        {
        x_toggle.setSelected(false);
        o_toggle.setSelected(false);
        erase_toggle.setSelected(false);
        // Get rid of rollover icons because nothing is selected
        for(i=0;i<9;++i)
            {
            boardButtons[i].setRolloverIcon(null);
            boardButtons[i].setPressedIcon(null);
            }
        }
    }

    // updateIcons takes an integer that represents what toggle button
    // is being selected, and determines using .getSelectedObjects()
    // whether or not the toggle button is being toggled up or down
    // then calls the appropriate methods to update the icons.
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




    // Convert board_number 0 through 8 to the corresponding
    // row and column for use w/ Logic.java
    int[] boardNumberToRowCol(int board_number)
        {
        int [] result = {0,0};

        if(board_number<=2 && board_number>=0)
            {
            result[0]=0;
            result[1]=board_number;
            }
        if (board_number <= 5 && board_number >= 3) {
            result[0] = 1;
            result[1] = board_number%3;
            }
        if (board_number <= 8 && board_number >= 6) {
            result[0] = 2;
            result[1] = board_number%3;
            }

        return result;
        }

    // Sets the GUI Board to look like a new game,
    // sets the current player to none, and makes the toggle buttons
    // reflect that change.
    public void cleanBoard()
    {
    current_player = 'n'; // Change player to none
    selectToggle('n'); // Unselect all toggle buttons
    int i;
    for(i=0;i<9;++i)
        {
        boardButtons[i].setIcon(board_square);
        }
    }

    // Calls the Logic.java checkBoard() method
    // to determine whether or not a player has won
    // after each time a player makes a move and
    // calls the appropriate methods depending on
    // who won, or if it was a draw / still playing.
    void checkWin()
    {
    int status = new_board.checkBoard();

    if(status == 0) // Still playing
        {
        return;
        }

    else if(status == 2) // X Won
        {
        Win_draw_dialog x_win = new Win_draw_dialog('x');
        x_win.setVisible(true);
        cleanBoard();
        new_board.cleanBoard();
        return;
        }

    else if(status == 1) // O won
        {
        Win_draw_dialog o_win = new Win_draw_dialog('o');
        o_win.setVisible(true);
        cleanBoard();
        new_board.cleanBoard();
        return;
        }

    else if(status == 3) // Draw game
        {
        Win_draw_dialog no_win = new Win_draw_dialog('d');
        no_win.setVisible(true);
        cleanBoard();
        new_board.cleanBoard();
        return;
        }
    }

    // Implements java.awt.event.ActionListener.actionPerformed
    // listens for a toggle button change from x, o, or earse
    // toggle buttons. Then calls the appropriate methods to update
    // the mouseover icons on the board.
    public void actionPerformed(ActionEvent e)
        {
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

        // If the action command contains the string "clicked"
        // then it is from one of the board squares (buttons)
        // so get the board number out of the string and change
        // the clicked buttons icon to whatever player is selected.
        else if(e.getActionCommand().contains("clicked"))
            {
            // String should be i_clicked, so split it with _
            String[] split_command = e.getActionCommand().split("_");

            // In case we don't get a valid integer
            // out of Integer.parseInt set board_number to -1
            int board_number = -1;
            board_number = Integer.parseInt(split_command[0]);

            // Check for valid range of board numbers
            if(board_number>=0 && board_number<=8)
                {
                if(current_player == 'x')
                    {
                    boardButtons[board_number].setIcon(board_square_x);
                    int[] row_col = boardNumberToRowCol(board_number);
                    new_board.addMove(row_col[0],row_col[1],'x');
                    checkWin();
                    }
                else if(current_player == 'o')
                    {
                    boardButtons[board_number].setIcon(board_square_o);
                    int[] row_col = boardNumberToRowCol(board_number);
                    new_board.addMove(row_col[0],row_col[1],'o');
                    checkWin();
                    }
                else if(current_player == 'e')
                    {
                    boardButtons[board_number].setIcon(board_square);
                    int[] row_col = boardNumberToRowCol(board_number);
                    new_board.addMove(row_col[0],row_col[1],' ');
                    checkWin();
                    }
                }

            }
        }

    
    // GUI is the main method of the GUI Class that sets up the GUI...
    // I apologize for how ugly this code is, I entirely new
    // at designing GUI's by coding, and so I am not sure how
    // to modularize it correctly. For now everything is going
    // to be set up in this GUI() method.
    public GUI()
        {
        setTitle("Tic Tac Toe v3.14159");
        setSize(800,600); // 800x600 seems reasonable now days.
        setResizable(false); // May change depending on requirements.

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen w/ toolkit methods
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);


        // Menu Bar (only 1 to hold file and help menus)
        JMenuBar menuBar = new JMenuBar();

        // File Menu, set key to F
        JMenu file_menu = new JMenu("File");
        file_menu.setMnemonic(KeyEvent.VK_F);

        // Help Menu, set key to H
        JMenu help_menu = new JMenu("Help");
        help_menu.setMnemonic(KeyEvent.VK_H);

        // Allow the user to clear the board and start a new game
        // from the file menu.
        JMenuItem file_new_game = new JMenuItem("New Game");

        file_new_game.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent event)
                {
                cleanBoard();
                new_board.cleanBoard();
                }
            });


        // Allow the user to exit from the file menu
        JMenuItem file_exit = new JMenuItem("Exit");

        file_exit.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent event)
                {
                System.exit(0);
                }
            });

        menuBar.add(file_menu);
        file_menu.add(file_new_game);
        file_menu.add(file_exit);

        
        JMenuItem help_about = new JMenuItem("About");
        help_about.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent event)
                {
                About_dialog new_about = new About_dialog();
                new_about.setVisible(true);
                }
            });

        menuBar.add(help_menu);
        help_menu.add(help_about);
        
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

            


        // middleLeftPanel will hold the toggle buttons to choose who is playing
        JPanel middleLeftPanel = new JPanel();
        middleLeftPanel.setOpaque(false);
        middleLeftPanel.setAlignmentX(0f);
        middleLeftPanel.setAlignmentY(.5f);
        middleLeftPanel.setLayout(
                new BoxLayout(middleLeftPanel, BoxLayout.Y_AXIS));
        middleLeftPanel.setPreferredSize(new Dimension(100,600));

        
        // Set up toggle button actionListeners and the commands to listen for
        x_toggle.addActionListener(this);
        x_toggle.setActionCommand("ToggleX");

        o_toggle.addActionListener(this);
        o_toggle.setActionCommand("ToggleO");

        erase_toggle.addActionListener(this);
        erase_toggle.setActionCommand("ToggleE");


        // Add the toggle buttons to the middleLeftPanel
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

        // Using grid layout for the tic-tac-toe JPanel because it seems
        // like a natural way to implement 9 squares of the same size...
        GridLayout boardPanelGridLayout = new GridLayout(3,3,2,2);
        boardPanelGridLayout.preferredLayoutSize(boardPanel);
        boardPanel.setLayout(boardPanelGridLayout);

        // Set boardPanel's size to the size of the background image plus
        // room for the spacing (background image is just the lines, boxes
        // need to be spaced out to show the tic-tac-toe lines between them.
        boardPanel.setPreferredSize(
                new Dimension(board_square.getImage().getWidth(null)*3+12,
                board_square.getImage().getHeight(null)*3+8));

        boardPanel.setMaximumSize(
                new Dimension(board_square.getImage().getWidth(null)*3+12,
                board_square.getImage().getHeight(null)*3+8));

        boardPanel.setAlignmentX(0f);
        boardPanel.setAlignmentY(.5f);
        boardPanel.setOpaque(false);


        // Setup all the tic-tac-toe buttons, and add them to the boardPanel
        // grid layout. Also set up the action listener for each one to
        // send the command i_clicked for each i corresponding to the square
        // clicked.
        int i;
        for(i=0;i<9;++i)
            {
            // setMargin,BorderPainted,IconTextGap,ContentAreaFilled,
            // FocusPainted, are all to make only the image visible
            // instead of the default button.
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
        bottomPanel.add(new JLabel("Copyright 2009, Anthony Robinson"));




        mainPanel.add(bottomPanel);
        }

     
}


