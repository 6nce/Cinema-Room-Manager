import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        int sum = 1;
        int i = 0;
        while(sum <= m){
            i++;
            sum *= i;
        };
        System.out.println(i);
    }
}
