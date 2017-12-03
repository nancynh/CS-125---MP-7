/** Cat class that you create with.
 * 
 */
public class Cat {
	private String name;
	private boolean gender; //true if female, false male (eye shape changes based on gender)
	private int attack;
	private int defense;
	private int hp;
	
	public Cat(String n, boolean g, int a, int d, int h) {
		name = n;
		gender = g;
		attack = a;
		defense = d;	
		hp = h;
	}
	
	
	
	
	//Getters
	public String getName() {return name;}
	public boolean getGender() {return gender;}
	public int getAttack() {return attack;}
	public int getDefense() {return defense;}
	public int getHP() {return hp;}
	
	//Setters
	public void setName(String n) {name = n;}
	public void setGender(boolean g) {gender = g;}
	public void setAttack(int a) {attack = a;}
	public void setDefense(int d) {defense = d;}
	public void setHP(int h) {hp = h;}
	
}