package Day9;

import java.io.*;
import java.util.ArrayList;

public class Part1 {
    private static ArrayList<Long> numbersArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();
        for (int i = 25; i < numbersArrayList.size(); i++) {
            if (!checkIfTwoOfPrevious25ElementsSumsToNumber(i)){
                System.out.println(numbersArrayList.get(i));
            }
        }
    }

    private static boolean checkIfTwoOfPrevious25ElementsSumsToNumber(int index){
        boolean status = false;
        for (int i = index-25; i < index; i++) {
            for (int j = index-25; j < index; j++) {
                if (numbersArrayList.get(index) == numbersArrayList.get(i) + numbersArrayList.get(j) ){
                    status = true;
                    break;
                }
            }
        }

        return status;
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

