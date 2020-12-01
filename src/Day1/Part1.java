package Day1;

import java.io.*;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("Day1PuzzleInput.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        String text;
        int result = 0;
        ArrayList<Integer> numbersArrayList = new ArrayList<>();

        // insert text into arrayList
        while ((text = bufferedReader.readLine())!=null) {
            if (bufferedReader != null) {
                numbersArrayList.add(Integer.parseInt(text));
            }
        }

        // get result by comparing numbers with each others
        for (int i = 0; i < numbersArrayList.size(); i++) {
            for (int j = 0; j < numbersArrayList.size(); j++) {
                if (numbersArrayList.get(i) + numbersArrayList.get(j) == 2020){
                    result = numbersArrayList.get(i) * numbersArrayList.get(j);
                }
            }
        }

        // return result
        System.out.println(result);
    }
}
