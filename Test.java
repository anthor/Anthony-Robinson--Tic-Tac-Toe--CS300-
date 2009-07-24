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


public class Test extends JFrame {

    public Test() {
        setSize(400,400);
        setTitle("Test Window");
   
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
        mainPanel.add(Box.createVerticalGlue());
        JPanel topPanel = new JPanel();
        topPanel.setAlignmentX(.5f);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        mainPanel.add(topPanel);
        topPanel.add(new JLabel("Blah"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setAlignmentX(.5f);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        mainPanel.add(bottomPanel);

        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setAlignmentX(.5f);
        bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.X_AXIS));
        bottomLeftPanel.add(new JLabel("Blah"));
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(Box.createHorizontalGlue());

        JPanel boardPanel = new JPanel();
        boardPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        boardPanel.setLayout(new GridLayout(3,3,5,5));
        boardPanel.setMaximumSize(new Dimension(300,250));
        boardPanel.setAlignmentX(0f);
        boardPanel.setAlignmentY(.5f);
        ImageIcon boardSquare = new ImageIcon("square.png");
        
        // ulSquare1.setBorderPainted(true);
        // ulSquare1.setContentAreaFilled(false);
        // ulSquare1.setFocusPainted(false);

        int i;
        for(i=0;i<9;++i)
        {
        JButton temp = new JButton(boardSquare);
        temp.setMargin(new Insets(0,0,0,0));
        temp.setBorderPainted(false);
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

