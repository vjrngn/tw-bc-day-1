import org.junit.Test;

import javax.crypto.Cipher;

import static junit.framework.TestCase.assertEquals;

public class CaesarCipherTest {
    @Test
    public void shouldReturnBForInputAAndKey1() {
        CaesarCipher cipher = new CaesarCipher();

        String encrypted = cipher.encrypt("a", 1);

        assertEquals("b", encrypted);
    }

    @Test
    public void shouldReturnCForInputAAndKey2() {
        CaesarCipher cipher = new CaesarCipher();

        String encrypted = cipher.encrypt("a", 2);

        assertEquals("c", encrypted);
    }

    @Test
    public void shouldReturnEncryptedValueForLowerCaseString() {
        CaesarCipher cipher = new CaesarCipher();

        String encrypted = cipher.encrypt("abc", 1);

        assertEquals("bcd", encrypted);
    }

    @Test
    public void shouldReturnDBUForInputCATAndKey1() {
        CaesarCipher cipher = new CaesarCipher();

        String encrypted = cipher.encrypt("CAT", 1);

        assertEquals("DBU", encrypted);
    }

    @Test
    public void shouldReturnABCForInputXYZAndKey3() {
        CaesarCipher cipher = new CaesarCipher();

        String uppercaseEncryptionResult = cipher.encrypt("XYZ", 3);
        String lowercaseEncryptionResult = cipher.encrypt("xyz", 3);

        assertEquals("ABC", uppercaseEncryptionResult);
        assertEquals("abc", lowercaseEncryptionResult);
    }

    @Test
    public void shouldReturnAForInputBAndKey1() {
        CaesarCipher cipher = new CaesarCipher();

        String decrypted = cipher.decrypt("b", 1);

        assertEquals("a", decrypted);
    }

    @Test
    public void shouldReturnCATForInputDBUForKey1() {
        CaesarCipher cipher = new CaesarCipher();

        String decrypted = cipher.decrypt("DBU", 1);

        assertEquals("CAT", decrypted);
    }
}
