import java.util.Scanner;

//package chucknorris;

public class Main {
    public static void main(String[] args) {

        Boolean continueQuestions = true;
        Scanner scan = new Scanner(System.in);

        while (continueQuestions == true) {

            System.out.println("Please input operation (encode/decode/exit):");
            String firstInput = scan.nextLine();

            if (firstInput.equalsIgnoreCase("encode")) {
                System.out.println("Input string: ");
                String input = scan.nextLine();
                String converted = "";

                for (int i = 0; i < input.length(); i++) {
                    char charGiven = input.charAt(i);
                    int value = charGiven;
                    String binConvert = Integer.toBinaryString(value);
                    converted = converted + String.format("%7s", binConvert).replaceAll(" ", "0");
    //            Displaying the binary converted code
    //            System.out.println();

                }

                String result = "0";

                if (converted.charAt(0) == '0') {
                    result = result + "0";
                }

                result = result + " 0";

                for (int j = 1; j < converted.length(); j++) {
                    char currentNumber = converted.charAt(j);

    //                Testing value of currentNumber and ConvertedChar
    //                System.out.print("A Number: " + currentNumber );
    //                System.out.print("B Number: " + converted.charAt(j - 1) );
                    if (currentNumber == converted.charAt(j - 1)){
                        result = result + "0";
                    } else if (currentNumber != converted.charAt(j - 1)){
                        result = result + " 0";
                        if (currentNumber == '0' ) {
                            result = result + "0";
                        }
                        result = result + " 0";
                    }
                }
                System.out.println("Encoded string:");
                System.out.println(result);
            }


                else if (firstInput.equalsIgnoreCase("decode")) {
                System.out.println("Input encoded string:");
                String input = scan.nextLine();
                boolean continueDecode = true;

                for (int i = 0; i < input.length() - 1; i++) {
                    if (input.charAt(i) != '0' && input.charAt(i) != ' ') {
                        System.out.println("not valid");
                        continueDecode = false;
                        break;
                    }
                }
                if (continueDecode != true) {
                    continue;
                }

                String[] split = input.split(" ");
                String binaryResults = "";

//                System.out.println(split.length);
//                System.out.println(split.length % 2);
                if (split.length % 2 != 0) {
                    System.out.println("not valid");
                    continueDecode = false;
                }

                if (continueDecode != true) {
                    continue;
                }



                for (int i = 0; i < split.length - 1; i = i + 2) {
                    if (split[i].equals("0")) {
                        split[i] = "1";
                    } else if (split[i].equals("00")) {
                        split[i] = "0";
                    }

                    for (int j = 0; j < split[i + 1].length(); j++) {
                        binaryResults = binaryResults + split[i];
                    }
                }

//                System.out.println(binaryResults);
                if (binaryResults.length() % 7 != 0) {
                    continueDecode = false;
                    System.out.println("not valid");
                }
                if (continueDecode != true) {
                    continue;
                }
//

                String[] results = binaryResults.split("(?<=\\G.{" + 7 + "})");

                if (continueDecode != true) {
                    continue;
                }

                String convertedBinary = "";

                for (int i = 0; i < results.length; i++) {
                    char temp = (char) Integer.parseInt(results[i], 2);
                    convertedBinary += temp;
                }

//                if (convertedBinary.length() % 7 != 0) {
//                    continueDecode = false;
//                    System.out.println("not valid");
//                }
//                if (continueDecode != true) {
//                    continue;
//                }
                System.out.println("Decoded string:");
                System.out.println(convertedBinary);
            }
                else if (firstInput.equalsIgnoreCase("exit")) {
                continueQuestions = false;
                System.out.println("Bye!");
                }
                else {
                System.out.println("There is no '" +firstInput+"' operation.");
                }

        }
    }
}


// 0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00