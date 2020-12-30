import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jdk.jfr.Timestamp;
import Playfair.java;

class PlayfairTest extends Playfair {

  Playfair pf = new Playfair("monarchy");

  @Test
  void testRemoveDuplicates() {
    assertEquals("ALISON", removeDuplicates("allison"));
    assertEquals("A", removeDuplicates("AAAAAAAAaa"));
  }

  @Test
  void testEncryptTwoChars() {
    assertEquals("GA", pf.encryptTwoChars("in"));
    assertEquals("TL", pf.encryptTwoChars("st")); // TL
  }

}

// reminder: figure out how to use this test file