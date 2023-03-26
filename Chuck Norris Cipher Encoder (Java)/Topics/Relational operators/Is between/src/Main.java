import java.sql.Array;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] nums = input.split(" ");
        int num = 0;
        int[] numbers = new int[3];
        boolean result = false;

        for (int i = 0; i < nums.length; i++) {
            int updated = Integer.parseInt(nums[i]);
            numbers[i] = updated;
        }

        if (numbers[0] >= numbers[1] && numbers[0] <= numbers[2]) {
            result = true;
        } else if ( (numbers[0] <= numbers[1] && numbers[0] >= numbers[2])) {
            result = true;
        }

        System.out.println(result);

        // put your code here
    }
}