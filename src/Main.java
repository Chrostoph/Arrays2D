public class Main {
    public static void main(String[] args) {
        Arrays2D arrayIn = new Arrays2D();
        arrayIn.readArray();
        arrayIn.printArray();
        int[] snailArray = arrayIn.getSnailOrder();
        arrayIn.printInSnailOrder(snailArray);
    }
}