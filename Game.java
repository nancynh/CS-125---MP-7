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
	public static void main(String[] args) {
		final int numGames = 6;
		boolean run = true;
		boolean paintExists = true;
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		System.out.println("You're walking on campus when you pass by a building you've never seen before. You decide to go check it out.");
		System.out.println("You arrive to what looks like a rundown arcade. There are various games to play which you can play for free.");
		
		while (run) {
			System.out.println("What do you want to do? (type in the corresponding number to do that action)"
						           + "\n\t• Leave the arcade (1)"
						           + "\n\t• Play that cat simulator (2)"
						           + "\n\t• Play Battleship (3)"
						           + "\n\t• Play Hangman (4)");
			if (paintExists) {
				System.out.println("\t• Stare at the painting (5)");
			} else {
				System.out.println("\t• Stare at the wall (5)");
			}
			System.out.println("\t• Play some music (" + numGames + ")"); //ahahaha probs won't work
			
			int play = scan.nextInt();
			while (play <= 0 || play > numGames) {
				System.out.println("Please type in a number between 1 and " + numGames);
				play = scan.nextInt();
			}
			//scan.close();
			if (play == 1) {
				System.out.println("You leave the arcade. As soon as you stepped out, the whole place vanishes into thin air. Huh. Weird.\nYou head back home to do your MP. You completly forgot that it was due tomorrow.");
				run = false;
			} else if (play == 2) {
				System.out.println("You go over to the cat simulator and start it up.");
			} else if (play == 3) {
				System.out.println("You go to the machine with a giant ship on it. You press the play button.");
			} else if (play == 4) {
				System.out.println("You spot a man leaning against a chalkboard. Above them is a sign that says, \"Play Hangman Here!\"\nYou walk up to him and tell him that you want to play.\nHe smiles and says, \"Great.\"");
			} else if (play == 5) {
				if (paintExists) {
					System.out.println("There's a portrait of a man on the wall. You walk up to it to take a closer look.");
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
					    System.out.println("The caption below states:\n\"This UIUC alumn, Chinny Emeka, solved the RSA problem and would make billions from his solution. \nThis painting is dedicated to him for all of his hard work over the years \nand for teaching the CS 125 AYM Lab Section.\"");
					} catch(InterruptedException e) {
					    System.out.println("You hear someone calling for you name and turn around. No one is there.\nYou look back at the wall but the painting is no longer there. Strange.");
					    paintExists = false;
					}	
				} else {
					System.out.println("You stare at the wall for a few minutes until you decide to do something else.");
				}
			} else {
				//Got this from: https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
				Application.launch();
				System.out.println("You go over to the radio and turn it on. Music starts to play.");
				String song = "Lawrence_Angrave_performs_parody_of_Taylor_Swifts_Blank_Space_for_CS_241_Systems_Programming[Mp3Converter.net].mp3";
				Media hit = new Media(new File(song).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
			}
			System.out.println("\n"); //here to see text easier
		}
		scan.close();
		
	}
	

	
	
	
	
}
