package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {
    private static ArrayList<String[]> inputArrayList = new ArrayList<>();
    private static ArrayList<String[]> bagsRules = new ArrayList<>();
    private static int bagsAmount;

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();
        String myBagName = "shiny gold ";
        bagsAmount = 0;
        addBagsRules(myBagName);
        System.out.println(bagsAmount);

        for (int i = 0; i < bagsRules.size(); i++) {
            for (int j = 1; j < bagsRules.get(i).length; j++) {
                System.out.println(bagsRules.get(i)[j]);
            }
        }
    }

    private static void addBagsRules(String bagName){
        String[] bagRule;
        for (int i = 0; i < inputArrayList.size(); i++) {
            if (inputArrayList.get(i)[0].equals(bagName)){
                bagRule = inputArrayList.get(i);
                for (int j = 1; j < bagRule.length; j++) {
                    if (bagRule[j] != null){
                        if (!bagRule[j].contains("other") && !bagRule[j].equals("")){
                            bagsAmount += Integer.parseInt(String.valueOf(bagRule[j].charAt(0)));
                            for (int k = 0; k < Integer.parseInt(String.valueOf(bagRule[j].charAt(0))); k++) {
                                addBagsRules(bagRule[j].substring(2));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void takeCareOfFiles() throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Day7PuzzleInput.txt")));

        // initialize variables
        String[] inputArray;
        String input;

        // load line by line
        while((input = bufferedReader.readLine()) != null){
            inputArray = input.split("bags contain |, |bags|bag|\\.");
            inputArrayList.add(inputArray);
        }
    }

}