import database.InMemDbHandler;
import database.dbController;

import java.util.List;

/**
 * Purpose of this object is to refresh the Java basics.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        InMemDbHandler dbHandler = InMemDbHandler.getInstance();
        List<?> objects = dbHandler.getTableData("user");

        dbController db = new dbController();
        long next = db.getNextIdForTable("user");
        System.out.println(next);
    }
}