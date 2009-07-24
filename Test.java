/*
 * Test java program to remember how to program in java
 *
 * Change in master...
 * Experiment version
 */
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;



public class Test extends JFrame {

    public Test() {
        Color backgroundColor = new Color(255,255,255);

        setSize(400,400);
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

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.setBackground(backgroundColor);

        JPanel topPanel = new JPanel();
        topPanel.setAlignmentX(.5f);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(backgroundColor);
        topPanel.add(new JLabel("Blah"));

        mainPanel.add(topPanel);
        


        JPanel bottomPanel = new JPanel();
        bottomPanel.setAlignmentX(.5f);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBackground(backgroundColor);
        mainPanel.add(bottomPanel);

        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setAlignmentX(.5f);
        bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.X_AXIS));
        bottomLeftPanel.add(new JLabel("Blah"));
        bottomLeftPanel.setBackground(backgroundColor);
        
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(Box.createHorizontalGlue());

        JPanel boardPanel = new JPanel();
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        boardPanel.setLayout(new GridLayout(3,3,0,0));
        boardPanel.setMaximumSize(new Dimension(300,250));
        boardPanel.setAlignmentX(0f);
        boardPanel.setAlignmentY(.5f);
        boardPanel.setBackground(Color.black);

        ImageIcon boardSquare = new ImageIcon("square.png");
        ImageIcon boardSquareOver = new ImageIcon("squareover.png");
        // ulSquare1.setBorderPainted(true);
        // ulSquare1.setContentAreaFilled(false);
        // ulSquare1.setFocusPainted(false);

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

        bottomPanel.add(boardPanel);
        bottomPanel.add(Box.createHorizontalGlue());


        JPanel bottomRightPanel = new JPanel();
        bottomRightPanel.setAlignmentX(.5f);
        bottomRightPanel.setLayout(new BoxLayout(bottomRightPanel, BoxLayout.X_AXIS));
        bottomRightPanel.add(new JLabel("Blah"));
        bottomPanel.add(bottomRightPanel);
   

    }

    public static void main(String[] args)
    {
    Test test = new Test();
    test.setVisible(true);
    }
}

