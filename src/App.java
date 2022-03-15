import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        Anagrams a = new Anagrams();

        System.out.println("Здравстуйте! Введите пожалуйста путь до файла (Например: G:\\JAVA\\projects\\Anagrams\\src\\Poetry): ");
        String filePath = sc.nextLine();
        List<String> result = null;

        boolean isExit = false;
        while (!isExit) {
            try {
                result = a.fileWordsReverse(filePath);
            } catch (IOException e) {
                System.out.println("Вы ввели неверный путь к файлу.");
                System.out.println("Введите ещё раз:");
                isExit = true;
                filePath = sc.nextLine();
            }
        }

        for (String stringInResult : result ) {
            System.out.println(stringInResult);
        }

        System.out.println();
        System.out.println("В следующий раз попрубуйте файл TRAP: G:\\JAVA\\projects\\Anagrams\\src\\TRAP");

    }
}