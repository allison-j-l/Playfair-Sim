
import org.junit.jupiter.api.Test;
import jdk.jfr.Timestamp;

class PlayfairTest {

  Playfair pf = new Playfair("monarchy");

  @Test
  void testEncryptTwoChars() {
    assertEquals("", pf.encryptTwoChars(""));
    assertEquals("GA", pf.encryptTwoChars("in"));
    assertEquals("TL", pf.encryptTwoChars("st")); // TL
  }

  boolean encrypt = true;
  boolean decrypt = !encrypt;

  @Test
  void testCipher() {
    assertEquals("", pf.cipher("", true));
    assertEquals("GATLMZCLRQTZX", pf.cipher("instruments", encrypt));
    assertEquals("INSTRUMENTS", pf.cipher("GATLMZCLRQTZX", decrypt));
  }

}

// reminder: figure out how to use this test file