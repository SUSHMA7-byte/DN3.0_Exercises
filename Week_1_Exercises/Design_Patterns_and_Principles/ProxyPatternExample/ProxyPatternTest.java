package ProxyPatternExample;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");
        Image image3 = new ProxyImage("image1.jpg");

        System.out.println("Displaying image1:");
        image1.display();

        System.out.println("\nDisplaying image2:");
        image2.display();

        System.out.println("\nDisplaying image1 again (should be from cache):");
        image3.display();
    }
}
