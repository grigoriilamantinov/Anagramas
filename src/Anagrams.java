
import java.util.StringJoiner;

public class Anagrams {

    /**Class for working with some words
     * @param word A set of characters
     * @return A set of characters written in reverse order that does not affect the digits.
     */

    public String reWorkWord(String word)
    {

        char[] arrayMain = word.toCharArray();
        char[] arrayMainCopy = new char[word.length()];

        int countJ = word.length() - 1;
        char buffer;
        int digitCount = 0;
        boolean isLetter;
        int countQ = 0;

        for (int i = 0; i < word.length(); i++) {
            isLetter = Character.isAlphabetic(arrayMain[i]);
            if (!isLetter) {
                digitCount++;
            }
        }

        System.arraycopy(arrayMain, 0, arrayMainCopy, 0, word.length());

        char[] arrayDigitBuf = new char[digitCount];

        for (int i = 0; i < word.length(); i++) {
            isLetter = Character.isAlphabetic(arrayMain[i]);
            if (!isLetter) {
                arrayDigitBuf[countQ] = arrayMain[i];
                countQ++;
            }
        }

        for (int i = 0; i < (word.length() / 2); i++) {
            buffer = arrayMain[i];
            arrayMain[i] = arrayMain[countJ];
            arrayMain[countJ] = buffer;
            countJ--;
        }

        char[] arrayLetterBuf = new char[word.length() - digitCount];
        countJ = 0;
        for (int i = 0; i < word.length(); i++) {
            isLetter = Character.isAlphabetic(arrayMain[i]);
            if (isLetter) {
                arrayLetterBuf[countJ] = arrayMain[i];
                countJ++;

            }
        }

        countJ = 0;
        countQ = 0;
        for (int i = 0; i < word.length(); i++) {
            isLetter = Character.isAlphabetic(arrayMainCopy[i]);
            if (isLetter) {
                arrayMain[i] = arrayLetterBuf[countJ];
                countJ++;
            } else {
                arrayMain[i] = arrayDigitBuf[countQ];
                countQ++;
            }
        }
        return String.copyValueOf(arrayMain);
    }


public String reWorkSentence(String word) {
        String[] stringArray = word.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (String element : stringArray ) {
            String reWorkWord = reWorkWord(element);
            joiner.add(reWorkWord);
        }

        return joiner.toString();
    }
}
