//Name: Raymond Diamonds
//Student#: 260656751

public class Cipher {
  
  //encoding character by shifting characters to the right by n
  public static char charRightShift(char c, int n){
    //make sure input value is within 0 and 25; if not print ERROR
    if (n<0 || n>25){
      System.out.println("Error: Input must be within 0 and 25");
      return 0;
    }
    //find out if n is within lower case letter ASCII values; if not return original char; if so shift accordingly
    if (c >= 97 && c <= 122) {
       //if c becomes greater than 122 then add n and subtract 26 to keep it within alphabet values
      if((c+n) > 122){
        char newLetter = (char)(c + n - 26);
        return newLetter;
      }
      else if((c+n) <= 122){
        return c+=n;
      }
    } 
    //if none are true return the original char
    return c;
     
  }
  
  public static char charLeftShift (char c, int n){
    //make sure input value is within 0 and 25; if not print ERROR
    if (n<0 || n>25){
      System.out.println("Error: Input must be within 0 and 25");
      return 0;
    }
    //find out if n is within lower case letter ASCII values
    if (c >= 97 && c <= 122) {
      //if c becomes less than 97 then subtract n and add 26 to keep it within alphabet values
      if((c-n) < 97){
        char newLetter = (char)(c - n + 26);
        return newLetter;
      }
      else if((c-n) >= 97){
        return c-=n;
      }
    } 
    //if none are true return the original char
    return c;
  }
  //method using Caesar's cipher
  public static String caesarEncode(String message, int key){
    //key must be within 0 and 25 or else print error and return nul
    if(key>25 || key<0){
      System.out.println("Error: Key must be an integer from 0 to 25");
      return"";
    }
    //empty string so that you can concatenate more chars on it
    String result = "";
    //for loop to shift each character right (calling charRightShift method) @ index=i by the value key 
    for(int i = 0; i<message.length();i++){
      char c = charRightShift(message.charAt(i), key);
      result = result + c;     
    }
    return result;
  }
  //method reversing Caesar's cipher
  public static String caesarDecode(String message, int key){
    //key must be within 0 and 25 or else print error and return nul
    if(key>25 || key<0){
      System.out.println("Error: Key must be an integer from 0 to 25");
      return"";
    }
    //empty string so that you can concatenate more chars on it
    String result = "";
    //for loop to shift each character left (calling charLeftShift method) @ index=i by the value key 
    for(int i = 0; i<message.length();i++){
      char c = charLeftShift(message.charAt(i), key);
      result = result + c;     
    }
    return result;
  }
  //method to return an array of keys from each character of the String
  public static int[] obtainKeys(String input){
    int[] numbers = new int[input.length()];
      
      for(int i=0; i<input.length(); i++){
        numbers[i] = input.charAt(i)-'a';
    }
    return numbers;
  }
  //method that encodes each letter of message by a shift of value of each letter corresponding to keyword
  public static String vigenereEncode(String message, String keyword){
    
    //calls obtainKeys method to get array of #s corresponding to each letter
    int[] key = obtainKeys(keyword);
    String code = "";
    for (int x=0; x<message.length();x++){
      //use modulo operator so that if # of keyword letter < # of letter of message, it can repeat itself
      int index = x % keyword.length();
      char y = keyword.charAt(index);
      if(!((y >= 'a' && y <= 'z') || (y == ' '))){
        System.out.println("Error: Keyword must only contain characters from the lower case English alphabet");
        return "";
      }
      //encoding message using array of number corresponding to keyword 
      char c = (charRightShift(message.charAt(x), key[index]));
      code += c;
    }
    return code;
  }
  //method that decodes each letter of message by a shift of value of each letter corresponding to keyword  
  public static String vigenereDecode(String message, String keyword){
    //calls obtainKeys method to get array of #s corresponding to each letter
    int[] key = obtainKeys(keyword);
    String code = "";
    for (int x=0; x<message.length();x++){
      //use modulo operator so that if # of keyword letter < # of letter of message, it can repeat itself
      int index = x % keyword.length();
      char y = keyword.charAt(index);
      if(!((y >= 'a' && y <= 'z') || (y == ' '))){
        System.out.println("Error: Keyword must only contain characters from the lower case English alphabet");
        return "";
      }
      //decoding message using array of number corresponding to keyword
      char c = (charLeftShift(message.charAt(x), key[index]));
      code += c;
    }
    return code;
  }
}


