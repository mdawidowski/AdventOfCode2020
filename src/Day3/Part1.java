package Day3;

import java.io.*;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("Day3PuzzleInput.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        int countTrees = 0,  posX = 0;
        String input;

        // count all trees
        while ((input = bufferedReader.readLine()) != null){
            if (input.charAt(posX) == '#'){
                countTrees +=1;
            }
            posX += 3;
            if (posX >= input.length()){
                posX -= input.length();
            }
        }

        // return result
        System.out.println(countTrees);
    }
}
