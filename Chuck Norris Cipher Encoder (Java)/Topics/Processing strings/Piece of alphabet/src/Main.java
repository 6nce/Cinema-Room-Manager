import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Boolean result = true;

        for(int i = 0; i < input.length() - 1; i++){
            char firstLetter = input.charAt(i);
            char secondLetter = input.charAt(i + 1);
            if(firstLetter == (secondLetter - 1)) {
                result = true;
            } else if (firstLetter != (secondLetter - 1)) {
                result = false;
                break;
            } else if (secondLetter == 32) {
                result = true;
                break;
            } else {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}