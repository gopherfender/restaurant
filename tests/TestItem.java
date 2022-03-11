import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.uk.barclays.Item;

public class TestItem {
    @Test
    public void an_item_has_a_name_and_price() {
        Item item = new Item(1, "Bacon Cheeseburger", 5.99);
        assertEquals("Bacon Cheeseburger", item.getName());
        assertEquals(5.99, item.getPrice(), 0);

    }
}
