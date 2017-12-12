import java.util.Scanner;

public class CatGame {
	private static Cat petCat;
	

	public static void game() {
		boolean gameRun = true;
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		
		System.out.println("What's your name?");
		String playerName = scan.next();
		scan.close();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package on your table when you come home. Inside that package was a cat and a letter addressed from your roommate!");
		System.out.println("Hey " + playerName + ","
						   + "\n\tMy brother's cat just gave birth to a bunch of kittens so I decided to take one in."
						   + "\nI'll take care of the little guy when I come back next week! (I forgot to tell you that"
						   + "\nI went to visit my family for the week). Please take care of him for me!"
						   + "\n(I haven't decided on a name so if you don't come up with one I'll name him Mr. Schnookums)"
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
		String catName = scan.next();
		
		//Making your pet cat
		petCat = new Cat(catName, 25, 0.15, 50, 25);
		
		System.out.println("\nThat's a great name! You look up to find the cat has gone missing! Oh no! "
				+ "\nYour roommate is going to tear you a new one if you don't find " + catName 
				+ "\nYou look out the window to see " + catName + " fighting another cat?!"
				+ "\nNot only that but it's your next door neighbor, Mr. Huo's cat!"
				+ "\nYou quickly go outside to take " + catName + " back in, but " + catName + " hisses at you "
				+ "\nand motions his paw towards the other cat. It seems like your cat wants to fight the other cat..."
				+ "\n" + catName + " tries to claw the other cat, but that cat brutally attacks " + catName
				+ "Oh no! If " + catName + " gets injured - or worse, dies - then your roommate will definetly kick you out."
				+ "\nYou gotta help " + catName + " defeat the other cat otherwise you'll end up homeless!");
	
		//--------------
		//-- TUTORIAL --
		//--------------
		Cat weakCat = new Cat("Your neighbor's cat", 10, 0.05, 10, 5);
		petCat.fight(weakCat);
		if (!petCat.winner(weakCat)) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		
		//If made it through the tutorial then do the other fights
		
	}
	

}
