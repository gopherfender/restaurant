import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        new DB("jdbc:sqlite:./src/db.db");
        Restaurant.init();
        Restaurant restaurant = new Restaurant("Red Dwarf Cafe", "./reddwarf.jpg");
        System.out.println(restaurant.getId());
        Menu.init();
        Menu menu = restaurant.createMenu("Lister's Special");
        Item.init();
        menu.createItem("triple fried egg chili chutney sandwich", 2.99);
        DB.conn.close();
    }

}
