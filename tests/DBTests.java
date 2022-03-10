import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import org.junit.Test;

public class DBTests {

    @Test
    public void scan_connect_to_my_db() throws SQLException {
        new DB("jdbc:sqlite://e:/Documents/Dropbox/Apprenticeship/Code/Java/Bootcamp/restaurant/restaurant/src/db.db");
        assertTrue(DB.conn instanceof Connection);
    }
}
