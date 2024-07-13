import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Coonection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hotel?useSSL=false";   //hotel = DataBase Name
        String user = "root";
        String password = "root";
        String query = "SELECT * FROM customer";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //ADD MySql Connector Driver jar file in module ---> dependencies
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet result =  statement.executeQuery(query);

            String id;
            String name;
            String email;
            int phone;
            String username;
            String pass;

            while (result.next()) {

                id = result.getString(1);
                name = result.getString(2);
                email = result.getString(3);
                phone = result.getInt(4);
                username = result.getString(5);


                System.out.println("ID : " + id + " || " + "Name : " + name + " || " + "Email : " + email + " || " + "Phone : " + phone + " || " + "UserName : " + username);
            }

            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
