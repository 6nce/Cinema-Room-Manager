import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        boolean sym = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        //{Legacy function} Now print the matrix of the input.
        // New task is to iterate through created array and check to see if numbers are not symmetrical
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.print(mat[i][j]+" ");
                if (mat[i][j] != mat[j][i]) {
                    sym = false;
                    break;
                }
            }
//            System.out.println();

        }
        if (sym) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}


