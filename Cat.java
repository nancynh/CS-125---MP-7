import java.util.Scanner;

/** Cat class that you create with.
 * 
 */
public class Cat {
	private String name; 		//name of the cat
	private boolean gender; 		//true if female, false male (eye shape changes based on gender)
	private int attack;			//Attack power of the cat, no limit on the power
	private double defense; 		//Defense power of the cat, on a scale of 0-75% reduced damage
	private int hp; 				//Amout of damage a cat can recieve before they die
	private int maxHP;
	private int accuracy; 		//How well the cat can hit without missing on a scale of 1-100, the bigger the number the more accurate
	private boolean isDefending = false; 	//whether or not the cat is defending
	static private int ranAway = 0;			//number of times the cat has ran away successfully
	static private int numFights = 0; 		//number of fights that happened so far
	static private boolean ranAwayBool = false;
	
	
	public Cat(String n, int a, double d, int h, int acc) {
		name = n;
		gender = false;
		attack = a;
		defense = d;	
		hp = h;
		maxHP = h;
		accuracy = acc;
	}
	
	public Cat(String n, boolean g, int a, double d, int h, int acc) {
		name = n;
		gender = g;
		attack = a;
		defense = d;	
		hp = h;
		maxHP = h;
		accuracy = acc;
	}
	
	/**
	 *Current cat attacking their opponent. 
	 * @param c is the cat you're attacking
	 */
	public void attack(Cat c) {
		isDefending = false;
		//Do probablity of the cat being able to hit the cat
		//If hit cat, then other cat will take damage
		int hitProb = ((int) (Math.random() * 100)) + 1;
		
		//Amount of damage to be done
		int hitPow = ((int) (Math.random() * attack) + 1);
		
		//Chance of getting the attack
		if (hitProb >= accuracy) {
			//Checking if the opponent cat is defending itself or not
			if (c.getDefending()) {
				hitPow = (int) (hitPow * (1 - defense));
				System.out.println(c.getName() + " defends against " + this.getName() + "\'s attack!" + "\n" +
						this.getName() + " only attacks " + c.getName() + " for a total of " + hitPow + " damage.");
				c.setHP(c.getHP() - hitPow);
			} else {
				System.out.println(this.getName() + " attacks " + c.getName() + " for a total of " + hitPow + " damage!");
				c.setHP(c.getHP() - hitPow);
			}
		} else {
			System.out.println(name + " misses!");
		}
		
	}
	
	/**
	 * Current cat defending against their opponent.
	 * 
	 */
	public void defend() {
		isDefending = true;
		System.out.println(name + " goes into a defensive stance!");
	}
	
