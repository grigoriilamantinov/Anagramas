import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Введите сочетание букв и цифр, иногда разделяя их пробелами: ");
        Anagrams a = new Anagrams();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = a.reverseSentence(str);
        System.out.println("Ответик-с: " + result);
    }

}