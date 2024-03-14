import database.InMemDbHandler;

public class Main {
    public static void main(String[] args) {
        InMemDbHandler dbHandler = InMemDbHandler.getInstance();
        dbHandler.getTableData("user");
    }
}