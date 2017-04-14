import java.util.Scanner;
import java.util.*;
//Raymond Diamonds
//260656751

public class BattleGame{
  
  public static void main(String[] args){
    playGame();
  }
  
  //1.playGame method using FileIO
  public static void playGame(){
    //call readSpells method

    Character player = FileIO.readCharacter("player.txt");
    Character enemy = FileIO.readCharacter("monster.txt");
    ArrayList<Spell> spells = FileIO.readSpells("spells.txt");
    
    player.printMethod();
    enemy.printMethod();
    System.out.println("");
    System.out.println("Spell:");
    for (Spell s : spells) {
      System.out.println(s);
    }
    player.setSpells(spells);

    
    //scanner to take input while both player/enemy have health above 0
    while(player.getCurrentHealthVal()>0 && enemy.getCurrentHealthVal() >0){
      //asking user for command: attack & quit: if attack, call doAttack; if quit, 
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a command: 'attack' or 'quit'");
      String command = input.nextLine();
      if(command.equals("attack")){
        doAttack(player,enemy);
        doAttack(enemy,player);
      }else if(command.equals("quit")){
        System.out.println("Goodbye. See you next time!");
        return;
      }else{
        double damage = player.castSpell(command);
        enemy.takeDamage(damage);
      }
      input.close();
    }
    //loop stops cus charc health>0; congratulate or say you lost
    if(enemy.getCurrentHealthVal()<=0){
      player.increaseWins();
      FileIO.writeCharacter(player, "player.txt");
      System.out.println("Congratulations, you won! You have " + player.getNumWins() + " wins, and player 2 has " + enemy.getNumWins() + " wins");
    } else if(player.getCurrentHealthVal()<=0){
      enemy.increaseWins();
      FileIO.writeCharacter(enemy, "monster.txt");
      System.out.println("Sorry, you lost! You have " + player.getNumWins() + " wins, and player 2 has " + enemy.getNumWins() + " wins");
    }
  }
  //2.doAttack method takes 2 Character inputs
  public static void doAttack(Character ch1, Character ch2){
    double damage = ch1.calcAttack();
    System.out.println(ch1.getName() + " attacks for " + String.format("%1$.2f", damage) + " damage!");
    ch2.takeDamage(damage);
    System.out.println(ch2.getName() + " takes " + String.format("%1$.2f", damage) + " damage!");
    //if ch2 health>0 then print name and its current health
    if(ch2.getCurrentHealthVal() > 0){
      System.out.println("Name: " + ch2.getName() + " : " + String.format("%1$.2f", ch2.getCurrentHealthVal()));
    }
    System.out.println("");
  }
  
}