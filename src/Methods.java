import java.util.Arrays;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {

    }

}

class Anagrams {

    public String reWorkWord(String word)
    {
        Scanner sc = new Scanner(System.in);

        int b = word.length();
        char[] array1 = new char[b];
        char[] array4 = new char[b];
        array1 = word.toCharArray();

        int i;
        int j = b - 1;
        char c;
        int z = 0;
        boolean isArray1;
        int q = 0;

        //УЗНАЮ КОЛИЧЕСТВО ЦИФР, ЧТОБЫ МОЖНО БЫЛО УКАЗАТЬ ДЛИНУ БУФЕРНОГО МАССИВА
        for (i = 0; i < (b); i++) {
            isArray1 = Character.isAlphabetic(array1[i]);
            if (!isArray1) {
                z++;
            }
        }

        // ЗАПИСЫВАЮ ОРИГИНАЛЬНЫЙ МАССИВ В БУФЕРНЫЙ
        for (i = 0; i < (b); i++) {
            array4[i] = array1[i];
        }


        //ЗАПИСЫВАЮ ЦИФРЫ В БУФЕРНЫЙ МАССИВ
        char[] array2 = new char[z];

        for (i = 0; i < (b); i++) {
            isArray1 = Character.isAlphabetic(array1[i]);
            if (!isArray1) {
                array2[q] = array1[i];
                q++;
            }
        }


        //УСТРАИВАЮ ПЕРЕВОРОТ МАССИВА
        for (i = 0; i < (b / 2); i++) {

            c = array1[i]; // сохраняем символ из левой части
            array1[i] = array1[j]; // переносим символ из правой части
            array1[j] = c; // переносим символ из левой части
            j--;
//            System.out.println("#" + (i+1) + " " + Arrays.toString(array1) + " " + isArray1 + " " + isArray2 + " " + z);
        }


        //ЗАПИСЫВАЮ БУКВЫ В БУФЕРНЫЙ МАССИВ
        char[] array3 = new char[b - z];
        j = 0;
        for (i = 0; i < (b); i++) {
            isArray1 = Character.isAlphabetic(array1[i]);
            if (isArray1) {
                array3[j] = array1[i];
                j++;

            }
        }

        //НАЧИНАЮ ДИАЛОГ


        System.out.print("Мда... Вы ввели: ");
        System.out.println(Arrays.toString(array4));
        System.out.print("А рыба взяла и перевернула все буквы, оставив цифры на месте: ");

        // ВНОШУ В ОРИГИНАЛЬНЫЙ МАССИВ ВЕРНЫЕ ДАННЫЕ
        j = 0;
        q = 0;
        for (i = 0; i < (b); i++) {
            isArray1 = Character.isAlphabetic(array4[i]);
            if (isArray1) {
                array1[i] = array3[j];
                j++;
            } else {
                array1[i] = array2[q];
                q++;
            }
        }
        System.out.println(Arrays.toString(array1));
        String result = String.copyValueOf(array1);
        return result;
    }

// ХРИСТА РАДИ, СДЕЛАЕМ ВИД, ЧТО КОММИТ БЫЛ ДО ЭТИХ СТРОК
//    void reWorkProp (String word) {
//        String[] stringArray = word.split(" ");
//        fore
//
//    }
}
