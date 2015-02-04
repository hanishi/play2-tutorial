package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Item;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Result;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
public class ItemsTest {
    JsonNode itemCreate;

    {
        Items.CreateItem item = new Items.CreateItem();
        item.name = "Play! Framework Essentials";
        item.price = 42.0;
        itemCreate = Json.toJson(item);
    }

    @Test
    public void createItem(){
        running(fakeApplication(),()-> {
            Result response = route(fakeRequest(controllers.routes.Items.list()));
            assertThat(status(response)).isEqualTo(OK);
            assertThat(contentAsString(response)).isEqualTo("[]");
        });
    }
}