import java.util.Scanner;

public class CatGame {

	public static void game() {
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		
		System.out.println("What's your name?");
		String name = scan.next();
		scan.close();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package on your table when you come home. Inside that package was a cat and a letter addressed from your roommate!");
		System.out.println("Hey " + name + ","
						   + "\n\tMy brother's cat just gave birth to a bunch of kittens so I decided to take one in."
						   + "\nI'll take care of the little guy when I come back next week! (I forgot to tell you that"
						   + "\nI went to visit my family for the week). Please take care of Mr. Schoomkums for me!"
						   + "\n(I include a cheque in the box to compensate for any troubles and so you can buy him "
						   + "some food, toys, etc.)"
						   + "\n\nPersonally, you:"
						   + "\n\t(1) Love cats so are estatic to take care of this one"
						   + "\n\t(2) Hate cats so you are dreading this"
						   + "\n\t(3) Don't care either way for them");
		int choice = scan.nextInt();
		if (choice <= 0 || choice > 3) {
			System.out.println("Please type in a number between 1 and 3");
			choice = scan.nextInt();
		}
		if (choice == 1) {
			System.out.println("You told yourself to thank your roommate later for this.");
		} else if (choice == 2) {
			System.out.println("You were going to kill your rommate when they get back. They knew you hated cats.");
		} else {
			System.out.println("You were just happy that your rommate cleaned the place before leaving the cat off with you.");
		}
		
		
		System.out.println("You look at the cat and notice it has a collar with no name on it."
						   + "\nWhat are you going to call the cat?");
		

	}

}
