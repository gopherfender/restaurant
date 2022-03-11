import java.sql.SQLException;

import co.uk.barclays.DB;
import co.uk.barclays.Restaurant;

public class App {
    public static void main(String[] args) throws SQLException {
        new DB("jdbc:sqlite:./src/db.db");
        Restaurant.init();
        DB.conn.close();
    }

}
