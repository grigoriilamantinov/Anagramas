import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    Anagrams a = new Anagrams();

    @Test
    void shouldReverseLettersInWordsFromSentence() throws IOException {

        String filePath = "G:\\JAVA\\projects\\Anagrams\\src\\resources\\TextForTest";
        String expectedResult = "адгоТ ен л3ан2з\n" + "я хынреЧ лед ииссоР.";
        String actualResult = a.fileWordsReverse(filePath);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldThrowThrowExceptionWhenInvalidPath() {
        String filePath = "что?";
        assertThrows(InvalidPathException.class, () -> a.fileWordsReverse(filePath));
    }
}