import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner; 


/** @author nancy
 * Where the game runs itself.
 *
 *
 */
public class Game extends JPanel{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		System.out.println("What's your name?");
		String name = scan.next();
		scan.close();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package in front of your door. Inside that package was a cat and a letter addressed from your grandpa!");
		System.out.println("Dear " + name + ",");
	}
}
