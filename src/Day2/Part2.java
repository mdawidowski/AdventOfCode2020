package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("src/Day2/Day2PuzzleInput.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        String input;
        String[] splittedString;
        ArrayList<String[]> passwordsArrayList = new ArrayList<>();

        // insert passwords and policies to ArrayList
        while ((input = bufferedReader.readLine())!=null){
            splittedString = input.split("\\s|-");
            passwordsArrayList.add(splittedString);
        }

        // count valid passwords appearances
        int countValidPasswords = 0;
        for (String[] strings : passwordsArrayList) {
            String password = strings[3];
            char passwordPolicy = strings[2].charAt(0);
            int valueOne = Integer.parseInt(strings[0]);
            int valueTwo = Integer.parseInt(strings[1]);
            if (password.charAt(valueOne - 1) == passwordPolicy ^ password.charAt(valueTwo - 1) == passwordPolicy) {
                countValidPasswords += 1;
            }
        }

        // return the answer
        System.out.println(countValidPasswords);

    }
}
