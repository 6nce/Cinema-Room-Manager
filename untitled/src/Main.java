import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int test = 2;

        for (int i = input.length() - 1; i >= 0; i--){
            System.out.print(input.charAt(i));
        }
        System.out.println(" ");
        for (int i = input.length() - 1; i >= 0; i--){
            test = test * 2;
            System.out.print(test + " ");
        }

    }
}
