package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // load file
        FileReader fileReader = new FileReader(new File("Day5PuzzleInput.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        int lowerRowsRange = 0, upperRowsRange = 127, lowerColumnsRange = 0, upperColumnsRange = 7,
                seatID, maxValue = 0;
        String input;
        ArrayList<Integer> seatIdsArrayList = new ArrayList<>();

        //load boarding passes one by one and calculate seats placement
        while ((input = bufferedReader.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)){
                    case 'F':
                        upperRowsRange = (upperRowsRange+lowerRowsRange)/2;
                        if (input.charAt(i+1) == 'R' || input.charAt(i+1) == 'L'){
                            lowerRowsRange = upperRowsRange;
                        }
                        break;

                    case 'B':
                        lowerRowsRange = (int) Math.ceil((upperRowsRange+lowerRowsRange)/2.0);
                        if (input.charAt(i+1) == 'R' || input.charAt(i+1) == 'L'){
                            upperRowsRange = lowerRowsRange;
                        }
                        break;

                    case 'L':
                        upperColumnsRange = (upperColumnsRange+lowerColumnsRange)/2;
                        break;

                    case 'R':
                        lowerColumnsRange = (int) Math.ceil((upperColumnsRange+lowerColumnsRange)/2.0);

                }
            }

            // calculate seat ID
            seatID = (lowerRowsRange * 8) + lowerColumnsRange;

            seatIdsArrayList.add(seatID);

            lowerColumnsRange = 0;
            upperColumnsRange = 7;
            lowerRowsRange = 0;
            upperRowsRange = 127;

        }
        // sort seat ids
        Collections.sort(seatIdsArrayList);
        for (int i = 1; i < seatIdsArrayList.size(); i++) {
            if (seatIdsArrayList.get(i) - seatIdsArrayList.get(i-1) == 2){
                // return result
                System.out.println("Your seat ID is " + (seatIdsArrayList.get(i)-1));
            }
        }
    }
}
