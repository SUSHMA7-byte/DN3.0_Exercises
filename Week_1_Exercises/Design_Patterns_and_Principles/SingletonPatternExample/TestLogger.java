public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        logger3.log("This is the third log message.");

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("logger1, logger2, and logger3 are the same instance.");
        } else {
            System.out.println("logger1, logger2, and logger3 are different instances.");
        }
    }
}
