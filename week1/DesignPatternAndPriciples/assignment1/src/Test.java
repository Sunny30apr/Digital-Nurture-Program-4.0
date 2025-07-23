public class Test {
    public static void main(String[] args) throws Exception {
        Logger testLog1 = Logger.getLogger();
        Logger testLog2 = Logger.getLogger();
        Logger testLog3 = Logger.getLogger();

        if(testLog1 == testLog2) {
            System.out.println("Singleton Pattern is applied for Logger class.");
        } else {
            System.out.println("Singleton Pattern was not applied.");
        }
        if(testLog2 == testLog3) {
            System.out.println("Singleton Pattern is applied for Logger class.");
        } else {
            System.out.println("Singleton Pattern was not applied.");
        }
    }
}
