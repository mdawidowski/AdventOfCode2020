package Day5;

import java.io.*;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // load file
        FileReader fileReader = new FileReader(new File("src/Day5/Day5PuzzleInput.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // initialize variables
        int lowerRowsRange = 0, upperRowsRange = 127, lowerColumnsRange = 0, upperColumnsRange = 7,
                seatID, maxValue = 0;
        String input;

        //load boarding passes one by one and calculate seats placement
        while((input = bufferedReader.readLine()) != null){
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
            System.out.println(seatID);
            // set max seat ID value
            if (seatID > maxValue){
                maxValue = seatID;
            }
            lowerColumnsRange = 0;
            upperColumnsRange = 7;
            lowerRowsRange = 0;
            upperRowsRange = 127;

        }

        // return result
        System.out.println(maxValue);
    }
}
