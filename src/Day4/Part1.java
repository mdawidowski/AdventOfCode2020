package Day4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        FileReader fileReader = new FileReader(new File("Day4PuzzleInput.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        String[] words = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int index = 0, amountOfWrongPassports=0, countPassports=0;
        String input, passport="";

        //load passports one by one
        while ((input = bufferedReader.readLine()) != null){
            while (!(input == null) && !input.isBlank()){
                passport += " " + input;
                input = bufferedReader.readLine();
            }
            // check if passport contains all required fields
            for (int i = 0; i < words.length; i++) {
                if (!passport.contains(words[i])){
                    amountOfWrongPassports += 1;
                    break;
                }
            }
            passport = "";
            countPassports += 1;
        }

        // return result
        System.out.println(countPassports + " - " + amountOfWrongPassports + " = " + (countPassports-amountOfWrongPassports));
    }
}

