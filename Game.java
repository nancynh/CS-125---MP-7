import java.util.Scanner;


//Music stuff
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.application.Application;

/** @author nancy
 * Where the game runs itself.
 *
 *
 */
public class Game {
	//Put scanner here otherwise it will throw a NoSuchElementException
	//Closing scanner also closes any available input as well
	//Source: https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
	static Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
	static boolean paintExists = true;


	public static void main(String[] args) {
		final int numGames = 6;
		boolean run = true;
		System.out.println("You're walking on campus when you pass by a building you've never seen before. You decide to go check it out.");
		System.out.println("You arrive to what looks like a rundown arcade. There are various games to play which you can play for free.");
		
		while (run) {
			System.out.println("What do you want to do? (type in the corresponding number to do that action)"
						           + "\n\t• Leave the arcade (1)"
						           + "\n\t• Play that cat simulator (2)"
						           + "\n\t• Play Battleship (3)"
						           + "\n\t• Play Hangman (4)" 
						           + "\n\t• Play Tic-Tac-Toe (5)");
			if (paintExists) {
				System.out.println("\t• Stare at the painting (6)");
			} else {
				System.out.println("\t• Stare at the wall (6)");
			}
			System.out.println("\t• Play some music (" + numGames + ")"); //ahahaha probs won't work
			
			int play = scan.nextInt();
			while (play <= 0 || play > numGames) {
				System.out.println("Please type in a number between 1 and " + numGames);
				play = scan.nextInt();
			}
			//scan.close();
			if (play == 1) {
				System.out.println("You leave the arcade. As soon as you stepped out, the whole place vanishes into thin air. \nHuh. \nWeird.\nYou head back home to do your MP. You completly forgot that it was due tomorrow.");
				run = false;
			} else if (play == 2) {
				System.out.println("You go over to the cat simulator and start it up.");
				playCat();
			} else if (play == 3) {
				System.out.println("You go to the machine with a giant ship on it. You press the play button.");
				playBattleShip();
			} else if (play == 4) {
				System.out.println("You spot a man leaning against a chalkboard. Above them is a sign that says, \"Play Hangman Here!\"\nYou walk up to him and tell him that you want to play.\nHe smiles and says, \"Great.\"");
				HangMan.hangMan();
			} else if (play == 5) {
				System.out.println("You go over to the booth where someone with a hood on sits. In front of them is a tablet with a tic-tac-toe game. "
								   + "\nThe person looks up and pulls off their hood revealing to be you!"
								   + "\n\"Hey myself. Let's play a game of tic-tac-toe,\" your clone says."
								   + "\nYou ask, \"But wouldn't I basically be playing by myself then?\""
								   + "\n\"Yup! But it'll be fun because you will win no matter what!\""
								   + "\n\"Okay.\""
								   + "\"Great. You start.\"\n" );
				TicTacToe.ticTacToe();
			} else if (play == 6) {
				if (paintExists) {
					System.out.println("There's a portrait of a man on the wall. You walk up to it to take a closer look.");
					seePainting();
				} else {
					System.out.println("You stare at the wall for a few minutes until you decide to do something else.");
				}
			} else {
				//Got this from: https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
				Application.launch();
				System.out.println("You go over to the radio and turn it on. Music starts to play.");
				playMusic();		
			}
			System.out.println("\n"); //here to see text easier
		}
		scan.close();
		
	}
	
