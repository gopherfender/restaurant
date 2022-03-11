import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.uk.barclays.Item;
import co.uk.barclays.Menu;

public class TestMenu {
    @Test
    public void a_menu_has_a_title() {
        Menu menu = new Menu("Five Guys", 1);
        assertEquals("Five Guys", menu.getTitle());
    }

    @Test
    public void a_menu_can_add_items() {
        Menu menu = new Menu("Five Guys", 1);
        Item item = new Item(1, "Bacon Cheeseburger", 5.99);
        menu.createItem("asd", 4.99);
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
