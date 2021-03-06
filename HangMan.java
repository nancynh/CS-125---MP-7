
	import java.util.Scanner;

	public class HangMan {

		private static String[] wordBank = {"awkward", "terminator", "banana", "computer", "cow", "rain", "water",
										"oxygen", "zombie", "pajama", "breeze", "mysterious", "fireplace", "jazz", 
										"frazzled", "mnemonic", "voyeurism", "voodoo", "transplant", "zodiac", 
										"xylophone", "youthful", "sphinx", "pneumonia", "khaki", "espionage", 
										"keyhole", "microwave", "fluffiness", "beekeeper", "buffalo", "fuchsia",
										"bagpipes", "dwarves", "nymph", "onyx", "stronghold", "polka", "jogging",
										"croquet", "barrels", "gazette", "finance", "revolutionary", "corruption", 
										"dilemma", "colleague", "seed", "quit", "cinema", "nuclear", "happen", "bill",  
										"hippopotomonstrosesquippedaliophobia", "supercalifragilisticexpialidocious",
										"insomnia", "memes", "corn", "illinois", "soybeans", "champaign", "urbana",
										"uiuc", "csrocks", "acm", "wcs", "angrave", "challen", "chapman"};
		private static String word;
		private static String currentResultString;
		private static int count = 0; //counts the number of incorrect guesses 
		private static String incorrectLetters; 

		public static void hangMan() { //main method to be called from game center
			Scanner input = new Scanner(System.in);
			word = wordBank[(int) (Math.random() * wordBank.length)]; //randomly chooses a word from the wordBank
			currentResultString = new String(new char[word.length()]).replace("\0", "*"); //the displayed results
			incorrectLetters = "Past attempts:"; //keeps track of incorrect guesses 
			
			while (count < 6 && currentResultString.contains("*")) { //while game still in play
				System.out.println("Guess any letter in the word");
				System.out.println(currentResultString);
				System.out.println(incorrectLetters);
				String guess = input.next();
		//		if(incorrectLetters.indexOf(guess) != -1 && incorrectLetters.length() > 1) { //check for repeat letters
		//			System.out.println("Enter a different letter");
		//			guess = input.next();
		//			hang(guess);
					
		//		} else {
					hang(guess);
		//		}
			}
			count = 0;
			//input.close();
		}

		public static void hang(String guess) {
			String newAsterisk = "";
			if(guess.equals(word)) {
				System.out.println("You are correct! The word was " + word);
			}
			else { //check if the user input letter (guess) is in the word
				for (int i = 0; i < word.length(); i++) {
			
				if (word.charAt(i) == guess.charAt(0)) { //letter exists so add to result string newAsterisk string
					newAsterisk += guess.charAt(0);		//charAt(0) since assume only one letter was entered
					
				} else if (currentResultString.charAt(i) != '*') { //automatically add letters that where already guessed 
													   //correctly to the newAsterisk string
					newAsterisk += word.charAt(i);
					
				} else {								//letter doesn't exist so add an asterisk to newAsterisk string
					newAsterisk += "*";
					
				}
			}
			}

			if (currentResultString.equals(newAsterisk)) { //didn't get a letter
				count++;
				hangmanImage();
				incorrectLetters += " " + guess.charAt(0);
			} else { //did get one letter
				currentResultString = newAsterisk;
			}
			if (currentResultString.equals(word)) {
				System.out.println("You are correct! The word was " + word);
			}
		}

		public static void hangmanImage() {
			/*if (count == 1) {
				System.out.println("Wrong guess, try again");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("___|___");
				System.out.println();
			}
			if (count == 2) {
				System.out.println("Nope, try again!");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("___|___");
			}*/
			if (count == 0) {
				System.out.println("Here we go!");
				System.out.println("   ____________");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   | ");
				System.out.println("___|___");
			}
			if (count == 1) {
				System.out.println("Hmmmm, not quite... Try again");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println("___|___");
			}
			if (count == 2) {
				System.out.println("Sorry, try again");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |           |");
				System.out.println("   |           |");
				System.out.println("   |");
				System.out.println("___|___");
			}
			if (count == 3) {
				System.out.println("Wrong guess, try again!");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |           |");
				System.out.println("   |           |");
				System.out.println("   |          /  ");
				System.out.println("___|___      /   ");
			}
			if (count == 4) {
				System.out.println("Nope, try again!");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |           |");
				System.out.println("   |           |");
				System.out.println("   |          / \\ ");
				System.out.println("___|___      /   \\");
			}
			if (count == 5) {
				System.out.println("Uh oh, one last try!");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |          _|");
				System.out.println("   |         / | ");
				System.out.println("   |          / \\ ");
				System.out.println("___|___      /   \\");			
			}
			if (count == 6) {
				System.out.println("GAME OVER!");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |          _|_");
				System.out.println("   |         / | \\");
				System.out.println("   |          / \\ ");
				System.out.println("___|___      /   \\");
				System.out.println("The correct word was " + word);
			}
		}
	}

