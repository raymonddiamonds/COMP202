import java.util.*;
import java.io.*;
import java.lang.String;

//Raymond Diamonds
//260656751

public class FileIO{

  
  //method takes input filename as String and returns char
  public static Character readCharacter(String fileName){
    try{
      FileReader fr = new FileReader(fileName); 
      BufferedReader br = new BufferedReader(fr);
      //where the file gets read
      String name = br.readLine();
      Double attackVal = Double.parseDouble(br.readLine());
      Double maxHealthVal = Double.parseDouble(br.readLine());
      int numWins = Integer.parseInt(br.readLine());
      
      Character ch = new Character(name, attackVal, maxHealthVal, numWins);

      br.close();
      fr.close();
      return ch;
      
    }catch(FileNotFoundException e){
      throw new IllegalArgumentException("File was not found");
    }catch(IOException e){
      throw new IllegalArgumentException("There is an IO Exception");
    }
  }
  
  // new static method readSpells that reads the file
  public static ArrayList<Spell> readSpells(String fileName){
    
    ArrayList<Spell> spells = new ArrayList<Spell>();
    try{
      //where the file gets read
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      String[] input = new String[4];
      //while loop
      while (line != null) {
        input = line.split(" ");
        String a = input[0];
        //parsing input
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        double d = Double.parseDouble(input[3]);
        spells.add(new Spell(a, b, c, d));
        line = br.readLine();
      }
      br.close();
      fr.close();
      return spells;
      
    
    }catch(FileNotFoundException e){
      throw new IllegalArgumentException("File was not found");
    }catch(IOException e){
      throw new IllegalArgumentException("There is an IO Exception");
    }
  }
  
  //method called writeCaracter: inputs Character, and String
  public static void writeCharacter(Character ch, String fileName){
    try{
      FileWriter fw = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(fw);
      String message = (ch.getName() + "\n" + ch.getAttackVal() + "\n" + ch.getCurrentHealthVal() + "\n" + ch.getNumWins());
      bw.write(message);
      bw.close();
      fw.close();

    }catch(IOException e){
      throw new IllegalArgumentException("There is an IO Exception");
    }
    
  }
  
  
  
}