/**
 * New Version
 */
public class JavaPlayfair {
  private String keyword;
  private char[][] cipherSquare = new char[5][5];

  String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // omit J

  /**
   * Removes all duplicates in the string [str] and makes all characters
   * capitalized.
   * 
   * @param str
   * @return a string without any duplicates with the order preserved.
   */
  private String removeDuplicates(String str) {
    LinkedHashSet<Character> set = new LinkedHashSet<>();
    str = str.replaceAll("\\s", "");
    for (int i = 0; i < str.length(); i++) {
      set.add(str.charAt(i));
    }
    return set.toString().toUpperCase();
  }

  /**
   * Makes a keyword usable by removing all it's duplicates, removing all spaces,
   * replacing all instances of I with J.
   */
  private String adjustKeyword(String k) {
    String s = removeDuplicates(k);
    keyword = s.replace('J', 'I');
    return keyword;
  }

}
