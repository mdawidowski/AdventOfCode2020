package Day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {
    private static ArrayList<Long> numbersArrayList = new ArrayList<>();
    private static int endingIndex;

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();
        // initialize variables
        long number = 14360655;

        for (int i = 0; i < numbersArrayList.size(); i++) {
            if (checkIfSumsUpToNumber(number, i)){
                System.out.println(getMinNumber(i, endingIndex) + getMaxNumber(i, endingIndex));

            }
        }
    }

    private static long getMaxNumber(int startingIndex, int endingIndex){
        long maxValue = 0;
        for (int i = startingIndex; i < endingIndex; i++) {
            if (numbersArrayList.get(i) > maxValue){
                maxValue = numbersArrayList.get(i);
            }
        }
        return maxValue;
    }

    private static long getMinNumber(int startingIndex, int endingIndex){
        long minValue = numbersArrayList.get(startingIndex);
        for (int i = startingIndex; i < endingIndex; i++) {
            if (numbersArrayList.get(i) < minValue){
                minValue = numbersArrayList.get(i);
            }
        }
        return minValue;
    }

    private static boolean checkIfSumsUpToNumber(long number, int startingIndex){
        long sum = 0;
        endingIndex = startingIndex;

        while (sum < number){
            sum += numbersArrayList.get(endingIndex);
            endingIndex++;
        }

        return sum == number && startingIndex != endingIndex - 1;
    }

    private static void takeCareOfFiles() throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/Day9/Day9PuzzleInput.txt")));

        // initialize variable
        String input;

        // load, parse and add to arraylist line by line
        while ((input = bufferedReader.readLine()) != null){
            numbersArrayList.add(Long.parseLong(input));
        }
    }
}
