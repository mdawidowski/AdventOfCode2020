package Day6;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        FileReader fileReader = new FileReader(new File("src/Day6/Day6PuzzleInput.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        String input, answers="";
        ArrayList<String> answersArrayList = new ArrayList<>();
        int sumOfAnswers = 0;

        // get answers group by group and add them to ArrayList
        while ((input = bufferedReader.readLine()) != null){
            while (!(input == null) && !input.isBlank()){
                answers += input;
                input = bufferedReader.readLine();
            }
            answersArrayList.add(answers);
            answers = "";
        }

        for (int i = 0; i < answersArrayList.size(); i++) {
            //eliminate duplicates from answers
            char[] chars = answersArrayList.get(i).toCharArray();
            Set<Character> charSet = new LinkedHashSet<>();
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
