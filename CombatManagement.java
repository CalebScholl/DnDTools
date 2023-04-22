package EnemyManipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CombatManagement {
	
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	
	public static int inputchecker(String string) {
		
		
		int command;
		try {
			command = Integer.parseInt(string);
		} catch(Exception e) {
			System.out.println("Provide a valid number, Please.\n");
			return -1;
		}
		return command;
	}
	
	public static void enemyFromFile(String fileName) {
		fileName = "testEnemy.txt";
		
		Scanner scanner = new Scanner(fileName);

        File file = new File(scanner.nextLine());

        try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
        scanner.next();
        String name = scanner.next();
        scanner.next();
        int AC = scanner.nextInt();
        scanner.next();
        int speed = scanner.nextInt();
        scanner.next();
        scanner.next();
        int HP = scanner.nextInt();
        scanner.next();
        scanner.next();
        scanner.next();
        int profBonus = scanner.nextInt();
        scanner.next();
        int str = scanner.nextInt();
        scanner.next();
        int dex = scanner.nextInt();
        scanner.next();
        int con = scanner.nextInt();
        scanner.next();
        int intel = scanner.nextInt();
        scanner.next();
        int wis = scanner.nextInt();
        scanner.next();
        int cha = scanner.nextInt();
        
        Enemy enemyFile = new Enemy(name, AC, speed, HP, profBonus, str, dex, con, intel, wis, cha);
        int initative;
        String attack;
        
        if(scanner.hasNext()) {
        	 while (scanner.hasNext()) {
                 String line = scanner.next();
                 System.out.println(line);
                 
                 if(line.equals("Initative:")) {
                	 enemyFile.setInitative(Integer.parseInt(scanner.next())) ;
                 } else if(line.equals("Actions:")) {
                	 line = scanner.next();
                	 while(!line.contains(":")) {
                		 
                	 }
                 }
                 
                 
             }
        } else {
        	scanner.close();
            enemies.add(enemyFile);
        }


        
         
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean running = true;
		String command;
		Enemy selectedEnemy = null;
		
		while(running) {

			enemyFromFile("ahh");
									
			System.out.println("Enemy Manipulation Menu");
			System.out.println("Press 1 to create a new Enemy");
			System.out.println("Press 2 to damage a Enemy");
			System.out.println("Press 3 to heal a Enemy");
			System.out.println("Press 4 to edit an enemy");
			System.out.println("Press 5 to get rid of an enemy");
			System.out.println("Press 6 to add initative\n");
			if(enemies.size() != 0) {
				for(Enemy enemy: enemies) {
					System.out.println(enemy);
				}
			}
			//System.out.println("Press 7 to write your enemy to a file"); this works just don't want the user to see.
			//not even started, seems like a lot of work.
			//pre-defined enemy
			//maybe read stuff to files to make enemy creation easier or another switch case
			
			//processes the user input into something I can use
			command = input.nextLine();
			
			switch(command) {
				//create a new enemy
				case "1":
					System.out.println("What is their name?");
					command = input.nextLine();
					String name = command;
					
					System.out.println("What is their AC?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int ac = Integer.parseInt(command);
					
					System.out.println("What is their speed?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int speed = Integer.parseInt(command);
					
					System.out.println("What is their HP?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int hp = Integer.parseInt(command);
					
					System.out.println("What is their Proficency Bonus?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int prof = Integer.parseInt(command);
					
					System.out.println("What is their Strength?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int str = Integer.parseInt(command);
					
					System.out.println("What is their Dexterity?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int dex = Integer.parseInt(command);
					
					System.out.println("What is their Constitution?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int con = Integer.parseInt(command);
					
					System.out.println("What is their Intelligence?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int intel = Integer.parseInt(command);
					
					System.out.println("What is their Wisdom?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int wis = Integer.parseInt(command);
					
					System.out.println("What is their Charisma?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					int cha = Integer.parseInt(command);
					
					Enemy enemy = new Enemy(name, ac, speed, hp, prof, str, dex, con, intel, wis, cha);
					enemies.add(enemy);
					break;
					
				//damage an enemy
				case "2":
					System.out.println("What enemy in the list would you like to damage?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						selectedEnemy = enemies.get(Integer.parseInt(command) - 1);
					} catch(Exception e) {
						System.out.println("Invalid Enemy, Please.\n");
						break;
					}
					
					System.out.println("How much damage would you like to do?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					selectedEnemy.setHP(selectedEnemy.getHP() - Integer.parseInt(command));
					break;
					
				//heal an enemy
				case "3":
					System.out.println("What enemy in the list would you like to heal?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						selectedEnemy = enemies.get(Integer.parseInt(command) - 1);
					} catch(Exception e) {
						System.out.println("Invalid Enemy.\n");
						break;
					}
					
					System.out.println("How much healing would you like to do?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					selectedEnemy.setHP(selectedEnemy.getHP() + Integer.parseInt(command));
					break;
					
				//edit an enemy
				case "4":
					System.out.println("What enemy in the list would you like to edit?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						selectedEnemy = enemies.get(Integer.parseInt(command) - 1);
					} catch(Exception e) {
						System.out.println("Invalid Enemy.\n");
						break;
					}
						
					System.out.println("Press 1 to change name.");
					System.out.println("Press 2 to change AC");
					System.out.println("Press 3 to change HP");
					System.out.println("Press 4 to change speed");
					System.out.println("Press 5 to change one of their stats");
					System.out.println("Press 6 to add a condition, immunity, or resistance");
					System.out.println("Press 7 to add an actions");
					System.out.println("Press 8 to add a skill");
					command = input.nextLine();
					switch(command) {
						//change name
						case "1":
							System.out.println("Please type the name you want to change it too.");
							command = input.nextLine();
							selectedEnemy.setName(command);
							break;
								
						//change AC	
						case "2":
							System.out.println("Please type the AC you want to change it too.");
							command = input.nextLine();
							if(inputchecker(command) < 0) {
								break;
							}
							selectedEnemy.setAC(Integer.parseInt(command));
							break;
								
						//change HP
						case "3":
							System.out.println("Please type the HP you want to change it too.");
							command = input.nextLine();
							if(inputchecker(command) < 0) {
								break;
							}
							selectedEnemy.setHP(Integer.parseInt(command));
							break;
								
						//change speed
						case "4":
							System.out.println("Please type the speed you want to change it too.");
							command = input.nextLine();
							if(inputchecker(command) < 0) {
								break;
							}
							selectedEnemy.setSpeed(Integer.parseInt(command));
							break;
								
						//change stats
						case "5":
							System.out.println("Which stat do you want to change?");
							System.out.println("str, dex, con, int, wis, cha");
							command = input.nextLine();
							String stat = command.toLowerCase();
							if(stat.equals("str") || stat.equals("dex") || stat.equals("con") || stat.equals("int") || stat.equals("wis") || stat.equals("cha")) {
								System.out.println("What do you want the new stat to be?");
								command = input.nextLine();
								if(inputchecker(command) < 0) {
									break;
								}
								selectedEnemy.stats.put(stat, Integer.parseInt(command));
								break;
							} else {
								System.out.println("Provide a valid stat, Please.\n");
								break;
							}
								
						//add condition
						case "6":
							System.out.println("What condition do you want to add?");
							command = input.nextLine();
							selectedEnemy.addCondition(command);
							break;
							
						//add action
						case "7":
							String actionName;
							System.out.println("What is the name of the action?");
							command = input.nextLine();
							actionName = command;
							System.out.println("What is the description of the action?");
							command = input.nextLine();
							selectedEnemy.addAction(actionName, command);
							break;
								
						//add skill
						case "8":
							int bonus;
							System.out.println("What is the name of the skill you want to add?");
							command = input.nextLine();
							String ah = command;
							System.out.println("What is the bonus of the skill?");
							command = input.nextLine();
							if(inputchecker(command) < 0) {
								break;
							}
							bonus = Integer.parseInt(command);
							selectedEnemy.addSkill(ah, bonus);
							break;
						}
						break;
					
				// remove enemy
				case "5":
					System.out.println("Which enemy in the list do you want to remove?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						enemies.remove(Integer.parseInt(command) - 1);
						break;
					} catch(Exception e) {
						System.out.println("Invalid Enemy, Please.\n");
						break;
					}
					
				//add initiative
				case "6":
					System.out.println("Which enemy in the list do you want to add initative to?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						selectedEnemy = enemies.get(Integer.parseInt(command) - 1);
					} catch(Exception e) {
						System.out.println("Invalid Enemy, Please.\n");
						break;
					}
					System.out.println("What is it's initative?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					selectedEnemy.setInitative(Integer.parseInt(command));
					break;
				case "7":
					System.out.println("Which enemy in the list do you want to write to a file?");
					command = input.nextLine();
					if(inputchecker(command) < 0) {
						break;
					}
					
					try {
						selectedEnemy = enemies.get(Integer.parseInt(command) - 1);
					} catch(Exception e) {
						System.out.println("Invalid Enemy.\n");
						break;
					}
					
					try {
					File output = new File(selectedEnemy.getName() + "Enemy.txt");
					FileWriter writer = new FileWriter(output);

					writer.write(selectedEnemy.toString());
					writer.flush();
					writer.close();
					System.out.println("This operation was successful.\n");
					break;
					} catch(Exception e) {
						System.out.println("Your operation was unsuccessful.\n");
						break;
					}
			}
		}
		input.close();
	}
}