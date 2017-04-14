import java.util.Random;
import java.util.*;
//Name: Raymond Diamonds
//StudentID: 260656751


import java.util.ArrayList;
public class Character{
  //private attributes for both monster/character instances
  private String name;
  private double attackVal;
  private double maxHealthVal;
  private double currentHealthVal;
  private int numWins;
  
  private static ArrayList<Spell> spells = new ArrayList<Spell>();
  
  //1.Constructor that takes 1 string, 2 doubles and 1 int as input
  public Character(String name, double attackVal, double maxHealthVal, int numWins){
    this.name = name;
    this.attackVal = attackVal;
    this.maxHealthVal = maxHealthVal;
    this.currentHealthVal = maxHealthVal;
    this.numWins = numWins;
  }
  
  //2. toString consisting of Char's name and current health
  public String toString(){
    String s = name + "'s current health is: " + currentHealthVal;
    return s;
  }
  
  //3. calcAttack: char's attackVal*randomVal between 0.3-0.7(excl)
  public double calcAttack(){
    //generate random value between 0.3(incl) to 0.7(excl)
    Random val = new Random();
    double randomVal = (0.3 + (val.nextDouble() * (0.7-0.3)));
    double damage = this.attackVal*randomVal;
    return damage;
  }
  
  //4. takeDamage subtract damage from current health
  public void takeDamage(double damage){
    this.currentHealthVal = this.currentHealthVal-damage;
  }
  
  //5. increaseWins: Increase # wins by one, does not return anything but will be called
  public void increaseWins(){
    this.numWins++;
  }
  
  //public print method to print character attributes
  public void printMethod(){
    System.out.println("Name: " + this.name);
    System.out.println("Current Health Value: " + String.format("%1$.2f", this.currentHealthVal));
    System.out.println("Attack Value: " + String.format("%1$.2f", this.attackVal));
    System.out.println("Number of Wins: " + this.numWins);
  }
  
  //get method for currentHealth attribute
  public double getCurrentHealthVal(){
    return this.currentHealthVal;
  }
  //get method for attackVal attribute
  public double getAttackVal(){
    return this.attackVal;
  }
  //get method for name attribute
  public String getName(){
    return this.name;
  }
  //get method for numWins attribute
  public int getNumWins(){
    return this.numWins;
  }
  //set method for spell attribute
  public void setSpells(ArrayList<Spell> spellList){
    this.spells = spellList;      
  }
  
  //cast spell method
  public double castSpell(String spellName){
    //lower case conversion of spellName input
    String spellLowerCase = spellName.toLowerCase();
    
    
    //for each loop to iterate thru items in arraylist
    int flag = 0;
    Spell targetSpell = null;
    for( Spell spell : spells ){
      if(spell.getName().compareTo(spellLowerCase) == 0){
        flag = 1;
        targetSpell = spell;
        break;
        //if spell cannot be found, print and then return 0
      }
    }//print messages
    if( flag == 0){
       System.out.println("Character, " + name +  " casted unknown spell: " + spellName + ". They don't know that spell!") ;
        return 0;
    }else{
      double damage = targetSpell.getDamage();
      if(damage == 0){
        System.out.println("Character, " + name + " failed to cast the spell");
      }else if(damage > 0){
        System.out.println("Character, " + name + " casted the spell: " + spellName);
      }
      return damage;
    }
  }

  
}