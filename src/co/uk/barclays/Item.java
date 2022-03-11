package co.uk.barclays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Item {
    public static ArrayList<Item> all = new ArrayList<>();
    private int id;
    private int menuId;
    private String name;
    private double price;

    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS items (menu_id INTEGER, name TEXT, price DOUBLE, id INTEGER PRIMARY KEY);");
            Statement getItems = DB.conn.createStatement();
            ResultSet items = getItems.executeQuery("SELECT * FROM items;");
            while (items.next()) {
                int menuId = items.getInt(1);
                String name = items.getString(2);
                double price = items.getDouble(3);
                int id = items.getInt(4);
                new Item(menuId, name, price, id);
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public static ArrayList<Item> getAll() {
        return all;
    }

    public Item(int menuId, String name, double price, int id) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.id = id;
        Item.all.add(this);
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
        Item.all.add(this);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getId() {
        return this.id;
    }

}
