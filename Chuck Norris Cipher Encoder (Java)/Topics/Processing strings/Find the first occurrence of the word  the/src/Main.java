import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        int strIn = sentence.indexOf("The");
        int strLowerIn = sentence.indexOf("the");

        if (strIn == -1) {
            System.out.println(strLowerIn);
        } else {
            System.out.println(strIn);
        }



    }
}

