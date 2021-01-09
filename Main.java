/**
 * Class that controls how the user will interact with this program.
 * 
 * @author Allison Liu
 * @version 1/8/2021
 */

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a keyword ");
    System.out.println("> ");
    String keyword = sc.next();
    Playfair pf = new Playfair(keyword);
    System.out.println("Enter a message you would like to encrypt: ");
    String message = sc.next();
    System.out.println("Encryption: " + pf.cipher(message, true));
    sc.close();
  }
}