import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {
    private int id;
    private int menuId;
    private String name;
    private double price;

    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS items (menu_id INTEGER, name TEXT, price DOUBLE, id INTEGER PRIMARY KEY);");
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public Item(int menuId, String name, double price) {
        this.name = name;
        this.price = price;
        this.menuId = menuId;
        try {
            PreparedStatement insertItem = DB.conn
                    .prepareStatement("INSERT INTO items (menu_id, name, price) VALUES (?, ?, ?);");
            insertItem.setInt(1, this.menuId);
            insertItem.setString(2, this.name);
            insertItem.setDouble(3, this.price);
            insertItem.executeUpdate();
            this.id = insertItem.getGeneratedKeys().getInt(1);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}
