import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMenu {
    @Test
    public void a_menu_has_a_title() {
        Menu menu = new Menu("Five Guys");
        assertEquals("Five Guys", menu.getTitle());
    }

    @Test
    public void a_menu_can_add_items() {
        Menu menu = new Menu("Five Guys");
        Item item = new Item("Bacon Cheeseburger", 5.99);
        menu.addItem(item);
        assertTrue(menu.getItems().contains(item));
    }

    // Would this not be better as HashMap not ArrayList?

    // @Test
    // public void a_menu_can_get_a_single_item() {
    // Menu menu = new Menu("Five Guys");
    // Item burger = new Item("Bacon Cheeseburger", 5.99);
    // Item hotdog = new Item("Hotdog", 4.99);
    // Item fries = new Item("Cajun Fries", 3.99);
    // menu.addItem(burger);
    // menu.addItem(hotdog);
    // menu.addItem(fries);
    // Item returnedItem = menu.getItem("Hotdog");
    // assertEquals(hotdog, returnedItem);

    // }
}
