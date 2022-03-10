import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Menu {
    public static ArrayList<Menu> all = new ArrayList<>();
    private int id;
    private int restaurantId;
    private String title;
    private ArrayList<Item> items;

    public Menu(String title, int restaurantId) {
        this.title = title;
        this.restaurantId = restaurantId;
        this.items = new ArrayList<>();
        try {
            PreparedStatement insertMenu = DB.conn
                    .prepareStatement("INSERT INTO menus (restaurant_id, name) VALUES (?, ?);");
            insertMenu.setInt(1, this.restaurantId);
            insertMenu.setString(2, this.title);
            insertMenu.executeUpdate();
            this.id = insertMenu.getGeneratedKeys().getInt(1);
        } catch (SQLException error) {
            error.printStackTrace();
        }
        Menu.all.add(this);
    }

    public Menu(int id, int restaurantId, String name) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = name;
        Menu.all.add(this);
    }

    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS menus (id INTEGER PRIMARY KEY, restaurant_id INTEGER, name TEXT);");
            Statement getMenus = DB.conn.createStatement();
            ResultSet menus = getMenus.executeQuery("SELECT * FROM menus;");
            while (menus.next()) {
                int id = menus.getInt(1);
                int restaurantId = menus.getInt(2);
                String name = menus.getString(3);
                new Menu(id, restaurantId, name);
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void createItem(String name, double price) {
        Item item = new Item(this.id, name, price);
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

}
