import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        new DB("jdbc:sqlite:./src/db.db");
        Restaurant.init();
        Restaurant restaurant = new Restaurant("Krustyburger", "./krusty.jpg");
        System.out.println(restaurant.getId());
        Menu.init();
        Menu menu = restaurant.createMenu("Cheap crap");
        Item.init();
        menu.createItem("Tiny Krusty Burger", 2.99);
        DB.conn.close();
    }

}
