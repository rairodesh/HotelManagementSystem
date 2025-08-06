import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "rooot";
    private static final String password = "Rodesh";

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        try{
            //initialize all the driver from com.mysql.cj
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
