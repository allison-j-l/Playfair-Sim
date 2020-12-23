/**
 * The Playfair class simulates using playfair cipher. 
 * @author Allison Liu
 * @version 1.0
 */

import java.util.*;

public class Playfair {
  private String key; //keyword
  private char[][] keySquare = new char[5][5];

  String alphabet = "abcdefghiklmnopqrstuvwxyz";

  /**
   * Generates the (5x5) keysquare with the specified keyword
   * @param key The encryption keyword
   */
  private void genTable(String key) {
    return;
  }

  /**
   * Makes two characters viable to be used in playfair
   * @return Adjusted inputs
   * @throws IllegalArgumentException if length of str is greater than 2
   */
  private String adjustInput(String str) {
    // duplicates
    str = str.trim().toLowerCase();
    if (str.length()>2) 
      throw new IllegalArgumentException("Length has to be less than 2");
    if (str.length()==1) return str+="x";
    return str;
  }
  /**
   * 
   */
  private String encryptTwo(String str, char[][] table) {
    String input = adjustInput(str);
    return "";
  }

  private String cipher(String str, char[][] table) {
    return "";
  }

}