import java.util.HashMap;

public class CaesarCipher {
    private static final int UPPER_CASE_MAX_ASCII = 90;
    private static final int UPPER_CASE_MIN_ASCII = 65;
    private static final int LOWER_CASE_MAX_ASCII = 122;
    private static final int LOWER_CASE_MIN_ASCII = 97;

    public String encrypt(String payload, int key) {
        String encrypted = "";

        for (int index = 0; index < payload.length(); index++) {
            char currentCharacter = payload.charAt(index);
            int rotatedAsciiValue = getRotatedAsciiValue(currentCharacter, key);

            encrypted += (char) rotatedAsciiValue;
        }

        return encrypted;
    }


    public String decrypt(String payload, int key) {
        String decrypted = "";

        for (int index = 0; index < payload.length(); index++) {
            int asciiValue = (int) payload.charAt(index) - key;
            char character = (char) asciiValue;

            decrypted += character;
        }

        return decrypted;
    }

    private int getRotatedAsciiValue(char currentCharacter, int key) {
        int newAsciiValue = (int) currentCharacter + key;

        if (Character.isUpperCase(currentCharacter) && newAsciiValue > 90) {
            newAsciiValue = newAsciiValue - UPPER_CASE_MAX_ASCII + UPPER_CASE_MIN_ASCII - 1;
        } else if (Character.isLowerCase(currentCharacter) && newAsciiValue > 122) {
            newAsciiValue = newAsciiValue - LOWER_CASE_MAX_ASCII + LOWER_CASE_MIN_ASCII - 1;
        }
        return newAsciiValue;
    }
}
