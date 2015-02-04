import play.Application;
import play.GlobalSettings;
import static models.Shop.Shop;

/**
 * Created by b05752 on 2015/02/04.
 */
public class Global extends GlobalSettings {
    @Override
    public void onStart(Application app) {
        super.onStart(app);
        if (Shop.list().isEmpty()) {
            Shop.create("Play Framework Essentials", 42.0);
        }
    }
}
