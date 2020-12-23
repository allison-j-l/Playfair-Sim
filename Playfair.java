/**
 * The Playfair class simulates using playfair cipher. 
 * @author Allison Liu
 * @version 1.0
 */

import java.util.*;

public class Playfair {
  private String keyword; //keyword
  private char[][] keySquare = new char[5][5];

  String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

  /**
   * Generates the (5x5) key-square with the specified keyword
   * @param key The encryption keyword
   */
  private void genTable(String key) {
	  key = key.toUpperCase();
	  
	  return;
    
  }

  /**
   * Makes two characters viable to be used in playfair
   * @param str
   * @return
   */
  private String adjustInput(String str) {
    // duplicates
    str = str.replaceAll("\\s", "").toUpperCase();
    if (str.length()>2) 
      throw new IllegalArgumentException("Length has to be less than 2");
    if (str.length()==1) return str+="x";
    return str;
  }
  
  /**
   * 
   * @param str
   * @param table
   * @return
   */
  private String encryptTwo(String str, char[][] table) {
    String input = adjustInput(str);
    return "";
  }
  
  /**
   * 
   * @param str
   * @param table
   * @return
   */
  private String cipher(String str, char[][] table) {
    for (int i = 0; i < str.length(); i++) {
    	return "";
    }
    return "";
  }

  public static void main(String[] args) {
    return;
  }
}