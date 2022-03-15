
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Anagrams {

    /**
     * Class for working with some words
     *
     * @param word A set of characters
     * @return A set of characters written in reverse order that does not affect the digits.
     */

    public String reverseWord(String word) {

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

    /**
     * A class that changes characters in words. The letters are written in reverse order, the numbers remain in their places.
     *
     * @param word A set of characters or words
     * @return A set of characters written in reverse order that does not affect the digits.
     */

    public String reverseWordsInSentence(String word) {
        String[] stringArray = word.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (String element : stringArray) {
            String reWorkWord = reverseWord(element);
            joiner.add(reWorkWord);
        }

        return joiner.toString();
    }
    /**
     * This method will return strings in which the letters will be reversed, but the numbers and signs will remain in their places.
     *
     * @param filePath The path to the file where you want to reverse the words
     * @return textAfterReverse
     */

    public List<String> fileWordsReverse(String filePath) throws IOException {

        List<String> text = Files.lines(Path.of(filePath)).collect(Collectors.toList());

        System.out.println();
        for (String originStringInFile : text ) {
            System.out.println(originStringInFile);
        }
        System.out.println();

        Anagrams a = new Anagrams();
        List<String> textAfterReverse = new ArrayList<>();

        for (String str : text ) {
            textAfterReverse.add(reverseWordsInSentence(str));
        }

        return textAfterReverse;
    }
}

