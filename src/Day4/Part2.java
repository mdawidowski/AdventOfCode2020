package Day4;

import java.io.*;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // load file
        FileReader fileReader = new FileReader(new File("Day4PuzzleInput.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //initialize variables
        String input, passport = "";
        String[] passportsInParts;
        int countValidElementsOfPassport = 0, countValidPassports = 0;

        // check passports one by one
        while ((input = bufferedReader.readLine())!= null){
            while (!(input == null) && !input.isBlank()){
                passport += " " + input;
                input = bufferedReader.readLine();
            }

            passportsInParts = passport.split(":|\\s");
            for (int i = 1; i < passportsInParts.length; i+=2) {
                switch (passportsInParts[i]) {
                    case "byr":
                        int byr = Integer.parseInt(passportsInParts[i + 1]);
                        if (byr >= 1920 && byr <= 2002) {
                            countValidElementsOfPassport++;
                        }
                        break;

                    case "iyr":
                        int iyr = Integer.parseInt(passportsInParts[i + 1]);
                        if (iyr >= 2010 && iyr <= 2020) {
                            countValidElementsOfPassport++;
                        }
                        break;

                    case "eyr":
                        int eyr = Integer.parseInt(passportsInParts[i + 1]);
                        if (eyr >= 2020 && eyr <= 2030) {
                            countValidElementsOfPassport++;
                        }
                        break;

                    case "hgt":
                        int hgt;
                        if (passportsInParts[i + 1].contains("cm")) {
                            hgt = Integer.parseInt(passportsInParts[i + 1].replace("cm", ""));
                            if (hgt >= 150 && hgt <= 193) {
                                countValidElementsOfPassport++;
                            }
                        } else if (passportsInParts[i + 1].contains("in")) {
                            hgt = Integer.parseInt(passportsInParts[i + 1].replace("in", ""));
                            if (hgt >= 59 && hgt <= 76) {
                                countValidElementsOfPassport++;
                            }
                        }
                        break;

                    case "hcl":
                        if (passportsInParts[i + 1].matches("^#([a-f0-9]{6})$")) {
                            countValidElementsOfPassport++;
                        }
                        break;

                    case "ecl":
                        // amb blu brn gry grn hzl oth
                        if (passportsInParts[i+1].equals("amb") || passportsInParts[i+1].equals("blu") || passportsInParts[i+1].equals("brn") || passportsInParts[i+1].equals("gry") ||
                                passportsInParts[i+1].equals("grn") || passportsInParts[i+1].equals("hzl") || passportsInParts[i+1].equals("oth")){
                            countValidElementsOfPassport++;
                        }
                        break;

                    case "pid":
                        if (passportsInParts[i+1].matches("^([0-9]{9})$")){
                            countValidElementsOfPassport++;
                        }

                }
            }
            if (countValidElementsOfPassport == 7){
                countValidPassports++;
            }
            countValidElementsOfPassport = 0;
            passport = "";

        }
        System.out.println(countValidPassports);

    }
}
