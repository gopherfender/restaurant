import java.util.ArrayList;

public class Menu {
    private String title;
    private ArrayList<Item> items;

    public Menu(String title) {
        this.title = title;
        this.items = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

}
