import java.util.Scanner;

public class CatGame {

	public static void game() {
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		
		System.out.println("What's your name?");
		String name = scan.next();
		scan.close();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package on your table when you come home. Inside that package was a cat and a letter addressed from your neighbor!");
		System.out.println("Dear " + name + ","
						   + "\n\tI found this cat scratching on your door this week. So I thought it belonged to you and brought the little guy inside."
						   + "\n\nP.S. I broke into your place to put the cat in."
						   + "\nAlso, I'm out of town for the week so I won't be able to find your cat again."
						   + "Personally, you:"
						   + "\t(1) Love cats so are estatic to take care of this one"
						   + "\t(2) Hate cats so you just want to get rid of this one as fast as possible"
						   + "\t(3) Don't care either way for them");
		int choice = scan.nextInt();
		
		
		System.out.println("You look at the cat and notice it has a collar with no name on it."
						   + "\nWhat are you going to call the cat?");
		

	}

}
