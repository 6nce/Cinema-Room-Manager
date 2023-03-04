import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        int winner = 100;
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        for (int element : array) {
            if (element < winner) {
                winner = element;
            }
        } System.out.print(winner);
    }
}