	public static void seePainting() {
		
			try {
			    Thread.sleep(750);
			    System.out.println("\n" + 
			        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooossyyhdddddhhhysooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooosydmNNNMMMMMMMMMNmhysoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooydmNMMMNNNNNNMMMMMMMMNmyooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooshmmdhhyssosssyhhdmNNMMMMNhoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooydhs/:-::////++ooosssyyhmNMNhsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooshdh+:--:://++++ooooosssosoydNNdsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooohdho/:://++ooooossssyyhyysssydNNdsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooymdy+///+++oooooosssyyhhhhyysshmNNhoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooosdmhs+++++++oooosoossssyyyhhhyyhmNMmsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooymmho+++osyhdmmdhyyhhddddhhhhhhdmNMNsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooymmyoooydmmNNNNNmmmmNNNNNNNNmdddmNMNyooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooymNyooyddmmNNMMNmddmNMMMNNNNNNmddNMNyooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooosmms+yhdmmNNNNNmdsoymNNNNMMNNNmddNMmsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooosh++osshdmmmdhyo/+oydmmmNNmmdmdhNNdoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooosyso////ossyyso+///+osyhdhhyyssyhmNhoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooosdyo//+osyhdho++++ossyshmmdhhyysymNyoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooyhssyhdmmmmdddmddmmmmmmmmmNNmmddddsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooyyhdmNNNmdhhdmNNNNNNNmmmmNNNNNmdyooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooydmmNNmdhhhhddmmmmmmmmmmNNNNNmhoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooshdmmNNNmmmdddddhddmmNMMNNNNNmsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooyddmNNNmdo//:-:-:/+smNNNNNNNhooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooosdmmmmmhyo++ooo+syyhhmmmNNNdoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooymmmmddhhhhhhhhddmmmmNNNNmyoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooshmmmmdddmNNNNNNNNNNNNNNNdsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooydmmmddhhhddmmmmmmmNNNNNdsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooshdmmmmmmmmmmNNNNNNNNNNmdsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooyhmNNNNNNMMMMMMMMMMMNNmdsoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooosyhdmmNNNMMMMMMMMMMMNNNdo:oyoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooooo+-+shhdmmdmNNMMMMMMMMNNho:--hNdysooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooooosys```:sdddddmmNNNMMNNds/----:mNNNmhysoooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooooosshmy`````-odmmmNNNNmho:---..-:sNMNNNNNmddyyssoooooooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooooooosyyhdms`` ````-sdhdhs/--......--/dNNNNNNNNNNNmmmdhyssooooooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooooooossyyhhhdmNo` ` `:odmmdddy+........--sNMMNNNNNNNNNNNNNmmmddhysooooooooooooooooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooooooooooooooooooossyhhhhhhhddmmo`  -ydmmNNNMMMNdo-......+NNNMMNNNNNNNNNNNNNNNNmmmddhyssoooooooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooooooosyyhhddddddhdddmm+``/dNNNmNNMMMMMMNy:....:hNNMNNNNNNNMMNNNNNNNNNNNmmmmmmdhyssoooooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooooooosyyhhddddddmmmdddddmm+`:+/odmNNMMMMMMds+//..-omNNNMMNNMMMMMNNNNNNNNNNNNNNNNNNmmmdhyoooooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooooooooossyhhddddddddddmNNmmdddmmo....-+NMMMMMMNh+:-.---/hNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmdyoooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooossyyyhdddmmmmmmmddddmmNmmdddmms```.-yNNNMMMMmo:-..`.-omNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNdoooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooosydddddmmmmmmmmmmmmmmmNNmmmddmNs.``.omNMMMMMMNy-...`.:hNMNNNNNNNNNNNMNNNNNNNNNNNNNNNNNNNMNNNNNmsooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooosdmNmmmmmmmmmmmmmmmmmNNmmmmddmNh.``:mNMMMMMMMMN+...`.oNNMNNNNNNNNNNMMNNNNNNNNNNNNNNNNNNNNNNNNMNhooooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooooymmNNmmmmmmmmmmmmmmmmmmmmmmmmmmd-``hNNMMMMMMMMMd-.`.:dNNNNNNNNNNNNMMNNNNNNNNNNNNNNNNNNNNNNNMMMNmooooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooohmmNNmmmmNmmmmmmmmmmmmmmmmmmmmmm/`:NNNMMMMMMMMMNo.`.sNNMNNNNNNNNNMNNNNNNNNNNNNNNNNNNNNMMNNMMMMNNyoooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooosdmmNNNmmmNNmmmmmmmmmmmmmmmmmmmmNo.sNNNMMMMMMMMMNy.`/mNNNNNNNNNNNMMNNNNNNNNNNNNNNNNNNNMMNNMMMMMNNdsooooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooosmmNNMNmNNNNmmmmmmmmmmNNNNmmmmmmNy:dNNNMMMMMMMMMNh..hNNNMNNNNNNNMMNNNNNNNNNNNNNNNNNNMMMMNNMMMMMMNNyooooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooooymmNNNNNNNNNNmmmmmmmmNNNNNmmmmmmNmsmMMMMMMMMMMMMMh-+mNNMMNNNNNNMMNNNNNNNNNNNNNNMMMMMMMMMNMMMMMMMMNdsoooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooohNNNNNMNNNNNNmmmmmmmNNNNNNNmmmmmNNmNMMMMMMMMMMMMMh/hNNNNNNNNNNMMNNNNNNNNNNNNMMMMMMMMMMMMMMMMMMMMMNNyoooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooodNNNNNMNNNNNNNNmmmmNNNNNNNNNNNmmNNMMMMMMMMMMMMMMMdyNNNMNNNNNNMMNNNNNNNNNNNMMMMMMMMMMMMMMMMMMMMMMMNNdoooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooosmmNNNMMMNNNNNNNmNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMMMmmNNNNNNNNNMMMNNNNNNNNNNMMMMMMMMMMMMMMMMMMMMMMMMMNmsooooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooooymmNNNMMMNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMMMNNNMMNNNNNMMMNNNNNNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNhooooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooohmmNNNMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMNNNNMMNNNMMMMNNMMNNNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNdsoooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooohmNNNNMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMNNNMMMNNMMMMMMMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNyoooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooodmNNNNMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMMMNNNMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNhoooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooosdmNNNMMMMMNNNNNNNNNNNNNNNNNNNMNNNNNNNMMMMMMMMMMNNNNMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNMmsooooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooooymNNNNMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMNNNMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNyooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooohmNNNMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNdooooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooohNNNNNMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMNNMMMMMMMMMMNNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNsoooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooohNNNNMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMNNNMMMMMMMMMMMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNyoooooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooodNNNNNNNNNMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNMNdoooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooosdNNNNMNNMMMMMNNNMNNNNNNNNNNNNNNNNNNNNNNNNMMMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNMMMMMMmsooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooosmNNNMMMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMNNMMMMMMMMMMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNMMMMMMMNhooooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooosmNNNNMMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNMMNMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMdsoooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooymNNNNNMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNyoooooooooooooooooooo\n" + 
			    		"oooooooooooooooooooooymNNNNNNMMMMMMMMMNMNNNNNNNNNNNNNNNNNNNNMMMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNhoooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooohNNNNNNNNNNMMMMMMMNNNNNNNNNNMMNNNNNNNNMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMNNMMmsooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooohNNNNNNNNNNNNMMMMMNNNNNNNNNMMNNNNNNNNNNNMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNMMMMMMMMMNMNyooooooooooooooooooo\n" + 
			    		"ooooooooooooooooooooodNNNNNNNNMMMMMMMMMMMMNNNNNMMMMMNNNNNNNMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNNNMMMMMMMNNyooooooooooooooooooo\n" + 
			    		"");
			    System.out.println("The caption below states:\n\"This UIUC alumn, Chinny Emeka, solved the RSA problem and would make billions \nfrom his solution. This painting is dedicated to him for all of his hard work \nover the years and for teaching the CS 125 AYM Lab Section.\"");
			} catch(InterruptedException e) {
			    System.out.println("You hear someone calling for you name and turn around. No one is there.\nYou look back at the wall but the painting is no longer there. Strange.");
			    paintExists = false;
			}
	}
	
