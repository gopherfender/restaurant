import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestItem {
    @Test
    public void an_item_has_a_name_and_price() {
        Item item = new Item("Bacon Cheeseburger", 5.99);
        assertEquals("Bacon Cheeseburger", item.getName());
        assertEquals(5.99, item.getPrice(), 0);

    }
}
