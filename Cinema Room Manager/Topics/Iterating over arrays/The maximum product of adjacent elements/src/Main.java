import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int numberOfElements = sc.nextInt();
        int[] array = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            array[i] = sc.nextInt();
        }

        int product = 0;

        for (int i = numberOfElements - 1; i > 0; i--) {
            int temp = array[i] * array[i - 1];
            if (temp > product) {
                product = temp;

            }
        } System.out.print(product);
    }
}