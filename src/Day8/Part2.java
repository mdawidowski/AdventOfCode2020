package Day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
    private static ArrayList<String[]> inputArrayList = new ArrayList<>();
    private static boolean[] visitedLine;
    private static int accumulator;

    public static void main(String[] args) throws IOException {
        takeCareOfFiles();
        ArrayList<String[]> tweakedArrayList =  new ArrayList<>(inputArrayList);

        // initialize variables
        boolean status = false;
        int attemptNumber = 0;

        // repeat checking until program terminates
        while (!status){
            changeExactlyOneJmpToNop(attemptNumber, tweakedArrayList);
            initializeVisitedArray();
            status = checkIfProgramRunsSuccessfully(tweakedArrayList);
            tweakedArrayList = new ArrayList<>(inputArrayList);
            if (!status) {
                changeExactlyOneNopToJmp(attemptNumber, tweakedArrayList);
                initializeVisitedArray();
                status = checkIfProgramRunsSuccessfully(tweakedArrayList);

                tweakedArrayList = new ArrayList<>(inputArrayList);

            }

            attemptNumber++;

        }

        System.out.println(accumulator);


    }

    private static void changeExactlyOneJmpToNop(int numberOfJmp, ArrayList<String[]> tweakedArrayList){
        int jmpOccurrences = 0;
        String tweaked;
        for (int i = 0; i < tweakedArrayList.size(); i++) {
            if (tweakedArrayList.get(i)[0].equals("jmp")){
                if (jmpOccurrences == numberOfJmp){
                    tweaked = "nop " + tweakedArrayList.get(i)[1];
                    tweakedArrayList.set(i, tweaked.split(" "));
                }
                jmpOccurrences += 1;
            }
        }
    }

    private static void changeExactlyOneNopToJmp(int numberOfNop, ArrayList<String[]> tweakedArrayList){
        int nopOccurrences = 0;
        String tweaked;
        for (int i = 0; i < tweakedArrayList.size(); i++) {
            if (tweakedArrayList.get(i)[0].equals("nop")){
                if (nopOccurrences == numberOfNop){
                    tweaked = "jmp " + tweakedArrayList.get(i)[1];
                    tweakedArrayList.set(i, tweaked.split(" "));
                }
                nopOccurrences += 1;
            }
        }
    }

    private static boolean checkIfProgramRunsSuccessfully(ArrayList<String[]> tweakedArrayList){
        boolean status = true;
        accumulator = 0;
        for (int i = 0; i < tweakedArrayList.size(); i += 0) {
            if (visitedLine[i]) {
                status = false;
                break;
            }
            switch (tweakedArrayList.get(i)[0]) {
                case "acc":
                    accumulator += Integer.parseInt(tweakedArrayList.get(i)[1]);
                    visitedLine[i] = true;
                    i += 1;
                    break;

                case "jmp":
                    visitedLine[i] = true;
                    i += Integer.parseInt(tweakedArrayList.get(i)[1]);
                    break;

                case "nop":
                    visitedLine[i] = true;
                    i += 1;
            }
        }
        return status;
    }

    private static void initializeVisitedArray(){
        visitedLine = new boolean[inputArrayList.size()];
        Arrays.fill(visitedLine, false);
    }

    private static void takeCareOfFiles() throws IOException {
        // load file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Day8PuzzleInput.txt")));

        // initialize variables
        String input;

        //load and add to arraylist line by line
        while((input = bufferedReader.readLine()) != null){
            inputArrayList.add(input.split(" "));
        }

        initializeVisitedArray();

    }
}
