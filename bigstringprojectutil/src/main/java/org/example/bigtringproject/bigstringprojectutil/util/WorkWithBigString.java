package org.example.bigtringproject.bigstringprojectutil.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkWithBigString {

    public static String countCharsAndSortChars(String bigString) {
        char[] charArray = bigString.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list) {
            for(int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }

        return stringBuilder.toString();
    }


    public static String countWordsAndSortWords(String bigString) {
        String [] wordsArray = bigString.split("[-,;:.!?\\s]+");
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            String s = wordsArray[i];
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, Integer> entry : list) {
            for(int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey().concat(" "));
            }
        }

        return stringBuilder.toString();

    }


    public static String reverseWords(String bigString) {

        String[] sentencesArray = bigString.split("[.!?]");

        StringBuilder stringBuilder = new StringBuilder();

        for (String value : sentencesArray) {
            String[] wordsArray = value.split(" ");

            for (int j = 0; j < wordsArray.length / 2; j++) {
                String s = wordsArray[j];
                wordsArray[j] = wordsArray[wordsArray.length - 1 - j];
                wordsArray[wordsArray.length - 1 - j] = s;
            }

            for (int k = 0; k < wordsArray.length - 1; k++) {

                stringBuilder.append(wordsArray[k]).append(" ");
            }
            stringBuilder.append(wordsArray[wordsArray.length - 1] + ". ");
        }

        return stringBuilder.toString();
    }
}
