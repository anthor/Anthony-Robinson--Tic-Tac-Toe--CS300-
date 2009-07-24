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


public class Test extends JFrame {

    public Test() {
        setSize(300,200);
        setTitle("Test Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        JPanel boardPanel = new JPanel();
        boardPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        boardPanel.setLayout(new GridLayout(3,3,5,5));

        ImageIcon boardSquare = new ImageIcon("square.png");
        // JButton ulSquare1 = new JButton(boardSquare);
        // ulSquare.setAlignmentX(0.5f);
        // ulSquare.setAlignmentY(0.5f);
        // ulSquare.setSize(80,80);
        // ulSquare1.setBorderPainted(true);
        // ulSquare1.setContentAreaFilled(false);
        // ulSquare1.setFocusPainted(false);

        int i;
        for(i=0;i<9;++i)
        {
        boardPanel.add(new JButton(boardSquare));
        }

        add(boardPanel);
    }

    public static void main(String[] args)
    {
    Test test = new Test();
    test.setVisible(true);
    }
}

