/**
 * Performs some basic AList.
 *
 * @author blz
 */
public class AListTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

//        AList<Integer> arr = new AList<>();
        AList arr = new AList();
        boolean passed = checkEmpty(true, arr.isEmpty());
        arr.addLast(2);

        passed = checkSize(1, arr.size()) && passed;
        passed = checkEmpty(false, arr.isEmpty()) && passed;

        arr.addLast(4);
        int last = arr.getLast();
        passed = 4 == last && passed;

        passed = checkSize(2, arr.size()) && passed;

        arr.removeLast();
        passed = checkSize(1, arr.size()) && passed;

        arr.addLast(3);
        int item = arr.get(1);
        passed = item == 3 && passed;

        arr.removeLast();
        arr.removeLast();
        passed = checkEmpty(true, arr.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        addRemoveTest();
    }
}
