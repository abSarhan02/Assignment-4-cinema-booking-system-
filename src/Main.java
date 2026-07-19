import java.util.Scanner;

public class Main {

    //MENU FUNCTION
    public static void displayMenu(){
        System.out.println("\n=======================================");
        System.out.println("1. Display Seats");
        System.out.println("2. Book Seat");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Show All Movies");
        System.out.println("5. Show Available and Booked Seats");
        System.out.println("0. Exit");
        System.out.println("=======================================");
    }
    // INITIALIZE SEATS
    public static void initializeSeats(char[][] seats) {

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'O'; // Available
            }
        }
    }


    // DISPLAY ALL SEATS
    public static void displayAllSeats(char[][] seats) {

        System.out.println("\nSEATS");

        //COLUMN NMBR
        System.out.println("       Column");

        System.out.print("       ");
        for (int i = 0 ; i < seats[0].length; i++ ){
            System.out.print((i+1) + " ");
        }
        System.out.println();


        for (int i = 0; i < seats.length; i++) {

            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }
    }

    //BOOK
    public static void bookSeat(char[][] seats, Scanner scanner){
        System.out.print("chose row number (1-5): ");
        int slctdRow = scanner.nextInt();

        System.out.print("chose seat number (1-6): ");
        int seat = scanner.nextInt();

        if( slctdRow < 1 || slctdRow > 5 || seat < 1 || seat > 6){
            System.out.println("Invalid seat, retry!");
            return;
        }

        if (seats[slctdRow - 1][seat - 1] == 'X' ) {
            System.out.println("Seat already booked!");
        }else {
            seats[slctdRow - 1][seat - 1] = 'X';
            System.out.println("Seat booked!");
        }
    }



    // SHOW MOVIES
    public static void showMovies(String[] movieNames) {

        System.out.println("\nMOVIES:");

        for (int i = 0; i < movieNames.length; i++){
            System.out.println( (i + 1) + ". " + movieNames[i]);
        }

    }

    // CANCEL
    public static void cancelBooking(char[][] seats, Scanner scanner) {

        System.out.print("chose row number (1-5): ");
        int row = scanner.nextInt();

        System.out.print("chose seat number (1-6): ");
        int seat = scanner.nextInt();


        if (row < 1 || row > seats.length ||
                seat < 1 || seat > seats[0].length) {

            System.out.println("Invalid Seat, retry");
            return;
        }


        if (seats[row - 1][seat - 1] == 'O') {

            System.out.println("Seat already available!");

        } else {

            seats[row - 1][seat - 1] = 'O';
            System.out.println("Booking cancelled!");
        }
    }
    public static void showSeatCount(char[][] seats) {

        int booked = 0;
        int available = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == 'X') {
                    booked++;
                } else {
                    available++;
                }
            }
        }

        System.out.println("Booked seats: " + booked);
        System.out.println("Available seats: " + available);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] seats = new char[5][6];
        String[] movieeNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"
        };
        int choice;

        initializeSeats(seats);


        do {

            displayMenu();

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();


            switch (choice) {

                case 1:
                    displayAllSeats(seats);
                    break;


                case 2:
                    bookSeat(seats, scanner);
                    break;


                case 3:
                    cancelBooking(seats, scanner);
                    break;


                case 4:
                    showMovies(movieeNames);
                    break;


                case 5:
                    showSeatCount(seats);

                case 0:
                    System.out.println("Thank you for using our System.");
                    System.out.println("Goodbye!");
                    break;


                default:
                    System.out.println("Invalid option.");
            }


        } while (choice != 0);

    }
}