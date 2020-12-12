package Day2;

import java.io.*;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        File file = new File("src/Day2/Day2PuzzleInput.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        String input;
        String[] splitedString;
        ArrayList<String[]> passwordsArrayList = new ArrayList<>();

        // insert passwords and policies to ArrayList
        while ((input = bufferedReader.readLine()) != null ){
            splitedString = input.split("\\s|-");
            passwordsArrayList.add(splitedString);
        }

        // count valid passwords appearances
        int countValidPasswords = 0;
        for (int i = 0; i < passwordsArrayList.size() - 1; i++) {
            int amountOfCharsInPassword = countChar(passwordsArrayList.get(i)[3], passwordsArrayList.get(i)[2].charAt(0));
            if (amountOfCharsInPassword >= Integer.parseInt(passwordsArrayList.get(i)[0]) &&
                    amountOfCharsInPassword <= Integer.parseInt(passwordsArrayList.get(i)[1])){
                countValidPasswords +=1;
            }
        }

        // return the answer
        System.out.println(countValidPasswords);
    }

    // count how many times Char occurs in String
    private static int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }

}

