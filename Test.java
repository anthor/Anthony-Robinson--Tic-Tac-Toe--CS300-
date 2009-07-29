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

            Image mainBackground = new ImageIcon("Images/background.png").getImage();
            JPanel masterPanel = new JPanel_with_background(mainBackground);
          
            masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
            add(masterPanel);
            
            

            JPanel topPanel = new JPanel();
            topPanel.setAlignmentX(.5f);
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
            topPanel.add(new JLabel("Blah"));

            masterPanel.add(topPanel);



            JPanel middlePanel = new JPanel();
            middlePanel.setAlignmentX(.5f);
            middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
            middlePanel.setOpaque(false);
            
            masterPanel.add(middlePanel);
            

            JPanel middleLeftPanel = new JPanel();
            middleLeftPanel.setAlignmentX(.5f);
            middleLeftPanel.setLayout(new BoxLayout(middleLeftPanel, BoxLayout.X_AXIS));
            middleLeftPanel.add(new JLabel("Blah"));
            middleLeftPanel.setBackground(backgroundColor);

            middlePanel.add(middleLeftPanel);

            Image boardBackground = new ImageIcon("Images/board_background.png").getImage();
            JPanel middleCenterPanel = new JPanel();
            middleCenterPanel.setLayout(null);
            middleCenterPanel.setPreferredSize(new Dimension(boardBackground.getWidth(null),boardBackground.getHeight(null)));
            middlePanel.add(middleCenterPanel);

            JPanel boardPanel = new JPanel_with_background(boardBackground);
            
            boardPanel.setLayout(new GridLayout(3,3,0,0));
            boardPanel.setAlignmentX(.5f);
            boardPanel.setAlignmentY(.5f);
            boardPanel.setOpaque(false);
            boardPanel.setSize(new Dimension(boardBackground.getWidth(null),boardBackground.getHeight(null)));


            ImageIcon[] boardBoxes = {new ImageIcon("Images/tl_box.png"),new ImageIcon("Images/tc_box.png"),new ImageIcon("Images/tr_box.png"),
                                      new ImageIcon("Images/ml_box.png"),new ImageIcon("Images/mc_box.png"),new ImageIcon("Images/mr_box.png"),
                                      new ImageIcon("Images/bl_box.png"),new ImageIcon("Images/bc_box.png"),new ImageIcon("Images/br_box.png")};
            ImageIcon[] boardBoxesOver = {new ImageIcon("Images/tl_box_over.png"),new ImageIcon("Images/tc_box.png"),new ImageIcon("Images/tr_box.png"),
                                      new ImageIcon("Images/ml_box.png"),new ImageIcon("Images/mc_box.png"),new ImageIcon("Images/mr_box.png"),
                                      new ImageIcon("Images/bl_box.png"),new ImageIcon("Images/bc_box.png"),new ImageIcon("Images/br_box.png")};
            /*
            ImageIcon tlBox = new ImageIcon("tl_box.png");
            ImageIcon tcBox = new ImageIcon("tc_box.png");
            ImageIcon trBox = new ImageIcon("tr_box.png");
            ImageIcon mlBox = new ImageIcon("ml_box.png");
            ImageIcon mcBox = new ImageIcon("mc_box.png");
            ImageIcon mrBox = new ImageIcon("mr_box.png");
            ImageIcon blBox = new ImageIcon("bl_box.png");
            ImageIcon bcBox = new ImageIcon("bc_box.png");
            ImageIcon brBox = new ImageIcon("br_box.png");
            */

            // ulSquare1.setBorderPainted(true);
            // ulSquare1.setContentAreaFilled(false);
            // ulSquare1.setFocusPainted(false);

            
            int i;
            for(i=0;i<9;++i)
                {
                JButton temp = new JButton(new ImageIcon("Images/tl_box.png"));
                temp.setRolloverIcon(new ImageIcon("Images/tl_box_over.png"));
                temp.setMargin(new Insets(0,0,0,0));
                temp.setBorderPainted(false);
                temp.setIconTextGap(0);
                temp.setContentAreaFilled(false);
                temp.setFocusPainted(false);
                temp.setPreferredSize(new Dimension(100,142));
                temp.setSize(new Dimension(100,142));
                boardPanel.add(temp);
                }
           
            middleCenterPanel.add(boardPanel);
            


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