	public static void playBattleShip() {
		//Scanner scan = new Scanner(System.in); 
		int length, height, maxGuesses, x, y;
		
		//Intro to the game
		System.out.println(
				"\nWelcome to Battleship!\n~~~~~~~~~~~~~~~~~~~~~~\n" +
				"                                     # #  ( )\n" + 
				"                                  ___#_#___|__\n" + 
				"                              _  |____________|  _\n" + 
				"                       _=====| | |            | | |==== _\n" + 
				"                 =====| |.---------------------------. | |====\n" + 
				"   <--------------------'   .  .  .  .  .  .  .  .   '--------------/\n" + 
				"     \\                                                             /\n" + 
				"      \\_______________________________________________WWS_________/\n" + 
				"  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" + 
				"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" + 
				"   wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww \n" + 
				"" +
						  
						  "\nIn this game your goal is to sink your opponent's ship in less than the number of guesses you're given!" +
						  "\nThe number of guesses you have is calculated by the length of the ship multiplied by the height plus \nan additional 5 tries.");
		System.out.println("\nType in an integer from 1 - 5 for the length of your enemy's ship: ");
		length = scan.nextInt();
		while (length < 1 || length > 5) {
			System.out.println("Please type in an integer from 1 - 5 for the length of the ship");
			length = scan.nextInt();
		}
		
		System.out.println("Type in an integer from 1 - 5 for the height of your enemy's ship: ");
		height = scan.nextInt();
		while (height < 1 || height > 5) {
			System.out.println("Please type in an integer from 1 - 5 for the height of the ship");
			height = scan.nextInt();
		}
		
		maxGuesses = length * height + 5;
		
		//Randomly generates the location for the ship
		x = (int) (Math.random() * (15 - length));
		y = (int) (Math.random() * (15 - height));
		Ship targetShip = new Ship(x, length, height, y);
		
		PlayerBS player = new PlayerBS(targetShip);
		
		//Running the game itself. Only runs if the player hasn't used up all of their guesses and the ship hasn't sunk yet
		while (!targetShip.isSunk() && player.getGuesses() < maxGuesses) {
			int xGuess, yGuess;
			try {
			    Thread.sleep(350);
			    player.drawBoard();
			} catch(InterruptedException e) {
			    System.out.println("Exception has occured :(");
			}	
			System.out.println("\nGuess a location. \nx-coordinate: ");
			xGuess = scan.nextInt();
			System.out.println("y-coordinate: ");
			yGuess = scan.nextInt();
			player.takeShot(xGuess, yGuess);
			System.out.println("\t\tNumber of moves left: " + (maxGuesses - player.getGuesses()));
		}
		
		//End game results
	    player.drawBoard();
		if (player.getGuesses() < maxGuesses) {
			System.out.println("\nCongrats! You won!\nIt took you " + player.getGuesses() + " tries!");
		} else {
			System.out.println("\nYou lose! You didn't sink the ship in " + maxGuesses + " moves or less :(");
		}		
	}
	
