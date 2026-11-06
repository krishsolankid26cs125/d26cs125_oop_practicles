public class MyTests {

    @Run
    public void testAddition() {
        System.out.println("Addition test executed");
    }

    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test executed");
    }

    @Run
    public void testMultiplication() {
        System.out.println("Multiplication test executed");
    }

    public void normalMethod() {
        System.out.println("This method should not run");
    }
}
