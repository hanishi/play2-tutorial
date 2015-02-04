

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Items;
import models.Item;
import org.junit.Test;

import static models.Shop.Shop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;


/**
 * Created by b05752 on 2015/02/04.
 */
public class ShopTest {
    JsonNode itemCreate;

    {

    }
    @Test
    public void addItem() {
        running(fakeApplication(inMemoryDatabase()),()->{
            Item item = Shop.create("Play Framework Essentials", 42.0);
            assertNotNull(item);
            assertEquals("Play Framework Essentials",item.name);
            assertEquals(new Double(42.0), item.price);
        });
    }
}
