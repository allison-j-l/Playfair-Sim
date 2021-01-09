import java.util.*;

/**
 * @author Allison Liu
 * @version 1/7/2021
 */
public class Playfair {
  private String keyword;
  private char[][] cipherSquare = new char[5][5];

  String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // omit J

  /**
   * Constructor for an object that represents playfair cipher. Takes in a keyword
   * and constructs the ciphersquare that corresponds to it.
   * 
   * @param k The keyword the user wants the cipher to have.
   */
  public Playfair(String k) {
    keyword = adjustKeyword(k);
    cipherSquare = genTable(keyword);
  }

  /**
   * Removes all duplicates in the string [str] and makes all characters
   * capitalized.
   * 
   * @param str
   * @return a string without any duplicates with the order preserved.
   */
  private String removeDuplicates(String str) {
    LinkedHashSet<Character> set = new LinkedHashSet<>();
    str = str.replaceAll("\\s", "").toUpperCase();
    for (int i = 0; i < str.length(); i++) {
      set.add(str.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : set) {
      sb.append(c);
    }
    return sb.toString();
  }

  /**
   * Makes a keyword usable by removing all it's duplicates, removing all spaces,
   * replacing all instances of I with J.
   */
  private String adjustKeyword(String k) {
    String s = removeDuplicates(k.replaceAll("\\s", ""));
    keyword = s.replace('J', 'I');
    return keyword;
  }

  /**
   * Generates a table for for the cipher with [key] as the keyword.
   */
  private char[][] genTable(String key) {
    String t = removeDuplicates(adjustKeyword(key) + alphabet);
    int curInd = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        cipherSquare[i][j] = t.charAt(curInd);
        curInd++;
      }
    }
    return cipherSquare;
  }

  /**
   * Searches for [c] inside [table] and returns an array with it's x and y
   * positions
   * 
   * @param c     The character that is being searched for. Requires: [c] is
   *              uppercase
   * @param table A valid keytable.
   * @return Array of length 2 that has the position of [c] in [table].
   */
  private int[] searchTable(char c) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (c == cipherSquare[i][j])
          return new int[] { i, j };
      }
    }
    throw new IllegalArgumentException("This character is not in the table");
  }

  /**
   * Adjusts input so that it can be properly encrypted by playfair cipher.
   * Removes spaces, changes "J" to "I", adds "Z" if the number of characters is
   * odd.
   */
  private String adjustInput(String phrase) {
    phrase = phrase.toUpperCase().replaceAll("\\s", "").replace("J", "I");
    return phrase.length() % 2 == 0 ? phrase : phrase + "Z";
  }

  /**
   * Encrypts a pair of two characters with this cipher table.
   * 
   * @param chars The characters that are to be encrypted.
   * @return The encrypted characters.
   */
  public String encryptTwoChars(String chars) {
    chars = chars.toUpperCase();
    if (chars.charAt(0) == chars.charAt(1) || chars.length() == 1) // duplicates
      chars = chars.charAt(0) + "X";
    int[] c1Pos = searchTable(chars.charAt(0));
    int c1X = c1Pos[0], c1Y = c1Pos[1];
    int[] c2Pos = searchTable(chars.charAt(1));
    int c2X = c2Pos[0], c2Y = c2Pos[1];
    // in the same row --> change each to one letter to right
    char newC1, newC2;
    if (c1X == c2X) {
      newC1 = cipherSquare[c1X][(c1Y + 1) % 5];
      newC2 = cipherSquare[c2X][(c2Y + 1) % 5];
    }
    // in the same column --> change each to one letter below
    else if (c1Y == c2Y) {
      newC1 = cipherSquare[(c1X + 1) % 5][c1Y];
      newC2 = cipherSquare[(c2X + 1) % 5][c2Y];
    }
    // not in same row or column --> switch y-positions with eachother
    else {
      newC1 = cipherSquare[c1X][c2Y];
      newC2 = cipherSquare[c2X][c1Y];
    }
    return ("" + newC1 + newC2).toUpperCase();
  }

  /**
   * Decrypts two characters [chars] with the cipher configuration
   * 
   * @param chars
   * @return The decrypted version of the chars.
   */
  private String decryptTwoChars(String chars) {
    chars = chars.toUpperCase();
    int[] c1Pos = searchTable(chars.charAt(0));
    int c1X = c1Pos[0], c1Y = c1Pos[1];
    int[] c2Pos = searchTable(chars.charAt(1));
    int c2X = c2Pos[0], c2Y = c2Pos[1];
    char newC1, newC2;
    if (c1X == c2X) {
      newC1 = cipherSquare[c1X][(c1Y + 4) % 5];
      newC2 = cipherSquare[c2X][(c2Y + 4) % 5];
    } else if (c1Y == c2Y) {
      newC1 = cipherSquare[(c1X + 4) % 5][c1Y];
      newC2 = cipherSquare[(c2X + 4) % 5][c2Y];
    } else {
      newC1 = cipherSquare[c1X][c2Y];
      newC2 = cipherSquare[c2X][c1Y];
    }
    return ("" + newC1 + newC2).toUpperCase();
  }

  /**
   * Either decrypts or encrypts a phrase in this configuration
   * 
   * @param phrase      The phrase to either encrypt or decrypt
   * @param encryptThis Set to true to encrypt, false to decrypt
   * @return
   */
  String cipher(String phrase, boolean encryptThis) {
    phrase = adjustInput(phrase);
    // repeatedly call encrypt
    StringBuilder sb = new StringBuilder();
    String str = "";
    for (int i = 0; i < phrase.length() - 1; i += 2) {
      if (encryptThis)
        str = encryptTwoChars(phrase.substring(i, i + 2));
      else
        str = decryptTwoChars(phrase.substring(i, i + 2));
      sb.append(str);

    }
    return sb.toString();
  }

}
