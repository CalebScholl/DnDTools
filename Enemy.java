package EnemyManipulation;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class Enemy implements Map {
	private String name;
	private int AC;
	private int speed;
	private int HP;
	private int profBonus;
	private int initative;
	//The key is the stat and the value is the value of the stat.
	Map<String, Integer> stats = new TreeMap<>();
	//The key is the name while the the value is the action description.
	private Map<String, String> actions = new TreeMap<>();
	//The key is the skill and the value is the bonus, 
	private Map<String, Integer> skills = new TreeMap<>();
	//This list comprises damage resistance/immunities, condition resistance/immunities.
	private ArrayList<String> conditions = new ArrayList<String>();
	
	public Enemy(String name, int AC, int speed, int HP, int profBonus, int str, int dex, int con, int intelligence, int wis, int cha) {
		this.name = name;
		this.AC = AC;
		this.speed = speed;
		this.HP = HP;
		this.profBonus = profBonus;
		this.stats.put("str", str);
		this.stats.put("dex", dex);
		this.stats.put("con", con);
		this.stats.put("int", intelligence);
		this.stats.put("wis", wis);
		this.stats.put("cha", cha);
	}
	
	//Getter Methods
	public int getHP() {
		return this.HP;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Setter Methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAC(int AC) {
		this.AC = AC;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public void setProfBonus(int profBonus) {
		this.profBonus = profBonus;
	}
	
	public void setInitative(int init) {
		this.initative = init;
	}
	
	//Enemy Editing methods
	
	/**
	 * This method adds an action to the enemy it is called on.
	 * 
	 * @param name The name of the action that the enemy can perform.
	 * @param desc The description for the action.
	 */
	public void addAction(String name, String desc) {
		this.actions.put(name.toLowerCase(), desc.toLowerCase());
	}
		
	/**
	 * This method will remove an action from the creatures actions. 
	 * Note that the action must be the same as the action that you are trying to remove.
	 * 
	 * @param action
	 */
	public void removeAction(String action) {
		if(this.actions.containsKey(action.toLowerCase())) {
			this.actions.remove(action.toLowerCase());
		}
	}
	
	/**
	 * This method adds a skill to the enemy it is called on.
	 * 
	 * @param skill The skill that the enemy has.
	 * @param bonus The bonus it gets to the skill.
	 */
	public void addSkill(String skill, int bonus) {
		this.skills.put(skill.toLowerCase(), bonus);
	}
		
	/**
	 * This method will remove a skill from the creatures skills. 
	 * Note that the skill must be the same as the skill that you are trying to remove.
	 * 
	 * @param skill
	 */
	public void removeSkill(String skill) {
		if(this.skills.containsKey(skill.toLowerCase())) {
			this.skills.remove(skill.toLowerCase());
		}
	}
	
	/**
	 * This method adds a condition to the enemy it is called on.
	 * 
	 * @param condition The condition that the enemy has.
	 */
	public void addCondition(String condition) {
		this.conditions.add(condition);
	}
	/**
	 * This method overrides the toString method.
	 */
	public String toString() {
		String returnString = "Name: " + name + "\n";
		returnString += "AC: " + AC + "\n";
		returnString += "Speed: " + speed + " ft. \n";
		returnString += "HP: " + HP + "\n";
		returnString += "Proficency Bonus: + " + profBonus + "\n";
		returnString += "Strength: " + stats.get("str") + "\n";
		returnString += "Dexterity: " + stats.get("dex") + "\n";
		returnString += "Constitution: " + stats.get("con") + "\n";
		returnString += "Intelligence: " + stats.get("int") + "\n";
		returnString += "Wisdom: " + stats.get("wis") + "\n";
		returnString += "Charisma: " + stats.get("cha") + "\n";
		
		if(initative != 0)
			returnString += "Initative: "+ initative + "\n";
		
		if(!actions.isEmpty()) {
			returnString += "Actions: \n";
			 for (Map.Entry<String,String> entry : actions.entrySet()) {
				 returnString += entry.getKey() + ": " + entry.getValue() + " \n";
			 }
		}
		
		if(!skills.isEmpty()) {
			returnString += "Skills: \n";
			for (Map.Entry<String, Integer> entry : skills.entrySet()) {
				returnString += entry.getKey() + " + " + entry.getValue() + " \n";
			}
		}
		
		if(!conditions.isEmpty()) {
			returnString += "Conditions: \n";
			for(String st: conditions) {
				returnString += st + " \n";
			}
		}
		return returnString;
	}	
}