package models;

import models.Item;
import org.junit.BeforeClass;
import org.junit.Test;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;

import javax.persistence.EntityManager;

import java.util.HashMap;

import static models.Shop.Shop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;


/**
 * Created by b05752 on 2015/02/04.
 */
public class ShopTest {
    public static Shop shop = Shop.Shop;
    private final HashMap<String, String> options = new HashMap<>();
    @Test
    public void addItem() {
        options.putAll(inMemoryDatabase());
        options.put("jpa.default", "shopDatasource");
        options.put("db.default.jndiName","shopDatasource");

        running(fakeApplication(options), () -> {
            Item item = shop.create("Play! Framework Essentials", 42.0);
            assertNotNull(item);
            assertEquals("Play! Framework Essentials", item.name);
            assertEquals(new Double(42.0), item.price);
        });
    }
}
