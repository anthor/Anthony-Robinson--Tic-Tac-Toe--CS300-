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
import java.awt.Image;
import java.awt.Graphics;

class JPanel_with_background extends JPanel
    {
        private Image img;

        public JPanel_with_background(Image img)
            {
            this.img = img;
            }

        // We have to override paintComponent to have a somewhat hacked background image
        @Override
        public void paintComponent(Graphics g)
            {
            g.drawImage(img,0,0,null);
            }
    }

public class Test extends JFrame {



    public Test()
        {
            Color backgroundColor = new Color(255,255,255);

            setSize(400,400);
            setTitle("Tic Tac Toe v2.0");
            setResizable(true); // May change depending on requirements.

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            Toolkit toolkit = getToolkit();
            Dimension size = toolkit.getScreenSize();
            setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);


            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");

            menuBar.add(menu);
            setJMenuBar(menuBar);

            Image mainBackground = new ImageIcon("Images/background.png").getImage();
            JPanel mainPanel = new JPanel_with_background(mainBackground);
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



            JPanel middlePanel = new JPanel();
            middlePanel.setAlignmentX(.5f);
            middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
            middlePanel.setBackground(backgroundColor);
            mainPanel.add(middlePanel);

            JPanel middleLeftPanel = new JPanel();
            middleLeftPanel.setAlignmentX(.5f);
            middleLeftPanel.setLayout(new BoxLayout(middleLeftPanel, BoxLayout.X_AXIS));
            middleLeftPanel.add(new JLabel("Blah"));
            middleLeftPanel.setBackground(backgroundColor);

            middlePanel.add(middleLeftPanel);
            middlePanel.add(Box.createHorizontalGlue());

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

            middlePanel.add(boardPanel);
            middlePanel.add(Box.createHorizontalGlue());


            JPanel middleRightPanel = new JPanel();
            middleRightPanel.setAlignmentX(.5f);
            middleRightPanel.setLayout(new BoxLayout(middleRightPanel, BoxLayout.X_AXIS));
            middleRightPanel.add(new JLabel("Blah"));
            middlePanel.add(middleRightPanel);


        }

    public static void main(String[] args)
        {
        Test test = new Test();
        test.setVisible(true);
        }
}

