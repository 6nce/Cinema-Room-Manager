import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < steps; i++){
            int j = 0;
            int lastNumber = arr[arr.length - 1];
            for(j = arr.length - 1; j > 0; j--){
                arr[j] = arr[j-1];
            }
            arr[0] = lastNumber;
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}