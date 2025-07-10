public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName=fileName;
        loadImageFromRemote();
    }

    private void loadImageFromRemote() {
        System.out.println("Loading " + fileName + " from xyz Server...");
    }

    public void display() {
        System.out.println("Displaying: " + fileName);
    }
}