	public static void playMusic() {
		String song = "Lawrence_Angrave_performs_parody_of_Taylor_Swifts_Blank_Space_for_CS_241_Systems_Programming[Mp3Converter.net].mp3";
		Media hit = new Media(new File(song).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	}
	
	public static void playCat() {
		System.out.println(
				"                      /^--^\\     /^--^\\     /^--^\\\n" + 
				"                      \\____/     \\____/     \\____/\n" + 
				"                     /      \\   /      \\   /      \\\n" + 
				"                    |        | |        | |        |\n" + 
				"                     \\__  __/   \\__  __/   \\__  __/\n" + 
				"|^|^|^|^|^|^|^|^|^|^|^|^\\ \\^|^|^|^/ /^|^|^|^|^\\ \\^|^|^|^|^|^|^|^|^|^|^|^|\n" + 
				"| | | | | | | | | | | | |\\ \\| | |/ /| | | | | | \\ \\ | | | | | | | | | | |\n" + 
				"########################/ /######\\ \\###########/ /#######################\n" + 
				"| | | | | | | | | | | | \\/| | | | \\/| | | | | |\\/ | | | | | | | | | | | |\n" + 
				"|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|" + 
				"\nWelcome to the Cat Simulator game! In this game you will be given some choices to make."
				+ "\nIf you are given a set of choices then please type in the corresponding number to the"
				+ "\nchoice you want to make. (ex. If you want to choose option (2) then you type in \"2\")"
				+ "\n");
		CatGame.game();
	}

	
	
}
