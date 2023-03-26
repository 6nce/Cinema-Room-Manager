import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // NxM, K
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int area = n * m;

        if (k >= area) {
            System.out.print("NO");
        } else if (k % m == 0 || k % n == 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
