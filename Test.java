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

            setSize(800,600);
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
            Image mainPanelBackground = new ImageIcon("Images/background.png").getImage();
            JPanel mainPanel = new JPanel_with_background(mainPanelBackground); // Main panel will contain all the other panels.
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            add(mainPanel);
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.setBackground(backgroundColor);


            ImageIcon title = new ImageIcon("Images/tictactoe.png");
            JPanel topPanel = new JPanel();
            topPanel.setOpaque(false);
            topPanel.setAlignmentX(.5f);
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
            topPanel.setBackground(backgroundColor);
            topPanel.setPreferredSize(new Dimension(800,100));
            topPanel.add(new JLabel(title));


            mainPanel.add(topPanel);



            JPanel middlePanel = new JPanel();
            middlePanel.setOpaque(false);
            middlePanel.setAlignmentX(.5f);
            middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
            mainPanel.add(middlePanel);

            JPanel middleLeftPanel = new JPanel();
            middleLeftPanel.setOpaque(false);
            middleLeftPanel.setAlignmentX(.5f);
            middleLeftPanel.setLayout(new BoxLayout(middleLeftPanel, BoxLayout.X_AXIS));
            middleLeftPanel.add(new JLabel("Blah"));

            middlePanel.add(middleLeftPanel);
            middlePanel.add(Box.createHorizontalGlue());


            ImageIcon boardSquare = new ImageIcon("Images/tl_box.png");
            ImageIcon boardSquareOver = new ImageIcon("Images/tl_box_over.png");

            Image boardPanelBackground = new ImageIcon("Images/board_background2.png").getImage();
            JPanel boardPanel = new JPanel_with_background(boardPanelBackground);

            //boardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            GridLayout boardPanelGridLayout = new GridLayout(3,3,2,2);
            boardPanelGridLayout.preferredLayoutSize(boardPanel);
            boardPanel.setLayout(boardPanelGridLayout);
            boardPanel.setPreferredSize(new Dimension(boardSquare.getImage().getWidth(null)*3+12,boardSquare.getImage().getHeight(null)*3+8));
            boardPanel.setMaximumSize(new Dimension(boardSquare.getImage().getWidth(null)*3+12,boardSquare.getImage().getHeight(null)*3+8));
            boardPanel.setAlignmentX(0f);
            boardPanel.setAlignmentY(.5f);
            //boardPanel.setBackground(Color.black);
            boardPanel.setOpaque(false);
            
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
            middleRightPanel.setOpaque(false);
            middleRightPanel.setAlignmentX(.5f);
            middleRightPanel.setLayout(new BoxLayout(middleRightPanel, BoxLayout.X_AXIS));
            middleRightPanel.add(new JLabel("Blah"));
            middlePanel.add(middleRightPanel);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setAlignmentX(.5f);
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
            bottomPanel.setPreferredSize(new Dimension(800,100));
            bottomPanel.add(new JLabel("Blah"));
            mainPanel.add(bottomPanel);

        }

    public static void main(String[] args)
        {
        Test test = new Test();
        test.setVisible(true);
        }
}

