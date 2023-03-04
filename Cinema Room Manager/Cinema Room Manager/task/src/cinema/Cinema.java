import java.util.Scanner;
//package cinema;

public class Cinema {
    static void showSeats(int a, int b, String[][] array) {

        System.out.println("Cinema:");
        System.out.print("  ");

        for (int i = 0; i < b; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < a; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < b; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        }

    static int buyTicket(int a, int b, String[][] array, int r, int s) {
        Scanner sc = new Scanner(System.in);

        int front = r / 2;
        int back = r - front;
        int frontTickets = 10;
        int backTickets = 8;
        int ticketTotal;

        if (s * r < 60) {
            int tickets = 10;
            System.out.println("Ticket price: $" + tickets);
            ticketTotal = tickets;
        } else if (a > front) {
            System.out.println("Ticket price: $" + backTickets);
            ticketTotal = backTickets;
        } else {
            System.out.println("Ticket price: $" + frontTickets);
            ticketTotal = frontTickets;
        }
        array[a - 1][b - 1] = "B";

        return ticketTotal;
    }

    static void stats(int ticketCounter, int currentIncome, int totalSeats, int grandTotal){
        if (ticketCounter == 0){
            float ticketConvert = ticketCounter;
            System.out.println("Number of purchased tickets: 0");
            System.out.printf("Percentage: %1.2f%%\n ", ticketConvert);
        }
        else {
            float ticket1 = ticketCounter;
            float ticket2 = totalSeats;
            float total = (ticketCounter / ticket2) * 100;
            System.out.printf("Number of purchased tickets: %d%n", ticketCounter);
            System.out.printf("Percentage: %1.2f%%\n", total);
        }
        System.out.printf("Current Income: $%d\n", currentIncome);
        System.out.printf("Total Income: $%d\n", grandTotal);


    }
    static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        int totalSeats = rows * seats;

        String[][] theater = new String[rows][seats];

        int ticketCounter = 0;
        int currentIncome = 0;

//        System.out.println("Cinema:");
//        System.out.print("  ");
//        for (int i = 0; i < seats; i++) {
//            System.out.print(i + 1 + " ");
//        }
//        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                theater[i][j] = "S";
            }
        }

        int front = rows / 2;
        int back = rows - front;
        int frontTickets = 10 * (front * seats);
        int backTickets = 10 * (back * seats);
        int grandTotal = frontTickets + backTickets;

        if (totalSeats > 60) {
            backTickets = 8 * (back * seats);
        }
        System.out.println("Test: front Tickets: " + frontTickets);
        System.out.println("Test: front Tickets: " + backTickets);
        grandTotal = frontTickets + backTickets;


//        for (int i = 0; i < rows; i++) {
//            System.out.print(i + 1 + " ");
//            for (int j = 0; j < seats; j++) {
//                System.out.print(theater[i][j] + " ");
//            }
//            System.out.println();
//        }

        Boolean keepGoing = true;

        while (keepGoing) {
            printMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case (1):
                    showSeats(rows, seats, theater);
                    break;

                case (2):
                    Boolean keepTrying = true;

                    System.out.println("Enter a row number:");
                    int userRow = sc.nextInt();

                    System.out.println("Enter a seat number in that row:");
                    int userSeat = sc.nextInt();

                    while(keepTrying) {

                        Boolean validSeat = false;
                        Boolean validRow = false;

                        while(validRow == false) {
                            if (userRow < 0 || userRow > rows) {
                                System.out.println("Wrong input!1");

                                System.out.println("Enter another row number:");
                                userRow = sc.nextInt();

                                System.out.println("Enter a seat number in that row:");
                                userSeat = sc.nextInt();
                            } else {
                                validRow = true;
                            }
                        }

                        while(validSeat == false) {
                            if (userSeat < 0 || userSeat > seats) {
                                System.out.println("Wrong input!2");

                                System.out.println("Enter another row number:");
                                userRow = sc.nextInt();

                                System.out.println("Enter a seat number in that row:");
                                userSeat = sc.nextInt();
                            } else {
                                validSeat = true;
                            }
                        }

                        if (theater[userRow - 1][userSeat - 1] != "B") {
                            ticketCounter ++;
                            keepTrying = false;
                        } else {
                            System.out.println(" That ticket has already been purchased!");

                            System.out.println("Enter another row number:");
                            userRow = sc.nextInt();

                            System.out.println("Enter a seat number in that row:");
                            userSeat = sc.nextInt();
                        }
                    }
                    buyTicket(userRow, userSeat, theater, seats, rows);
                    currentIncome += buyTicket(userRow, userSeat, theater, seats, rows);
                    System.out.printf("Current Income: %d%nTickets Sold: %d%n", currentIncome, ticketCounter);
                    break;

                case (3):
                    System.out.println(ticketCounter + " " + currentIncome + " " + totalSeats + " " + grandTotal);
                    stats(ticketCounter, currentIncome, totalSeats, grandTotal);
                    break;

                case (0):
                    keepGoing = false;

            }
        }
    }
}
