package entities;

public class PlayerProfile {
	
	public static PlayerProfile profile = new PlayerProfile();
	
	public int health;
	public int score;
	
	public PlayerProfile(){
		health = 100;
		score = 0;
	}
}
