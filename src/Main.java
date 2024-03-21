import cli.CommandRunner;

/**
 * Purpose of this object is to refresh the Java basics.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        CommandRunner cmd = new CommandRunner();
        try {
            cmd.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}