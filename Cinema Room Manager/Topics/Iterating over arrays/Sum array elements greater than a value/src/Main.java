import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int number = sc.nextInt();
        int sum = 0;

        for (int element : array) {
            if (element > number) {
                sum += element;
            }
        } System.out.println(sum);
    }
}