	/**
	 * Current cat trying to run away from the fight 
	 * @param c is the cat you're running away from
	 * @return true if the cat is able to run away 
	 */
	public boolean run(Cat c) {
		isDefending = false;
		int runProb = (int) (Math.random() * 100) + 1;
		//Running away successfully
		if (runProb <= 15) {
			ranAway++;
			ranAwayBool = true;
			System.out.println(name + " runs aways!");
			return true;
		} else {
			System.out.println(c.getName() + " blocks " + name + " from running away!");
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if the cat is dead, false otherwise
	 */
	public boolean isDead() {
		if (hp <= 0) {
			return true;
		} else{
			return false;
		}
	}
	
	/**Returns the winner of the fight.
	 * @param c opponent cat
	 * @return true if the player cat won, false if the opponent cat won
	 */
	public boolean winner(Cat c) {
		if (this.isDead()) {
			System.out.println(c.getName() + " defeated " + name + ".");
			return false;
		} else {
			System.out.println(name + " defeated " + c.getName() + ".");
			return true;
		}
	}
	
	
	/**
	 * Fighting sequence between you and the other cat
	 * @param c is the opponent
	 * 
	 */
	public void fight(Cat c) {
		ranAwayBool = false;
		numFights++;
		Scanner scan = new Scanner(System.in);
		int choice, catActionProb;
		boolean fight = true;
		while (fight) {
			//Your turn
			System.out.println("What should your cat do?"
							+ "\n\t(1) Attack"
							+ "\n\t(2) Defend"
							+ "\n\t(3) Run Away");
			choice = scan.nextInt();
			if (choice <= 0 || choice > 3) {
				System.out.println("Please type in a number between 1 and 3");
				choice = scan.nextInt();
			}
			if (choice == 1) {
				this.attack(c);
			} else if (choice == 2) {
				this.defend();
			} else {
				if(this.run(c)) {
					break;
				}
			}
			
			//Checking if the other cat is dead yet
			if (c.isDead()) {
				break;
			}
			
			//Opponent's turn
			catActionProb = (int) (Math.random() * 100) + 1;
			if (catActionProb <= 80) {
				c.attack(this);
			} else {
				c.defend();
			}
			
			//Checking if the player's cat is dead yet
			if (this.isDead()) {
				break;
			}
			
			//Printing out how much health each cat has 
			System.out.println("\t\t" + this.getName() + "'s Health: " + this.getHP() + "\t\t " + c.getName() + "'s Health: " + c.getHP());
		}
	}
	
	/**
	 * Your cat sleeps and regains health.
	 */
	public void sleep() {
		System.out.println(
				"Night falls and " + name + " and you go to sleep." +
				"\n               /\\____/\\    __\n" + 
				"             .'  \"\"\"\"  `,-'  `--.__\n" + 
				"        __,- :   -  -  ;  \" ::     `-. -.__\n" + 
				"     ,-sssss `._  `' _,'\"     ,'~~~::`.sssss-.\n" + 
				"    |ssssss ,' ,_`--'_    __,' ::  `  `.ssssss|\n" + 
				"   |sssssss `-._____~ `,,'_______,---_;; ssssss|\n" + 
				"    |ssssssssss     `--'~{__   ____   ,'ssssss|\n" + 
				"     `-ssssssssssssssssss ~~~~~~~~~~~~ ssss.-'\n" + 
				"          `---.sssssssssssssssssssss.---' ");
		System.out.print(name + " sleeps and regains " + this.possession() + " HP!");	
		this.setHP(maxHP);
	}
	
	/**
	 * Prints out the gender
	 * @return the gender
	 */
	public String possession() {
		if (gender) {
			return "her";
		} else {
			return "his";
		}
	}
	
	public String pronoun() {
		if (gender) {
			return "she";
		} else {
			return "he";
		}
	}
	
	/**
	 * Prints out the stats of the kitty
	 */
	public void getStats() {
		System.out.println("Stats:"
				+ "\n\tName: " + this.getName()
				+ "\n\tHP: " + this.getHP()
				+ "\n\tAttack: " + this.getAttack()
				+ "\n\tDefense: " + ((int) (this.getDefense() * 100))
				+ "\n\tAccuracy: " + this.getAcc() + "%");
	}
	
	
	//Getters
	public String getName() {return name;}
	public boolean getGender() {return gender;}
	public int getAttack() {return attack;}
	public double getDefense() {return defense;}
	public int getHP() {return hp;}
	public int getAcc() {return accuracy;}
	public boolean getDefending() {return isDefending;}
	public int getMaxHP() {return maxHP;}
	
	//Setters
	public void setName(String n) {name = n;}
	public void setGender(boolean g) {gender = g;}
	public void setAttack(int a) {attack = a;}
	public void setDefense(double d) {defense = d;}
	public void setHP(int h) {hp = h;}
	public void setDefending(boolean d) {isDefending = d;}
	public void setAcc(int acc) {accuracy = acc;}
	public void setMaxHP(int hp) {maxHP = hp;}
	
	
	
	//--------------
	//---  GAME  ---
	//--------------
	public static void game() {
		Cat petCat;
		Scanner scan = new Scanner(System.in); //ex. String s = scan.next();
		
		System.out.println("What's your name?");
		String playerName = scan.nextLine();
		System.out.println("Great! Continuing onward with the story.");
		System.out.println("One day, you found a package on your table when you come home. \nInside that package was a cat and a letter addressed from your roommate!");
		System.out.println("\nHey " + playerName + ","
						   + "\nMy brother's cat just gave birth to a bunch of kittens so I decided to take one in."
						   + "\nI'll take care of the little guy when I come back next week! (I forgot to tell you "
						   + "\nthat I went to visit my family for the week). Please take care of him for me! I "
						   + "\nhaven't decided on a name. So if you don't come up with one I'll name him Mr. Schnookums"
						   + "\nI include a cheque in the box to compensate for any troubles and so you can buy him "
						   + "\nsome food, toys, etc."
						   + "\n\nPersonally, you:"
						   + "\n\t(1) Love cats so are estatic to take care of this one"
						   + "\n\t(2) Hate cats so you are dreading this"
						   + "\n\t(3) Don't care either way for them");
		int choice = scan.nextInt();
		while (choice <= 0 || choice > 3) {
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
		String catName = scan.nextLine();
		
		while (catName.equals("")) {
			System.out.println("Please type in a name: ");
			catName = scan.nextLine();
		}
		
		//Making your pet cat
		petCat = new Cat(catName, 25, 0.15, 50, 25);
		
		System.out.println("\nThat's a great name! You look up to find the cat has gone missing! Oh no! "
				+ "\nYour roommate is going to tear you a new one if you don't find " + catName + "."
				+ "\nYou look out the window to see " + catName + " fighting another cat?! Not only"
				+ "\nthat but it's your next door neighbor, Mr. Hong's cat! You quickly go outside to "
				+ "\ntake " + catName + " back in, but " + catName + " hisses at you and motions his paw"
				+ "\ntowards the other cat. It seems like your cat wants to fight the other cat..."
				+ "\n" + catName + " tries to claw the other cat, but that cat brutally attacks " + catName
				+ "\nOh no! If " + catName + " gets injured - or worse, dies - then your roommate will definitely kick you out."
				+ "\nYou gotta help " + catName + " defeat the other cat otherwise you'll end up homeless!");
	
		//--------------
		//-- TUTORIAL --
		//--------------
		Cat weakCat = new Cat("Mr. Hong's cat", 10, 0.05, 10, 10);
		System.out.println(
				"         \n" + 
				"           (\\(\\      \\\\\n" + 
				"           /.. \\      ||\n" + 
				"           \\Y_, '----.//\n" + 
				"             )        /\n" + 
				"             |   \\_/  ;\n" + 
				"              \\\\ |\\`\\ |\n" + 
				"              ((_/(_(_/");
		weakCat.getStats();
		
		petCat.fight(weakCat);
		if (!petCat.winner(weakCat) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		petCat.sleep();
		
		//------------
		//-- FIGHTS --
		//------------
		//(String name, int attack, double defense, int hp, int acc)
		
		//1. High attack, low defense, low health, high accuracy (small quick cat with a knife in it's mouth?!?!) /ᐠ｡ꞈ｡ᐟ\
		Cat evilKitty = new Cat("Evil Kitty", 45, 0.05, 20, 90);
		System.out.println("The next morning, you take " + catName + " on a shopping trip to buy some food and toys."
						+ "\nMaybe " + catName + " can help you pick out some toys it will like. You and " + catName
						+ "\ngo to the pet store. You wander around the aisles for a bit until you hearing mewing."
						+ "\nSounds like " + catName + ". You go over to " + catName + " to find " + catName + " in yet another scuffle. "
						+ "\nThis time the two cats are fighting over a ball of yarn. The other kitty is a cute little thing. "
						+ "\nIt has something shiny in its mouth. You take a closer look and see"
						+ "a knife?! Time to help " + catName + " fight this devil!");
		System.out.println(
				" ／l、\n" + 
				"（ﾟ､ ｡ ７\n" + 
				" |、 ~\\\n" + 
				" じしf_, )ノ");
		evilKitty.getStats();
		petCat.fight(evilKitty);
		if (!petCat.winner(evilKitty) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		System.out.println("\nAfter the fight, you bought the toy " + catName + " fought so hard for"
						+ "\nalong with some food and other supplies. However, you discover that \n" 
						+ catName + " has already abandoned the toy and went off to sleep on top of"
						+ "\nyour computer as soon as the two of you got home. You stare at \n" 
						+ catName + " and could swear that " + petCat.pronoun() + " has gotten faster...\n"
						+ catName + " has increased their speed and accuracy!");
		petCat.setAcc(petCat.getAcc() + 25);
		
		petCat.sleep();
		
		//2. low attack, high defense, high health, low accuracy (fat cat)
		Cat fatCat = new Cat("Fat Cat", 5, 0.85, 125, 5);
		System.out.println("\nThe next day, you feed " + catName + " some food. " + catName + " was too busy napping to"
						+ "\nnotice that you put some food out. Hours later you hear screeching in your kitchen."
						+ "\nYou rush over to see " + catName + " fighting yet another cat! This time the cat is very"
						+ "\nchubby. Time to help " + catName + "!");
		
		System.out.println(
				"\n" + 
				"        .\n" + 
				"       -.\\_.--._.______.-------.___.---------.___\n" + 
				"       )`.                                       `-._\n" + 
				"      (                                              `---.\n" + 
				"      /o                                                  `.\n" + 
				"     (                                                      \\\n" + 
				"   _.'`.  _                                                  L\n" + 
				"   .'/| \"\" \"\"\"\"._                                            |\n" + 
				"      |          \\             |                             J\n" + 
				"                  \\-._          \\                             L\n" + 
				"                  /   `-.        \\                            J\n" + 
				"                 /      /`-.      )_                           `\n" + 
				"                /    .-'    `    J  \"\"\"\"-----.`-._             |\\          \n" + 
				"              .'   .'        L   F            `-. `-.___        \\`.\n" + 
				"           ._/   .'          )  )                `-    .'\"\"\"\"`.  \\)\n" + 
				"__________((  _.'__       .-'  J              _.-'   .'        `. \\\n" + 
				"                   \"\"\"\"\"\"\"((  .'--.__________(   _.-'___________)..|----------------._____\n" + 
				"                            \"\"                \"\"\"               ``U'\n" + 
				"\n" + 
				"-----._______\n" + 
				"             `-------.__________.--\n" + 
				"                       `-.                      ______________.---------------------------\n" + 
				"                          `----'`---------'----'\n" + 
				"");
		fatCat.getStats();
		petCat.fight(fatCat);

		if (!petCat.winner(fatCat) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		//inc health
		System.out.println("After the fight, you noticed " + catName + " has gotten more healthy."
						+ "\n" + catName + "'s HP increased!");
		petCat.setMaxHP(petCat.getMaxHP() + 50);
		
		petCat.sleep();
		
		//3. Fabulous cat - [^._.^]ﾉ彡
		Cat fabCat = new Cat("Fabulous Cat", 30, 0.25, 75, 50);
		System.out.println("You wake up in the middle of the night to hear " + catName + " hissing."
						+ "\nYou knew what that meant. Time to fight another cat. You go over to \n"
						+ catName + " and find " + petCat.possession() + " fighting a cat on its"
						+ " hind legs.");
		
		System.out.println(
				"_ヽ\n" + 
				"　 ＼＼ Λ＿Λ\n" + 
				"　　 ＼(　ˇωˇ)　\n" + 
				"　　　 >　⌒ヽ\n" + 
				"　　　/ 　 へ＼\n" + 
				"　　 /　　/　＼＼\n" + 
				"　　 ﾚ　ノ　　 ヽ_つ\n" + 
				"　　/　/\n" + 
				"　 /　/|\n" + 
				"　(　(ヽ\n" + 
				"　|　|、＼\n" + 
				"　| 丿 ＼ ⌒)\n" + 
				"　| |　　) /\n" + 
				"`ノ )　　Lﾉ\n" + 
				"(_／.");
		fabCat.getStats();
		petCat.fight(fabCat);

		if (!petCat.winner(fabCat) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		//increase attack
		System.out.println("After the fight, you noticed " + catName + " has gotten more vicious."
				+ "\n" + catName + "'s attack increased!");
		petCat.setAttack(petCat.getAttack() + 15);
		
		
		petCat.sleep();
		
		//4. another filler 
		Cat militaryCat = new Cat("Military Cat", 65, 0.50, 15, 35);
		System.out.println("The next day while your cat was out and about, " + petCat.pronoun() + " came across"
					+ "\na cat in a mini tank. You know what that means. Time to fight another cat!");
		
		System.out.println(
				"              ________________\n" + 
				"              |                |_____    __\n" + 
				"              |                |     |__|  |_________\n" + 
				"              |________________|     |::|  |        /\n" + 
				" /\\**/\\       |                \\.____|::|__|      <\n" + 
				"( o_o  )_     |                      \\::/  \\._______\\\n" + 
				" (u--u   \\_)  |\n" + 
				"  (||___   )==\\\n" + 
				",dP\"/b/=( /P\"/b\\\n" + 
				"|8 || 8\\=== || 8\n" + 
				"`b,  ,P  `b,  ,P\n" + 
				"  \"\"\"`     \"\"\"`");
		militaryCat.getStats();
		petCat.fight(militaryCat);

		if (!petCat.winner(militaryCat) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		petCat.sleep();
		
		//inc defense
		System.out.println("After the fight, you noticed " + catName + " has gotten more durable."
				+ "\n" + catName + "'s defense increased!");
		petCat.setDefense(petCat.getDefense() + 15);
		
		//5. boss cat dun dun
		Cat bossCat = new Cat("Boss Cat", 88, 0.88, 888, 88);
		System.out.println("You and " + catName + " have been feeling pretty confident with the amount of cats"
						+ "\nyou have defeated. Unforunately, along comes a big cat which threatens the life of"
						+ "\n" + catName + "! Time to defeat the Cat King!");
		
		System.out.println(
				"      .                .                    \n" + 
				"            :\"-.          .-\";                    \n" + 
				"            |:`.`.__..__.'.';|                    \n" + 
				"            || :-\"      \"-; ||                    \n" + 
				"            :;              :;                    \n" + 
				"            /  .==.    .==.  \\                    \n" + 
				"           :      _.--._      ;                   \n" + 
				"           ; .--.' `--' `.--. :                   \n" + 
				"          :   __;`      ':__   ;                  \n" + 
				"          ;  '  '-._:;_.-'  '  :                  \n" + 
				"          '.       `--'       .'                  \n" + 
				"           .\"-._          _.-\".                   \n" + 
				"         .'     \"\"------\"\"     `.                 \n" + 
				"        /`-                    -'\\                \n" + 
				"       /`-                      -'\\               \n" + 
				"      :`-   .'              `.   -';              \n" + 
				"      ;    /                  \\    :              \n" + 
				"     :    :                    ;    ;             \n" + 
				"     ;    ;                    :    :             \n" + 
				"     ':_:.'                    '.;_;'             \n" + 
				"        :_                      _;                \n" + 
				"        ; \"-._                -\" :`-.     _.._    \n" + 
				"        :_          ()          _;   \"--::__. `.  \n" + 
				"         \\\"-                  -\"/`._           :  \n" + 
				"        .-\"-.                 -\"-.  \"\"--..____.'  \n" + 
				"       /         .__  __.         \\               \n" + 
				"      : / ,       /      \\       . \\ ;           \n" + 
				"       \"-:___..--\"      \"--..___;-\"    ");
		bossCat.getStats();
		petCat.fight(bossCat);

		if (!petCat.winner(bossCat) && !ranAwayBool) {
			System.out.println("You watch as " + catName + " dies helplessly in your arms."
								+ "\nNow you're in for it when your roommate comes back."
								+ "\nGame over.");
			return;
		} else {
			System.out.println("Thankfully, " + catName + " won. You still get to live in your home for now...");
		}
		
		
		//End game
		System.out.println("You and " + catName + " spend the rest of your time relaxing around until"
						+ "\nyour roommate comes back. They seem to be satisfied with your care of "
						+ catName + ". Because you didn't kill off " + catName + " you get to stay "
						+ "\nin your home.\nThe End");
		if (ranAway == numFights) {
			System.out.println(catName + " \"won\" every fight by running away. Congrats. Do you feel good about yourself?"
							+ "\nYou win (I guess)!");
		} else {
			System.out.println(catName + " won every fight! Congratulations!"
								+ "\nYou win!");
		}
		return;
		
	}
	
}
