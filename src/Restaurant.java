import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Restaurant {
    public static ArrayList<Restaurant> all = new ArrayList<>();
    private int id;
    private String name;
    private String imageURL;
    private ArrayList<Menu> menus;

    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS restaurants (id INTEGER PRIMARY KEY, name TEXT, imageURL TEXT);");
            Statement getRestaurants = DB.conn.createStatement();
            ResultSet restaurants = getRestaurants.executeQuery("SELECT * FROM restaurants;");
            while (restaurants.next()) {
                int id = restaurants.getInt(1);
                String name = restaurants.getString(2);
                String imageURL = restaurants.getString(3);
                new Restaurant(id, name, imageURL);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public Restaurant(String name, String imageUrl) {
        this.name = name;
        this.imageURL = imageUrl;
        this.menus = new ArrayList<>();
        try {
            PreparedStatement insertRestaurant = DB.conn
                    .prepareStatement("INSERT into restaurants (name, imageURL) VALUES (?, ?);");
            insertRestaurant.setString(1, this.name);
            insertRestaurant.setString(2, this.imageURL);
            insertRestaurant.executeUpdate();
            this.id = insertRestaurant.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Restaurant.all.add(this);
    }

    public Restaurant(int id, String name, String imageURL) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        Restaurant.all.add(this);
    }

    public String getName() {
        return this.name;
    }

    public String getImageUrl() {
        return this.imageURL;
    }

    public Menu createMenu(String title) {
        Menu menu = new Menu(title, this.id);
        this.menus.add(menu);
        return menu;
    }

    public ArrayList<Menu> getMenus() {
        return this.menus;
    }

    public int getId() {
        return this.id;
    }

}