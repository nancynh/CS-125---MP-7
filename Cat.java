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
	private int accuracy; 		//How well the cat can hit without missing on a scale of 1-100, the bigger the number the more accurate
	private boolean isDefending = false; 	//whether or not the cat is defending
	
	public Cat(String n, int a, double d, int h, int acc) {
		name = n;
		gender = false;
		attack = a;
		defense = d;	
		hp = h;
		accuracy = acc;
	}
	
	public Cat(String n, boolean g, int a, double d, int h, int acc) {
		name = n;
		gender = g;
		attack = a;
		defense = d;	
		hp = h;
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
		if (hitProb <= accuracy) {
			//Checking if the opponent cat is defending itself or not
			if (c.getDefending()) {
				hitPow = (int) (hitPow * (1 - defense));
				System.out.println(c.getName() + " defends against " + this.getName() + "\'s attack!" +
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
		if (runProb <= 25) {
			System.out.println(name + " runs aways like a pussy!");
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
			System.out.println(name + " dies!");
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
		if (c.isDead()) {
			System.out.println(c.getName() + " defeated " + name);
			return false;
		} else {
			System.out.println(name + " defeated " + c.getName());
			return true;
		}
	}
	
	
	/**
	 * Fighting sequence between you and the other cat
	 * @param c is the opponent
	 * 
	 */
	public void fight(Cat c) {
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
		}
	}
	
	
	//Getters
	public String getName() {return name;}
	public boolean getGender() {return gender;}
	public int getAttack() {return attack;}
	public double getDefense() {return defense;}
	public int getHP() {return hp;}
	public boolean getDefending() {return isDefending;}
	
	//Setters
	public void setName(String n) {name = n;}
	public void setGender(boolean g) {gender = g;}
	public void setAttack(int a) {attack = a;}
	public void setDefense(double d) {defense = d;}
	public void setHP(int h) {hp = h;}
	public void setDefending(boolean d) {isDefending = d;}
	
}
