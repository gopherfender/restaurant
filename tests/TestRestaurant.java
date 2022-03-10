import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRestaurant {

    @Test
    public void a_Restaurant_has_a_name() {
        Restaurant fiveGuys = new Restaurant("Five Guys", "./fiveguys.png");
        assertEquals("Five Guys", fiveGuys.getName());
    }

    @Test
    public void a_restaurant_has_an_imageUrl() {
        Restaurant fiveGuys = new Restaurant("Five Guys", "./fiveguys.png");
        assertEquals("./fiveguys.png", fiveGuys.getImageUrl());
    }

    @Test
    public void a_restaurant_has_a_menu() {
        Restaurant fiveGuys = new Restaurant("Five Guys", "./fiveguys.png");
        Menu menu = new Menu("Standard", 1);
        assertTrue(fiveGuys.getMenus().contains(menu));
    }

}
