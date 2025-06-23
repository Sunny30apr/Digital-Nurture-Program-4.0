public class Logger {
    private static Logger log;

    private Logger() {

    }
    public static Logger getLogger() {
        if(log == null) {
            log = new Logger();
        }
        return log;
    }
}
