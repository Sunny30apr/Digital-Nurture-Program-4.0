public class Test {
    public static void main(String[] args) throws Exception {
        Image file1 = new ProxyImage("test_file_1.jpg");
        Image file2 = new ProxyImage("test_file_2.jpg");

        file1.display();

        file1.display();

        file2.display();

        file2.display();
    }
}
