import java.util.Scanner;

public class CatGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		
		System.out.println("What's your name?");
		String name = scan.next();
		scan.close();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package in front of your door. Inside that package was a cat and a letter addressed from your grandpa!");
		System.out.println("Dear " + name + ",");

	}

}
