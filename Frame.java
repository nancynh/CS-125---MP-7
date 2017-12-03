//Used: https://www.abeautifulsite.net/java-game-programming-for-beginners 
//To figure out how to get a screen to pop open when you run the application

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//import java.awt.BorderLayout;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Toolkit;


public class Frame {
	
    public static void main(String args[]){    	
    	
      	/**General screen of the game*/
        JFrame screen = new JFrame("Cat Simulator Game"); 
        JPanel buttonLayer = new JPanel();
        screen.setSize(750,750);
        
        /**Centers the frame*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setLocation(dim.width/2 - screen.getSize().width/2, 
        		               dim.height/2 - screen.getSize().height/2); 
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //buttonLayer.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
        buttonLayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLayer.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        JButton playButton = new JButton();

        playButton.setSize(100,20);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        playButton.setVisible(true);
        playButton.setText("Play Game");
        buttonLayer.add(playButton); //Adding the buttons to the button layer
        
        //Making the button do shit
        playButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            		buttonLayer.setVisible(false);
                JPanel screen1 = new JPanel();
                screen1.setBackground(Color.getHSBColor(308, 91, 80));
                screen1.setVisible(true);
            }
        });
        
        
        
        //Now adding the buttonLayer onto the screen itself
        screen.add(buttonLayer, BorderLayout.CENTER);
        
        buttonLayer.setBackground(Color.getHSBColor(208, 100, 76));

        
        screen.setVisible(true);

        
    }
  
}