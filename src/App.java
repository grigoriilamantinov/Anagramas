import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Anagrams str = new Anagrams();
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String result = str.reWorkWord(a);

        System.out.println(result);
    }

}