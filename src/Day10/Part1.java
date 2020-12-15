package Day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
    private static ArrayList<Integer> joltsArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();
        Collections.sort(joltsArrayList);

        // initialize variables
        int differenceOne = 1, differenceThree = 1, diff;

        for (int i = 1; i < joltsArrayList.size(); i++) {
            diff = joltsArrayList.get(i) - joltsArrayList.get(i-1);
            if (diff == 1) {
                differenceOne++;
            } else if (diff == 3){
                differenceThree++;
            }
        }

        System.out.println(differenceOne * differenceThree);

    }

    private static void takeCareOfFiles() throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/Day10/Day10PuzzleInput.txt")));

        // initialize variable
        String input;

        // load, parse and add to arraylist line by line
        while ((input = bufferedReader.readLine()) != null){
            joltsArrayList.add(Integer.parseInt(input));
        }
    }
}
