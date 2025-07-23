public class Test {
    public static void main(String[] args) throws Exception {
        Computer personalComputer = new Computer.Builder()
                                                    .setCPU("AMD Ryzen 5 5500U")
                                                    .setRAM("8.0 GB")
                                                    .setStorage("512 GB SSD")
                                                    .build();

        Computer gamingComputer = new Computer.Builder()
                                                    .setCPU("Intel core i9")
                                                    .setRAM("32 GB")
                                                    .setStorage("1 TB SSD")
                                                    .build();

        System.out.println("Personal Computer: " + personalComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}
