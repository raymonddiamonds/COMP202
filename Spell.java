import java.util.Random;

//Raymond Diamonds
//260656751

public class Spell{
  //spell attributes
  private String name;
  private double minDamage;
  private double maxDamage;
  private double randomVal;
  
  //constructor for the spells
  public Spell(String name, double minDamage, double maxDamage, double randomVal){
    if(minDamage<0 || minDamage>maxDamage || randomVal<0 || randomVal>1){
      throw new IllegalArgumentException();
    }
    
    this.name = name;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.randomVal = randomVal;
  
  }
  //getName that returns name attribute
  public String getName(){
    return this.name;
  }
  //getDamage that return damage for spell casting
  public double getDamage(){
    double num = Math.random();
    if(num>this.randomVal){
      return 0;
    }else{
      Random val = new Random();
      double damage = (minDamage + (val.nextDouble() * (maxDamage-minDamage)));
      return damage;
    }
    
  }
  //toString method
  public String toString(){
    String s = ("'" + this.name +"'" + " has a min damage of " + this.minDamage + " and a max damage of " 
                  + this.maxDamage + ". Success chance is " + this.randomVal*100 + "%");
    return s;
  }
  
}