package Day6;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("Day6PuzzleInput.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        // initialize variables
        String input, answers, readyAnswers = "";
        ArrayList<String> answersArrayList = new ArrayList<>();
        ArrayList<String> ready = new ArrayList<>();
        int sumOfAnswers = 0;

        // load line by line
        while ((input = bufferedReader.readLine()) != null){
            answers = input;
            while ((input = bufferedReader.readLine()) != null && !(input.isBlank())){
                    for (int i = 0; i < answers.length(); i++) {
                        // if input contains char from first answer then char is added to readyAnswer
                        if (input.indexOf(answers.charAt(i)) > -1){
                            readyAnswers += answers.charAt(i);
                        }
                    }
                    // change answer value and clear readyAnswer for next comparisons
                    answers = readyAnswers;
                    readyAnswers = "";
            }
            // add good answer to array list
            answersArrayList.add(answers);
        }

        for (String s : answersArrayList) {
            //eliminate duplicates from answers
            char[] chars = s.toCharArray();
            Set<Character> charSet = new LinkedHashSet<Character>();
            for (char c : chars) {
                charSet.add(c);
            }

            // add amount of answers
            sumOfAnswers += charSet.size();

        }

        // return result
        System.out.println(sumOfAnswers);
    }
}
