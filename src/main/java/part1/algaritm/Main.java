package part1.algaritm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 01.11.2017.
 */

//* Change by places first and last letters in each second string of list or array

public class Main {

    public static void main(String[] args) {
        List<String> stringList = createList();
        System.out.println(stringList);

        stringList = modifyList(stringList);
        System.out.println(stringList);


    }

    public static List<String> createList() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("This is the first string!");
        stringList.add("Is this string second?");
        stringList.add("Just third");
        stringList.add("There is no doubt that it is forth4 string, isn't it?");
        stringList.add("Fifth");
        stringList.add("String number: six");

        return stringList;
    }

    public static List<String> modifyList(List<String> stringList) {
        for (int i = 1; i < stringList.size(); i+=2) {
            String[] wordsInLine = stringList.get(i).split(" ");
            String modifiedLine = "";
            for (String word: wordsInLine) {
                char[] letters = word.toCharArray();
                if (letters.length>1) {
                    if (isLastCharLetter(letters[letters.length - 1])) {
                        char temp = letters[0];
                        letters[0] = letters[letters.length - 1];
                        letters[letters.length - 1] = temp;
                    } else {
                        char temp = letters[0];
                        letters[0] = letters[letters.length - 2];
                        letters[letters.length - 2] = temp;
                    }
                }
                modifiedLine += String.valueOf(letters)+" ";
            }
            stringList.remove(i);
            stringList.add(i, modifiedLine);
        }
        return stringList;
    }

    private static boolean isLastCharLetter(char lastChar) {
        return String.valueOf(lastChar).matches("[^;!,.:?\\d]" );
    }
}
