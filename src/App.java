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
        int stopMark;

        do {
            try {
                result = a.fileWordsReverse(filePath);
                stopMark = 0;
            } catch (IOException e) {
                System.out.println("Вы ввели неверный путь к файлу.");
                System.out.println("Введите ещё раз:");
                stopMark=1;
                filePath = sc.nextLine();
            }
        } while (stopMark == 1) ;

        for (String stringInResult : result ) {
            System.out.println(stringInResult);
        }

        System.out.println();
        System.out.println("В следующий раз попрубуйте файл TRAP: G:\\JAVA\\projects\\Anagrams\\src\\TRAP");

    }
}