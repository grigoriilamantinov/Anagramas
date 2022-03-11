import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Введите сочетание букв и цифр, иногда разделяя их пробелами: ");
        Anagrams str = new Anagrams();
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String result = str.reWorkSentence(a);

        System.out.println("Ответик-с: " + result);
    }

}