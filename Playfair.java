import java.util.*;

/**
 * @author Allison Liu
 * @version 2.0
 */
public class Playfair {
  private String keyword;
  private char[][] cipherSquare = new char[5][5];

  String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // omit J

  /**
   * Constructor for an object that represents playfair cipher.
   * 
   * @param k
   */
  public Playfair(String k) {
    keyword = adjustKeyword(k);
    cipherSquare = genTable(keyword);
  }

  public Playfair() {
    keyword = "";
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
   * @param c     The character that is being searched for. Requires: c is
   *              uppercase
   * @param table The keytable
   * @return Array of length 2 that has the position of c in table.
   */
  private int[] searchTable(char c, char[][] table) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (c == table[i][j])
          return new int[] { i, j };
      }
    }
    throw new IllegalArgumentException("This character is not in the table");
  }

  /**
   * Adjusts input so that it can be properly encrypted by playfair cipher.
   * Removes spaces, changes "J" to "I", adds "X" if the number of characters is
   * odd.
   */
  private String adjustInput(String phrase) {
    phrase = phrase.toUpperCase().replaceAll("\\s", "").replace("J", "I");
    return phrase.length() % 2 == 0 ? phrase : phrase + "X";
  }

  /**
   * 
   * @param chars
   * @param pf
   * @return
   */
  private String encryptTwoChars(String chars, Playfair pf) {
    if (chars.charAt(0) == chars.charAt(1) || chars.length() == 1) // duplicates
      chars = chars.charAt(0) + "X";
    char[][] table = pf.cipherSquare;
    int[] c1Pos = searchTable(chars.charAt(0), table);
    int c1X = c1_pos[0], c1Y = c1_pos[1];
    int[] c2Pos = searchTable(chars.chatAt(1), table); // mod positions by 5
    int c2X = c2Pos[0], c2Y = c2Pos[1];
    // in the same row --> change each to one letter to right
    if (c1X == c2X) {
      char newC1 = table[c1X][(c1Y + 1) % 5];
      char newC2 = table[c2X][(c2Y + 1) % 5];
      return (newC1 + newC2 + "").toUpperCase();
    }
    // in the same column --> change each to one letter below
    if (c1_y == c2_y) {
      char newC1 = table[(c1X + 1) % 5][c1Y];
      char newC2 = table[(c2X + 1) % 5][c2Y];
      return (newC1 + newC2 + "").toUpperCase();
    }
    // not in same row or column --> reflected (most complicated case)

    return "";
  }

  /**
   * 
   */
  private String encrypt(String phrase, Playfair pf) {
    return "";
  }

  /**
   * Decrypts two characters [chars] with the cipher configuration [pf].
   * 
   * @param chars
   * @param pf
   */
  private String decryptTwoChars(String chars, Playfair pf) {
    return "";
  }

  /**
   * Decrypts message [phrase] according to the keyword [key].
   */
  private String decrypt(String phrase, Playfair pf) {
    return "";
  }

  public static void main(String[] args) {
    Playfair pf = new Playfair("bruh");
    System.out.println(pf.removeDuplicates("allison"));
    System.out.println(pf.adjustKeyword("JACK and Jill"));
    System.out.println(Arrays.deepToString(pf.cipherSquare));
  }

}
