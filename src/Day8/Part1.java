package Day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
    private static ArrayList<String[]> inputArrayList = new ArrayList<>();
    private static boolean[] visitedLine;

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();

        int accumulator = 0;

        for (int i = 0; i < inputArrayList.size(); i+=0) {
            if (visitedLine[i]){
                System.out.println(accumulator);
                break;
            }
            switch (inputArrayList.get(i)[0]){
                case "acc":
                    accumulator += Integer.parseInt(inputArrayList.get(i)[1]);
                    visitedLine[i] = true;
                    i += 1;
                    break;

                case "jmp":
                    visitedLine[i] = true;
                    i += Integer.parseInt(inputArrayList.get(i)[1]);
                    break;

                case "nop":
                    visitedLine[i] = true;
                    i += 1;
            }
        }
    }

    private static void initializeVisitedArray(){
        visitedLine = new boolean[inputArrayList.size()];
        Arrays.fill(visitedLine, false);
    }

    private static void takeCareOfFiles() throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/Day8/Day8PuzzleInput.txt")));

        // initialize variables
        String input;

        //load and add to arraylist line by line
        while((input = bufferedReader.readLine()) != null){
            inputArrayList.add(input.split(" "));
        }

        initializeVisitedArray();

    }
}
