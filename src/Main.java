import java.util.Scanner;

public class Main {

    // Display the main menu
    public static void displayMenu() {

        System.out.println("\n=======================================");
        System.out.println("1. Display Seats");
        System.out.println("2. Book Seat");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Show All Movies");
        System.out.println("5. Show Available and Booked Seats");
        System.out.println("0. Exit");
        System.out.println("=======================================");
    }


    // Set all seats as available
    public static void initializeSeats(char[][] seats) {

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                // O means that the seat is available
                seats[i][j] = 'O';
            }
        }
    }


    // Display the cinema seats
    public static void displayAllSeats(char[][] seats) {

        System.out.println("\nSEATS");

        // Display column numbers
        System.out.println("       Column");

        System.out.print("       ");

        for (int i = 0; i < seats[0].length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println();


        // Display every row and its seats
        for (int i = 0; i < seats.length; i++) {

            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < seats[i].length; j++) {

                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }
    }


    // Book a seat selected by the user
    public static void bookSeat(
            char[][] seats,
            Scanner scanner) {

        System.out.print("chose row number (1-5): ");
        int slctdRow = scanner.nextInt();

        System.out.print("chose seat number (1-6): ");
        int seat = scanner.nextInt();


        // Check if the selected position exists
        if (slctdRow < 1 || slctdRow > 5 ||
                seat < 1 || seat > 6) {

            System.out.println("Invalid seat, retry!");
            return;
        }


        // X means that the seat is already booked
        if (seats[slctdRow - 1][seat - 1] == 'X') {

            System.out.println("Seat already booked!");

        } else {

            // Change the seat from available to booked
            seats[slctdRow - 1][seat - 1] = 'X';

            System.out.println("Seat booked!");
        }
    }


    // Display all available movies
    public static void showMovies(String[] movieNames) {

        System.out.println("\nMOVIES:");

        for (int i = 0; i < movieNames.length; i++) {

            System.out.println(
                    (i + 1) + ". " + movieNames[i]
            );
        }
    }


    // Cancel an existing booking
    public static void cancelBooking(
            char[][] seats,
            Scanner scanner) {

        System.out.print("chose row number (1-5): ");
        int row = scanner.nextInt();

        System.out.print("chose seat number (1-6): ");
        int seat = scanner.nextInt();


        // Check that row and seat numbers are valid
        if (row < 1 || row > seats.length ||
                seat < 1 || seat > seats[0].length) {

            System.out.println("Invalid Seat, retry");
            return;
        }


        // No booking to cancel if the seat is already available
        if (seats[row - 1][seat - 1] == 'O') {

            System.out.println("Seat already available!");

        } else {

            // Make the seat available again
            seats[row - 1][seat - 1] = 'O';

            System.out.println("Booking cancelled!");
        }
    }


    // Count booked and available seats
    public static void showSeatCount(char[][] seats) {

        int booked = 0;
        int available = 0;


        // Check every seat in the cinema
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

        // Cinema has 5 rows with 6 seats each
        char[][] seats = new char[5][6];

        String[] movieeNames = {
                "Superman",
                "Avatar",
                "Minecraft",
                "Inside Out",
                "F1"
        };

        int choice;


        // Prepare the seats before starting the program
        initializeSeats(seats);


        // Keep the program running until the user chooses Exit
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
                    break;


                case 0:
                    System.out.println(
                            "Thank you for using our System."
                    );
                    System.out.println("Goodbye!");
                    break;


                default:
                    System.out.println("Invalid option.");
            }


        } while (choice != 0);


        scanner.close();
    }
}
