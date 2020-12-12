package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("src/Day3/Day3PuzzleInput.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        int[] posXChange = new int[]{1,3,5,7,1};
        int[] posYChange = new int[]{1,1,1,1,2};
        int[] results = new int[5];
        int countTrees,  posX;
        long result = 1;
        String input;
        ArrayList<String> inputArrayList = new ArrayList<>();

        // insert input file into ArrayList
        while ((input = bufferedReader.readLine()) != null){
            inputArrayList.add(input);
        }

        // count all trees
        for (int currentIndex = 0; currentIndex <= 4; currentIndex++) {
            countTrees = 0;
            posX=0;
            for (int i = 0; i < inputArrayList.size(); i++) {
                if (inputArrayList.get(i).charAt(posX) == '#') {
                    countTrees += 1;
                }

                posX += posXChange[currentIndex];
                if (posX >= inputArrayList.get(i).length()) {
                    posX -= inputArrayList.get(i).length();
                }
                if (posYChange[currentIndex] > 1) {
                    for (int j = 0; j < posYChange[j]; j++) {
                        i += 1;
                    }
                }
                results[currentIndex] = countTrees;
            }
        }
        // return result
        for (int j : results) {
            result *= j;
        }
        System.out.println(result);
    }
}
