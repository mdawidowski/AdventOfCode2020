package Day7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/Day7/Day7PuzzleInput.txt")));

        // initialize variables
        String input, bagColor;
        ArrayList<String> rulesArrayList = new ArrayList<>();
        ArrayList<String> bagsColors = new ArrayList<>();
        int amountOfBagColors = 0, answerOne = 0, answerTwo = 1;

        // load line by line to arraylist
        while ((input = bufferedReader.readLine()) != null){
            rulesArrayList.add(input);
        }

        // add shiny gold
        bagsColors.add("shiny gold");

        // get bags that can contain shiny gold bag
        while (answerOne != answerTwo) {
            answerOne = answerTwo;
            for (int j = 0; j < rulesArrayList.size(); j++) {
                for (int i = 0; i < bagsColors.size(); i++) {
                    if (rulesArrayList.get(j).contains(bagsColors.get(i))) {
                        if (!rulesArrayList.get(j).substring(0, rulesArrayList.get(j).indexOf("bags")).contains(bagsColors.get(i))) {
                            bagsColors.add(rulesArrayList.get(j).substring(0, rulesArrayList.get(j).indexOf("bags")));
                        }
                    }
                }
            }

            // remove duplicates
            Set<String> set = new HashSet<>(bagsColors);
            bagsColors.clear();
            bagsColors.addAll(set);
            answerTwo = bagsColors.size();
        }

        // return result minus shiny gold bag
        System.out.println(bagsColors.size()-1);
    }
}
