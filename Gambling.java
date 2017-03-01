//Name: Raymond Diamonds
//Student Number: 260656751

public class Gambling {
  
  //main method
  public static void main (String[] args){

    double moneyHas = Double.parseDouble(args[0]);
    double moneyBet = Double.parseDouble(args[1]);
    double moneyLeft = passLineBet(moneyHas, moneyBet);
    System.out.println("You now have: $" + moneyLeft);
    
  }
  
  //method to find sum of two 6-sided dies 
  public static int diceRoll(){
    int getRandomValue1 = (int) ((6*Math.random())+1);
    int getRandomValue2 = (int) ((6*Math.random())+1);
    int total = getRandomValue1 + getRandomValue2;
 
    return total;  
  }
  
  //method to simulate 2nd stage of bet 
  public static int secondStage (int result){
    int point = result;
    int secondDiceRoll = diceRoll();
    //if dice roll = to point or 7, print and return the number 
    if (secondDiceRoll == point){
      System.out.println(point);
    }
    else if (secondDiceRoll == 7){
      System.out.println(secondDiceRoll);
    }
    else{
      while (secondDiceRoll != point && secondDiceRoll !=7){
        System.out.print(secondDiceRoll + ", ");
        secondDiceRoll = diceRoll();
        if (secondDiceRoll == 7){
          System.out.println(secondDiceRoll);
        }
        if (secondDiceRoll == point){
          System.out.println(secondDiceRoll); 
        }
      }
    }
    return secondDiceRoll;
  }
  
  //method to determine whether player has sufficient funds to play
  public static boolean canPlay (double moneyValue, double betValue){
    
    return(moneyValue>=betValue);
  }
  
  public static double passLineBet (double moneyPlayerHas, double moneyPlayerBets){
  
    //check if player is allowed to play using canPlay method
    boolean result = canPlay(moneyPlayerHas, moneyPlayerBets);
    if (result != true){
      System.out.println("Insufficient funds. You cannot play.");
      return (moneyPlayerHas);
    }
    else {
      int numberRolled = diceRoll();
      //if number rolled is 7 or 11, you win; if number rolled is 2, 3, or 12, you lose; if anythine else, roll again
      if (numberRolled == 7 || numberRolled == 11){
        System.out.println("A " + numberRolled +  " has been rolled. You win!");
        return(moneyPlayerHas+(2*moneyPlayerBets));
      }
      else if (numberRolled == 2 || numberRolled == 3 || numberRolled == 12){
        System.out.println("A " + numberRolled +  " has been rolled. You lose!");
        return(moneyPlayerHas-moneyPlayerBets);
      }
      else {
        System.out.println("A " + numberRolled + " has been rolled. Roll again!");
        int point = secondStage(numberRolled);
        //if number rolled equals the point, then you win
        if(point == numberRolled){
          System.out.println("You win!");
          return(moneyPlayerHas+(2*moneyPlayerBets));
        }
        else {
          System.out.println("You lose");
        }
      }
    }
    return(moneyPlayerHas-moneyPlayerBets);
  }
  
} 