import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {

    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "Rodesh";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println();
                System.out.println("HOTEL RESERVATION SYSTEM");
                System.out.println("1. New Reservation");
                System.out.println("2. View Reservation");
                System.out.println("3. Get Room Number ");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        // implement check reservation
                        viewReservation(connection, scanner);
                        break;
                    case 3:
                        // implement get room
                        break;
                    case 4:
                        // implement update
                        break;
                    case 5:
                        // implement delete
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //------------------- reserveRoom is used to enter detail -----------------

    private static void reserveRoom(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter guest name: ");
            String guestName = scanner.next();

            System.out.println("Enter room number: ");
            int roomNumber = scanner.nextInt();

            System.out.println("Enter contact number: ");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES ('"
                    + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

            try (Statement statement = connection.createStatement()) {
                int affectedRows = statement.executeUpdate(sql);
                if (affectedRows > 0) {
                    System.out.println("Reservation successful!");
                } else {
                    System.out.println("Reservation failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        //--------------------view Reservation ------------------
        private static void viewReservation(Connection connection, Scanner scanner) throws SQLException{
            String sql = "SELECT * FROM reservations;";
            try(Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql)){ //ResultSet is and interface, resultset is the instance of Resultset.

                System.out.println("Current Reservations");
                System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
                System.out.println("| Reservation ID                 | Guest                           | Room Number                   | Contact Number                 | Reservation Date               | ");
                System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");

                while(resultset.next())
                {
                    int reservationId = resultset.getInt("reservation_id");
                    String guestName = resultset.getString("guest_name");
                    int roomnumber = resultset.getInt("room_number");
                    String contactNumber = resultset.getString("contact_number");
                    String reservationDate = resultset.getTimestamp("reservation_date").toString();

                    //formate and display the reservation date in a table -like formate
                System.out.printf("|%-14d                  | %-15s                          | %-13d                           | %-20s                         | %-19s                          |\n",
                       reservationId, guestName, roomnumber, contactNumber, reservationDate);

                }
              System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");

            }
            //next(), it run untile the data is available in loop

        }
        private static void getRoomNumber(Connection connection, Scanner scanner)
        {
            try{
                System.out.println("Enter reservation ID: ");
                int reservationID = scanner.nextInt();
                System.out.println("Enter guest name");
                String guestname = scanner.next();

                String sql = "SELECT room_number from reservations"+"WHERE reservation id = "+reservationID + "AND guest_name = "+guestname" ' ";

                try(Statement statement = connection.createStatement())
                {
                    ResultSet resultset = statement.executeQuery(sql));
                }
            }
        }
    }


